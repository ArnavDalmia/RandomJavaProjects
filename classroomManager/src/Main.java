
import java.util.Scanner;
public class Main {

	public static Matrix createMatrix(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Create Your Matrix\n");

		int row;
		int column;
		int value;

		row = Utils.obtainIntegerInputLow("Please enter number of rows: ", 1);
		column = Utils.obtainIntegerInputLow("Please enter number of columns: ", 1);
		
		boolean valid;
		valid  = false;
		while(!valid){	
			String answer;
			System.out.println("Would you like to set the values of the matrix right now to ONE specific number?(YES/NO)");
			System.out.println("If NO then values will be set to random numbers, UNTIL CHANGED.");

			answer = userInput.nextLine();																							
			answer = answer.toUpperCase();
																	
			if(answer.equals("YES"))
				valid = true;													
			else if (answer.equals("NO"))											
				break;																		
			else 
				System.out.println("Invalid Input. Please input either YES or NO.");		
		}

		if(valid){
			value = Utils.obtainIntegerInputLowHigh("Please enter the specific value: ",10,99);
			return new Matrix(row, column, value);
		}
		Matrix temp = new Matrix(row, column);
		temp.setRandomValues(10,100);
		return temp;
	} 
	public static int menu(){
		System.out.println("1.	Display matrix");		
		System.out.println("2.	Print specific Row");	
		System.out.println("3.	Print specific Column");							
		System.out.println("4.	Print the transpose(opposite) of matrix");
		System.out.println("5.	Set random values of matrix");								
		System.out.println("6.	Set specific values of matrix");
		System.out.println("7.	Print smallest entry");
		System.out.println("8.	Print largest entry");
		System.out.println("9.	Print average of entries");
		System.out.println("10.	RESET MATRIX");
		System.out.println("11.	Quit");
		return Utils.obtainIntegerInputLowHigh("",1,11);				     
	}


	public static void main(String[] args) {
		Matrix initialMatrix;
		System.out.println("Welcome to the Matrix creation program.");
		initialMatrix = createMatrix();
		System.out.println("Matrix has been made.\n\n");
		
		while(true){
			int choice;
			choice = menu();
			
			if (choice == 1){
				initialMatrix.displayArray();
			}
			
			else if(choice == 2){
				int max;
				max = initialMatrix.getRowCount();

				int row;
				row = Utils.obtainIntegerInputLowHigh("Enter The row number that you would like printed: ", 1, max);
				int [] specificRow;
				specificRow = initialMatrix.getRow(row-1);
				//display portion needs to be done
				System.out.println("\n"+initialMatrix.returnDashes(initialMatrix.getColumnCount() * 4));
				
				for (int j=0; j<specificRow.length ; j++)  {
					System.out.print("|");
					System.out.print(specificRow[j]);
					System.out.print("|");
				} //end for j
				
				System.out.println("\n"+initialMatrix.returnDashes(initialMatrix.getColumnCount() * 4));

			}
			else if(choice == 3){
				int max;
				max = initialMatrix.getColumnCount();

				int row;
				row = Utils.obtainIntegerInputLowHigh("Enter The column number that you would like printed: ", 1, max);
				int [] specificColumn;
				specificColumn = initialMatrix.getColumn(row-1);
				//display portion needs to be done
				System.out.println("\n"+"----");
				for (int j=0; j<specificColumn.length ; j++)  {
					System.out.print("|");
					System.out.print(specificColumn[j]);
					System.out.print("|");
					System.out.println("\n"+"----");
				} //end for j

			}
			else if(choice == 4){
				Matrix transpose;
				transpose = initialMatrix.getTranspose();
				transpose.displayArray();
			}
			else if(choice == 5){
				int low;
				int high;
				low = Utils.obtainIntegerInputLowHigh("What would you like to be lowbound of the random numbers: ",0,99);
				high = Utils.obtainIntegerInputLowHigh("What would you like to be highbound of the random numbers: ",0,99);
				if (high < low){
					System.out.println("Error. High bound must be greater than Low bound. Please Try Again.\n");
				}
				else{
					initialMatrix.setRandomValues(low, high+1);
					System.out.println("Successfully set values to be randomized between low and high ranges\n");

				}
			}
			else if(choice == 6){
				int value;
				value = Utils.obtainIntegerInputLowHigh("Enter specific value: ", 10, 99);
				initialMatrix.setSpecificValue(value);
				System.out.println("Matrix has been successfully changed to contain solely the value of "+value+".");
			}
			else if(choice == 7){
				System.out.println("Matrix smallest value is "+initialMatrix.smallestEntry()+"\n");

			}
			else if(choice == 8){
				System.out.println("Matrix largest value is "+initialMatrix.largestEntry()+"\n");
			}
			else if(choice == 9){
				System.out.println("Matrix average of values is "+initialMatrix.averageOfEntries()+"\n");
			}
			else if(choice == 10){
				System.out.println("Matrix has been reset to empty");
				System.out.println("Information is required:\n\n");

				initialMatrix = createMatrix();
				System.out.println("Matrix has been reset.\n\n");

			}
			else
				break;
			
		}//while loop 

		System.out.println("Thank you for using the Matrix program.");
		
	}

}
