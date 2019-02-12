/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresarial.backend.modelos;

import empresarial.backend.recursoshumanos.ManejadorRH;
import empresarial.gui.frames.EscritorioFrame;
import java.util.Locale;

/**
 *
 * @author jose
 */
public class Run {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		ManejadorRH rh = new ManejadorRH();
		EscritorioFrame escritorio = new EscritorioFrame(rh);
		escritorio.setVisible(true);
	}
	
}
