/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica2;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;//para graficos 2D

/**
 *
 * @author bryan
 */
public class LaminaConFiguras extends JPanel{
    
    //sobre escritura de metoso paint Graphics
     @Override
     public void paintComponent(Graphics nuevaGrafica){
         
         //llamando metodo painComponente de super clase o clase padre
         super.paintComponent(nuevaGrafica);
         
         //creando grafica rectangular o cuadrada, location(posicion), whidt y  heigth
         //nuevaGrafica.drawRect(50, 50, 200, 200);
         
         //dibujando linea recta parametros(Pinicial x y, Pfinal x y)
         //nuevaGrafica.drawLine(100, 100, 300, 200);
         
         //dibujando un arco (x, y, whidth,height,angulo de arco)
         //nuevaGrafica.drawArc(50, 100, 100, 200, 120, 150);
         
         
         /**
          * Creacion de graficas 2D con java 2D
          **/
         
         //instanciando objeto nuevaGrafica2D de la clase Graphics2D
         Graphics2D nuevaGrafica2D=(Graphics2D)nuevaGrafica;
         
         //instanciando nuevo objeto rectangulo de Rectangle 2D
         //x,y  whidt heigth
         Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
         
         //implementando interfaz shape
         
          /**
          * setPaint para incluir color
          * draw para dibujar el trazo, fill para rellenar el trazo
          * 
          **/
         
         //aderiendo color azul a las graficas 2D(Incluye todas con la instancia nuevaGrafica2D)
         nuevaGrafica2D.setPaint(Color.BLUE);
         
         //dibujando trazo de rectangulo con el color aderido draw
         nuevaGrafica2D.draw(rectangulo);
         
         //rellenando fifura rectangulo con el color aderido fill
         nuevaGrafica2D.fill(rectangulo);
 
         
         //instanciando objeto elipse de la clase Graphics 2D        
         Ellipse2D nuevaElipse2D=new Ellipse2D.Double();
         
         //Creando una nueva Elipse dentro del rectangulo anterior       
         nuevaElipse2D.setFrame(rectangulo);
         
         //dandole nuevo color a elipse
         nuevaGrafica2D.setPaint(Color.GREEN);
         
         //draw para dibujar trazo de elipse con color establecido
         //nuevaGrafica2D.draw(nuevaElipse2D);
         
         //fill para rellenar elipse con el color establecido
         nuevaGrafica2D.fill(nuevaElipse2D);
         
         //dibujando una linea
         //utilizando elipse y rectangulo anterior como guia
         nuevaGrafica2D.draw(new Line2D.Double(100,100,300,250));
         
         /**
          * Dibujando Circulo
          **/
         
         //metodo setCenter
         
         //declarando centro en el eje de las X
         double CentroX=rectangulo.getCenterX();
         
         //declarando centro en el eje del alas y
         double CentroY=rectangulo.getCenterY();
         
         //Radio
         
         double radio=150;
         
         //dibujando Circulo
         
         Ellipse2D circulo=new Ellipse2D.Double();
         
         //integrando centros en X Y para el radio
         circulo.setFrameFromCenter(CentroX, CentroY, CentroX+radio, CentroY+radio);
         
         //dandole color al circulo
         nuevaGrafica2D.setPaint(Color.ORANGE);
         
         //Generando Circulo con el trazo 
         nuevaGrafica2D.draw(circulo);
         
         //Generando elipse con el relleno de color establecido
         //nuevaGrafica2D.fill(circulo);
         
         
         
         
         
         
         
    }
    
}
