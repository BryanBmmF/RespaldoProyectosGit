/*
 * Ejemplo de Foco para Ventana en una sola clase
 */
package eventosdefoco;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class FocoVentana extends JFrame implements WindowFocusListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //instanciacion de FocoVentana
        
        FocoVentana miVentana=new FocoVentana();
        miVentana.iniciar();//llamando metodo iniciar
    }
    
    //clase Iniciar
    public void iniciar(){
        //instanciacion de marcos
        marco1=new FocoVentana();
        marco2=new FocoVentana();
        
        marco1.setVisible(true);
        marco2.setVisible(true);
        
        marco1.setBounds(300, 100, 600, 345);
        marco2.setBounds(1200, 100, 600, 350);
        
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);
        
        
    
    }
    //implementando metodos obligatorios
    @Override
    public void windowGainedFocus(WindowEvent e) {
        
        //
        if(e.getSource()==marco1){
            marco1.setTitle("Tengo el Foco");
        }
        else{
            marco2.setTitle("Tengo Foco");
        }
        
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        
        //e(objeto evento)  getSource(Identifica quien es el origen de la accion)
        if(e.getSource()==marco1){
            marco1.setTitle("");
        }
        else{
            marco2.setTitle("");
        }
        
    }
    
    //creacion de marcos
    FocoVentana marco1;
    FocoVentana marco2;
    
}
