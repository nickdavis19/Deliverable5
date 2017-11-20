import java.util.ArrayList;

public class Pairwise {

	public static void main(String[] args){
		try{
			ArrayList<int[]> exhaustive = new ArrayList<int[]>();
			ArrayList<int[]> interactions = new ArrayList<int[]>();
			ArrayList<int[]> covering = new ArrayList<int[]>();
			int numberOfArgs = args.length;

			if (numberOfArgs < 2){
				System.out.println("Please enter at least two parameters!");
				throw new RuntimeException();
			}

			args = truncateParameters(args, numberOfArgs);

			String dashes = "";
			for(int i=0; i<numberOfArgs; i++){ //prints the names of the args
				int numSpaces = 12 - args[i].length();
				StringBuilder spaces = new StringBuilder();
				for(int j=0; j < numSpaces; j++){
					spaces = spaces.append(" ");
				}
				dashes = dashes + "-------------";
				System.out.print(args[i] + spaces + "| ");
			}

			System.out.println();
			System.out.print(dashes);
			System.out.println();

			exhaustive = generateExhaustive(numberOfArgs);
			interactions = generateInteractions(numberOfArgs);
			covering = generateCovering(exhaustive, interactions);
			for(int i=0; i<exhaustive.size(); i++){
				int[] tempArray = exhaustive.get(i);
				for(int j=0; j<tempArray.length; j++){
					System.out.print(tempArray[j] +"           "+"| ");
				}
				System.out.println();
			}
		}
		catch(RuntimeException rte){
			System.exit(-1);
		}
	}


	//generateExhaustive generates the exhaustive truth table for the number of arguements entered
	//parameters: int num: number of arguements entered when running the program
	//returns: ArrayList of strings where each element is the string representation of a line of the exhaustive truth table
	public static ArrayList<int[]> generateExhaustive(int num){
		ArrayList<int[]> temp = new ArrayList<int[]>();
		int rows = (int) Math.pow(2,num); //number of rows in an exhuastive truth table is 2^num
		for(int i=0; i<rows; i++){
			int[] tempArray = new int[num];
			int k = 0;
			for(int j=num-1; j>=0; j--){
				int tempInt = i/(int) Math.pow(2,j)%2;
				tempArray[k] = tempInt;
				System.out.println(tempInt);
				k++;
			}
			System.out.println("her");
			temp.add(tempArray);
		}
		return temp;
	}

	//truncateParameters truncates each parameter to at most 10 characters then returns the resulting array of truncated parameters
	//parameters: String[] args: the command line arguments, int numberOfArgs: the number of command line arguments
	//returns: String[] of the resulting truncated args
	public static String[] truncateParameters(String[] args, int numberOfArgs){
		String[] returnArr = new String[numberOfArgs];
		for(int i = 0; i < args.length; i++){
			String temp = args[i];

			if (temp.length() > 10){
				temp = temp.substring(0,10);
			}
			returnArr[i] = temp;

			}
		return returnArr;
		}

	//generateCovering generates the covering array for a provided truth table
		//parameters: ArrayList<int[]> truthT: a truth table for the number of arguements entered when running the program
		//returns: ArrayList<int[]> where each element is an int array that represents a line of the covering array
		public static ArrayList<int[]> generateCovering(ArrayList<int[]> truthT, ArrayList<int[]> interactions){
			ArrayList<int[]> covering = new ArrayList<int[]>();
			ArrayList<int[]> pairwiseTT = new ArrayList<int[]>();
			pairwiseTT = generatePairwiseTT();
			int[] rowsToKeep = new int[truthT.size()]; //max possible rows needed is the exhaustive array size
			for(int i=0; i<rowsToKeep.length; i++){ //starts with no rows needed, all 0s. 0=not needed, 1=needed
				rowsToKeep[i] = 0;
			}
			for(int i=0; i<interactions.size(); i++){ //current interaction we're dealing with
				int[] currentInteraction = interactions.get(i);

				for(int k=0; k<truthT.size(); k++){ //current row in the truth table we're dealing with
					int[] tempArray = truthT.get(k);

					for(int j=0; j<pairwiseTT.size()-1; j++){ //current row in the pairwiseTT we're trying to match
						int[] tempPair = pairwiseTT.get(j);

						if(tempArray[currentInteraction[0]] == tempPair[0] && tempArray[currentInteraction[1]] == tempPair[1]
						|| tempArray[currentInteraction[1]] == tempPair[0] && tempArray[currentInteraction[0]] == tempPair[1]){
							if(covering.contains(tempArray)){
								System.out.print("");
							}else{
								covering.add(k, tempArray);
							}
						}
					}

				}
			}
			return covering;
		}

		//generateInteractions makes a list of all the pairwise interactions
		//parameters: int num: number of argurments entered when running the program
		//returns: ArrayList<int[]> where each element is an int array that represents a pairwise interaction
		public static ArrayList<int[]> generateInteractions(int num){
			ArrayList<int[]> theInteractions = new ArrayList<int[]>();
			for(int i=0; i<num-1; i++){
				for(int j=i+1; j<num; j++){
					int[] row = {i,j};
					theInteractions.add(row);
				}
			}
			return theInteractions;
		}

		//generatePairwiseTT makes a standard pairwise TT to use
		//parameters: none
		//returns ArrayList<int[]> where each element is a row in a pairwise TT
		public static ArrayList<int[]> generatePairwiseTT(){
			ArrayList<int[]> pairwiseTT = new ArrayList<int[]>();
			// int[] pair = new int[2];
			for(int i=0; i<2; i++){
				for(int j=0; j<2; j++){
					int[] pair = new int[2];

					pair[0] = i;
					pair[1] = j;
					pairwiseTT.add(pair);
				}
			}

			return pairwiseTT;
		}
}
