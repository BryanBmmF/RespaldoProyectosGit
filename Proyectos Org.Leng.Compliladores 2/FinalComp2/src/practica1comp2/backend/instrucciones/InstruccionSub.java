/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import java.util.ArrayList;
import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Categoria;
import practica1comp2.backend.analizadores.simbolos.Id;
import practica1comp2.backend.analizadores.simbolos.Parametro;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.Token;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionSub extends Instruccion implements GenerarCuarteto{
    private Tipo tipo;
    private Token processName;
    private List<Parametro> parametros;
    private List<Instruccion> declaracionesLocal;
    private List<Instruccion> instruccionesLocal;
    private TablaSimbolos symTable;
    private List<Cuarteto> listaCuartetosCall;
    //private List<Instruccion> listaConsultaSubs;
    private boolean varsCambiadas;
    private boolean varsDeclaradas;
    
    public InstruccionSub(Tipo tipo, Token processName, List<Parametro> parametros, List<Instruccion> declaracionesLocal, List<Instruccion> instruccionesLocal, TablaSimbolos symTable, GeneradorCod generador) {
        super(generador);
        this.tipo = tipo;
        this.processName = processName;
        this.parametros = parametros;
        this.declaracionesLocal = declaracionesLocal;
        this.instruccionesLocal = instruccionesLocal;
        this.symTable = symTable;
        this.listaCuartetosCall = new ArrayList();
        //this.listaConsultaSubs = null; // se setea con los subs a la hora de evaluar cada subprograma
        this.varsCambiadas = false;
        this.varsDeclaradas = false;
    }
    
    public void agregar(){
        evaluarParametros();
    }


    @Override
    public void evaluar() {
        /*generando cuarteto de subprograma*/
        generarCuarteto(Operador.ETIQ, new Expresion(processName.getLexeme(), tipo, this.getGenerador()), null, null);
        /*generando declaraciones del subprograma*/
        if (declaracionesLocal!=null) {
            evaluarDeclaraciones();
        }
        /*evaluando instrucciones del subprograma*/
        if (instruccionesLocal!=null) {
            evaluarInstrucciones();
        }
        
    }
    
    public void evaluarLlamadaSub() {
        /*generando cuarteto de subprograma*/
       // generarCuarteto(Operador.ETIQ, new Expresion(processName.getLexeme(), tipo, this.getGenerador()), null, null);
        /*generando declaraciones del subprograma*/
        if (declaracionesLocal!=null) {
            evaluarDeclaraciones();
        }
        /*evaluando instrucciones del subprograma*/
        if (instruccionesLocal!=null) {
            evaluarInstrucciones();
        }
        
    }
    
    public void setearVariablesLocales(){
        //setear en las declaraciones y los parametros y en la tabla de simbolos
        if (!varsCambiadas) {
            if (parametros!=null) {
                for(Parametro param: parametros){
                    //stenado el nombre del parametro
                    
                    //seteando el nombre del patrametro parametro en la tabla de simbolos
                    symTable.setVarLocal(param.getToken(), processName.getLexeme());
                    param.setToken(new Token(param.getToken().getLexeme()+processName.getLexeme(), param.getToken().getLine(), param.getToken().getColumn()));
                }
            }
            
            if (!declaracionesLocal.isEmpty()) {
                InstruccionDeclaracion dec;
                for(Instruccion declaracion : declaracionesLocal){
                   if (declaracion!=null) {
                       dec = (InstruccionDeclaracion)declaracion;
                       for(Id id: dec.getListVar()){
                           symTable.setVarLocal(id.getId(), processName.getLexeme());
                       }
                           
                    }
                       //System.out.println("--NUEVA DECLARACION SUB_PROGRAMA: "+processName.getLexeme());
                       //declaracion.evaluar();
                }
            }
//            
            //ya se setearon
            this.setVarsCambiadas(true);
//            }
//        
            
        }
    }
    
    public void evaluarPorLlamada(){
        
    
    }
    
    public void evaluarParametros(){
        int numParam = 0;
        List<Tipo> listTiposParam = new ArrayList();
        if (parametros!=null) {
            numParam = parametros.size();
            for(Parametro param: parametros){
                //agregar los parametos a la tabla de simbolos y al array de tipos que necesita el subprograma
                Tipo t = new Tipo(param.getTipo().getTipo(), null, null, null, Categoria.PARAMETRO,
                        0, null, 1, param.getTipo().getJerarqui(), processName.getLexeme(), param.getToken());
                symTable.addPrametroLocal(param.getToken(), t, processName.getLexeme());
                listTiposParam.add(t);
            }
        }
        guardarSub(numParam, listTiposParam);
        
    }
    public boolean compararParametrosRepetidos(){
        /*ya se hace en la tabla de simbolos al evaluar si es void*/
     return true;
    }
    
    public boolean compararParametrosConDeclaraciones(){
        /*ya se hace automticamente al poner cada variable como local*/
        return true;
        
    }
    
    public void guardarSub(int numParam, List<Tipo> listTiposParam){
        /*guardar tipo y nombre del sub*/
        
        /*solo se setea su nuevo tipo con todos los parametros porque despues se evalua si existe o no*/
        this.setTipo(new Tipo(tipo.getTipo(), null, null, null, Categoria.SUBPROGRAMA
                , numParam, listTiposParam, 0, tipo.getJerarqui(), null, processName));
    }
    
    public void evaluarDeclaraciones(){
        //habria que evaluar que no se declaren antes en las globales o ya no declararlas aqui otravez
        if (!declaracionesLocal.isEmpty()) {
            //symTable.verificarInstruccionLocal(declaracionesLocal, this);
            for(Instruccion declaracion : declaracionesLocal){
                   if (declaracion!=null) {
                       System.out.println("--NUEVA DECLARACION SUB_PROGRAMA: "+processName.getLexeme());
                       declaracion.evaluar();
                }
            }
        }
    
    }
     
    public void evaluarInstrucciones(){
        
        if (!instruccionesLocal.isEmpty()) {
            //symTable.verificarInstruccionLocal(instruccionesLocal, this);
            for(Instruccion instruc : instruccionesLocal){
                   if (instruc!=null) {
                       System.out.println(">>NUEVA INSTRUCCION SUB_PROGRAMA: "+processName.getLexeme());
                       instruc.evaluar();
                }
            }
        }
    
    }


    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    
    public Token getProcessName() {
        return processName;
    }

    public void setProcessName(Token processName) {
        this.processName = processName;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }

    public List<Instruccion> getDeclaracionesLocal() {
        return declaracionesLocal;
    }

    public void setDeclaracionesLocal(List<Instruccion> declaracionesLocal) {
        this.declaracionesLocal = declaracionesLocal;
    }

    public List<Instruccion> getInstruccionesLocal() {
        return instruccionesLocal;
    }

    public void setInstruccionesLocal(List<Instruccion> instruccionesLocal) {
        this.instruccionesLocal = instruccionesLocal;
    }

    public TablaSimbolos getSymTable() {
        return symTable;
    }

    public void setSymTable(TablaSimbolos symTable) {
        this.symTable = symTable;
    }

//    public List<Instruccion> getListaConsultaSubs() {
//        return listaConsultaSubs;
//    }
//
//    public void setListaConsultaSubs(List<Instruccion> listaConsultaSubs) {
//        this.listaConsultaSubs = listaConsultaSubs;
//    }
//    

    public List<Cuarteto> getListaCuartetosCall() {
        return listaCuartetosCall;
    }

    public void setListaCuartetosCall(List<Cuarteto> listaCuartetosCall) {
        this.listaCuartetosCall = listaCuartetosCall;
    }

    public boolean isVarsCambiadas() {
        return varsCambiadas;
    }

    public void setVarsCambiadas(boolean varsCambiadas) {
        this.varsCambiadas = varsCambiadas;
    }

    public boolean isVarsDeclaradas() {
        return varsDeclaradas;
    }

    public void setVarsDeclaradas(boolean varsDeclaradas) {
        this.varsDeclaradas = varsDeclaradas;
    }
    

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }
    
    public void generarCuartetoCall(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.listaCuartetosCall.add(new Cuarteto(op, result, arg1, arg2));
    }
    
    
}
