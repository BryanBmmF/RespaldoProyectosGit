/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica3;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryan
 */
public class Panel extends JPanel{
    
    //sobreescrituta paintComponent
    
    @Override
    public void paintComponent(Graphics nuevaLetra){
      
        //llamando a super clase
        super.paintComponent(nuevaLetra);
      
        //instanciando nuevo grafico 2D para letras y castiando Graphics 2D
        Graphics2D nuevaLetra2D=(Graphics2D) nuevaLetra;
        
        //connstructor para fuentes
        
        //tipo funte size
        Font miFuente= new Font("Arial",Font.BOLD,15);
        
        //agregando mi fuente
        nuevaLetra2D.setFont(miFuente);
        
        //agregando color a fuente
        nuevaLetra2D.setColor(Color.BLUE);
        
        //mostrando texto con fuente establecida
        nuevaLetra2D.drawString("Si Puedes Imaginarlo pudes programarlo",50,50);
        
        //instanciando nueva letra
        nuevaLetra2D.setFont(new Font("Arial",Font.ITALIC,15));
        
        //poniendo color
        nuevaLetra2D.setColor(Color.RED);
        
        //mostrando nueva frase
        nuevaLetra.drawString("Curso Java Development", 100, 100);             
    
    }
}
