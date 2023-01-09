/* Public class Main
 *  
 * This class is reponsible for the entire operation of the program. It controls userinput and calculates all outputs. This is a one file program.
 */
import java.util.ArrayList;
public class Main {
	
	/*Method obtainIntegerInputLow
 * This method is used to obtain a user input of an integer within a low bound
 * 
 * Parameters:
 * 			graph  :  2 dimensional ArrayList that represents the stem leaf 
 * 			row  :  int variable that represents the rows
 * Return Values:
 * 			temp  :  String variable that represents the values of each row/leaf
 * Local Variables Used:
 * 			none
 */
	public static String doSomething(ArrayList <ArrayList <Integer> > graph,int row) {
		String temp =""; // initializes temp
		for (int i=1;i<graph.get(row).size();i++){ // for loop to add each leaf value to the stem row
			if(i == 1) // basically adds a space between the stem number and leaf
				temp += " ";

			temp += graph.get(row).get(i) + " "; // adds each number in the stem row, and includes a space after each leaf
		}
		return temp; //returns String
	}


		/*Method main
 * This method is used to opperate the program. It calls the inputs of the user and displays the output
 * 
 * Parameters:
 * 			none
 * Return Values:
 * 			none
 * Local Variables Used:
 * 			numbers  :  ArrayList variable that represents the list of randomly generated numbers
 * 			graph  :  2 dimensional ArrayList that represents the stem leaf graph
 * 			firstInput  :  int variable that represents the the number of numbers in the numbers
 * 			secondInput  :  int variable that represents the lowbound of the graph
 * 			thirdInput  :  int variable that represents the highbound of the graph
 * 			i  :  int variable that is used to iterate in for loops
 * 			x  :  int variable that is used to iterate in for loops
 * 			val  :  int variable that represents the first value of each row : stem value
 * 			header  :  String variable that repreents the header of "Stem" and "Leaf"
 */
	public static void main(String[] args) {
		ArrayList <Integer> numbers = new ArrayList<>(); // initialize numbers arraylist
        ArrayList <ArrayList <Integer> > graph = new ArrayList<>(); // initialize graph 2 dimensional arraylist


		int firstInput = Utils.obtainIntegerInputLow("Enter how many numbers you would like: ", 1); // obtain user number of numbers in numbers variable
		int secondInput = Utils.obtainIntegerInputLowHigh("Enter low bound for range of numbers: ", 10, 999); // obtain low boound
		int thirdInput = Utils.obtainIntegerInputLowHigh("Enter high bound for range of numbers: ", secondInput, 999); // obtain high bound

		for(int i=0; i<firstInput; i++){ // fills numbers with random values based on firstInput
			numbers.add(Utils.randomBetween(secondInput, thirdInput)); // call randomBetween for random values
		}

		numbers.sort(null); // sorts the numbers by 

		for(int i = secondInput/10, x = 0; i< thirdInput/10 + 1; i++, x++){ // initializes all rows based on the second and third inputs(why: because we cant display rows before or after our range values)
			graph.add(new ArrayList<Integer>()); // initialize rows
            graph.get(x).add(i); // adds the row number to the first value within the row
		}

        for(int i=0; i < graph.size();i++){ // loop through the graph
			int val; //initializes val to the first value of each row, the stem values
			val = graph.get(i).get(0); 

			for(int j=0; j < firstInput;j++){ // loop through each number in the numbers and checks what row it is in and adds to it
				int number; // initializes number which is the calculated value of each number in numbers - the current row number * 10
				number  =  numbers.get(j) - (val*10); 
				if (number < 10 && number > -1) // if number is between 0 and 10 that means it is i'th row
                    graph.get(i).add(number); // if true then adds to row
					
			}
		}

        String header = String.format("%4s %-100s", "Stem", " Leaf"); //initialize header and prints
        System.out.println(header);

		for (int i=0; i<graph.size();i++) { // loops through graph to display
			System.out.println(String.format("%4s %-100s", graph.get(i).get(0),doSomething(graph,i))); // uses string formatting for spacing, and calls doSomething for the allignment of each row from the stem value

			}
            System.out.println(""); // splits each row by adding new line
	}

}
