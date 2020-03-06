package practica1comp2.backend.analizadores.simbolos;

import practica1comp2.backend.analizadores.simbolos.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import practica1comp2.backend.expresiones.ComprobadorTipos;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.instrucciones.TipoDim;

/**
 *
 * @author jose
 */
public class TablaSimbolos {

    private Map<String, Object> symTable; //Object referencia a la tabla de tipos O mejor solo un obejeto Tipo
    private Map<String, Tipo> symTip;//para almacenra los tipos de las variables
    private List<String> errorsList;
    private List<String> listTemp;
    private ComprobadorTipos comprob;
    
    

    public TablaSimbolos(List<String> errorsList) {
        
        this.errorsList = errorsList;
        //this.listTemp = new ArrayList();
        this.symTable = new HashMap<>();
        this.symTip = new HashMap<>();
        this.comprob = new ComprobadorTipos(this.errorsList);
        this.iniciarTiposBases();
    }
    public TablaSimbolos() {
        symTable = new HashMap<>();
            this.symTip = new HashMap<>();
        this.listTemp = new ArrayList();
    }

//    public boolean exists(Token id, ProcedureTable procedureTable ,boolean isAnalyzingFile) {
//        Object value = this.symTable.get(id.getLexeme());
//        if (value == null) {
//            if (isAnalyzingFile) {
//                errorsList.add(String.format("**La Variable '%s' no se ha declarado en el archivo que estoy leyendo, linea %d columna %d. Por tanto no existe.", id.getLexeme(), id.getLine(), id.getColumn()));
//            } else {
//                errorsList.add(String.format("**La Variable '%s' no se ha declarado en el area de instrucciones, linea %d columna %d. Por tanto no existe.", id.getLexeme(), id.getLine(), id.getColumn()));
//            }
//            return false;
//        }
//        return procedureTable.existName(id);
//    }
    //*******
    
    //verificar variables que se intentan declarar
    public boolean addVariables(List<Id> vars, Tipo tipo){
        boolean retorno = true;
        for(Id id: vars){
            if (this.symTip.containsKey(id.getId().getLexeme())) {
                errorsList.add(String.format("La variable '%s' que intenta declarar , linea %d columna %d ya fue declarada anteriormente.", id.getId().getLexeme(), id.getId().getLine(), id.getId().getColumn()));
                retorno = false;
            } else {
                symTip.put(id.getId().getLexeme(), new Tipo(tipo.getTipo(), tipo.getJerarqui(), id.getId()));
            }
        }
        return retorno;
    }
    public boolean verificarTipoAsig(Token id, Expresion ex){
        if (getTipo(id).getTipo()==ex.getTipo().getTipo()) {
            //si son tipos iguales
            return true;
        }
        errorsList.add(String.format("A La variable '%s' , linea %d columna %d no se le puede asignar un valor Tipo %s.",
                id.getLexeme(), id.getLine(), id.getColumn(),ex.getTipo().getTipo().toString()));
        return false;
    }
    
    //consultar la existencia de una variable **EVALUAR EL TIPO DE UNA VEZ
    public boolean consultarVar(Token id, Expresion ex){
        if (this.symTip.containsKey(id.getLexeme())) {
            //symTip.put(id.getLexeme(), tipo); //actualiza su tipo
            return true;
        } 
        errorsList.add(String.format("La variable '%s' que intenta asignar , linea %d columna %d no ha sido declarada.", id.getLexeme(), id.getLine(), id.getColumn()));
        return false;
    
    }
    //agregr una variable
    public boolean addSimbolo(Token id, Tipo tipo){
        if (this.symTip.containsKey(id.getLexeme())) {
            errorsList.add(String.format("La variable '%s' que intenta declarar , linea %d columna %d ya fue declarada anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            return false;
        } 
        symTip.put(id.getLexeme(), tipo);
        return true;
    
    }
    
    public Tipo getTipo(Token id) {
        if ((Tipo)this.symTip.get(id.getLexeme())==null) {
            System.out.println(" El Tipo Es: "+id.getLexeme());
            System.out.println("NO SE ENCONTRO EL TIPO");
        } else {
             System.out.println("SE ENCONTRO EL TIPO");
        }
        return (Tipo)this.symTip.get(id.getLexeme());
    }
    
    public boolean asignarArray(Id id, Expresion exp){
        //comprobar existencia y tipos de arreglos
        if (exp.isIsPosArray()) {
            return consultarVar(id.getId(), null) && consultarVar(exp.getIdArray().getId(), null) ;
        }
        return consultarVar(id.getId(), null);
    }
    
    public void iniciarTiposBases(){
        //INICIALIZAR LOS PRIMEROS TIPOS
        this.addSimbolo(new Token("int",0,0), new Tipo(TipoVar.INT, Integer.MIN_VALUE, Integer.SIZE,3,null));
        this.addSimbolo(new Token("long",0,0), new Tipo(TipoVar.LONG, Integer.MIN_VALUE, Integer.SIZE,null));
        this.addSimbolo(new Token("double",0,0), new Tipo(TipoVar.DOUBLE, Integer.MIN_VALUE, Integer.SIZE,6,null));
        this.addSimbolo(new Token("float",0,0), new Tipo(TipoVar.FLOAT, Integer.MIN_VALUE, Integer.SIZE,5,null));
        this.addSimbolo(new Token("byte",0,0), new Tipo(TipoVar.BYTE, Integer.MIN_VALUE, Integer.SIZE,2,null));
        this.addSimbolo(new Token("char",0,0), new Tipo(TipoVar.CHAR, Integer.MIN_VALUE, Integer.SIZE,2,null));
        this.addSimbolo(new Token("boolean",0,0), new Tipo(TipoVar.BOOLEAN, Integer.MIN_VALUE, Integer.SIZE,1,null));
        this.addSimbolo(new Token("string",0,0), new Tipo(TipoVar.STRING, Integer.MIN_VALUE, Integer.SIZE,7,null));
    
        
    }
    
    //******
    public Object getIdValue(Token id) {
        return this.symTable.get(id.getLexeme());
    }

    public boolean addId(Token id, int value, boolean isAnalyzingFile) {
        if (this.symTable.containsKey(id.getLexeme())) {
            if (isAnalyzingFile) {
                errorsList.add(String.format("La variable '%s' que intenta declar en el archivo que estoy leyendo, linea %d columna %d ya fue declarada anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            } else {
                errorsList.add(String.format("La variable '%s' que intenta declar ya fue declarada anteriormente en el area de instrucciones.", id.getLexeme()));
            }
            return false;
        }
        symTable.put(id.getLexeme(), value);
        return true;
    }
    
    public TablaSimbolos createSymTable(List<Token> parameters,boolean isAnalyzingFile){
        TablaSimbolos sym = new TablaSimbolos(this.errorsList);
        for (Token parameter : parameters) {
            sym.addId(parameter, 0, isAnalyzingFile);      
        }
        
        return sym;
    }
    
    public void addSymTable(Token id, TablaSimbolos sym) {
        this.symTable.put(id.getLexeme(), sym);
    }
    
    public boolean verifyParameter(Token id) {
        if (!this.symTable.containsKey(id.getLexeme())) {
            return false;
        }
        return true;
    }

    public void assignValueToId(Token id, int value) {
        this.symTable.put(id.getLexeme(), value);
    }
    public void removeParameter(Token id) {
        this.symTable.remove(id.getLexeme());
    }
    
    public void cleanAll() {
        this.symTip.clear();
        this.errorsList.clear();
    }
    
    public void addTemporal(String var){
        this.listTemp.add(var);
    }
    public boolean verifyTemporalVar(String var){
        if (this.listTemp.contains(var)) {
            return true;
        }
        return false;
    }
    public void clearTemporal(){
        this.listTemp.clear();
    }
    
    public Map<String, Object> getSymTable() {
        return symTable;
    }

    public void setSymTable(Map<String, Object> symTable) {
        this.symTable = symTable;
    }

    public List<String> getErrorsList() {
        return errorsList;
    }

    public void setErrorsList(List<String> errorsList) {
        this.errorsList = errorsList;
    }

    public Map<String, Tipo> getSymTip() {
        return symTip;
    }

    public void setSymTip(Map<String, Tipo> symTip) {
        this.symTip = symTip;
    }

    public ComprobadorTipos getComprob() {
        return comprob;
    }

    public void setComprob(ComprobadorTipos comprob) {
        this.comprob = comprob;
    }
    
    
}
