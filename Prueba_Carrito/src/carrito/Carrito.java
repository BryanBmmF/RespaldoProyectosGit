
package carrito;

import GUI.CarritoGUI;


/**
 *
 * @author jpmazate
 */
public class Carrito {
    public static void main(String[] args) {
       try{
          
       
           CarritoGUI carrito = new CarritoGUI();
           carrito.setVisible(true);
       
       
       }catch(Exception e ){
           e.printStackTrace();
       }
       
    }
    
}
