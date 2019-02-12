/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodememoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import static juegodememoria.FramePanel.panelPrincipal;

/**
 *
 * @author bryan
 */
public class PlayerFrame extends JFrame{
    
    public PlayerFrame(){
    
        setTitle("Juego de Memoria");
        setBounds(500,300,500,350);
    
        //instanciando nuevo Panel
        FramePanel panel1= new FramePanel();
       
        //agragando panel al Frame        
        add(panel1);
        
        //configuaracion de acciones para cambiar el fondo del frame
        Action accionAmarillo= new AccionColor("Amarillo",new ImageIcon("src/graficos2/amarillo.jpg"),Color.YELLOW);
        Action accionAzul= new AccionColor("Azul",new ImageIcon("src/graficos2/azul.jpg"),Color.BLUE);
        Action accionRojo= new AccionColor("Rojo",new ImageIcon("src/graficos2/rojo.png"),Color.RED);        
        Action accionSalir= new AbstractAction("Salir",new ImageIcon("src/graficos2/salir.png")){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
    
        };
        
        //construciion de la barra de herramientas
        barra= new JToolBar();
        //botones para fondo
        barra.add(new JLabel("Fondos "));
        barra.add(accionAzul);
        barra.add(accionRojo);
        barra.add(accionAmarillo);
       
        //separadores
        barra.addSeparator();
        barra.addSeparator();
        //opcion de cerrar el juego
        barra.add(new JLabel("Salir "));
        barra.add(accionSalir);
        
        //colocacion de barra herramientas en Frame
        add(barra, BorderLayout.SOUTH);
        
    }
    //configuaracion de acciones para barra de herramientas
    //encapsulando clase
    private class AccionColor extends AbstractAction {
    
    //constructor con parametros a recibir
    public AccionColor(String nombre, Icon icono, Color colorBoton){
    
        //almacenamiento de parametros recibidos
        
        //almacenando nombre
        putValue(Action.NAME,nombre); //cuando se instancie la clase oyente
                                      //clave:NAME, valor:nombre
                                      
        //almacenando icono
        putValue(Action.SMALL_ICON,icono);
        
        //almacenando descripcion y mostrando mensaje emergente
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
        panelPrincipal.setBackground(nuevoColor);
        
        //rescatando el valor de la clave del nombre y su descripcion
        System.out.println("Nombre: "+getValue(Action.NAME)+"Descipcion: "+getValue(Action.SHORT_DESCRIPTION));
        
    }
    
}
    public static JToolBar barra;
    
}
