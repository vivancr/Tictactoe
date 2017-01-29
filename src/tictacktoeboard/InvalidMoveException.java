/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoeboard;

/**
 *
 * this exception will be thrown when a move is out of bounds, or the position is already full
 */
public class InvalidMoveException extends Exception {

    /**
     * Creates a new instance of InvalidMoveException
     * 
     */
    public InvalidMoveException() {
    }

}
