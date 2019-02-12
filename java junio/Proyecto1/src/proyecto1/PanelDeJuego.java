/*
 *Panel de Juego
 */
package proyecto1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author bryan
 */
public class PanelDeJuego extends JPanel{
    public static JPanel tablero;
    public static JLabel[] casillas=new JLabel[100];
    
    public PanelDeJuego(){
        tablero= new JPanel();
        
        //Gridlayout para rejilla  10 columnas 10 filas
        tablero.setLayout(new GridLayout(10,10));
        tablero.setBorder(BorderFactory.createLoweredBevelBorder());
        add(tablero);
    }
    //metodo para colocar las 100 casillas del tablero
    public void colocarCasillas(){
        int cont=100;
        for (int i = 99; i >= 0; i--) {
            casillas[i]= new JLabel(""+cont);
            Dimension dimension= new Dimension(60, 60);
            casillas[i].setPreferredSize(dimension);
            casillas[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
            tablero.add(casillas[i]);
            cont--;
        }
    }
    //metodo para actualizar casilla de avance
    public void actualizarCasilla(int numeroCasilla,int turno){
        if (numeroCasilla==1) {
            casillas[0].setForeground(Color.BLUE); casillas[0].setText(""+1+" E#1");
        }
        else{
            switch(turno){
                case 1:{casillas[numeroCasilla-1].setForeground(Color.GREEN);
                        casillas[numeroCasilla-1].setText(""+numeroCasilla+" PsJ"+turno);
                break;
                }
                case 2:{casillas[numeroCasilla-1].setForeground(Color.ORANGE);
                        casillas[numeroCasilla-1].setText(""+numeroCasilla+" PsJ"+turno);
                break;
                }
                case 3:{casillas[numeroCasilla-1].setForeground(Color.CYAN);
                        casillas[numeroCasilla-1].setText(""+numeroCasilla+" PsJ"+turno);
                break;
                }
                case 4:{casillas[numeroCasilla-1].setForeground(Color.MAGENTA);
                        casillas[numeroCasilla-1].setText(""+numeroCasilla+" PsJ"+turno);
                break;
                }
            }
        }          
    }//metodo para normalizar casilla Pasada
    public void normalCasilla(int numeroCasilla,int turno){
        casillas[numeroCasilla-1].setForeground(Color.BLACK);
        casillas[numeroCasilla-1].setText(""+numeroCasilla);
        
    }
    //metodo para colocar identificadores de serpientes y escaleras
    public void colocarIdentificadores(){
        casillas[0].setForeground(Color.BLUE); casillas[0].setText(""+1+" E#1");
        casillas[37].setForeground(Color.BLUE); casillas[37].setText(""+38+" E#1");
        casillas[3].setForeground(Color.BLUE); casillas[3].setText(""+4+" E#2");
        casillas[13].setForeground(Color.BLUE); casillas[13].setText(""+14+" E#2");
        casillas[8].setForeground(Color.BLUE); casillas[8].setText(""+9+" E#3");
        casillas[30].setForeground(Color.BLUE); casillas[30].setText(""+31+" E#3");
        casillas[16].setForeground(Color.RED); casillas[16].setText(""+17+" $e1");
        casillas[6].setForeground(Color.RED); casillas[6].setText(""+7+" $e1");
        casillas[20].setForeground(Color.BLUE); casillas[20].setText(""+21+" E#4");
        casillas[41].setForeground(Color.BLUE); casillas[41].setText(""+42+" E#4");
        casillas[27].setForeground(Color.BLUE); casillas[27].setText(""+28+" E#5");
        casillas[83].setForeground(Color.BLUE); casillas[83].setText(""+84+" E#5");
        casillas[50].setForeground(Color.BLUE); casillas[50].setText(""+51+" E#6");
        casillas[66].setForeground(Color.BLUE); casillas[66].setText(""+67+" E#6");
        casillas[53].setForeground(Color.RED); casillas[53].setText(""+54+" $e2");
        casillas[33].setForeground(Color.RED); casillas[33].setText(""+34+" $e2");
        casillas[61].setForeground(Color.RED); casillas[61].setText(""+62+" $e3");
        casillas[18].setForeground(Color.RED); casillas[18].setText(""+19+" $e3");
        casillas[63].setForeground(Color.RED); casillas[63].setText(""+64+" $e4");
        casillas[59].setForeground(Color.RED); casillas[59].setText(""+60+" $e4");
        casillas[71].setForeground(Color.BLUE); casillas[71].setText(""+72+" E#7");
        casillas[90].setForeground(Color.BLUE); casillas[90].setText(""+91+" E#7");
        casillas[79].setForeground(Color.BLUE); casillas[79].setText(""+80+" E#8");
        casillas[98].setForeground(Color.BLUE); casillas[98].setText(""+99+" E#8");
        casillas[86].setForeground(Color.RED); casillas[86].setText(""+87+" $e5");
        casillas[35].setForeground(Color.RED); casillas[35].setText(""+36+" $e5");
        casillas[92].setForeground(Color.RED); casillas[92].setText(""+93+" $e6");
        casillas[72].setForeground(Color.RED); casillas[72].setText(""+73+" $e6");
        casillas[94].setForeground(Color.RED); casillas[94].setText(""+95+" $e7");
        casillas[74].setForeground(Color.RED); casillas[74].setText(""+75+" $e7");
        casillas[97].setForeground(Color.RED); casillas[97].setText(""+98+" $e8");
        casillas[78].setForeground(Color.RED); casillas[78].setText(""+79+" $e8");   
    }
}
