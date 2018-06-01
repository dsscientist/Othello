/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author shirdav18
 */
public class Othello {

    public static File instructions;
    
    public static void main(String[] args) throws FileNotFoundException {
        instructions = new File("how_to_play.txt");
        Scanner sc = new Scanner(instructions);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
    
    
}
