/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplesfuentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author bryan
 */
public class PanelAccion extends JPanel{
    
    //creacion de botones
    
    //constructor
    public PanelAccion(){
        
        //instanciacion de clase oyente
        
        AccionColor accionAmarillo= new AccionColor("Amarillo",new ImageIcon("src/graficos/amarillo.jpg"),Color.YELLOW);
        AccionColor accionAzul= new AccionColor("Azul",new ImageIcon("src/graficos/azul.jpg"),Color.BLUE);
        AccionColor accionRojo= new AccionColor("Rojo",new ImageIcon("src/graficos/rojo.png"),Color.RED);
        
        /**
         * creacion normal de botones
         **/
        
        /*JButton botonAmarillo= new JButton("Amarillo");
        JButton botonAzul=new JButton("Azul");
        JButton botonRojo=new JButton("Rojo");
        
        //agregando botones al panel
        add(botonAmarillo);
        add(botonAzul);
        add(botonRojo);*/
        
        //otra forma de crear botones
        
        /*JButton botonAmarillo=new JButton(accionAmarillo);
          add(botonAmarillo);*/
        
        //forma simplificada de crear un boton e instanciar junto
        add(new JButton(accionAmarillo));
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));
        
        /**
         * 1. Creando Mapa de entrada para la fuente por medio de teclas
         
         **/
        //mapaEntrada  guarda el valor que devulve getInputMap
        //WHEN_IN..... (constantes de clase)
        InputMap mapaEntrada= getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        /**
         * 2. Creando conbinacion de Teclas para la fuente por medio de teclas
         *    KeyStroke: reprenta una accion por medio de teclas
         **/
        
        KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");
        KeyStroke teclaAzul=KeyStroke.getKeyStroke("ctrl B");
        KeyStroke teclaRojo=KeyStroke.getKeyStroke("ctrl R");
        
        /**
         * 3. Creando asignacion de Teclas a un Objeto para la fuente por medio de teclas
         *    
         **/
        
        mapaEntrada.put(teclaAmarillo, "fondoAmarillo");
        mapaEntrada.put(teclaRojo, "fondoRojo");
        mapaEntrada.put(teclaAzul, "fondoAzul");
        
        /**
         * 4. Creando asignacion de Objeto a una Accion para la fuente por medio de teclas
         *    Clase ActionMap permite la instanciacion de mapaAccion
         **/
        ActionMap mapaAccion=getActionMap();
        mapaAccion.put("fondoAmarillo",accionAmarillo);
        mapaAccion.put("fondoRojo", accionRojo);
        mapaAccion.put("fondoAzul", accionAzul);
        
    }
    
    //encapsulando clase
    private class AccionColor extends AbstractAction {
    
    //constructor con parametros a recibor
    public AccionColor(String nombre, Icon icono, Color colorBoton){
    
        //almacenamiento de parametros recibidos
        
        //almacenando nombre
        putValue(Action.NAME,nombre); //cuando se instancie la clase oyente
                                      //clave:NAME, valor:nombre
                                      
        //almacenando icono
        putValue(Action.SMALL_ICON,icono);
        
        //almacenando descripcion
        putValue(Action.SHORT_DESCRIPTION,"Poner el panel de color:"+nombre);
        
        
        //almacenando accion del boton
        putValue("color de fondo",colorBoton);
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //cambiando color del panel mediante actionperformed
        
        //rescatar el valor correspondiente a la clave
        Color nuevoColor=(Color)getValue("color de fondo");//casting de color
        
        //cambiando color   setBacKg... no corresponde a AbstractAction
        //pero puede ser accedidad por ser parte de la clase interna Accion Panel
        setBackground(nuevoColor);
        
        //rescatando el valor de la clave del nombre y su descripcion
        System.out.println("Nombre: "+getValue(Action.NAME)+"Descipcion: "+getValue(Action.SHORT_DESCRIPTION));
        
    }
    
}
    
}
