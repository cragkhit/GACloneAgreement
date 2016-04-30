package ssbse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InitialPopulationGenerator {
	
	private static Random random;
	private static MaxOnes fitnessEvaluator;

	private static HashMap<Integer, Integer> genesPossibleValues;
	
	public static void main(String[] args){
		System.out.println("Creating initial population");
		
		random = new Random();
		fitnessEvaluator = new MaxOnes();
		
		ArrayList<int[]> individualsGenomes = new ArrayList<int[]>();
		ArrayList<Double> individualsFitness = new ArrayList<Double>();
		
		genesPossibleValues = getGenesPossibleValues();
		
		int[] defaultIndividual = null;
		int[] randomIndividual = null;
		
		double populationSize = getPopulationSize();
		
		defaultIndividual = getDefaultIndividual();
		individualsGenomes.add(defaultIndividual);
		individualsFitness.add(fitnessEvaluator.evaluate(defaultIndividual));
		
		for(int i = 1; i < populationSize; i++){
			randomIndividual = getRandomIndividual();
			individualsGenomes.add(randomIndividual);
			individualsFitness.add(fitnessEvaluator.evaluate(randomIndividual));
		}
		
		writeECJPopulationInputFile(individualsGenomes, individualsFitness);
	}
	
	private static double getPopulationSize(){
		double populationSize = 0;
		String configFileName = "clone.params";
		String line = null;

		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File(configFileName)));
			
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
			System.out.println("Error in getting population size from " + configFileName);
			e.printStackTrace();
		}
		
		return populationSize;
	}
	
	private static HashMap<Integer, Integer> getGenesPossibleValues(){
		HashMap<Integer, Integer> genesPossibleValues = new HashMap<Integer, Integer>();
		String configFileName = "clone.params";
		String line = null;
		String[] splittedLine = null;

		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File(configFileName)));
			
			while(reader.ready()){
				line = reader.readLine();

				if(line.contains("pop.subpop.0.species.max-gene") == true){
					splittedLine = line.split("=");
					
					if(splittedLine[0].split("\\.").length == 6){
						genesPossibleValues.put(Integer.parseInt(splittedLine[0].split("\\.")[5].replace(" ", "")), Integer.parseInt(splittedLine[1].replace(" ", "")));
					}
				}
			}
			
			reader.close();
		}
		catch(Exception e){
			System.out.println("Error in genes possible values from " + configFileName);
			e.printStackTrace();
		}
		
		return genesPossibleValues;
	}
	
	private static int[] getDefaultIndividual(){
		int[] defaultIndividual =  {4, 11, 0, 2, 0, 1, 5, 3, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0};
		return defaultIndividual;
	}
	
	private static int[] getRandomIndividual(){
		int[] randomIndividual = new int[getDefaultIndividual().length];
		
		for(int i = 0; i < randomIndividual.length; i++){
			randomIndividual[i] = random.nextInt(genesPossibleValues.get(i) + 1);
		}
		
		return randomIndividual;
	}
	
	private static void writeECJPopulationInputFile(ArrayList<int[]> individualsGenomes, ArrayList<Double> individualsFitness){
		int[] individualGenome = null;

		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("pop.in")));
			
			writer.write("Number of Individuals: i" + individualsFitness.size() + "|\n");
			
			for(int i = 0; i < individualsGenomes.size(); i++){
				individualGenome = individualsGenomes.get(i);

				writer.write("Individual Number: i" + i + "|\n");
				writer.write("Evaluated: T\n");
				writer.write("Fitness: d|" + individualsFitness.get(i) + "|\n");
				
				writer.write("i" + individualGenome.length + "|");
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
