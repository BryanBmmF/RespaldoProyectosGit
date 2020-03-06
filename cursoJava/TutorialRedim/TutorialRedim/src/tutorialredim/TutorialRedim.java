/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialredim;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



/**
 *
 * @author Geek
 */
public class TutorialRedim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Imagen obj = new Imagen();
        ImageIO.write(obj.redimensionar("src/graficos/tg2.png", 0.15), "png", new File("src/graficos2/tg2.png"));
        
    }
}
