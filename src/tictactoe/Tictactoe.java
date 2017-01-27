/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 * This is a second update test
 * TODO: 
 * printBoard() no return, no parameters, prints board
 * validMove(int x, int y)  parameters: cords to check, returns true if valid, false if not
 * winnerCheck() no parameters, no return, prints winner and quits program
 * inputStringToCords(String input) parameters: string from user input, output: list of 2 numbers that represent
 *      cords [x,y]
 * 
 * meet 1:00pm sat
 */

/**
 *
 * @author ricardovivanco
 */
import java.util.ArrayList;
import java.util.Scanner; 

public class Tictactoe {

    ArrayList<String> board = new ArrayList<>(3);
    /**
     * Prints board 
     * @return board
     */
    /**
    public static String printboard(){
        board.set(0,"space 0");
        return "hey";
    }
     * @return random number, either 0 or 1
    */
    public static int randstart(){
        int r = (int) (Math.random() * (3 - 1));
        return r;
    }
    /**
     * chooses a random position for the computer to play
     * @return String 
     */
    public static String randplay(){
        int r = (int) (Math.random() * (4 - 1)+1);
        int c = (int) (Math.random() * (4 - 1)+1);
        String str1 = Integer.toString(c);
        String str2 = Integer.toString(r);
        return str1 + "," + str2;
    } 
    /**
     * asks the player to input their position
     */
    public static void pXturn(){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Player X, enter a pair of numbers, seperated by a comma, from 1-3\n"
                + "where the first number is the row and the second is the column. \n"
                + "For example 1,3 would be the top right position.");
        String n = reader.nextLine();
        
        System.out.println(n);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(randstart());
        pXturn();
        System.out.println(randplay());
    }
    
}
