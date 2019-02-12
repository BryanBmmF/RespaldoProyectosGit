/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combobox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author bryan
 */
public class PanelCombo extends JPanel{
    
    public PanelCombo(){
    
        //layout de panel
        setLayout(new BorderLayout());
        //iniciando Label texto
        texto=new JLabel("Si puedes Imaginarlo puedes Programarlo");
        //caracteristicas de texo
        texto.setFont(new Font("Serif",Font.PLAIN,18));
        
        //agregando texto en centro del panel
        
        add(texto,BorderLayout.CENTER);
        
        //creando nuevo panel
        JPanel panelNorte=new JPanel();
        
        //creando combo box con su constructor
        miCombo= new JComboBox();
        
        //agregando caracteristica de combo editable
        miCombo.setEditable(true);//permite escribir en el combo
        
        //agregando items de combo desplegable
        miCombo.addItem("Serif");
        miCombo.addItem("SanSerif");
        miCombo.addItem("Monospaced");
        miCombo.addItem("Dialog");
        
        //instanciando clase Oyente
        EventoCombo miEvento= new EventoCombo();
        //llamando metodo ActionListener enviando miEveno para e 
        miCombo.addActionListener(miEvento);
        
        //agregando a panelNorte el combo        
        panelNorte.add(miCombo);
        
        //agregando panelNorte al Marco
        add(panelNorte,BorderLayout.NORTH);
        
        
    }
    //creando clase interna para gestion de eventos   
    private class EventoCombo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //especificando tipo de letra  casteo de miCombo a String
            texto.setFont(new Font((String)miCombo.getSelectedItem(),Font.PLAIN,18));
        }

}
    
    //miembros de clase a utilizar encapsuladas
    
    private JLabel texto;
    private JComboBox miCombo;
    
}
