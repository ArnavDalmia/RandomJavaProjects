import java.util.ArrayList;
public class Main {

	

	public static void main(String[] args) {
		ArrayList <Integer> numbers = new ArrayList<>();
        ArrayList <ArrayList <Integer> > graph = new ArrayList<>();


		int firstInput = Utils.obtainIntegerInputLow("Enter how many numbers you would like: ", 1);
		int secondInput = Utils.obtainIntegerInputLowHigh("Enter low bound for range of numbers: ", 10, 999);
		int thirdInput = Utils.obtainIntegerInputLowHigh("Enter high bound for range of numbers: ", 10, 999);

		for(int i=0; i<firstInput; i++){
			numbers.add(Utils.randomBetween(secondInput, thirdInput));
		}

		numbers.sort(null);

            // 12,23,34,35

		int highestStem;
		highestStem  = numbers.get(numbers.size()-1);
        highestStem = highestStem/10;
		for(int i = 0; i< highestStem; i++){
			graph.add(new ArrayList<Integer>());
            graph.get(i).add(i+1);
		}

        for(int i=1; i < graph.size() + 1;i++){
			for(int j=0; j < firstInput;j++){
				int number;
				number  =  numbers.get(j) - (i*10);
				if (number < 10 && number > -1)
                    graph.get(i-1).add(number);
					
			}
		}

        System.out.println(numbers);
        String header = String.format("%-10s %s", "Stem", "Leaf");
        System.out.println(header);

        for (int i=0; i<graph.size();i++) {
            String temp;
            temp = "";
			for (int j=0; j<graph.get(i).size();j++){
                if(j == 0)
                    temp += String.format("%s", graph.get(i).get(j));
                else{
                    temp += String.format("%-10s", graph.get(i).get(j)); 
                    
                }
            }
            System.out.println(temp);
		}
        

	}

}
