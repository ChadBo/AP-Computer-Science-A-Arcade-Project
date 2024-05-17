import java.util.Scanner;
public class TicTacToe
{
    private String[][] board; 
    private int turn;
   //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
   public TicTacToe () {
        board = new String[][] {
            {"- ", "- ", "- "},
            {"- ", "- ", "- "},
            {"- ", "- ", "- "}
        };
   }
   
   //this method returns the current turn
    public int getTurn()
    {
        return turn;
    }
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
       System.out.println("  0 1 2");
       for(int i = 0; i<3; i++) {
           System.out.print(i + " ");
            for(int j = 0; j<3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
       }
   }
   
    //This method returns true if space row, col is a valid space
    public boolean pickLocation(int row, int col)
    {
       if (row<3) {
           if (col<3) {
               if (board[row][col].equals("- ")) {
                   return true;
               }
           }
       }
       System.out.println("\033[0;1m" + "Invalid location. Try again. " + "\033[0;0m");
       return false;
    }
    
    //This method places an X or O at location row,col based on the int turn
    public void takeTurn(int row, int col)
    {
        if (turn%2 == 0) {
            board[row][col] = "X ";
        }
        else {
            board[row][col] = "O ";
        }
        turn += 1;
    }
   
    //This method returns a boolean that returns true if a row has three X or O's in a row
    public boolean checkRow() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != "- ") {
                return true;
            }
        }
        return false; 
    }

   
    //This method returns a boolean that returns true if a col has three X or O's
    public boolean checkCol()
    {
        for(int i = 0; i<3; i++) {
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("- ")) {
                return true;
            }
        }
        return false;
    }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
    public boolean checkDiag() {
        if (board[0][0].equalsIgnoreCase(board[1][1]) && board[0][0].equalsIgnoreCase(board[2][2]) && !board[1][1].equals("- ")){
            return true;
        }
        else if (board[0][2].equalsIgnoreCase(board[1][1]) && board[0][2].equalsIgnoreCase(board[2][0]) && !board[1][1].equals("- ")) {
            return true;
        }
        return false;
    }
    
    public boolean checkCat() {
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(board[i][j] == "- ") {
                    return false;
                }
            }
        }
        return true;
    }
   
//   //This method returns a boolean that checks if someone has won the game
    public boolean checkWin()
    {
        if(checkRow() || checkCol() || checkDiag()) {
            return true;
        }
        return false;
    }

}