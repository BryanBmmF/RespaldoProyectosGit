/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tac3d;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Yylex lexer = new Yylex(new StringReader(""));
        
        parser pa = new parser(lexer);
        lexer.yyreset(new StringReader("x = 4-6;"));
      
        try {
            Object g= pa.parse().value;    

        } catch (Exception ex) {
            Logger.getLogger(run.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
