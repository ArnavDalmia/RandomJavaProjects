
import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static Matrix createMatrix(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Matrix creation program.");
		System.out.println("Create Your Matrix\n");

		int row;
		int column;
		int value;

		row = Utils.obtainIntegerInputLow("Please enter number of rows: ", 0);
		column = Utils.obtainIntegerInputLow("Please enter number of columns: ", 0);
		
		
		boolean valid;
		valid  = false;
		while(!valid){	
			String answer;
			System.out.println("Would you like to set the values of the matrix right now to ONE specific number?(YES/NO)");
			System.out.println("If NO then values will be set to 0, until changed.");

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
			value = Utils.obtainIntegerInputLow("Please enter the specific value: ",0);
			return new Matrix(row, column, value);
		}
		Matrix temp = new Matrix(row, column);
		temp.setSpecificValue(0);
		return temp;
	} 
	public static int menu(){
		System.out.println("1.	Display matrix");		
		System.out.println("2.	Print specific Row");	
		System.out.println("3.	Print specific Column");							
		System.out.println("4.	Print the transpose(opposite) of matrix");
		System.out.println("5.	Set random values of matrix");								
		System.out.println("6.	Set specific values of matrix");
		System.out.println("7.	RESET MATRIX");
		System.out.println("8.	Quit");
		return Utils.obtainIntegerInputLowHigh("",1,8);				     
	}


	public static void main(String[] args) {
		Matrix initialMatrix;
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
			}
			else if(choice == 3){
				int max;
				max = initialMatrix.getColumnCount();

				int row;
				row = Utils.obtainIntegerInputLowHigh("Enter The column number that you would like printed: ", 1, max);
				int [] specificColumn;
				specificColumn = initialMatrix.getColumn(row-1);
				//display portion needs to be done
			}
			else if(choice == 4){
				Matrix transpose;
				transpose = initialMatrix.getTranspose();
				transpose.displayArray();
			}
			else if(choice == 5){
				int low;
				int high;
				low = Utils.obtainIntegerInput("What would you like to be lowbound of the random numbers: ");
				high = Utils.obtainIntegerInput("What would you like to be highbound of the random numbers: ");
				if (high < low){
					System.out.println("Error. High bound must be greater than Low bound. Please Try Again.\n");
				}
				else{
					initialMatrix.setRandomValues(low, high);
					System.out.println("Successfully set values to be randomized between low and high ranges\n");

				}
			}
			else if(choice == 6){
				int value;
				value = Utils.obtainIntegerInputLow("Enter specific value: ", 0);
				initialMatrix.setSpecificValue(value);
				System.out.println("Matrix has been successfully changed to contain solely the value of "+value+".");
			}
			else if(choice == 7){
				System.out.println("Matrix has been reset to empty");
				System.out.println("Information is required:\n\n");

				initialMatrix = createMatrix();
				System.out.println("Matrix has been reset.\n\n");

			}
			else
				break;
			
		}//while loop 

		
	}

}
