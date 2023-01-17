/*public class Main
 * This class is the super class Main
 * It operates the entire program
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.text.*; 

public class Main {
	public static void login(String username, String password){
		boolean valid;
		valid = false;

		while(!valid){
			String userInput1 = Utils.obtainInput("Enter Login Username: ");
			String userInput2 = Utils.obtainInput("Enter Password: ");

			if (userInput1.equals(username) && userInput2.equals(password))
				valid = true;
			else	
				System.out.println("Login Failed. Username OR Password are incorrect. Try Again. ");
		}
		System.out.println("Login COmpleted. Welcome Mr Monster. ");
	}
	public static void readFile(ArrayList<Employee> people) { 	

        File txtFile = new File("database.txt");//laptop

    	String [] data; 
    	int lineCount=1; 
    	String line; // used to read a line at a time
    	try {
            BufferedReader in = new BufferedReader(new FileReader (txtFile));
    	    line = in.readLine();
    	    
    		while (line != null)  {
    		    data = line.split(", ");
    		    if (data.length == 5) {
    		        lineCount++;
    		        people.add(new Employee(data[0],data[1],Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
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

    public static Employee newEmp(ArrayList<Employee> people){
		boolean invalid = false;
		Employee temp = new Employee(null, null, 0, 0, 0);
		while (!invalid){
			String name = Utils.obtainInput("Enter Full Name: ");
			int ID = Utils.obtainIntegerInputLowHigh("Enter ID: ", 100000, 1000000);
			int age = Utils.obtainIntegerInputLow("Enter age: ",0);
			int salary = Utils.obtainIntegerInputLow("Enter salary: ",0);
			String type = Utils.obtainInputSpecificAnswers("Enter Employee Status(Employee or Manager): ", "Employee", "Manager6");

			boolean verify = true;
			for (Employee b : people){
				if (b.getID() == ID){
					verify = false;
				} 
			}
			if (verify){
				if(!(type.equals("Manager") || type.equals("Employee")))
					System.out.println("Employee Type must be specified as Employee or Manager. ***Case Sensitive. Try again!\n");


				else{
					temp = new Employee(type, name, age, ID, salary);
					invalid = true;}
			}
			else
				System.out.println("Employee ID exists in system. Try Again!\n");
	
		}
     
        return temp;

    }


	public static void writeToFile(ArrayList<Employee> people){
		Scanner userInput = new Scanner(System.in);
			File dataFile = new File("database.txt"); // database.txt for laptop
				
			try{
				// Initialize BufferedWriter and FileWriter objects
				BufferedWriter myFile = new BufferedWriter(new FileWriter(dataFile));
		
				for (int i =0; i<people.size();i++ ){
					Employee b = people.get(i);
			
						// Write data to file
					myFile.write((String) b.getType() + ", ");
					myFile.write((String) b.getName() + ", ");
					myFile.write(Integer.toString(b.getAge()) + ", ");
					myFile.write(Integer.toString(b.getID()) + ", ");
					myFile.write(Integer.toString(b.getSalary()));
					myFile.newLine();
					} //end for loop
		
				// Close BufferedWriter stream
				 myFile.close();
					  
				// Confirm that data has been written
				System.out.println("The data has been successfully written to the file.");
			} // end try statement
		
			// Handle exception if there’s a problem writing to file
			  catch (IOException e) {
				  System.err.println(e.getMessage() + "Error encountered writing to file!");
			  }
			  System.out.println("\n");
			}
	
	public static int inList(ArrayList<Employee> people){
		int index = -1;

		boolean found = false;
		while (!found){
				int ID;
				ID = Utils.obtainIntegerInput("Enter ID of employee: ");

				for(int i = 0; i < people.size(); i++){
					Employee e = people.get(i);
					if (e.getID() == (ID))
						index = people.indexOf(e);
					
						
							}
			if (index > -1)
					found = true;
			else
				System.out.println("Employee doesn't exist. Please check spelling as it is case sensistive.");
			}
		return index;
	}

	public static void displayAllEmployees(ArrayList<Employee> people){
		for(Employee e : people){
			e.printDetailsSimple();
		}
	}
	public static void displaySpecificEmp(ArrayList<Employee> people){
		Employee emp = people.get(inList(people));
		emp.printDetails();
	}
	public static void changeSalary(ArrayList<Employee> people){
		int index = inList(people);
		int newSalary;
		newSalary = Utils.obtainIntegerInputLow("Enter New Salary",0);
		people.get(index).setSalary(newSalary);
		System.out.println("Salary has been adjusted.");
	}

	public static void promote(ArrayList<Employee> people){
		int index = inList(people);
		if (people.get(index).getType().equals("Manager"))
			System.out.println("Sorry this is a Manager, requires CEO permission and CEO software to promote.");
		else{
			people.get(index).setType("Manager");
			System.out.println(people.get(index).getName() + " has been changed to a Manager.");
		}
	}
	public static void demote(ArrayList<Employee> people){
		int index = inList(people);
		if (people.get(index).getType().equals("Employee"))
			System.out.println("Sorry this is a Employee, requires CEO permission and CEO software to fire.");
		else{
			people.get(index).setType("Employee");
			System.out.println(people.get(index).getName() + " has been changed to a Employee.");
		}
	}
	public static void remove(ArrayList<Employee> people){
		int index = inList(people);
		people.remove(index);
		System.out.println("Successfully removed Employee");
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
		System.out.println("1.	Display All Employees(Managers INCLUDED)");		//displays menu options 
		System.out.println("2.	Display Specific Employee");	
		System.out.println("3.	Add Employee(Managers INCLUDED)");			//need to add verify for managers or employees				
		System.out.println("4.	Remove Employee(Managers INCLUDED)");		
		System.out.println("5.	Promote Employee(NOT MANAGERS)");								
		System.out.println("6.	Demote Manager(NOT EMPLOYEES)");		
		System.out.println("7.	Change Salary of Employees");
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
	public static void main(String[] args) { // remember to add functionality that there is always at least one employee in list
		final String username = "Cookie";
		final String password = "Monster";
		login(username, password);

		ArrayList<Employee> people = new ArrayList<>();
		readFile(people);

		boolean loopQuit = false;
		while (!loopQuit){
			if(people.size() < 2){
				System.out.println("Database requires at least two entries. Please create new employee below:");
				people.add(newEmp(people));
			}
			else {
				int option;
				option = menu();
				if (option == 1){
					displayAllEmployees(people);
				}
				else if (option == 2){
					displaySpecificEmp(people);
				}
				else if (option == 3){
					people.add(newEmp(people));
				}
				else if (option == 4){
					remove(people);
				}
				else if (option == 5){
					promote(people);
				}
				else if (option == 6){
					demote(people);
				}
				else if (option == 7){
					changeSalary(people);
				}
				else if (option == 8){
					loopQuit = true;
				}
				writeToFile(people);	
			}
	}
		System.out.println("Thanks for using program. OPERATIONS COMPLETED");
}
}