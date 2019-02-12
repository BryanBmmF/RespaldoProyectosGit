/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplesoyentes;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoPrincipal extends JFrame{
    //constructor
    public MarcoPrincipal(){ 
    
        //atributos
    setTitle("Prueba Multiples oyentes");
    setBounds(1000,100,300,200);
    //instancia de panel
    PanelPrincipal lamina= new PanelPrincipal();
    
    add(lamina);
    
    }
}
