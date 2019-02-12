/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadrodetexto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bryan
 */

//Panel Principal con Border layout como ubicacion
public class PanelTexto extends JPanel{
    
    public PanelTexto(){
        
        /**
         * Clase JTextField para creacion de cuadros de texto
         **/
        
        //constructor para texto por defecto adaptado al cuadro
        //JTextField campo1=new JTextField("texto por Defecto");
        
        //constructor con size
        //JTextField campo1=new JTextField(20);
        
        //constructor combinado
        //JTextField campo1=new JTextField("texto por Defecto",20);
        
        //imprimiendo en consola el texto en cuadro
        // quitando espacios adicionales con trim
        //System.out.println(campo1.getText().trim());
        //////////////////////////////////////////////////////////////
        
        //ejemplo
        
        //Borderlayout
        setLayout(new BorderLayout());
        
        //creando panel2
        JPanel miPanel2= new JPanel();
        miPanel2.setLayout(new FlowLayout());
        
        //llamando etiqueta resultado y alineando en Centro
        resultado = new JLabel("",JLabel.CENTER);
        
        //creando etiqueta con Jlabel  
        JLabel texto1 =new JLabel("Email: ");
        
        //agregando a Panel2
        miPanel2.add(texto1);
        
        //creando cuadro de texto
        campo1=new JTextField(20);
        
        //agregando a Panel2
        miPanel2.add(campo1);
        
        //agregando resultado en zona norte de zona principal
        add(resultado,BorderLayout.CENTER);
        
        //creando Boton
        JButton miBoton =new JButton("Comprobar");
        
        //creando Instancia del evento correspondiente
        DameTexto miEvento=new DameTexto();
        
        //boton ha escucha y pasando como parametro miEvento
        miBoton.addActionListener(miEvento);
        
        //agregando boton
        //agregando a Panel2
        miPanel2.add(miBoton);
        
        //colocando Panel2 en norte        
        add(miPanel2,BorderLayout.NORTH);
        
    
    }
    
    //creacion de clase interna
    private class DameTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(campo1.getText().trim());
            
            //comprobacion de correo
            
            int correcto=0;
            
            //miembro donde se almacena el texto que se introduce
            String email=campo1.getText().trim();
            
            //recorriendo cadena completa
            for(int i=0;i<email.length();i++){
                
                //comparando letra a letra
                if(email.charAt(i)=='@'){
                    
                    correcto++;
                
                }
            }
            //condicion de correo
            if(correcto!=1){
                
                JOptionPane.showMessageDialog(null,"Direccion de correo\n Incorrecta");
                resultado.setText("Incorrecto");
            }
            
            else{
                JOptionPane.showMessageDialog(null,"Direccion de correo\n Correcta");
                resultado.setText("Correcto");
            }
        }
        
        
}
    //creando cuadro  encapsulado
    private JTextField campo1;
    
    private JLabel resultado;

    
}
