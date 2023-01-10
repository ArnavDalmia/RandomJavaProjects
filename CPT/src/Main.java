/*public class Main
 * This class is the super class Main
 * It operates the entire program
 * 
 * Purpose of program is to manage a 2 dimensional array or even called a table
 */
import java.util.Scanner;
public class Main {
	/* method createMatrix
	 * This method creates an instance of Matrix, using user input
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		Matrix variable that is initialized using the row and column variables, and possible the value variable if overload occurs
	 * Local Variables:
	 * 		row : int variable that represents the user inputted number of rows
	 * 		column : int variable that represents the user inputted number of columns
	 * 		value : int variable that represents the user inputted integer fill value
	 * 		valid : boolean variable that is used in looping and veryfing if the user input is a yes or no
	 *		answer  : String variable containing the user input in relation to a yes or no question
	 * 		temp : Matrix variable that is initialized using user input
	 */
	public static Matrix createMatrix(){
		Scanner userInput = new Scanner(System.in); // initializes Random object
		System.out.println("Create Your Matrix\n"); //message of initialization

		int row; // initializes variables row, column, value
		int column;
		int value;

		row = Utils.obtainIntegerInputLow("Please enter number of rows: ", 1); //assigns the row and column to user input that has been error checked using Utils methods 
		column = Utils.obtainIntegerInputLow("Please enter number of columns: ", 1);
		
		boolean valid; // initializes variable valid
		valid  = false; // assigns to false for looping
		while(!valid){	
			String answer;
			System.out.println("Would you like to set the values of the matrix right now to ONE specific number?(YES/NO)"); //asks user for yes or no to if they want to choose a value
			System.out.println("If NO then values will be set to random numbers, UNTIL CHANGED.");

			answer = userInput.nextLine(); // recieves the user input and converts to all caps																					
			answer = answer.toUpperCase();
																	
			if(answer.equals("YES")) //checks if it is YES
				valid = true;					//changes valid to break loop								
			else if (answer.equals("NO"))									//checks if it is NO		
				break;														//if so breaks loop while maintaining that valid is false
			else //if the user doesnt input either  a yes or no
				System.out.println("Invalid Input. Please input either YES or NO.");		//error message
		}

		if(valid){ //if the user selected yes
			value = Utils.obtainIntegerInputLowHigh("Please enter the specific value: ",10,99); //asks user for input regarding fill value
			return new Matrix(row, column, value); //returns new Matrix object using overloaded contructor
		}
		//if the previous code from line 52 isnt run :
		Matrix temp = new Matrix(row, column); //initializes a temp Matrix
		temp.setRandomValues(10,100); //assigns it to random numbers
		return temp;//returns temp
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
		System.out.println("8.	Print largest entry");
		System.out.println("9.	Print average of entries");
		System.out.println("10.	RESET MATRIX");
		System.out.println("11.	Check if matrix is equal to another materix");
		System.out.println("12.	Quit");
		return Utils.obtainIntegerInputLowHigh("",1,12);				 //returns option number, and verefies it using the Utils class    
	}

	/* method main
	 * This method operates the entire program
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		none
	 * Local Variables:
	 * 		initialMatrix : Matrix variable that contains the Matrix object
	 * 		choice : int variable contains the return of menu method
	 * 
	 * 		max : int variable that represents the max number of rows
	 * 		row : int variable that contains the user input regarding the specific row
	 * 		specificRow : int [] variable that contains the specific row based on variable row
	 * 
	 * 		max : int variable that represents the max number of columns 
	 * 		column : int variable that contains the user input regarding the specific column
	 * 		specificColumn : int [] variable that contains the specific column based on variable column
	 * 
	 * 		transpose : Matrix variable that contains the transpose of initialMatrix
	 * 
	 * 		low : int variable that represents the low bound for the random range of numbers
	 * 		high : int variable that represents the high bound for the random range of numbers
	 * 		
	 * 		value : int variable that contains the specific value for the integer fill of initalMatrix
	 * 
	 * 		secondMatrix : Matrix variable that contains another instance of Matrix
	 * 		
	 */
	public static void main(String[] args) {
		Matrix initialMatrix; // initializes initialMatrix
		System.out.println("Welcome to the Matrix creation program."); //welcome message
		initialMatrix = createMatrix(); //calls createMatrix method and contains return in variable initialMatrix
		System.out.println("Matrix has been made.\n\n"); // success message of creation of initalMatrix
		
		while(true){ //commencing loop for menu options
			int choice; //initalize choice
			choice = menu(); // contains return of menu method within choice variable
			
			if (choice == 1){ // 1.	Display matrix
				initialMatrix.displayArray(); // calls displayArray method using intialMatrix variable. Displays initialMatrix in proper method
			}	
			else if(choice == 2){ // 2.	Print specific Row
				int max; //initialize max
				max = initialMatrix.getRowCount(); //max contains the number of rows using getRowCount method

				int row; //initialize row
				row = Utils.obtainIntegerInputLowHigh("Enter The row number that you would like printed: ", 1, max); //row contains the user inputted specific row to be printed
				int [] specificRow; //initialize specificRow
				specificRow = initialMatrix.getRow(row-1); //specificRow is set to the row at position row-1 using getRow method
				System.out.println("\n"+initialMatrix.returnDashes(initialMatrix.getColumnCount() * 4));// dashes that are placed above the row for organization using returnDashes method
				
				for (int j=0; j<specificRow.length ; j++)  {//loops through specificRow
					System.out.print("|");//seperates members of row using '|'
					System.out.print(specificRow[j]);
					System.out.print("|");
				} //end for j
				
				System.out.println("\n"+initialMatrix.returnDashes(initialMatrix.getColumnCount() * 4)); // dashes that are placed under the row for organization using returnDashes method

			}
			else if(choice == 3){ //3.	Print specific Column
				int max; //initialize max
				max = initialMatrix.getColumnCount(); //max contains the number of columns using getColumnCount method

				int column; // initialize variable column
				column = Utils.obtainIntegerInputLowHigh("Enter The column number that you would like printed: ", 1, max); //column now contains the user input of which colum the user wants to output
				int [] specificColumn; // initialize specificColumn
				specificColumn = initialMatrix.getColumn(column-1); // sets specificColumn to the column at position column-1 using getColumn method
				System.out.println("\n"+"----"); // dashes that are placed above the column for organization
				for (int j=0; j<specificColumn.length ; j++)  { //loops through column
					System.out.print("|"); //seperates members of column using '|'
					System.out.print(specificColumn[j]);
					System.out.print("|");
					System.out.println("\n"+"----"); //seperates between rows using dashes
				} //end for j

			}
			else if(choice == 4){ //4.	Print the transpose(opposite) of matrix
				Matrix transpose; // initialize transpose
				transpose = initialMatrix.getTranspose(); //obtain return from getTranspose and store within transpose
				transpose.displayArray(); // displays the transpose
			}
			else if(choice == 5){// 5.	Set random values of matrix
				int low; //initialize variable low
				int high;//initialize variable high
				low = Utils.obtainIntegerInputLowHigh("What would you like to be lowbound of the random numbers: ",0,99); //sets low and high to the user input of what the user desires the low and high bound of the random range to be
				high = Utils.obtainIntegerInputLowHigh("What would you like to be highbound of the random numbers: ",0,99);
				if (high < low){ //checks if the low bound is greater than the high bound, which is not possible so an error message shows
					System.out.println("Error. High bound must be greater than Low bound. Please Try Again.\n");
				}
				else{ // if the low and high bound are valid
					initialMatrix.setRandomValues(low, high+1); //sets the values using setRandomValues method
					System.out.println("Successfully set values to be randomized between low and high ranges\n"); //success message

				}
			}
			else if(choice == 6){//6.	Set specific values of matrix
				int value; //initialize value
				value = Utils.obtainIntegerInputLowHigh("Enter specific value: ", 10, 99); //obtains the value that the user wants as their value and contains it within value
				initialMatrix.setSpecificValue(value); // calls setSpecificValue with value parameter and changes all the entries within initialMatrix to value
				System.out.println("Matrix has been successfully changed to contain solely the value of "+value+"."); //success message
			}
			else if(choice == 7){ // 7.	Print smallest entry
				System.out.println("Matrix smallest value is "+initialMatrix.smallestEntry()+"\n"); //prints out the smallest entry within Matrix
			}
			else if(choice == 8){ // 8.	Print largest entry
				System.out.println("Matrix largest value is "+initialMatrix.largestEntry()+"\n"); // prints the largest entry within Matrix
			}
			else if(choice == 9){ // 9.	Print average of entries
				System.out.println("Matrix average of values is "+initialMatrix.averageOfEntries()+"\n"); //prints out message containing the average of all the entries in the Matrix
			}
			else if(choice == 10){ // 10.	RESET MATRIX
				System.out.println("Matrix has been reset to empty"); //message of deletion of Matrix
				System.out.println("Information is required:\n\n"); //tells user they require to re-enter info regarding the Matrix

				initialMatrix = createMatrix(); //calls createMatrix to initialize the intialMatrix once again with different values
				System.out.println("Matrix has been reset.\n\n"); //success message

			}
			else if(choice == 11){//11.	Check if matrix is equal to another materix
				Matrix secondMatrix; // initialize secondMatrix
				System.out.println("Creating the second matrix"); 
				secondMatrix = createMatrix(); // assigning values to secondMatrix using createMatrix method
				System.out.println("Created the second matrix.\n"); //success message

				secondMatrix.displayArray(); //displays secondMatrix to show user that it successfully was created

				if (initialMatrix.getEquals(secondMatrix)) // if both Matrix objects are the same, checked using the getEquals method on initialMatrix
					System.out.println("\nThese two matrixes are the same!\n");
				else // message if the two are not the same
					System.out.println("\nThese two matrixes are not the same!\n");

			}
			else // 12. quit
				break; //breaks out of loops
			
		}//while loop 

		System.out.println("Thank you for using the Matrix program.");
		
	}

}
