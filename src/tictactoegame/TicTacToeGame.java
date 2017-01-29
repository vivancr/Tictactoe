/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;


/**
 *
 * @author ricardovivanco, lazarcl
 */
import tictacktoeboard.TicTacToeBoard;
import java.util.Scanner; 
import tictacktoeboard.InvalidMoveException;

public class TicTacToeGame {
    
    public int currentPlayer; //0 if human, 1 if computer
    public int gameResult = -1; // -1 no result, 0 if human win, 1 if comp, 2 if draw
    
    /**
     * generates a random number, either 0 or 1, and sets the current player to it
    */
    public void randStart(){
        int r = (int) (Math.random() * 2); //multipliy by 2 b/c int cast rounds down
        currentPlayer = r;
    }
    /**
     * chooses a random position for the computer to play. does not check validity of position in this function
     * @return int array of size 2 with element0==x coordinate, and element1==y coordinate
     */
    public int[] randPlay(){
        int[] cords = new int[2];
        cords[0] = (int) (Math.random() * 3);
        cords[1] = (int) (Math.random() * 3);
        return cords;
    } 
    
    /**
     * prompts the player to input their position as int,int. splits the input string into int's that are then returned in array
     * @throws tictacktoeboard.InvalidMoveException, ArrayIndexOutOfBounds
     * @return int array of size two with element0==x, element1==y
     */
    public static int[] playerInput() throws InvalidMoveException, ArrayIndexOutOfBoundsException {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        String n = reader.nextLine();
        if (n.length() != 3) {
            throw new InvalidMoveException();
        }
        String[] stringCords = new String[2]; // create string array to store string split in
        stringCords = n.split(",");
        int[] cords = new int[2]; // create int array to store int cords after string->int cast
        cords[0] = Integer.parseInt(stringCords[0]) - 1;
        cords[1] = Integer.parseInt(stringCords[1]) - 1;
        return cords;
    }
    
    /**
     * makePlay() handles the structure for both player and computer turns, also prints the board
     * @param board pass in TicTacToeBoard obj that the game is being played on
     * @throws InvalidMoveException 
     */
    public void makePlay(TicTacToeBoard board) throws InvalidMoveException {
        int[] cords;
        if (currentPlayer == 0) {
            cords = playerInput();
        }
        else {
            cords = randPlay();
        }
//        board.validateMove(cords); 
        board.addPlayerMove(cords, currentPlayer); // validates and adds move to gameBoard. if invalid, throws InvalidMoveException
        if (currentPlayer == 1) { //print computer's input
            System.out.print("Computer chose: ");
            board.printCords(cords);
            System.out.println();
        }
        board.printBoard();
    }
    
    /**
     * manages players turns and handles exceptions for invalid inputs. sets result of game to gameResult field
     * @param board pass in the TicTacToeBoard class obj that the game is being played on 
     */
    public void playGame(TicTacToeBoard board) {
        board.printBoard();
        System.out.println("\nYOUR TURN");
        while (!board.isBoardFull()) {
            try {
                makePlay(board); // will prompt the correct player for input, and attempt to add to board
                if (board.checkForWin(currentPlayer)) {
                    gameResult =  currentPlayer; // current player won, so return their player number
                    return;
                }
                currentPlayer = (currentPlayer==0 ? 1 : 0); // switch currentPlayer for next player's turn
                if (currentPlayer==0) System.out.println("\nYOUR TURN");
                
            } catch (InvalidMoveException | ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                //if not computer with invalid move, then prompt user to 
                if (currentPlayer != 1) System.out.println("--INPUT VALID MOVE--");
            } // end catch

        } // end while loop
        gameResult = 2; //set result as tie
    } // end playGame()
    
    /**
     * prints message to congratulate the winner
     */
    public void printWinMessage() {
        switch (gameResult) {
            case 0:
                System.out.println("\nYOU WON!!!");
                break;
            case 1:
                System.out.println("\nTHE COMPUTER WON!!!");
                break;
            case 2:
                System.out.println("\nDraw GAME!!!");
                break;
            case -1:
                System.out.println("\nGame Failed");
                break;
        }
    }
    
    /**
     * creates a TicTacToeBoard, and Game, then runs the game and prints out message to winner
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        System.out.println("Player X, enter a pair of numbers");
        System.out.println("between 1 and 3 in the form of row,col");
        System.out.println("example: row 1 column 3 would be:  3,2");
        System.out.println("You are player 'O' and the computer is player 'X'");

        TicTacToeGame game = new TicTacToeGame();
        game.randStart();
        game.playGame(board);
        game.printWinMessage();        
    }
    
}
