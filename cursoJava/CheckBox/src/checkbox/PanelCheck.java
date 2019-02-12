/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bryan
 */
public class PanelCheck extends JPanel {
    
    public PanelCheck(){
        
        //Distribucion del Panel
        setLayout(new BorderLayout());
        
        //clase Fontn para manipular Texto
        Font miLetra = new Font("Serif",Font.PLAIN,24);
        
        //iniciando label texto
        texto= new JLabel("Si Pudes imaginarlo Puedes Programarlo");
        //pasando parametro miletra
        texto.setFont(miLetra);
        
        //creacion de nuevo Panel para texto, agregando a marco, y layout
        JPanel panelTexto= new JPanel();
        panelTexto.add(texto);
        add(panelTexto,BorderLayout.CENTER);
        
        //iniciando check 1,2 con su Resp.Constructor
        check1= new JCheckBox("Negrita");
        check2= new JCheckBox("Cursiva");
        
        //poniendo Checsk a escucha
        check1.addActionListener(new ManejaChecks());
        check2.addActionListener(new ManejaChecks());
        
        //creando panel para checks y agregando cada check al panel
        JPanel panelChecks= new JPanel();    
        panelChecks.add(check1);
        panelChecks.add(check2);
        
        //colocando panelChecks en layout sur
        add(panelChecks,BorderLayout.SOUTH);
        
    
    }
    
    //creacion de clase Interna oyente
    private class ManejaChecks implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //tipo=0 sin modificar fuente de letra
            int tipo=0;
            //en caso que el check1 este seleccionado tipo+=1 negrita
            if(check1.isSelected()) tipo+=Font.BOLD;
            //en caso que el check2 este seleccionado tipo+=2 cursiva
            if(check2.isSelected()) tipo+=Font.ITALIC;
            
            //tipo= 3 pone negrita y cursiva
            texto.setFont(new Font("Serif",tipo,24));
            
        }
    
    }
    //declaracion de miembros encapsulados a utilizar
    private JLabel texto;
    private JCheckBox check1,check2;
    
}
