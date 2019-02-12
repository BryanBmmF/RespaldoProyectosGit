/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica3;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryan
 */
public class FuentesDeOrdenador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //buscando fuentes en el ordenador
        String [] ListaDeFuentes= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        //imprimiendo fuentes
        
        for(String nombreFuente:ListaDeFuentes){
            
            System.out.println(nombreFuente);
        
        }
        
        
    }
    
}
