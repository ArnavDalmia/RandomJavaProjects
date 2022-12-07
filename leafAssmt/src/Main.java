import java.util.ArrayList;
public class Main {

	

	public static void main(String[] args) {
		ArrayList <Integer> numbers = new ArrayList<>();
		ArrayList <Integer> stem = new ArrayList<>();
		ArrayList <String> leaf = new ArrayList<>();

		int firstInput = Utils.obtainIntegerInputLow("Enter how many numbers you would like: ", 1);
		int secondInput = Utils.obtainIntegerInputLowHigh("Enter low bound for range of numbers: ", 10, 999);
		int thirdInput = Utils.obtainIntegerInputLowHigh("Enter high bound for range of numbers: ", 10, 999);

		for(int i=0; i<firstInput; i++){
			numbers.add(Utils.randomBetween(secondInput, thirdInput));
		}

		numbers.sort(null);

		int highest;
		highest  = numbers.get(numbers.size()-1);
		for(int i = 1; i<= highest/10; i++){
			stem.add(i);
		}

		for(int i=1; i < stem.size() + 1;i++){
			String tempString = "";
			for(int j=0; j < firstInput;j++){
				int number;
				number  =  numbers.get(j) - (i*10);
				if (number < 10 && number > -1)
					tempString += (number + " ");
					
			}
			leaf.add(tempString);
		}

		for(int i=0; i < stem.size();i++){
		System.out.println(stem.get(i) + " : " + leaf.get(i) + "\n");
		} 
	
	}

}
