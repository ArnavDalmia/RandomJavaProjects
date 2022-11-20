
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Matrix four = new Matrix(1,1);
		four.setRandomValues(10,11); // error check for left to right
		
		System.out.println(Arrays.deepToString(four.getMatrix()));

		Matrix next = new Matrix(1,1);
		next.setRandomValues(10,13); // error check for left to right
		System.out.println(Arrays.deepToString(next.getMatrix()));

		
		boolean equals;
		equals = four.getEquals(next);
		System.out.println(equals);

		
		
		int[] arr = four.getColumn(0); // error check for the incorrect value
		

	}

}
