/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Dimension;

/**
 *
 * @author Fernando GJ
 */
public class Config {
    public final static Dimension[] GRID_DIMENSIONS = {
      new Dimension(9, 9), // beginner
      new Dimension(16, 16), // intermediate
      new Dimension(30, 16) // expert
    };
    
    public final static byte[] MINES_NUMBER = {
        10, // beginner
        40, // intermediate
        99 // expert
    };
    
    public final static int EMPTY_CLUES = -10;

} // end Config
