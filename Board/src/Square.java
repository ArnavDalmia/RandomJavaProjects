
public class Square {

	private int [][] board;
	
	public Square() {
		this.board = new int [10][10];

	}
	
	public int[][] getBoard() {
		return board;
	}
	public void setValues() {
		for (int i=0; i<10; i++)
			for (int j=0; j<10; j++)
				board[i][j] = 0;
	}
	public void setBoard(int row, int col) {
		board[row][col] = 1;
	}
	
}
