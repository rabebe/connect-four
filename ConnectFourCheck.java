public class ConnectFourCheck{
  private Board board;
  private boolean hasWon;

  public ConnectFourCheck(Board board){
    this.board = board;
    hasWon = false;
  }
  
  public boolean checkHorizontal(char colour) {
    // Checks for horizontal connect four for the specified colour
    for(int i=0; i<board.getNumRows(); i++) {
        int count = 0;
        for(int j=0; j<board.getNthRow(i); j++) {
            if(board.getCellValue(i,j) == colour) {
                count++;
                if(count >= 4) {
                    hasWon = true;
                    break;
                }
            } else {
                count = 0;
            }
        }
        if(hasWon) {
            break;
        }
    }
    return hasWon;
  }

  public boolean checkVertical(char colour) {
    // Checks for vertical connect four for the specified colour
    for(int i=0; i<board.getNumCols(); i++) {
        int count = 0;
        for(int j=0; j<board.getNumRows(); j++) {
            if(board.getCellValue(j,i) == colour) {
                count++;
                if(count >= 4) {
                    hasWon = true;
                    break;
                }
            } else {
                count = 0;
            }
        }
        if(hasWon) {
            break;
        }
    }
    return hasWon;
  }

  public boolean checkDiagonal(char colour) {
    // Checks for diagonal connect four for the specified colour
    // Check first half of the board diagonals
    for(int i=3; i<board.getNumRows(); i++) {
        for(int j=3; j<board.getNumCols(); j++) {
            if(board.getCellValue(i,j) == colour && 
              board.getCellValue(i-1,j-1) == colour &&
              board.getCellValue(i-2,j-2) == colour &&
              board.getCellValue(i-3,j-3) == colour) {
                hasWon = true;
                break;
            }
        }
        if(hasWon) {
            break;
        }
    }

    if(!hasWon) {
        // Check second half of the board diagonals
        for(int i=0; i<board.getNumRows()-3; i++) {
            for(int j=3; j<board.getNumCols(); j++) {
                if(board.getCellValue(i,j) == colour && 
                  board.getCellValue(i+1,j-1) == colour &&
                  board.getCellValue(i+2,j-2) == colour &&
                  board.getCellValue(i+3,j-3) == colour) {
                    hasWon = true;
                    break;
                }
            }
            if(hasWon) {
                break;
            }
        }
    }
    return hasWon;
  }

  public boolean checkWin(char colour) {
    // Checks for horizontal, vertical or diagonal connect four
    return checkHorizontal(colour) || checkVertical(colour) || checkDiagonal(colour);
  }
}