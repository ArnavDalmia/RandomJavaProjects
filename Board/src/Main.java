
public class Main {

	public static void randomizer(Square board) {
		for (int i=0; i<6; i++) {
			int row;
			int col;
			
			boolean valid;
			valid = false;
			
			while(!valid) {
				row = randomBetween(0,9);
				col = randomBetween(0,9);
				if (board.getBoard()[row][col] != 1) {
					board.getBoard()[row][col] = 1;
					valid = true;
					}	
			}//while
			
				
		}//for
	}
	public static void main(String[] args) {
		Square board = new Square();
		board.setValues();
		randomizer(board);
		//board.setBoard(0, 0);
		//board.setBoard(1, 1);
		//board.setBoard(2, 2);
		//board.setBoard(3, 3);
		//board.setBoard(4, 4);
		
		
		System.out.println("Welcome");
		int counter=0;
		int cookieCounter = 0;
		while(counter<100 && cookieCounter < 5) {
			
			int row;
			int col;
			row = Utils.obtainIntegerInputLowHigh("Enter row: ", 1, 10) - 1;
			col = Utils.obtainIntegerInputLowHigh("Enter col: ", 1, 10) - 1;

			if(board.getBoard()[row][col] == 1) {
				System.out.println("Congrats there is a cookie at row: "+(row+1)+", and at col: "+(col+1));
				board.getBoard()[row][col] = 0;
				cookieCounter+=1;
			}
			else
				System.out.println("Wrong. Either you have already found this cookie, or there is none there.");
				
			counter++;
			
		}
		System.out.println("\nProgram is completed. Here is your score:");
		System.out.println("You guessed "+ cookieCounter+" cookies, in "+counter+" tries.");
			
	
	
	
	}
	

}
