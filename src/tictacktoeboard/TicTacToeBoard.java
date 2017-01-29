/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoeboard;

/**
 *
 * @author lazarcl
 */
public class TicTacToeBoard {
    
    String[][] gameBoard = new String[3][3]; //2D array of strings. options are: " X ", " O ", or "   " for easy printing
    
    /**
     * class constructor: initializes all elements of gameBoard array as "   " which denotes empty position
     */
    public TicTacToeBoard() {
        for (int row = 0; row < 3; row ++) {
            for (int col = 0; col < 3; col++) {
                gameBoard[row][col] = "   ";
            }
        }
    }
    
    /**
     * prints the board for a visual representation of the current gameBoard state
     */
    public void printBoard() {
        for (int i=0; i<3; i++) { //loop through each linea and print out line
            System.out.println(gameBoard[i][0] + "|" + gameBoard[i][1] + "|" + gameBoard[i][2]);
            if (i<2) System.out.println("---+---+---");
        }
    }
    
    /**
     * ensures that a given movement is valid within the 3x3 gameBoard. if not, throws exception
     * @param cords int array of size 2 of cords that will be checked. list elements are expected as: [x,y]
     * @return returns true if the cordinates are valid with current gameBoard state
     * @throws InvalidMoveException throws exception instead of returning false for easier error handling
     */
    public boolean validateMove(int[] cords) throws InvalidMoveException {
        int x = cords[0];
        int y = cords[1];
        if (x>2 || x<0) {
            throw new InvalidMoveException();
        } else if (y>2 || y<0) {
            throw new InvalidMoveException();
        }
        
        if (!gameBoard[x][y].equals("   ")) {
            throw new InvalidMoveException();
        }
        return true;
    }
    
    /**
     * validates then inputs the player's move to the gameBoard
     * @param cords int array of size 2 with desired move coordinates. expected form [x,y]
     * @param currentPlayer int signaling the player that made the move. expects 0=user, 1=computer
     */
    public void addPlayerMove(int[] cords, int currentPlayer) throws InvalidMoveException {
        if (validateMove(cords)) {
            String symbol = ( (currentPlayer == 0) ? " O " : " X ");
            gameBoard[cords[0]][cords[1]] = symbol;
        }
    }
    
    /**
     * finds if the board is full. or if there are spots open
     * @return if board is full, then returns true, else false
     */
    public boolean isBoardFull() {
        int sum = 0;
        for (int row = 0; row < 3; row ++) {
            for (int col = 0; col < 3; col++) {
                if (!gameBoard[row][col].equals("   ")) {
                    sum +=1;
                }
            }
        }
        if (sum < 9) return false;
        else return true;
    }
    
    /** 
     * checks whether a selected player has won the game.
     * @param currentPlayer specify which player should be checked to win game. expected 0=human, 1=computer
     * @return return if specified player has won, else return false
     */
    public boolean checkForWin(int currentPlayer){
        String p;
        int result = 3; // 1 is win, 2 is no win
        if (currentPlayer == 0){
            p = " O ";
        }
        else {
            p = " X ";
        }

        if (gameBoard[0][0].equals(p) && gameBoard[1][0].equals(p) && gameBoard[2][0].equals(p)){
            result = 0;}
        else if (gameBoard[0][1].equals(p) && gameBoard[1][1].equals(p) && gameBoard[2][1].equals(p)){
            result = 0;}
        else if (gameBoard[0][2].equals(p) && gameBoard[1][2].equals(p) && gameBoard[2][2].equals(p)){
            result = 0;}
        else if (gameBoard[0][0].equals(p) && gameBoard[0][1].equals(p) && gameBoard[0][2].equals(p)){
            result = 0;}
        else if (gameBoard[1][0].equals(p) && gameBoard[1][1].equals(p) && gameBoard[1][2].equals(p)){
            result = 0;}
        else if (gameBoard[2][0].equals(p) && gameBoard[2][1].equals(p) && gameBoard[2][2].equals(p)){
            result = 0;}
        else if (gameBoard[0][0].equals(p) && gameBoard[1][1].equals(p) && gameBoard[2][2].equals(p)){
            result = 0;}
        else if (gameBoard[0][2].equals(p) && gameBoard[1][1].equals(p) && gameBoard[2][0].equals(p)){
            result = 0;}
        // return true if won, false if no win
        if (result == 0) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    /**
     * print out given ints stored in an array of size 2. does not end the line it prints to
     * @param cords int array of size 2
     */
    public void printCords(int[] cords) {
        int x = cords[0] + 1;
        int y = cords[1] +1;
        System.out.print(x + "," + y);
    }
}



