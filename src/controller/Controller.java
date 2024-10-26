/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Dimension;
import java.awt.Point;
import model.Board;

/**
 *
 * @author Fernando GJ
 */
public class Controller {
    private Board playerBoard;
    
    public void initGame(Dimension boardDimensions, int minesNumber) {        
        this.playerBoard = new Board(boardDimensions, minesNumber);
        System.out.println(this.playerBoard);
    }
    
    public int revealCellNumber(Point boardPoint) {
        return this.playerBoard.revealCellNumber(boardPoint);
    }

    public boolean cellRevealed(Point boardPoint) {
        return this.playerBoard.cellRevealed(boardPoint);
    }

    public Point[] discoverAllMines() {
        return this.playerBoard.allMinesCoords();
    }

    
    

} // end Controller
