import java.util.Random;

public class ComputerPlayer extends Player{
  private Random rand = new Random();

  public ComputerPlayer(char colour){
    super(colour);
  }

  // Generates a random move for the computer player
  public int getMove() {
    // Choose a number between 1 and 7
    int move = rand.nextInt(7) + 1;
    return move;
  }

}
