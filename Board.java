public class Board {
	private char[][] board;
	private HumanPlayer player1;
	private ComputerPlayer player2;

	public Board(int numRows, int numCols) {
		// Initialise the board with the given number of rows and columns
		board = new char[numRows][numCols];
		// Player 1 is assigned the colour red
		player1 = new HumanPlayer('r');
		// Player 2 is assigned the colour yellow
		player2 = new ComputerPlayer('y');
	}

	// Gets the value of a cell on the board
	public char getCellValue(int row, int col) {
		return board[row][col];
	}

	// Gets the length of a row
	public int getNthRow(int row) {
		return board[row].length;
	}

	// Gets the number of rows on the board
	public int getNumRows() {
		return board.length;
	}

	// Gets the number of columns on the board
	public int getNumCols() {
		return board[0].length;
	}

	// Checks if a column is full
	public boolean isColumnFull(int position) {
		// If the top row of the column is already filled with player1's or player2's colour, the column is full
		if (board[0][position] == player1.getColour()) {
			return true;
		} else if (board[0][position] == player2.getColour()) {
			return true;
		} else {
			// Otherwise, column is not full
			return false;
		}
	}

	// Places a counter on the board
	public void placeCounter(char player, int position) {
		try {
			// If the column is full, print an error message and return
			if (isColumnFull(position - 1)) {
				System.out.println("Column is full please pick another column.");
			}
			// Otherwise, try to place the counter
			boolean placed = false;
			// Assigns opponent player 2's colour
			char opponent = player == player1.getColour() ? player2.getColour() :
				player1.getColour();
			// Loop through the rows starting from the bottom
			for (int i = board.length - 1; i >= 0; i--) {
				if (!placed) {
					if (board[i][position - 1] == opponent) {
						// skip turn
					} else if (board[i][position - 1] != player) {
						// Otherwise, place the counter in the current cell
						board[i][position - 1] = player;
						placed = true;
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException err2) {
			// If a number outside of the array is chosen, print an error message and return
			System.out.println("Invalid position. Please choose a number between 1 and 7.");
		}
	}
  

  public String printableBoard(){
    String s = "";
    for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == player1.getColour()){
					s +=("| " + player1.getColour() + " ");
				}
				else if(board[i][j] == player2.getColour()){
					s += ("| " + player2.getColour() + " ");
				}
				else{
					s += ("|   ");
				}
			}
			s += ("|");
      s += "\n";
		}
		s += ("  1   2   3   4   5   6   7");
    return s;
	}
  
}