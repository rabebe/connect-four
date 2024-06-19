public class ConnectFour {
	
	private Board board;
	private HumanPlayer player1; 
	private ComputerPlayer player2;
	private ConnectFourCheck check;

	public ConnectFour(){
		// Initialise the board with 6 rows and 7 columns
		board = new Board(6,7);
		
		// Player 1 is assigned the colour red
		player1 = new HumanPlayer('r');
		
		// Player 2 is assigned the colour red
		player2 = new ComputerPlayer('y');
		
		// Initialise the check object with the board
		check = new ConnectFourCheck(board);
		
		// Start the game
		playGame();
	}
  
	public void printInstructions(){
		System.out.println("Welcome to Connect 4!" + "\n");
		System.out.println("There are 2 players, you are player 1 and the computer is player 2.");
		System.out.println("Player 1 is Red, Computer is Yellow." + "\n");
		System.out.println("To play the game, type in the number of the column you want to drop your counter in and the computer will do the same. A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally.");
		System.out.println("");
		
		System.out.println(board.printableBoard());
	}

	public void playGame(){
		printInstructions();
		
		boolean win = false;
		
		// Continue playing until there is a winner
		while(!win){
			// Player 1's turn
			win = userTurn();
			if (win) {
				// Print the winner and end the game if player 1 wins
				System.out.println("Player 1 has won!!!");
				break;
			}
			
			// Computer's turn
			win = computerTurn();
			if (win) {
				// Print the winner and end the game if computer wins
				System.out.println("Computer has won!!!");
				break;
			}
		}
	}

	public boolean userTurn(){
		System.out.println("Player 1's turn:");
		
		int move = player1.getMove();
		
		// Place the player's counter on the board
		board.placeCounter(player1.getColour(), move);
		
		System.out.println(board.printableBoard());
		
		// Check if the player 1 has won the game
		return check.checkWin(player1.getColour());
	}

	public boolean computerTurn(){
		System.out.println("Computer's turn:");
		
		int move = player2.getMove();
		
		// Place the computer's counter on the board
		board.placeCounter(player2.getColour(), move);
		
		System.out.println(board.printableBoard());
		
		// Check if the computer has won the game
		return check.checkWin(player2.getColour());
	}  
}


