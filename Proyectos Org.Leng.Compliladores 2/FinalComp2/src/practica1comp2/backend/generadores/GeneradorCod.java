/*
 * Generador de cod 3D atravez de Cuartetos
 */
package practica1comp2.backend.generadores;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import practica1comp2.backend.analizadores.simbolos.Categoria;
import practica1comp2.backend.analizadores.simbolos.Parametro;
import practica1comp2.backend.analizadores.simbolos.Simbolo;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.analizadores.simbolos.Token;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.instrucciones.InstruccionSub;

/**
 *
 * @author bryan
 */
public class GeneradorCod {
    private TablaSimbolos sym;
    private List<Cuarteto> listaCuartetos;
    private List<Cuarteto> listaCuartetosSubs;
    private int contTemp;
    private int contEtiq;
    private Operador op; 
    private TipoVar tipoVar;
    private Categoria categoria;
    private EtiqRedireccion redir;
    private EtiqCondicion dos;

    public GeneradorCod(TablaSimbolos sym) {
        this.sym = sym;
        this.listaCuartetos = new ArrayList();
        this.listaCuartetosSubs = new ArrayList();
        this.contTemp =1;
        this.contEtiq =1;
        this.op = null;
        this.tipoVar = null;
        this.categoria = null;
        
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
    public void addCuarteto2(Cuarteto cuarteto){
        listaCuartetosSubs.add(cuarteto);
    }
    
    //recibir como parametro en donde se va imprimr el codigo3D
    public void imprimirCod3D(JTextArea text){
        for(Cuarteto cu : listaCuartetos){
            text.append(cu.imprimir3D()+"\n");
        }
    
    }
    
    //recibir como parametro en donde se va imprimir el codigoC
    public void imprimirCodC(JTextArea text){
        //encabezado de un archivo c
        text.append("#include <stdio.h>\n");
        text.append("#include <stdlib.h>\n");
        //text.append("#include <stdbool.h>\n");
        text.append("#include <string.h>\n\n");
        
        //declaraciones globales
        Tipo tipo;
        
        for(Simbolo key: sym.getSym()){
            tipo = key.getTipo();
            if (tipo.getCategoria()==Categoria.VAR && tipo.getAmbito()==0) {
                    declararVariable(tipo, text, key.getNombre());
                }
        }
        
        //main
        text.append("int main(){ \n");
        
        //declaracion de temporales codigo 3D
        for (Simbolo key: sym.getSym()){
                tipo = key.getTipo();
                /*solo imprimir los temporalel las var de subProgramas despues despues de evaluar cada call*/
                if (tipo.getCategoria()==Categoria.VAR_TEMPOTAL || tipo.getCategoria()==Categoria.SUBPROGRAMA) { //si es ambito 0 esta en el main
                    declararVariable(tipo, text, key.getNombre());
                }
                
        }
        /*copiar de una lista a otra*/
        for(Cuarteto cu : listaCuartetos){
            this.listaCuartetosSubs.add(cu);
        }
        /*limpiar la lista original para almacenar el codigo por llamada de cada funcion*/
        this.listaCuartetos.clear();
        
        for(Cuarteto cu : listaCuartetosSubs){
            if (cu.getOp()!=Operador.FIN_MAIN) {
                if (cu.getOp()==Operador.CALL) {
                    /*incrustar el codigo de la funcion aqui*/
                    text.append("/*********NUEVA LLAMADA DE SUBPROGRAMA**********/\n");
                    incrustarCodCall(text, cu);
                    /*asignando la funcion*/
                    text.append(cu.imprimirC(this.sym)+"\n");
                } else {
                    text.append(cu.imprimirC(this.sym)+"\n");
                }
                
            } else break;
            
        }
        
        
        text.append("return (EXIT_SUCCESS);\n");
        text.append("} \n");
    
    }
    
    public void incrustarCodCall(JTextArea text, Cuarteto cu){
        /*El arg1 del Cuarteto es el nombre de la funcion, de alli jalar toda la info*/
        
        /*recuperar la funcion*/
        InstruccionSub sub = sym.getSubprogramaCargado(new Token(cu.getArg1().getLugarTemp(), 0, 0), sym.getListaConsultaSubs());
        
        /*setear nuevo nombre de las declaraciones y parametros en el sub en el sub*/
        sub.setearVariablesLocales();
        
         //declaracion de temporales codigo 3D de los parametros de cada subprograma llamado
        if (!sub.isVarsDeclaradas()) {
            Tipo tipo;
            for (Simbolo key: sym.getSym()){
                    tipo = key.getTipo();
                    /*solo imprimir los temporalel las var de subProgramas despues despues de evaluar cada call*/
                    if ((tipo.getCategoria()==Categoria.PARAMETRO && tipo.getSubPadre().equals(sub.getProcessName().getLexeme())) || (tipo.getCategoria()==Categoria.VAR && tipo.getAmbito()==1 && tipo.getSubPadre().equals(sub.getProcessName().getLexeme()))) { //si es ambito 0 esta en el main
                        declararVariable(tipo, text, key.getNombre());
                    }

            }
            sub.setVarsDeclaradas(true);
         
        }
        
        /*asignacion de los parametros con los valores que se envian en la llamada*/
        int cont =0;
        if (sub.getParametros()!=null) {
           for(Parametro param: sub.getParametros()){
                this.addCuarteto(new Cuarteto(op.ASIG, new Expresion(param.getToken().getLexeme(), param.getTipo(), this), cu.getArg1().getListaParamEnviar().get(cont), null));
                cont++;
            }
        }
        
        /*evaluar las instrucciones del sub*/
        sub.evaluarLlamadaSub();
        
        /*imprimiendo las nuevas asignaciones e instrucciones de la llamada del sub*/
        for(Cuarteto cuar : listaCuartetos){
            text.append(cuar.imprimirC(sym)+"\n");
        }
    
        /*despues de cada llamada limpiar la lista original de cuartetos para poder realizar otra llamada*/
        listaCuartetos.clear();
        
        
    
    }
    public void declararVariable(Tipo tipo, JTextArea text, String key){
        switch (tipo.getTipo()) {
            case BOOLEAN:
                text.append("short "+key+";\n");
            break;
            case CHAR:
                text.append("char "+key+";\n");
            break;
            case BYTE:
                text.append("short "+key+";\n");
            break;
            case INT:
                text.append("int "+key+";\n");
            break;
            case LONG:
                text.append("long "+key+";\n");
            break;
            case FLOAT:
                text.append("float "+key+";\n");
            break;
            case DOUBLE:
                text.append("double "+key+";\n");
            break;
            case STRING:
                text.append("char "+key+"[75]=\"\";\n");
            break;
            default:
                //throw new AssertionError();
        }
    
    }
    
    public void limpiarListaCuart(){
        this.contTemp =1;
        this.contEtiq =1;
        this.listaCuartetos.clear();
    }
    
    public void agregarTemporal(Token id, Tipo tipo){
        sym.addSimbolo(id, tipo);
    }

    public TablaSimbolos getSym() {
        return sym;
    }

    public List<Cuarteto> getListaCuartetos() {
        return listaCuartetos;
    }

    public List<Cuarteto> getListaCuartetosSubs() {
        return listaCuartetosSubs;
    }
    

    public Operador getOp() {
        return op;
    }

    public TipoVar getTipoVar() {
        return tipoVar;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    
}
