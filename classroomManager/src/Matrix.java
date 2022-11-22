/*public class Matrix
 * This class contains the item type of Matrixx which contains a int [][] array
 * 
 * contains methods that are used to modify the int [][] array
 * Matrix represents a table full of numbers that can be changed by the user
 * In the Super class, Main class, a instance of Matrix will be called.
 */

import java.util.Random; //import random to be used in methods as a way to computer generate random numbers

public class Matrix { //class start

	/* field variables
		matrix : int [][] variable that will contain the numbers of the array/table accessed by class Matrix
	 */
							 // initializing field variables as private to make sure they can only be changes through setters rather than accessed directly from super class
	private int matrix [][]; //field variable 

	/* Constructor Matrix
	 * This constructor is used to create an Matrix object which represents a table within classroomManager
	 * Parameters:
	 * 		row : int variable that represents the number of rows
     *      column : int variable that represents the number of columns
	 * Return Value
	 * 		none
	 * Local Variables:
	 * 		none
	 */
	public Matrix(int row, int column) {
		matrix = new int[row][column]; // initializes the field variable with the parameters

	}
	/* Constructor Matrix - overload
	 * This constructor is used to create an Matrix object which represents a table within classroomManager, includes the integerFillValue variable which is the overload portion, in which it pre assigns all values within the Matrix array
	 * Parameters:
	 * 		row : int variable that represents the number of rows
     *      column : int variable that represents the number of columns
	 * 		integerFillValue : int variable that represents the value that will be set as the default value of the Matrix
	 * Return Value
	 * 		none
	 * Local Variables:
	 * 		none
	 */
	public Matrix(int row, int column, int integerFillValue) {
		matrix = new int[row][column];// initializes the field variable with the parameters
		setSpecificValue(integerFillValue); // sets the default values of the field variable matrix using the method setSpecificValue
	}
	
	/* method setRandomValues
	 * This method sets random values within the matrix field variable 
	 * Parameters:
	 * 		min : int variable that represents the low bound of the random range
     *      max : int variable that represents the high bound of the random range
	 * Return Value
	 * 		none
	 * Local Variables:
	 * 		rand : Random variable, used to generate random int
	 */
	public void setRandomValues(int min,int max) {
		Random rand = new Random(); // create instance of Random
		for (int i=0; i<matrix.length; i++) { //loop in row of matrix
			for (int j=0; j<matrix[0].length; j++) { //loop through columns of matrix
				matrix[i][j] = rand.nextInt(max-min) + min; // sets a random value and used the rand variable 
			}//end of j
		}//end of i
	}

	/* method setSpecificValue
	 * This method sets random values within the matrix field variable 
	 * Parameters:
	 * 		value : int variable that represents specific value that will fill in the entire matrix field variable
	 * Return Value
	 * 		none
	 * Local Variables:
	 * 		none
	 */
	public void setSpecificValue(int value) {
		for (int i=0; i<matrix.length; i++) { // loops through rows of matrix
			for (int j=0; j<matrix[0].length; j++) { // loops through columns of matrix
				matrix[i][j] = value; // assigns every iteration of matrix to value parameter variable
			}//end of j
		}//end of i
	}	
	
	/* method largestEntry
	 * This method returns the largest value within matrix field variable
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		highest : int variable that represents the highest value within matrix field variable
	 * Local Variables:
	 * 		highest : int variable that represents the highest value within matrix field variable
	 */
	public int largestEntry () {
		int highest; //initializes highest
		highest = matrix[0][0]; // assigns highets to first value of matrix
		for (int i=0; i<matrix.length; i++) { //loops through matrix
			for (int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] > highest) //checks if teh current value is greater than highest
					highest  = matrix[i][j]; // if it is greater than it re-assigns the value of highest
				
			}//end of j
		}//end of i
		return highest; //returns the highest/largest value of matrix
	}
	/* method smallestEntry
	 * This method returns the smallest value within matrix field variable
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		lowest : int variable that represents the smallest value within matrix field variable
	 * Local Variables:
	 * 		lowest : int variable that represents the smallest value within matrix field variable
	 */
	public int smallestEntry () {
		int lowest; //initializes lowest
		lowest = matrix[0][0]; //assigns lowest to first value of matrix
		for (int i=0; i<matrix.length; i++) { //loops through matrix
			for (int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] < lowest) //checks if current value is smaller than lowest
					lowest  = matrix[i][j]; //if it is then it re-assigns the value of lowest to the current value
				
			}//end of j
		}//end of i
		return lowest; //returns the lowest of the entries in matrix
	}


	/* method averageOfEntries
	 * This method returns the average of all the entries within matrix
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		double variable that represents average of the entries
	 * Local Variables:
	 * 		number : int variable that represents the total sum of all the entries
	 * 		counter : int variable that represents the number of entries within the matrix
	 */
	public double averageOfEntries () {
		int number;  //initializes number and counter
		int counter;
		number = 0; //sets both local variables to 0 initially, they will add to as the program continues
		counter = 0;
		
		for (int i=0; i<matrix.length; i++) { //loops through matrix
			for (int j=0; j<matrix[0].length; j++) {
				number+=matrix[i][j]; // adds each entries value to the variable number
				counter+=1; // adds 1 for each entry in counter
			}//end of j
		}//end of i
		return Utils.roundDouble((double)number/counter, 2);//returns the average using the mean formula, and rounds the double to 2 decimal places, if neccessary
	}
	
	/* method returnDashes
	 * This method returns dashes for formatting the 2 dimensional array
	 * Parameters:
	 * 		count : int variable that represents number of dashes that will be printed
	 * Return Value
	 * 		temp : string variable that contains the dashes
	 * Local Variables:
	 *	 	temp : string variable that contains the dashes

	 */
	public static String returnDashes(int count) {
		String temp = ""; // initializes the temp variable
		for (int i=0; i<count;i++) //loops through count
			temp+="-"; //adds a dash for every iteration of count
		return temp; //returns the filled in temp string
	}
	
	/* method displayArray
	 * This method returns a output for the display of matrix in a formatted fashion
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		none
	 * Local Variables:
	 *	 	none

	 */
	public void displayArray() {
		System.out.println("\n"+returnDashes(getColumnCount() * 4));//prints string line of dashes to cover the top portion of the array
		
		for (int i=0; i<matrix.length; i++) { //loops through row
			for (int j=0; j<matrix[0].length ; j++)  { //loops through column
				//adds | between all entries in a row
				System.out.print("|");
				System.out.print(matrix[i][j]); //surround the value with '|'
				System.out.print("|");
			} //end for j
			System.out.println("\n"+returnDashes(matrix[0].length * 4)); // prints string line of dashes to cover the bottom portion of each row and seperates rows
		} // end for i
	}
	
	/* method getColumnCount
	 * This method returns the number of columns within matrix
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		none
	 * Local Variables:
	 *	 	none
	 */
	public int getColumnCount() {
		return matrix[0].length;	//return the length of row number 1
	}
	/* method getRowCount
	 * This method returns the number of rows within matrix
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		none
	 * Local Variables:
	 *	 	none
	 */
	public int getRowCount() {
		return matrix.length;//return the length of a column
	}
	
	/* method getRow
	 * This method returns a specific row
	 * Parameters:
	 * 		value : int variable that represents the row number
	 * Return Value
	 * 		int [] variable that represents a row
	 * Local Variables:
	 *	 	none
	 */
	public int[] getRow(int value) {
		return matrix[value]; //returns a row at position value
	}
	/* method getColumn
	 * This method returns a specific column
	 * Parameters:
	 * 		value : int variable that represents the column number
	 * Return Value
	 * 		tempArray : int [] variable that represents a column
	 * Local Variables:
	 * 		tempArray : int [] variable that represents a column
	 */
	public int[] getColumn(int value) {
		int [] tempArray; //initializes the tempArray var
		tempArray = new int [getRowCount()]; // sets the length of tempArray to the number of rows
		for (int i =0; i<getRowCount();i++) //loops through each entry in the column
			tempArray[i] = matrix[i][value]; //sets the indiviual values wihin the column
		
		return tempArray;	//returns the array	
	}
	
	/* method getTranspose
	 * This method returns the transpose of matrix
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		source : Matrix variable that is the transpose of matrix
	 * Local Variables:
	 * 		source : Matrix variable that is the transpose of matrix
	 */
	public Matrix getTranspose() {
		Matrix source;//initializes source
		source = new Matrix(getColumnCount(), getRowCount()); //calls constructor and initializes it to the opposite dimensions of matrix
		for (int i=0; i<matrix.length;i++) { //loops through matrix
			for (int j =0; j<matrix[0].length;j++) {
				source.matrix[j][i] = matrix[i][j];//assigns the values of source by using the opposite column and row numbers
			}
		}
		return source; //returns the new Matrix of the transpose
	}
	
	/* method getEquals
	 * This method returns if matrix is equal to another Matrix object
	 * Parameters:
	 * 		obj : Matrix variable that represents a new object/instance of Matrix
	 * Return Value
	 * 		valid : boolean variable that represents if the two Matrix's are equal
	 * Local Variables:
	 * 		valid : boolean variable that represents if the two Matrix's are equal
	 */
	public boolean getEquals(Matrix obj) { 
		boolean valid; //initializes valid
		valid = true; //sets value to false 
		
		if (obj.getRowCount() == getRowCount() && obj.getColumnCount() == getColumnCount()) { //checks if the dimensions of both Matrix instances are the same
				//verefied same length of matrix total
				for (int i=0; i<matrix.length;i++) { //loops through matrix
					for (int j =0; j<matrix[0].length;j++) {
						if(matrix[i][j] != obj.getMatrix()[i][j]) { //checks if each value is also the same
							valid = false; //if it is not the same then it changes the valif to false
						}

					}
					
				}//for  loop
		}

		return valid; //returns the valid variable which if the instances are the EXACT same
	}
	
	/* method getMatrix
	 * This method returns matrix
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		int [][] variable that contains the matrix
	 * Local Variables:
	 * 		none
	 */
	public int [][] getMatrix(){
		return matrix;//returns matrix
	}
}


	