import java.util.ArrayList;
public class Main {

	public static int menu(){
		System.out.println("1.	Add Queue Entry");		//displays menu options
		System.out.println("2.	Dequeue Entry");	
		System.out.println("3.	Display Queue");		
		System.out.println("4.	Quit");						

		return Utils.obtainIntegerInputLowHigh("",1,4);				 //returns option number, and verefies it using the Utils class    
	}
	public static void main(String[] args) {
		
		MyQueue queue  = new MyQueue();
		queue.enqueue(new ClassA("Bob", 12));
		queue.enqueue(new ClassA("Joe", 123));
		queue.enqueue(new ClassA("Zoey", 121));
		queue.enqueue(new ClassA("Chris", 122));
		queue.enqueue(new ClassA("Peter", 213));

		while(true){
			if(!queue.isEmpty()){
				int choice;
				choice = menu();
				if (choice == 1){
					int value;
					String name;
					name = Utils.obtainInput("Enter Name: ");
					value  = Utils.obtainIntegerInputLow("Enter Value: ", 0);
					queue.enqueue(new ClassA(name, value));
					queue.displayQueue();
				}
				else if(choice ==2){
					System.out.print("Item Removed: ");
					ClassA temp = queue.dequeue();
					System.out.println(temp);
					queue.displayQueue();
			}
				else if(choice == 3)
				queue.displayQueue();
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
				queue.enqueue(new ClassA(name, value));
			}
		}
		

	}

}
