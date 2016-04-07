package ssbse;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import ec.*;
import ec.simple.*;
import ec.vector.*;

public class MaxOnes extends Problem implements SimpleProblemForm {
	private static final long serialVersionUID = 1L;
	private String[] ccfxMinToken = { 
			"10", "20", "30", "40", "50", "60", "70", "80", "90", "100", 
			"110", "120", "130", "140", "150", "160", "170", "180", "190", "200", 
			"210", "220", "230", "240", "250", "260", "270", "280", "290", "300" };
	private String[] ccfxTKS = { 
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
			"30", "40", "50", "60", "70", "80", "90", "100", "120", "140", 
			"160", "180", "200", "220", "240", "260", "280", "300" };
	
	private String[] deckardMinToken = { "30", "50" };
	private String[] deckardStride = { "0", "2", "4", "5", "8", "16", "inf"};
	private String[] deckardSim = { "0.9", "0.95", "1.00" };
	
	private String[] nicadMinLine = { "5", "6", "7", "8", "9", "10" };
	private String[] nicadMaxLine = { "100", "200", "300", "400", "500", 
			"600", "700", "800", "900", "1000", "2000", "2500" };
	private String[] nicadUpi = { "0.00", "0.10", "0.20", "0.30" };
	private String[] nicadBlind = { "none", "blind", "consistent" };
	private String[] nicadAbstract = { "none", "block", "declaration", "statement", "expression", "condition", "literal" };

	private String[] simianMinLine = { "5", "6", "7" };
	private String[] simianICB = { "true", "false" };
	private String[] simianID = { "true", "false" };
	private String[] simianIDC = { "true", "false" };
	private String[] simianIS = { "true", "false" };
	private String[] simianISC = { "true", "false" };
	private String[] simianIN = { "true", "false" };
	private String[] simianIC = { "true", "false" };
	private String[] simianICC = { "true", "false" };
	private String[] simianIL = { "true", "false" };
	private String[] simianISN = { "true", "false" };
	private String[] simianIM = { "true", "false" };
	private String[] simianIVN = { "true", "false" };
	private String[] simianBP = { "true", "false" };
	private String[] simianBSB = { "true", "false" };
	
	//private static String HOMEDIR="/home/cragkhit/ssbse2016";
	//private static String SCRIPT="scripts/run.sh";
	//private static String INPUTDIR="/home/cragkhit/ssbse2016/systems/mockito-master";
	//private static String OUTPUTDIR="/home/cragkhit/ssbse2016/clones";

	private static String HOMEDIR="/home/mhepaixao/ssbse2016";
	private static String SCRIPT="scripts/run.sh";
	private static String INPUTDIR="/home/mhepaixao/ssbse2016/systems/mockito-master";
	private static String OUTPUTDIR="/home/mhepaixao/ssbse2016/output";
	private static String CLONEDIR="/home/mhepaixao/ssbse2016/clones";
	private static String SYSNAME="mockito-master";

	public double evaluate(int[] genome){
		double fitness = 0;

		System.out.println("[" + genome[0] + "," + genome[1] + "," 
				+ genome[2] + "," + genome[3] + "," + genome[4] + "," 
				+ genome[5] + "," + genome[6] + "," + genome[7] + "," 
				+ genome[8] + "," + genome[9] + "," + genome[10] + "," 
				+ genome[11] + "," + genome[12] + "," + genome[13] + ","
				+ genome[14] + "," + genome[15] + "," + genome[16] + ","
				+ genome[17] + "," + genome[18] + "," + genome[19] + ","
				+ genome[20] + "," + genome[21] + "," + genome[22] + ","
				+ genome[23] + "," + genome[24] + "]");
		System.out.println(
				ccfxMinToken[genome[0]] + "," 
				+ ccfxTKS[genome[1]] + "\n" 
				+ deckardMinToken[genome[2]] + ","
				+ deckardStride[genome[3]] + ","
				+ deckardSim[genome[4]] + "\n" 
				+ nicadMinLine[genome[5]] + "," 
				+ nicadMaxLine[genome[6]] + "," 
				+ nicadUpi[genome[7]] + "," 
				+ nicadBlind[genome[8]] + "," 
				+ nicadAbstract[genome[9]] + "\n" 
				+ simianMinLine[genome[10]] + "," 
				+ simianICB[genome[11]] + ","
				+ simianID[genome[12]] + "," 
				+ simianIDC[genome[13]] + "," 
				+ simianIS[genome[14]] + "," 
				+ simianISC[genome[15]] + "," 
				+ simianIN[genome[16]] + ","
				+ simianIC[genome[17]] + "," 
				+ simianICC[genome[18]] + "," 
				+ simianIL[genome[19]] + "," 
				+ simianISN[genome[20]] + "," 
				+ simianIM[genome[21]] + "," 
				+ simianIVN[genome[22]] + ","
				+ simianBP[genome[23]] + ","
				+ simianBSB[genome[24]]
				);

		try {
			ProcessBuilder pb = new ProcessBuilder(SCRIPT, 
                    INPUTDIR ,
                    OUTPUTDIR ,
                    ccfxMinToken[genome[0]] , 
					ccfxTKS[genome[1]] , 
					deckardMinToken[genome[2]] ,
					deckardStride[genome[3]] ,
					deckardSim[genome[4]] , 
					nicadMinLine[genome[5]] , 
					nicadMaxLine[genome[6]] , 
					nicadUpi[genome[7]] , 
					nicadBlind[genome[8]] , 
					nicadAbstract[genome[9]] , 
					simianICB[genome[11]] ,
					simianID[genome[12]] , 
					simianIDC[genome[13]] , 
					simianIS[genome[14]] , 
					simianISC[genome[15]] , 
					simianIN[genome[16]] ,
					simianIC[genome[17]] , 
					simianICC[genome[18]] , 
					simianIL[genome[19]] , 
					simianISN[genome[20]] , 
					simianIM[genome[21]] , 
					simianIVN[genome[22]] ,
					simianBP[genome[23]] ,
					simianBSB[genome[24]] ,
					simianMinLine[genome[10]],
					CLONEDIR, SYSNAME);
			pb.directory(new File(HOMEDIR));
			Process p = pb.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			String result = builder.toString();
			
			System.out.println(result);
			// parse the result to get fitness value
			fitness = Double.parseDouble(result.trim());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return fitness;
	}

	public void evaluate(final EvolutionState state, final Individual ind, final int subpopulation,
			final int threadnum) {
		if (ind.evaluated)
			return; // don't evaluate the individual if it's already evaluated
		if (!(ind instanceof IntegerVectorIndividual))
			state.output.fatal("Whoa!  It's not an IntegerVectorIndividual!!!", null);
		IntegerVectorIndividual ind2 = (IntegerVectorIndividual) ind;
		/***
		 * Call ES here
		 */
		double fitness = 0.0;
		
//		System.out.println("[" + ind2.genome[0] + "," + ind2.genome[1] + "," 
//				+ ind2.genome[2] + "," + ind2.genome[3] + "," + ind2.genome[4] + "," 
//				+ ind2.genome[5] + "," + ind2.genome[6] + "," + ind2.genome[7] + "," 
//				+ ind2.genome[8] + "," + ind2.genome[9] + "," + ind2.genome[10] + "," 
//				+ ind2.genome[11] + "," + ind2.genome[12] + "," + ind2.genome[13] + ","
//				+ ind2.genome[14] + "," + ind2.genome[15] + "," + ind2.genome[16] + ","
//				+ ind2.genome[17] + "," + ind2.genome[18] + "," + ind2.genome[19] + ","
//				+ ind2.genome[20] + "," + ind2.genome[21] + "," + ind2.genome[22] + ","
//				+ ind2.genome[23] + "," + ind2.genome[24] + "]");
//		System.out.println(
//				ccfxMinToken[ind2.genome[0]] + "," 
//				+ ccfxTKS[ind2.genome[1]] + "\n" 
//				+ deckardMinToken[ind2.genome[2]] + ","
//				+ deckardStride[ind2.genome[3]] + ","
//				+ deckardSim[ind2.genome[4]] + "\n" 
//				+ nicadMinLine[ind2.genome[5]] + "," 
//				+ nicadMaxLine[ind2.genome[6]] + "," 
//				+ nicadUpi[ind2.genome[7]] + "," 
//				+ nicadBlind[ind2.genome[8]] + "," 
//				+ nicadAbstract[ind2.genome[9]] + "\n" 
//				+ simianMinLine[ind2.genome[10]] + "," 
//				+ simianICB[ind2.genome[11]] + ","
//				+ simianID[ind2.genome[12]] + "," 
//				+ simianIDC[ind2.genome[13]] + "," 
//				+ simianIS[ind2.genome[14]] + "," 
//				+ simianISC[ind2.genome[15]] + "," 
//				+ simianIN[ind2.genome[16]] + ","
//				+ simianIC[ind2.genome[17]] + "," 
//				+ simianICC[ind2.genome[18]] + "," 
//				+ simianIL[ind2.genome[19]] + "," 
//				+ simianISN[ind2.genome[20]] + "," 
//				+ simianIM[ind2.genome[21]] + "," 
//				+ simianIVN[ind2.genome[22]] + ","
//				+ simianBP[ind2.genome[23]] + ","
//				+ simianBSB[ind2.genome[24]]
//				);

		try {
			ProcessBuilder pb = new ProcessBuilder(SCRIPT, 
                    INPUTDIR ,
                    OUTPUTDIR ,
                    ccfxMinToken[ind2.genome[0]] , 
					ccfxTKS[ind2.genome[1]] , 
					deckardMinToken[ind2.genome[2]] ,
					deckardStride[ind2.genome[3]] ,
					deckardSim[ind2.genome[4]] , 
					nicadMinLine[ind2.genome[5]] , 
					nicadMaxLine[ind2.genome[6]] , 
					nicadUpi[ind2.genome[7]] , 
					nicadBlind[ind2.genome[8]] , 
					nicadAbstract[ind2.genome[9]] , 
					simianICB[ind2.genome[11]] ,
					simianID[ind2.genome[12]] , 
					simianIDC[ind2.genome[13]] , 
					simianIS[ind2.genome[14]] , 
					simianISC[ind2.genome[15]] , 
					simianIN[ind2.genome[16]] ,
					simianIC[ind2.genome[17]] , 
					simianICC[ind2.genome[18]] , 
					simianIL[ind2.genome[19]] , 
					simianISN[ind2.genome[20]] , 
					simianIM[ind2.genome[21]] , 
					simianIVN[ind2.genome[22]] ,
					simianBP[ind2.genome[23]] ,
					simianBSB[ind2.genome[24]] ,
					simianMinLine[ind2.genome[10]]);
			pb.directory(new File(HOMEDIR));
			Process p = pb.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			String result = builder.toString();
			
			System.out.println(result);
			// parse the result to get fitness value
			fitness = Double.parseDouble(result.trim());
		} catch (IOException e) {
			e.printStackTrace();
		} 

		if (!(ind2.fitness instanceof SimpleFitness))
			state.output.fatal("Whoa!  It's not a SimpleFitness!!!", null);

		((SimpleFitness) ind2.fitness).setFitness(state, fitness, fitness == 1.0);
		ind2.evaluated = true;
	}
}
