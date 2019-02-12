/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventosderaton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author bryan
 */
//objeto oyente
//clase oyente que implementa o hereda interface o clase mouse listener

/*si en caso no se quieran implementar totos los metodos
  heredar en lugar de implementar
  (implements MouseListener/extended MouseAdapter)*/
public class EventoRaton extends MouseAdapter{
    
    /*creacion de metodos obligatorios 
    pertenecientes a Mouselistene(Interface) en caso sea implementada y no heredada*/
 
    //sobreescritura de metodo MouseAdapter
    
    /*@Override
    public void mouseClicked(MouseEvent e){
        
        //mostrando posicion del raton al hacer click
        //System.out.println("coordenada X: "+e.getX()+"coordenada Y: "+e.getY());
        
        //contador de click
        //System.out.println(e.getClickCount());
        
        
    }*/
    @Override
    public void mousePressed(MouseEvent e){
     
        //verificando pulsacion de botones del raton
        
        if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){
            System.out.println("Has pulsado boton izquierdo");
        }
        
        else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK){
            System.out.println("Has pulsado boton derecho");
        }
        
        
    }
    
    /**
     * Controlador de Movimiento y arrastre del raton
     * implements MouseActionlistener  en la clase oyente
     * addMouseactionListener(nuevoEvento)
     * implementar metodos (sobreescritura)
     
     **/
    
}
