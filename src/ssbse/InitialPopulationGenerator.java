package ssbse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class InitialPopulationGenerator {
	
	private static double percentageOfDefaultConfigurationIndividuals = 100;
	
	private static double defaultConfigurationFitness = 0.2502254755961994;
	
	public static void main(String[] args){
		System.out.println("Creating initial population");
		
		ArrayList<int[]> individualsGenomes = new ArrayList<int[]>();
		ArrayList<Double> individualsFitness = new ArrayList<Double>();
		
		double populationSize = getPopulationSize();
		int numberOfDefaultIndividuals = (int) Math.round(populationSize / (percentageOfDefaultConfigurationIndividuals / 100.0));
		
		for(int i = 0; i < numberOfDefaultIndividuals; i++){
			individualsGenomes.add(getDefaultIndividual());
			individualsFitness.add(defaultConfigurationFitness);
		}
		
		writeECJPopulationInputFile(individualsGenomes, individualsFitness);
	}
	
	private static double getPopulationSize(){
		double populationSize = 0;
		String configFileName = "clone.params";
		String line = null;

		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("../" + configFileName)));
			
			while(reader.ready()){
				line = reader.readLine();

				if(line.contains("pop.subpop.0.size") == true){
					populationSize = Double.parseDouble(line.split("=")[1].replace(" ", ""));
					break;
				}
			}
			
			reader.close();
		}
		catch(Exception e){
			System.out.println("Error in reading " + configFileName);
			e.printStackTrace();
		}
		
		return populationSize;
	}
	
	private static int[] getDefaultIndividual(){
		int[] defaultIndividual =  {4, 11, 0, 3, 0, 5, 11, 3, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0};
		return defaultIndividual;
	}
	
	private static void writeECJPopulationInputFile(ArrayList<int[]> individualsGenomes, ArrayList<Double> individualsFitness){
		int[] individualGenome = null;

		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("../pop.in")));
			
			writer.write("Number of Individuals: i" + individualsFitness.size() + "|\n");
			
			for(int i = 0; i < individualsGenomes.size(); i++){
				individualGenome = individualsGenomes.get(i);

				writer.write("Individual Number: i" + i + "|\n");
				writer.write("Evaluated: T\n");
				writer.write("Fitness: d|" + individualsFitness.get(i) + "|\n");
				
				for(int j = 0; j < individualGenome.length; j++){
					writer.write("i" + individualGenome[j] + "|");
				}
				
				writer.write("\n");
			}
			
			writer.close();
		}
		catch(Exception e){
			System.out.println("Error in writing ecj initial population file ");
			e.printStackTrace();
		}
	}
}
