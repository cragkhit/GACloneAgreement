package ssbse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReleaseLocCounter {

	public static void main(String[] args) {
		try {
			readAllFiles("/Users/Chaiyong/Downloads/Archive/mockito-2.0.44", "java");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readAllFiles(String directory, String extension) throws IOException {
		File folder = new File(directory);
		String[] extensions = new String[] { extension };
		List<File> files = (List<File>) FileUtils.listFiles(folder, extensions, true);
		int count = 0;
		for (File file : files) {
			int loc = countLines(file.getCanonicalPath());
			String filename;
			filename = file.getCanonicalPath();
			System.out.println(filename + "," + loc);
			count += loc;
		}
		System.out.println("total loc = " + count);
	}
	
	public static int countLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        // add one more, just to be sure we have enough line in case 
	        // we don't have newline at the last line
	        count++;
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
}
