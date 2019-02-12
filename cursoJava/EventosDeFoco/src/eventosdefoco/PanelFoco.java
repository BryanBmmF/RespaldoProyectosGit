/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventosdefoco;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bryan
 */
public class PanelFoco extends JPanel{
    
     @Override
     public void paintComponent(Graphics g){
         super.paintComponent(g);
   
        //layuot disposicion que tiene un elemento en la ventana
         
        //invalidando layout por defecto
        setLayout(null);
        
        //agregando cuadros de texto
        //clase JTextField
        
        //instanciando miembros cuadro de texto
        cuadro1= new JTextField();
        cuadro2= new JTextField();  
        
        //posicionamiento de cuadros de texo
        
        cuadro1.setBounds(120, 10, 150, 20);
        cuadro2.setBounds(120, 50, 150, 20);
        
        //agregando cuadros al frame
        
        add(cuadro1);
        add(cuadro2);
        
        //instancia de clase oyente
        LanzaFocos elFoco=new LanzaFocos();
        
        //agregando elFoco
        cuadro1.addFocusListener(elFoco);
        
     }
     //creacion de clase interna Lanza Focos (Oyente)
     private class LanzaFocos implements FocusListener{
         
    //Foco ganado
    @Override
    public void focusGained(FocusEvent e) {
        System.out.println("Foco Ganado");
        
    }
    
    //perdida de foco
    @Override
    public void focusLost(FocusEvent e) {
        //Ejemplo de direccion de correo electronico erroneo
        
        //capturando Texto en cuadro1
        String email=cuadro1.getText();
        
        boolean comprobacion=false;
        
        //recorriendo cadena
        for(int i=0;i<email.length();i++){
            
            //comparando caracter a caracter
            if(email.charAt(i)=='@'){
                comprobacion=true;
                
            }
        }
        if(comprobacion){
            System.out.println("Email Correcto");
        }
        else{
            System.out.println("Email Incorrecto");
        }
    }
    
}
     //creando miembros de cuadro  que pertenecen a la clase PanelFoco
     JTextField cuadro1;
     JTextField cuadro2;   
     
    
}




