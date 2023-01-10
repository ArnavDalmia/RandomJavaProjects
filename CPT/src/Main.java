/*public class Main
 * This class is the super class Main
 * It operates the entire program
 */
import java.util.Scanner;
public class Main {
	
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
	 * 		
	 */
	public static void main(String[] args) {
		

}
