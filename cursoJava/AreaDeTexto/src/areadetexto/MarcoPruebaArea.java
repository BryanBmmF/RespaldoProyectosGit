/*
 * Se raliza todo en el marco tanto paneles como sus botones y areas de texto
 */
package areadetexto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author bryan
 */
public class MarcoPruebaArea extends JFrame{
    
    public MarcoPruebaArea(){
    
        setTitle("Ejemplo de Area de texto");
        setBounds(500,300,500,350);
        
        
        //Layout de marco
        setLayout(new BorderLayout());
        
        //iniciando panel y botones
        panelBotones= new JPanel();    
        botonInsertar=new JButton("Insertar");
        
        //accion de botonInsertar y creacion de interfaz oyente adjunta
        botonInsertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                areaTexto.append("SiPuedes Imaginarlo Pudes Programarlo");
                
            }
        
        });
        //agragar botonInsertar al PanelBotones
        panelBotones.add(botonInsertar);
        
        // iniciando boton SaltoLinea
        botonSaltoLinea= new JButton("Salto Linea");
        
        //accion de botonSaltoLinea  
        botonSaltoLinea.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //miembro saltar y logica de salto
                boolean saltar=!areaTexto.getLineWrap();
                
                //estableciendo salto de linea
                areaTexto.setLineWrap(saltar);
                
                //evaluando si hay o no hay salto de linea
                //saltar ==true
                
                /*if(saltar){
                    botonSaltoLinea.setText("Quitar Salto");
                
                }
                else{
                    botonSaltoLinea.setText("Salto Linea");
                }*/
                
                //operacion ternario para hacer la logica de salto 
                //de otra forma
                botonSaltoLinea.setText(saltar?"Quitar Salto":"Salto Linea");
            }
        
        });
        
        //agreagando botones al panel correspondiente
        panelBotones.add(botonSaltoLinea);
        
        //agregando panelBotones en layout sur
        add(panelBotones,BorderLayout.SOUTH);
        
        //iniciando areaTexto 8 filas de texto 20 largo texto
        areaTexto=new JTextArea(8,20);
        
        //iniciando panel con barras
        panelConBarras=new JScrollPane(areaTexto);
        
        //agregando panel con barras
        add(panelConBarras,BorderLayout.CENTER);
    
    }
    
    //creacion de lamina para botones
    private JPanel panelBotones;
    
    //creacion de botones
    private JButton botonInsertar,botonSaltoLinea;
    
    //creacion de area de texto
    private JTextArea areaTexto;
    
    //creacion de scroll
    private JScrollPane panelConBarras;
    
}
