/*
 * Applet del reloj
 */
package manejotimer;

import javax.swing.JApplet;

/**
 *
 * @author bryan
 */
public class AppletRelojUtil extends JApplet{
    /** 
     * Crea un modelo de reloj y su visual, metiéndolos en el applet.
     */
    public void start() {
        RelojModeloUtil modelo = new RelojModeloUtil();
        RelojVisual visual = new RelojVisual(modelo);
        
        getContentPane().add(visual);
    }
}
