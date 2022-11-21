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
	
	
	public void setRandomValues(int min,int max) {
		Random rand = new Random();
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = rand.nextInt(max-min) + min;
			}//end of j
		}//end of i
	}
	public void setSpecificValue(int value) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = value;
			}//end of j
		}//end of i
	}	
	
	public int largestEntry () {
		int highest; 
		highest = matrix[0][0];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] > highest)
					highest  = matrix[i][j];
				
			}//end of j
		}//end of i
		return highest;
	}
	public int smallestEntry () {
		int lowest; 
		lowest = matrix[0][0];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] < lowest)
					lowest  = matrix[i][j];
				
			}//end of j
		}//end of i
		return lowest;
	}
	public double averageOfEntries () {
		int number; 
		int counter;
		number = 0;
		counter = 0;
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				number+=matrix[i][j];
				counter+=1;
			}//end of j
		}//end of i
		return Utils.roundDouble((double)number/counter, 2);//round it
	}
	

	public static String returnDashes(int count) {
		String temp = "";
		for (int i=0; i<count;i++)
			temp+="-";
		return temp; 
	}
	public void displayArray() {
		System.out.println("\n"+returnDashes(getColumnCount() * 4));
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length ; j++)  {
				System.out.print("|");
				System.out.print(matrix[i][j]);
				System.out.print("|");
			} //end for j
			System.out.println("\n"+returnDashes(matrix[0].length * 4));
		} // end for i
	}
	
	
	public int getColumnCount() {
		return matrix[0].length;	
	}
	public int getRowCount() {
		return matrix.length;
	}
	
	
	public int[] getRow(int value) {
		return matrix[value];
	}
	public int[] getColumn(int value) {
		int [] tempArray;
		tempArray = new int [getRowCount()];
		for (int i =0; i<getRowCount();i++)
			tempArray[i] = matrix[i][value];
		
		return tempArray;		
	}
	
	public Matrix getTranspose() {
		Matrix source = new Matrix(getColumnCount(), getRowCount());
		for (int i=0; i<matrix.length;i++) {
			for (int j =0; j<matrix[0].length;j++) {
				source.matrix[j][i] = matrix[i][j];
			}
		}
		return source;
	}
	
	public boolean getEquals(Matrix obj) { 
		boolean valid;
		valid = false;
		
		if (obj.getRowCount() == getRowCount() && obj.getColumnCount() == getColumnCount()) {
				//verefied same length of matrix total
				for (int i=0; i<matrix.length;i++) {
					for (int j =0; j<matrix[0].length;j++) {
						if(matrix[i][j] == obj.getMatrix()[i][j]) {
							valid = true;
						}
						else
							valid = false;

					}
					
				}//for  loop
		}

		return valid;
	}
	public int [][] getMatrix(){
		return matrix;
	}
}


	