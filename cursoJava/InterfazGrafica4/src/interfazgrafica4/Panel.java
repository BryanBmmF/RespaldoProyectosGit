/*
 * panel para incluir imagenes  Image.IO  pertenece a javax.imajeIO
 * rescata imagenes con la direccion url(ruta de la imagen)
 *puede generar IOExcepcion en caso sea borrada la imagen o cambiada de ruta
 */
package interfazgrafica4;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bryan
 */
public class Panel extends JPanel{
    
    //reescribiendo metodo paintComponent
    
    @Override
    public void paintComponent(Graphics nuevaImagen){
        
        //obteniendo clase padre paint
        super.paintComponent(nuevaImagen);
        
        //indicando ruta de imagen (OpCional)
        //instanciacion de nueva imagen con la clase File  
        //File miImagen=new File("src/graficos/carro.jpg");
        
        //capturando excepcion
        try{
            //intentando rescatar imagen 
        imagen=ImageIO.read(new File("src/graficos/coco.gif"));//instanciacion adjunta
        }
        catch(IOException excepcionImagen){
            //excepcion en caso no se encuentre la imagen
            JOptionPane.showMessageDialog(null, "la imagen no se ha encontrado");
        }
        //mostrando imagen en la esquine superior izquierda
        nuevaImagen.drawImage(imagen, 0, 0, null);
        
        /**        
         * metodo para repetir imagen en ventana posee 6 parametros
         * metodo CopyArea
         * bucle for para estilo mosaico de la imagen
         **/
        //declaracion de variables para recibir ancho y alto
        int anchuraImagen=imagen.getWidth(this);
        int alturaImagen=imagen.getHeight(this);
        
        //metodos getWidth y getheigth para buscar dimensiones de cualquier imagen
        for(int i=0;i<400;i++){
            for (int j = 0; j < 400; j++) {
                
                nuevaImagen.copyArea(0, 0, anchuraImagen,alturaImagen,anchuraImagen*i,alturaImagen*j);
                
            }
        }
        
        
    
    }
    
    private Image imagen;// encapsulando imagen
    
    
    
}
