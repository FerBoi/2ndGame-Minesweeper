/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import controller.Config;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Fernando GJ
 */
public class Board {
    private final Cell[][] BOARD;
    public int boxesToWin;
    
    public Board(Dimension boardDimensions, int minesNumber) {
        this.BOARD = new Cell[boardDimensions.height][boardDimensions.width];
        this.boxesToWin = boardDimensions.width * boardDimensions.height - minesNumber;
        
        // -- INICIALIZE CELLS
        
        for (Cell[] cell : this.BOARD) {
            for (int j = 0; j < cell.length; j++)
                cell[j] = new Cell();
        }
        
        // -- SET MINES --
        
        for (int i = 0; i < minesNumber; i++) {
            Random r = new Random();
            Point pointToCheck = new Point(r.nextInt(this.BOARD[0].length), r.nextInt(this.BOARD.length));

            if (this.BOARD[pointToCheck.y][pointToCheck.x].getNumber() != Config.EMPTY_CLUES || 
                    this.BOARD[pointToCheck.y][pointToCheck.x].getNumber() == -1) {
                do {
                    pointToCheck = new Point(r.nextInt(this.BOARD[0].length), r.nextInt(this.BOARD.length));
                } while (this.BOARD[pointToCheck.y][pointToCheck.x].getNumber() != Config.EMPTY_CLUES || 
                        this.BOARD[pointToCheck.y][pointToCheck.x].getNumber() == -1);
                
            }

            this.BOARD[pointToCheck.y][pointToCheck.x].setNumber(-1);
        }
        
        // -- SET CLUES --
        
        for (int j = 0; j < this.BOARD.length; j++) {
            for (int k = 0; k < this.BOARD[j].length; k++) {
                if (this.BOARD[j][k].getNumber() != -1) {
                    ArrayList<Integer> adyacentNumbers = this.lookAdyacents(new Point(k, j));
                    this.BOARD[j][k].setNumber(Collections.frequency(adyacentNumbers, -1));
                }
            }
        }        
    }

    private ArrayList<Integer> lookAdyacents(Point boardPoint) {
        ArrayList<Integer> adyacentBoxes = new ArrayList<>();
        
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(boardPoint.x + j > -1 && boardPoint.x + j < this.BOARD[0].length && 
                        boardPoint.y + i > -1 && boardPoint.y + i < this.BOARD.length)
                    adyacentBoxes.add(this.BOARD[boardPoint.y + i][boardPoint.x + j].getNumber());
            }
        }
        
        return adyacentBoxes;
    }
    
    public int revealCellNumber(Point boardPoint) { 
        return this.BOARD[boardPoint.y][boardPoint.x].IsDiscovered() ? -99 : this.BOARD[boardPoint.y][boardPoint.x].getNumber();        
    }
    
    public boolean cellRevealed(Point boardPoint) {
        this.BOARD[boardPoint.y][boardPoint.x].setDiscovered(true);
        return --this.boxesToWin == 0;
    }

    @Override
    public String toString() {
        String s = "";
        
        for (Cell[] cells : BOARD) {
            for (Cell cell : cells)
                s+= cell + " ";
            
            s+= "\n";
        }
        
        return s;
    }

} // end Board