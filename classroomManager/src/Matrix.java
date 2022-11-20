
import java.util.Random;

public class Matrix {
	private int matrix [][];

	
	public Matrix(int row, int column) {
		matrix = new int[row][column];

	}
	public Matrix(int row, int column, int integerFillValue) {
		matrix = new int[row][column];
		setSpecificValue(integerFillValue);
		//program the setValue method to call the integerFill Value
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
	public int averageOfEntries () {
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
		return (number/counter);//round it
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
			} //end for i
			System.out.println("\n"+returnDashes(matrix[0].length * 4));
		} // end for j
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

	