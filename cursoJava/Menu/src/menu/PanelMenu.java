/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.*;

/**
 *
 * @author bryan
 */
public class PanelMenu extends JPanel{
    
    public PanelMenu(){
    
    //creacion de barra de menu MenuBar
    JMenuBar miBarra= new JMenuBar();
    
    //creacion de opciones de menu
    
    JMenu archivo= new JMenu("Archivo");
    JMenu edicion= new JMenu("Edicion");
    JMenu herramientas= new JMenu("Herramientas");
    
    JMenu opciones =new JMenu("Opciones");
    
    //creacion de submenus de las opciones ya creadas
    //elementos de opcion Archivo
    JMenuItem guardar= new JMenuItem("Guardar");
    JMenuItem guardarComo= new JMenuItem("Guardar Como");
    
    
    //elementos de opcion Edicion
    JMenuItem cortar= new JMenuItem("Cortar");
    JMenuItem copiar= new JMenuItem("Copiar");
    JMenuItem pegar= new JMenuItem("Pegar");
    
    //elementos de opcion herramientas
    JMenuItem generales= new JMenuItem("Generales");
    
    //elementos de opcion Opciones
    JMenuItem opcion1= new JMenuItem("Opcion1");
    JMenuItem opcion2= new JMenuItem("Opcion2");
    
    //agregando items a Opciones
    opciones.add(opcion1);
    opciones.add(opcion2);
       
    //agregando itemns a archivo
    archivo.add(guardar);
    archivo.add(guardarComo);
    
     //agregando itemns a edicion
    edicion.add(cortar);
    edicion.add(copiar);
    edicion.add(pegar);
    
    //colocando separador justo despues de pegar
    edicion.addSeparator();
    /**
     * clave agregar opciones a edicion
     **/
    edicion.add(opciones);
    
    //agregando itemns a herramientas
    herramientas.add(generales);
    
    
    //agregando opciones a miBarra
    miBarra.add(archivo);
    miBarra.add(edicion);
    miBarra.add(herramientas);
    
    //agregando miBarra a panel
    add(miBarra);
    
    }
    
}
