import java.util.ArrayList;
import java.lang.StringBuilder;

public class Deliverable5 {
	
	public static void main(String[] args){
		ArrayList<String> exhaustive = new ArrayList<String>();
		int numberOfArgs = args.length;
		for(int i=0; i<numberOfArgs; i++){ //prints the names of the args
			System.out.print(args[i] + "\t");
		}
		System.out.println();
		exhaustive = generateExhaustive(numberOfArgs);
		for(int i=0; i<exhaustive.size(); i++){
			System.out.println(exhaustive.get(i));
		}
	}
	
	
	//generateExhaustive generates the exhaustive truth table for the number of arguements entered
	//parameters: int num: number of arguements entered when running the program
	//returns: ArrayList of strings where each element is the string representation of a line of the exhaustive truth table
	public static ArrayList<String> generateExhaustive(int num){
		ArrayList<String> temp = new ArrayList<String>();
		int rows = (int) Math.pow(2,num); //number of rows in an exhuastive truth table is 2^num
		for(int i=0; i<rows; i++){
			StringBuilder tempBuilder = new StringBuilder();
			for(int j=num-1; j>=0; j--){
				int tempInt = i/(int) Math.pow(2,j)%2;
				tempBuilder.append(tempInt);
				tempBuilder.append("\t");
			}
			temp.add(tempBuilder.toString());
		}
		return temp;
	}
}
