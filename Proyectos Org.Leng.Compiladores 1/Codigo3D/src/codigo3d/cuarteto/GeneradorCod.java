/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo3d.cuarteto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author bryan
 */
public class GeneradorCod {
    
    private List<Cuarteto> listaCuartetos;

    public GeneradorCod() {
        this.listaCuartetos = new ArrayList();
        
    }
    
    public void addCuarteto(Cuarteto cuarteto){
        listaCuartetos.add(cuarteto);
    }
    
    //recibir como parametro en donde se va imprimr el codigo
    public void imprimirCod(JTextArea text){
        for(Cuarteto cu : listaCuartetos){
            text.append(cu.imprimir()+"\n");
        }
    
    }

    public List<Cuarteto> getListaCuartetos() {
        return listaCuartetos;
    }
       
    
    
}
