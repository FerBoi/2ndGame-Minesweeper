/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import controller.Config;

/**
 *
 * @author Fernando GJ
 */
public class Cell {
    private int number;
    private boolean discovered;
    
    public Cell() {
        this.number = Config.EMPTY_CLUES;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean IsDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    @Override
    public String toString() {
        return this.number + "";
    }
    
} // end Box
