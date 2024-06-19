import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{
  
  public HumanPlayer(char colour){
    super(colour);
  }
  
  // Reads user input from console and returns it as a String
  public String getUserInput(){
    String toReturn = null;
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    try{			
      toReturn = input.readLine();
    } catch(IOException e){ 
      System.err.println("Error reading user input: " + e.getMessage());
      // Error message if there is an IOException while reading input
    }
    return toReturn;
  }

  // Returns user input as an int
  public int getMove() {
    int move = 0;
    String userInput = "";
    while (true) {
      try {
        userInput = getUserInput();  // Get user input as a String
        move = Integer.parseInt(userInput);  // Convert input to an int
        break;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input, please try again.");  // Error message if input is not an int
      }
    }
    return move;
  }
  
}