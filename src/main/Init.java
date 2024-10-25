/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package main;

import controller.Controller;
import view.MainWindow;

/**
 *
 * @author Fernando GJ
 */
public class Init {

    public static void main(String[] args) {
        MainWindow window = new MainWindow(new Controller());
        window.setVisible(true);

    } // end main

} // end Init
