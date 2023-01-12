/*public class Main
 * This class is the super class Main
 * It operates the entire program
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.text.*; 
import java.util.Random; 

public class Main {
	public static void readFile(ArrayList<Employee> people) { 	

        File txtFile = new File("database.txt");
    	String [] data; 
    	int lineCount=1; 
    	String line; // used to read a line at a time
    	try {
            BufferedReader in = new BufferedReader(new FileReader (txtFile));
    	    line = in.readLine();
    	    
    		while (line != null)  {
    		    data = line.split(", ");
    		    if (data.length == 4) {
    		        lineCount++;
    		        people.add(new Employee(data[0],Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
    		    }
				else if (data.length == 5) {
    		        lineCount++;
    		        people.add(new Manager(data[0],Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]));
    		    }
    		    else
    		        System.out.println("Warning. Invalid output found at line #: "+lineCount+
    		                            " "+Arrays.toString(data));
    			line = in.readLine();
    		}
    		// Close BufferedReader stream
    		in.close();
    	} // end try
    			
    	// Output error message if exception is thrown
    	catch (IOException e) {
    			System.err.println("IOException:" + e.getMessage());	
    	} //end catch
    }

	/* method menu
	 * This method optains the user input to the main menu
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		int variable containing the user inputted menu option
	 * Local Variables:
	 * 		none
	 */
	public static int menu(){
		System.out.println("1.	Display matrix");		//displays menu options
		System.out.println("2.	Print specific Row");	
		System.out.println("3.	Print specific Column");							
		System.out.println("4.	Print the transpose(opposite) of matrix");
		System.out.println("5.	Set random values of matrix");								
		System.out.println("6.	Set specific values of matrix");
		System.out.println("7.	Print smallest entry");
		System.out.println("8.	Quit");
		return Utils.obtainIntegerInputLowHigh("",1,9);				 //returns option number, and verefies it using the Utils class    
	}

	/* method main
	 * This method operates the entire program
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		none
	 * Local Variables:
	 * 		
	 */
	public static void main(String[] args) {
		ArrayList<Employee> people = new ArrayList<>();
		readFile(people);
		people.get(2).printDetails();

		

	

}
}