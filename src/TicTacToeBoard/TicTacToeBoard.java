/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeBoard;

/**
 *
 * @author lazarcl
 */
public class TicTacToeBoard {
    
    String[][] gameBoard; //2D array of strings. options are: " X ", " O ", or "   " for easy printing
    
    public void TicTacToeBoard() {
        gameboard = new String[3][3];
        for (int i = 0; i<3; i++ ) { //set all positions as empty(three spaces) for easy printing
            for (int j=0; j<3; j++) {
                gameBoard[i][j] = "   ";
            }
        }
    }
    
    public static void printBoard(){
        //Made this code to hopefully print more clearly
//        for (int i=0; i<2; i++) { //loop through each linea and print out line
//            System.out.println(gameBoard[i][0] + "|" + gameBoard[i][1] + "|" + gameBoard[i][2]);
//            System.out.println("---|---|---");
//        }
//        System.out.println(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);

        
        String row1 = " " + plays.indexOf(0)+ "  |   |   "; /*this causes an issue but
                I have to go to class, I'll fix this later*/
        String row2 = "   |   |   ";
        String row3 = "   |   |   ";
        String rowm = "---+---+---";
                
        String board = row1 +"\n"+ rowm +"\n"+ row2 +"\n"+ rowm +"\n"+ row3;
        System.out.println(board);
    }
}
