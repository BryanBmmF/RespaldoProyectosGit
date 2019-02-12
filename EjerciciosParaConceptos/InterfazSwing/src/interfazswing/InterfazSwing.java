/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazswing;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

/**
 *
 * @author jose
 */
public class InterfazSwing {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		JFrame miFrame = new JFrame();
		JMenu menu = new JMenu();
		JPanel panel = new JPanel();
		JButton boton1 = new JButton("boton 1");
		JButton boton2 = new JButton("boton 2");
		JButton boton3 = new JButton("boton 3");
		miFrame.setTitle("Mi frame");
		
		Container contenedor = miFrame.getContentPane();
		
		FlowLayout layout = new FlowLayout(0);
		contenedor.setLayout(layout);
		contenedor.add(menu);
		contenedor.add(boton1);
		contenedor.add(boton2);
		contenedor.add(boton3);
		
		/*miFrame.add(menu);
		miFrame.add(panel);*/
		miFrame.setSize(300, 300);
		//miFrame.setVisible(true);
		
		MiFrame2 miFrame2 = new MiFrame2();
		miFrame2.setTitle("Mi frame2");
		//miFrame2.setVisible(true);
		
		CalculadoraDummy calculadora = new CalculadoraDummy();
		calculadora.setTitle("Mi calculadora");
		calculadora.setVisible(true);
		
		
	}
	
}
