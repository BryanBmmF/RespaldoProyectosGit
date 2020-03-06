/*
 * Generador de cod 3D atravez de Cuartetos
 */
package practica1comp2.backend.generadores;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import practica1comp2.backend.analizadores.simbolos.TipoVar;

/**
 *
 * @author bryan
 */
public class GeneradorCod {
    
    private List<Cuarteto> listaCuartetos;
    private int contTemp;
    private int contEtiq;
    private Operador op; 
    private TipoVar tipoVar;
    private EtiqRedireccion redir;
    private EtiqCondicion dos;

    public GeneradorCod() {
        this.listaCuartetos = new ArrayList();
        this.contTemp =1;
        this.contEtiq =1;
        this.op = null;
        this.tipoVar = null;
        
    }
    public List<Cuarteto> unirQuad(List<Cuarteto>cod1, List<Cuarteto> cod2){
        List<Cuarteto> list= new ArrayList();
        if (cod1!=null) {
             for(Cuarteto c: cod1){
                list.add(c);
            }
        }
        if (cod2!=null) {
            for(Cuarteto c: cod2){
                list.add(c);
            }
        }
        return list;
    
    }
    public EtiqRedireccion getRedir(){
        return redir;
    }
    public EtiqCondicion getDos(){
        return dos;
    }
    public EtiqRedireccion getNuevoRedir(){
        return redir = new EtiqRedireccion(getNuevaEtiq(), getNuevaEtiq());
    }
    public EtiqCondicion getNuevoDos(){
        return dos = new EtiqCondicion(getNuevaEtiq(), getNuevaEtiq());
    }
    
    public String getLugarTemp(){
		return "t"+contTemp++;
    }
    public String getNuevaEtiq(){
		return "Et"+contEtiq++;
    }
    
    public void dismEtiq(){
        this.contEtiq--;
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
    
    public void limpiarListaCuart(){
        this.contTemp =1;
        this.contEtiq =1;
        this.listaCuartetos.clear();
    }

    public List<Cuarteto> getListaCuartetos() {
        return listaCuartetos;
    }

    public Operador getOp() {
        return op;
    }

    public TipoVar getTipoVar() {
        return tipoVar;
    }
       
    
    
}
