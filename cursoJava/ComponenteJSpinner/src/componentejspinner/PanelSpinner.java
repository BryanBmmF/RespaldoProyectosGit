/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentejspinner;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.*;

/**
 *
 * @author bryan
 */
public class PanelSpinner extends JPanel{
    
    public PanelSpinner(){
        /**
         * 1. Constructor por defecto
         **/
        //creacion del Spinner con fecha y hora
        /**
         * SpinnerDateModel para poner fecha y hora  informacion en Api
            JSpinner control= new JSpinner(new SpinnerDateModel());
            agregando Spinner al panel
            add(control);
        **/
        
        /**
         * //creacion de array de objeto para spinner con texto
            //String lista[]={"Enero","Febrero","Marzo","Abril"};
        
            //creacion de spinner con todas los tipo de letras
            String lista[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
            //Spinner que muestra la lista del array
            JSpinner control= new JSpinner(new SpinnerListModel(lista));
            //creando objeto de tipo dimension para dimensiones de spinner
            Dimension d= new Dimension(200,20);
            control.setPreferredSize(d);
        
            add(control);
         **/
        
        ////////////////////////////////////////////////////////////////////////////
        /**
         * 2. Constructor NumberModel de Spinner
         *  empieza en 5, tope inf.0 , tope sup.10 ,  incremento 1 en 1 
         * JSpinner control= new JSpinner(new SpinnerNumberModel(5,0,10,1));
            //creando objeto de tipo dimension para dimensiones de spinner
            Dimension d= new Dimension(200,20);
            control.setPreferredSize(d);
        
             add(control);
         
         **/
        
        /**
         * Utilizando propio Modelo de SpinnerNumberModel
         **/
        
        //OPCION 1. creacion de clase interna ANONIMA
        JSpinner control= new JSpinner(new SpinnerNumberModel(5,0,10,1){
        
            @Override
            public Object getNextValue(){
            
            //devuleve el valor previo
            return super.getPreviousValue();
        
            }
        
            public Object getPreviusValue(){
        
            return super.getNextValue();
            }
        
        });
        
        //size 
        Dimension dim= new Dimension(100,20);        
        control.setPreferredSize(dim);
        
        add(control);
        
    }
    //OPCION2 creacion de clase interna enpasulada para gestion  
    /*private class MiModeloJSpinner extends SpinnerNumberModel{
    
        //valores de inicio
        public MiModeloJSpinner(){
            
            //llamar al constructor de Number Model y pasandole param.
            super(5,0,10,1);
        
        }
        
        //sobreescribiendo metodo para que trabaje alrevez
        
        @Override
        public Object getNextValue(){
            
            //devuleve el valor previo
            return super.getPreviousValue();
        
        }
        
        public Object getPreviusValue(){
        
            return super.getNextValue();
        }
    }
    */
    
}
