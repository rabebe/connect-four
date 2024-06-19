public abstract class Player{
  public char colour;
  
  // Constructor sets the player's colour
  public Player(char colour){
    this.colour = colour;
  }

  // Gets player's colour
  public char getColour(){
    return colour;
  }

  // Abstract method that gets player's move
  public abstract int getMove();
}

