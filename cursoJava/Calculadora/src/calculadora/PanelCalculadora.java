/*
 * Agregacion de botones 
 */
package calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author bryan
 */
public class PanelCalculadora extends JPanel{

    public PanelCalculadora(){
        
        //nadamas cargado el programa principio es true para que entre
        //en el if de comparacion para el 0
        principio=true;
        
        //disposicion de Borderlayout
        setLayout(new BorderLayout());
               
        //instanciando boton pantalla    
        pantalla=new JButton("0");
      
        //desactivando funcion de Boton Pantalla
        pantalla.setEnabled(false);
        
        //agregando pantalla en zona norte
        add(pantalla,BorderLayout.NORTH);
        
        //iniciando miPanel2 
        miPanel2=new JPanel();
        
        //Gridlayout para rejilla  4 columnas 4 filas
        miPanel2.setLayout(new GridLayout(4,4));
        
        /**
         * Agregando botones de forma practica
         * Usando metodo ponerBoton
         **/
        
        //creando instancia interna inserteNumero 
        ActionListener insertar= new InserteNumero();
        
        //creando instancia interna AccionOrden
        ActionListener orden=new AccionOrden();
        
        /*primer parametro se almacena en rotulo y el
          segundo en oyente */
        ponerBoton("7",insertar);
        ponerBoton("8",insertar);
        ponerBoton("9",insertar);
        ponerBoton("/",orden);
        ponerBoton("4",insertar);
        ponerBoton("5",insertar);
        ponerBoton("6",insertar);
        ponerBoton("*",orden);
        ponerBoton("1",insertar);
        ponerBoton("2",insertar);
        ponerBoton("3",insertar);
        ponerBoton("-",orden);
        ponerBoton("0",insertar);
        ponerBoton(".",orden);
        ponerBoton("+",orden);
        ponerBoton("=",orden);
        
        //agregando miPanel2 en borderCenter       
        add(miPanel2,BorderLayout.CENTER);
        
        //iniciando variable
        ultimaOperacion="=";
        
        
        
        /**
         * primera forma de crear todos los botones
         * para la calculadora  
         * se ordenan por filas
         **/
        /*
        //columna1 
        JButton boton1=new JButton("1");
        miPanel2.add(boton1);
        
        JButton boton2=new JButton("2");
        miPanel2.add(boton2);
        
        JButton boton3=new JButton("3");
        miPanel2.add(boton3);
        
        JButton boton4=new JButton("4");
        miPanel2.add(boton4);
        
        //columna2 
        JButton boton5=new JButton("5");
        miPanel2.add(boton5);
        
        JButton boton6=new JButton("6");
        miPanel2.add(boton6);
        
        JButton boton7=new JButton("7");
        miPanel2.add(boton7);
        
        JButton boton8=new JButton("8");
        miPanel2.add(boton8);
        
        //columna3
        JButton boton9=new JButton("9");
        miPanel2.add(boton9);
        
        JButton boton0=new JButton("0");
        miPanel2.add(boton0);
        
        JButton botonP=new JButton(".");
        miPanel2.add(botonP);
        
        JButton botonI=new JButton("=");
        miPanel2.add(botonI);
        
        //columna 4
        //columna1 
        JButton botonM=new JButton("+");
        miPanel2.add(botonM);
        
        JButton botonR=new JButton("-");
        miPanel2.add(botonR);
        
        JButton botonM2=new JButton("*");
        miPanel2.add(botonM2);
        
        JButton botonD=new JButton("/");
        miPanel2.add(botonD);
        */
       
    }
    
    /**
     * Creacion de metodo encargado de 
     * crear botones de una forma mas
     * accesible
     **/
    
    //recibe parametros enviados desde ponerBoton()
    private void ponerBoton(String rotulo,ActionListener oyente){
        
        //instanciacion de JButton
        JButton boton=new JButton(rotulo);
        
        //instanciando Boton ha escucha
        //recibe metodo de ActionListener 
        boton.addActionListener(oyente);
        
        //agregando boton al Panel2
        miPanel2.add(boton);
    
    }
    
    //creacion de clase interna InserteNumeropara funcionalidad de la calc
    
    private class InserteNumero implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //devuelve el comando String Asociado con la accin
            //CAPTURANDO TEXTO DEL BOTON PULSADO
            //recibe objeto tipo evento (texto)  que se almacena en e           
            String entrada=e.getActionCommand();
            
            //si principio es true
            if(principio){
                
                //pone en blanco la pantalla para luego escribir los numeros
                pantalla.setText("");
                principio=false;
                      
            }
            //desencadena y se establece en pantalla lo
            // que haya anteriormente mas lo que se pone despues
            pantalla.setText(pantalla.getText()+entrada);  
        }

    }
    
    //clase interna que gestiona operaciones matematicas
    private class AccionOrden implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //almacenando en operacion el simbolo del boton o texto
            String operacion=e.getActionCommand();
            System.out.println(operacion);//solo para verificacion imprimir
           
            //captura convierte a double y lo pasa como parametro
            calcular(Double.parseDouble(pantalla.getText()));
            
            //almacenando operaciones que se vallan realizando
            ultimaOperacion=operacion;
            
            //para no concatenar el 0 a las operaciones
            principio =true;
            
            
        }
        //metodo encargado de realizar operaciones
        //declarando metodo cerebro
        public void calcular(double x){
            
            if(ultimaOperacion.equals("+")){
                
                //suma lo acumulado por lo que se pasa en parametro
                resultado+=x;  
                System.out.println(resultado);//mostrando result
                
            }
            else if(ultimaOperacion.equals("-")){
                resultado-=x;
            }
            else if(ultimaOperacion.equals("*")){
                resultado*=x;
            }
            else if(ultimaOperacion.equals("/")){
                resultado/=x;
            }
            else if(ultimaOperacion.equals("=")){
                resultado=x;
            }
            
            pantalla.setText(""+resultado);
        
        }
    
    
    }
    
    //encapsulando miPanel2 principio  y pantalla para ser accedidos dentro de la clase
    private JPanel miPanel2;
    private JButton pantalla;
    private boolean principio;
    
    //miembro de almacenamiento
    private double resultado;
    
    private String ultimaOperacion;
}
