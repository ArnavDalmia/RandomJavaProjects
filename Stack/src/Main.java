import java.util.ArrayList;
public class Main {

	public static int menu(){
		System.out.println("1.	Push Entry");		//displays menu options
		System.out.println("2.	POP");	
		System.out.println("3.	Display Stack");		
		System.out.println("4.	Quit");						

		return Utils.obtainIntegerInputLowHigh("",1,4);				 //returns option number, and verefies it using the Utils class    
	}
	public static void main(String[] args) {
		
		MyStack stack  = new MyStack();
		stack.push(new ClassA("Bob", 12));
		stack.push(new ClassA("Joe", 123));
		stack.push(new ClassA("Zoey", 121));
		stack.push(new ClassA("Chris", 122));
		stack.push(new ClassA("Peter", 213));

		while(true){
			if(!stack.isEmpty()){
				int choice;
				choice = menu();
				if (choice == 1){
					int value;
					String name;
					name = Utils.obtainInput("Enter Name: ");
					value  = Utils.obtainIntegerInputLow("Enter Value: ", 0);
					stack.push(new ClassA(name, value));
					stack.displayStack();
				}
				else if(choice ==2){
					System.out.print("Item Removed: ");
					ClassA temp = stack.pop();
					System.out.println(temp);
					stack.displayStack();
			}
				else if(choice == 3)
					stack.displayStack();
				else
					break;
			}
			else{
				System.out.println("Stack is empty");	
				System.out.println("Create your new entry");
				int value;
				String name;
				name = Utils.obtainInput("Enter Name: ");
				value  = Utils.obtainIntegerInputLow("Enter Value: ", 0);
				stack.push(new ClassA(name, value));
			}
		}
		

	}

}
