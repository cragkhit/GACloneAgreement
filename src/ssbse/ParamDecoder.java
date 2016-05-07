package ssbse;

public class ParamDecoder {
	private static String[] ccfxMinToken = { 
			"10", "20", "30", "40", "50", "60", "70", "80", "90", "100", 
			"110", "120", "130", "140", "150", "160", "170", "180", "190", "200", 
			"210", "220", "230", "240", "250", "260", "270", "280", "290", "300" };
	private static String[] ccfxTKS = { 
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
			"30", "40", "50", "60", "70", "80", "90", "100", "120", "140", 
			"160", "180", "200", "220", "240", "260", "280", "300" };
	
	private static String[] deckardMinToken = { "30", "50" };
	private static String[] deckardStride = { "2", "4", "5", "8", "16", "inf"};
	private static String[] deckardSim = { "0.9", "0.95", "1.00" };
	
	private static String[] nicadMinLine = { "5", "6", "7" };
	private static String[] nicadMaxLine = { "100", "200", "400", "600", "800", "1000" };
	private static String[] nicadUpi = { "0.00", "0.10", "0.20", "0.30" };
	private static String[] nicadBlind = { "none", "blind" };
	private static String[] nicadAbstract = { "none", "block", "declaration", "statement", "expression", "condition", "literal" };

	private static String[] simianMinLine = { "5", "6", "7" };
//	private static String[] simianICB = { "1", "0" };
//	private static String[] simianID = { "1", "0" };
//	private static String[] simianIDC = { "1", "0" };
//	private static String[] simianIS = { "1", "0" };
//	private static String[] simianISC = { "1", "0" };
//	private static String[] simianIN = { "1", "0" };
//	private static String[] simianIC = { "1", "0" };
//	private static String[] simianICC = { "1", "0" };
//	private static String[] simianIL = { "1", "0" };
//	private static String[] simianISN = { "1", "0" };
//	private static String[] simianIM = { "1", "0" };
//	private static String[] simianIVN = { "1", "0" };
//	private static String[] simianBP = { "1", "0" };
//	private static String[] simianBSB = { "1", "0" };

	private static String[] simianICB = { "true", "false" };
	private static String[] simianID = { "true", "false" };
	private static String[] simianIDC = { "true", "false" };
	private static String[] simianIS = { "true", "false" };
	private static String[] simianISC = { "true", "false" };
	private static String[] simianIN = { "true", "false" };
	private static String[] simianIC = { "true", "false" };
	private static String[] simianICC = { "true", "false" };
	private static String[] simianIL = { "true", "false" };
	private static String[] simianISN = { "true", "false" };
	private static String[] simianIM = { "true", "false" };
	private static String[] simianIVN = { "true", "false" };
	private static String[] simianBP = { "true", "false" };
	private static String[] simianBSB = { "true", "false" };
	
	public static void main(String[] args) {
		int[] genome = new int[25]; // {5, 27, 1, 0, 2, 5, 9, 3, 0, 2, 2, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1};
		for (int i=0; i<25; i++) {
			genome[i] = Integer.valueOf(args[i]);
		}
		
//		System.out.println("[" + genome[0] + "," + genome[1] + "," 
//				+ genome[2] + "," + genome[3] + "," + genome[4] + "," 
//				+ genome[5] + "," + genome[6] + "," + genome[7] + "," 
//				+ genome[8] + "," + genome[9] + "," + genome[10] + "," 
//				+ genome[11] + "," + genome[12] + "," + genome[13] + ","
//				+ genome[14] + "," + genome[15] + "," + genome[16] + ","
//				+ genome[17] + "," + genome[18] + "," + genome[19] + ","
//				+ genome[20] + "," + genome[21] + "," + genome[22] + ","
//				+ genome[23] + "," + genome[24] + "]");
		if (args[25].equals("p"))
			System.out.println(
					ccfxMinToken[genome[0]] + " " 
					+ ccfxTKS[genome[1]] + " "
					+ deckardMinToken[genome[2]] + " "
					+ deckardStride[genome[3]] + " "
					+ deckardSim[genome[4]] + " " 
					+ nicadMinLine[genome[5]] + " " 
					+ nicadMaxLine[genome[6]] + " " 
					+ nicadUpi[genome[7]] + " " 
					+ nicadBlind[genome[8]] + " " 
					+ nicadAbstract[genome[9]] + " " 
					+ simianICB[genome[11]] + " "
					+ simianID[genome[12]] + " " 
					+ simianIDC[genome[13]] + " " 
					+ simianIS[genome[14]] + " " 
					+ simianISC[genome[15]] + " " 
					+ simianIN[genome[16]] + " "
					+ simianIC[genome[17]] + " " 
					+ simianICC[genome[18]] + " " 
					+ simianIL[genome[19]] + " " 
					+ simianISN[genome[20]] + " " 
					+ simianIM[genome[21]] + " " 
					+ simianIVN[genome[22]] + " "
					+ simianBP[genome[23]] + " "
					+ simianBSB[genome[24]] + " "
					+ simianMinLine[genome[10]] 
					);
		else if (args[25].equals("f"))
			System.out.println(
					ccfxMinToken[genome[0]] + ", " 
					+ ccfxTKS[genome[1]] + " & "
					+ deckardMinToken[genome[2]] + ", "
					+ deckardStride[genome[3]] + ", "
					+ deckardSim[genome[4]] + " & " 
					+ nicadMinLine[genome[5]] + ", " 
					+ nicadMaxLine[genome[6]] + ", " 
					+ nicadUpi[genome[7]] + ", " 
					+ nicadBlind[genome[8]] + ", " 
					+ nicadAbstract[genome[9]] + " & " 
					+ simianICB[genome[11]] + ", "
					+ simianID[genome[12]] + ", " 
					+ simianIDC[genome[13]] + ", " 
					+ simianIS[genome[14]] + ", " 
					+ simianISC[genome[15]] + ", " 
					+ simianIN[genome[16]] + ", "
					+ simianIC[genome[17]] + ", " 
					+ simianICC[genome[18]] + ", " 
					+ simianIL[genome[19]] + ", " 
					+ simianISN[genome[20]] + ", " 
					+ simianIM[genome[21]] + ", " 
					+ simianIVN[genome[22]] + ", "
					+ simianBP[genome[23]] + ", "
					+ simianBSB[genome[24]] + ", "
					+ simianMinLine[genome[10]] 
					);
		else 
			System.out.println("Wrong mode!");
	}
}
