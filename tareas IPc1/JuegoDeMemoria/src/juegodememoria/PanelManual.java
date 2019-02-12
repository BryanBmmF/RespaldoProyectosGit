/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodememoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import static juegodememoria.FramePanel.panelMenu;
import static juegodememoria.FramePanel.panelPrincipal;

/**
 *
 * @author bryan
 */
public class PanelManual extends FramePanel{
    
    public PanelManual(){
        
        //agregando menu de opciones heredado de FramePanel
        add(panelMenu,BorderLayout.NORTH);
        
         //creando panel principal de nueva partida de juego
        panelPrincipal= new JPanel();
        
        //caracteristicas de panel Principal para Partida Nueva
        panelPrincipal.setBackground(Color.YELLOW);
        panelPrincipal.setBorder(BorderFactory.createLoweredBevelBorder());
        //panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //agregando panel principal al Frame Panel2
        add(panelPrincipal,BorderLayout.CENTER);
        
         //agregando scroll al panel principa; adaptable vertical y hor.
        JScrollPane scroller= new JScrollPane(panelPrincipal);
        scroller.setPreferredSize(new Dimension(200,200));
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroller);
        
            try{ //manejo de ecepcion para el manual de usuario en dado caso se elimine el archivo
                //intentando generar el panel para mostrar el archivo de texto
                
                Font miFuente= new Font("Arial",Font.BOLD,15);
                Dimension dim2= new Dimension(300,1000);
                
                JTextArea manual= new JTextArea();
                manual.setFont(miFuente);
     
                //creacion de segundo panel para barras de scroll
                JScrollPane panelBarras= new JScrollPane(manual);
                manual.setBackground(Color.ORANGE);
                
                //agregando barra scroll al panel
                panelPrincipal.add(panelBarras);
                
                // leyendo archivo de texto con el manual de usuario
                BufferedReader bf= new BufferedReader(new FileReader("src/manual.txt")); 
                
                //variables de texto a utilizar
                String salto="\n";
                String linea;
                String lineaTemp="";
                String texto="";
                int i=0;
                while((linea=bf.readLine())!=null){
                    //leyendo linea a linea y almacenando
                    lineaTemp=lineaTemp+linea+salto;
                }
                texto=lineaTemp;
                //estableciendo manual en el area de Texto
                manual.setText(texto);
                
            }
            catch(Exception ex){ //capturando ecepcion y mostrando mensaje
                
                JOptionPane.showMessageDialog(PanelManual.this, "El archivo no se encontro");
            
            }
    }
    
}
