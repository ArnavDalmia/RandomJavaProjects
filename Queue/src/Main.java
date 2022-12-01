/* class Main (QUEUE)
this class is responsible for the management of the program and ensures user input is valid before calling other classes and methods
*/

import java.util.ArrayList;
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
		System.out.println("1.	Enqueue(add) Entry");		//displays menu options
		System.out.println("2.	Dequeue Entry");	
		System.out.println("3.	Display Queue");		
		System.out.println("4.	Quit");						

		return Utils.obtainIntegerInputLowHigh("",1,4);				 //returns option number, and verefies it using the Utils class    
	}
		/* method main
	 * This method runs the entire program is the only portion of the program that operates with the user
	 * Parameters:
	 * 		none
	 * Return Value
	 * 		none
	 * Local Variables:
	 * 		queue  :  MyQueue variable that represents the arraylist or stack
	 * 		choice :  int variable that represents the user's choice regarding the menu options
	 * 		value  :  int variable that represents the age of the entry/ instance of ClassA
	 * 		name   :  string variable that represents the name of the entry/ instance of ClassA
	 * 		temp   :  ClassA variable that represents the temp return of the pop method within MyQueue
	 */
	public static void main(String[] args) {
		
		MyQueue queue  = new MyQueue();
		queue.enqueue(new ClassA("Bob", 21)); // sets 5 initial values within the queue, can be changed with the rest of the operation of the program
		queue.enqueue(new ClassA("Joe", 74));
		queue.enqueue(new ClassA("Zoey", 12));
		queue.enqueue(new ClassA("Chris", 8));
		queue.enqueue(new ClassA("Peter", 35));

		while(true){ // enters loop for user input until quit option
			if(!queue.isEmpty()){ // ensures that the arraylist isnt empty
				int choice; //initializes choice and sets it to the user inputted menu option number
				choice = menu();
				if (choice == 1){ // option 1
					int value; //initializes two values that are then user inputted for instance of classA
					String name;
					name = Utils.obtainInput("Enter Name: "); //obtains user input
					value  = Utils.obtainIntegerInputLow("Enter Age: ", 0);
					queue.enqueue(new ClassA(name, value)); // creates new entry in arraylist using method
					queue.displayQueue(); // displays arraylist
				}
				else if(choice ==2){ //option 2
					System.out.print("Item Removed: "); // prints the entry that is removed from the arraylist
					ClassA temp = queue.dequeue();// deletes entry
					System.out.println(temp); // adds to the original message to contain the actual entry that was removed
					queue.displayQueue(); // displays arraylist
			}
				else if(choice == 3)//option 3
				queue.displayQueue(); //displays arraylist
				else // due to menu method only input possible would be 4, thererore quit
					break; //breaks out of loop
			}
			else{ //runs if the arraylist is empty
				System.out.println("Queue is empty");
				System.out.println("Create your new entry"); //tells user it must create a entry
				int value;
				String name;
				name = Utils.obtainInput("Enter Name: "); //obtains user input for entry data
				value  = Utils.obtainIntegerInputLow("Enter Age: ", 0);
				queue.enqueue(new ClassA(name, value)); // creates a entry
			}
		}
		

	}

}
