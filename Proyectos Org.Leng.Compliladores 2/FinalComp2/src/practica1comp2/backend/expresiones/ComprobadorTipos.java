/*
 * Comprobador de tipos
 */
package practica1comp2.backend.expresiones;

import java.util.List;
import java.util.Map;
import practica1comp2.backend.analizadores.simbolos.Categoria;
import practica1comp2.backend.analizadores.simbolos.Simbolo;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.analizadores.simbolos.Token;

/**
 *
 * @author bryan
 */
public class ComprobadorTipos {
    private List<String> errorsList;
    private List<Simbolo> symTip;
    
    public ComprobadorTipos(List<String> errorsList, List<Simbolo> symTip) {
        this.errorsList = errorsList;
        this.symTip = symTip;
    }
    
    public boolean isFloat(String decim){
        if (decim.charAt(decim.length()-1)=='f') {
            return true;            
        }
        return false;
    }
    
    public Tipo tipoEntero(Token id){
        //parsear segun rango del numero
        TipoVar tipo = null;
        try {
             
            Long ent = Long.parseLong(id.getLexeme());
            /*si esta en el rango char byte*/
            if (ent >=-128 && ent <=127) {
                return new Tipo(TipoVar.BYTE,null,null,null,Categoria.VAR,0,null,0,2,null,id);
            /*si esta en el rango int*/
            } else if (ent >=-2147483648 && ent <=2147483647) {
                return new Tipo(TipoVar.INT,null,null,null,Categoria.VAR,0,null,0,3,null,id);
            }
        } catch(NumberFormatException e) {
            errorsList.add(String.format("El entero '%s' en, linea: %d columna: %d no es Valido.", id.getLexeme(), id.getLine(), id.getColumn()));
            /*si esta en el rango indefinido*/
            return new Tipo(TipoVar.INDEF,null,null,null,Categoria.BASE,0,null,0,0,null,id);
        }
        /*si esta en el rango char long*/
        return new Tipo(TipoVar.LONG,null,null,null,Categoria.VAR,0,null,0,4,null,id); //el de mayor jerarquia
        
    }
    
    public Tipo tipoDecimal(Token id){
        //parsear segun rango del numero
        TipoVar tipo = null;
        try {
            Double dec = Double.parseDouble(id.getLexeme());
        } catch(NumberFormatException e) {
            errorsList.add(String.format("El Decimal '%s' en, linea: %d columna: %d no es Valido.", id.getLexeme(), id.getLine(), id.getColumn()));
            return new Tipo(TipoVar.INDEF,null,null,null,Categoria.BASE,0,null,0,0,null,id);
        }
        
        if (id.getLexeme().charAt(id.getLexeme().length()-1)=='f') {
            return new Tipo(TipoVar.FLOAT,null,null,null,Categoria.VAR,0,null,0,5,null,id);
        }
       
        return new Tipo(TipoVar.DOUBLE,null,null,null,Categoria.VAR,0,null,0,6,null,id); //el de mayor jerarquia
        
    }
    
    public Tipo evalOpAritmetica(Expresion ex1, Expresion ex2){
        int tipoEx1 = ex1.getTipo().getJerarqui();
        int tipoEx2 = ex2.getTipo().getJerarqui();
        
        if ((tipoEx1>=2 && tipoEx1<=6) && (tipoEx2>=2 && tipoEx2<=6) ) {
            //los tipos se pueden evaluar pero el resultado sera el de mayor jerarquia
            if (tipoEx1>=tipoEx2) {
                return new Tipo(ex1.getTipo().getTipo(),null,null,null,Categoria.VAR_TEMPOTAL,0,null,0,tipoEx1,null,new Token(null, 0, 0));
            } else {
                return new Tipo(ex2.getTipo().getTipo(),null,null,null,Categoria.VAR_TEMPOTAL,0,null,0,tipoEx2,null,new Token(null, 0, 0));
            }
            
        } else {
            if (ex1.getLugarTemp().charAt(0)=='t' || ex2.getLugarTemp().charAt(0)=='t') {
                //para no tirar los errores de los temporales tambien
                //errorsList.add(String.format("No se puede operar el Tipo del Temporal que generara  '%s' con '%s'",
                //        ex1.getLugarTemp(),ex2.getLugarTemp()));
            } else {
                if (ex1.getTipo().getToken()!=null && ex2.getTipo().getToken()!=null) {
                    errorsList.add(String.format("Los Tipos de '%s' en, linea: %d columna: %d"
                    + " y %s en, linea: %d columna: %d no pueden evaluarse porque no son compatibles.", ex1.getTipo().getToken().getLexeme(),
                    ex1.getTipo().getToken().getLine(), ex1.getTipo().getToken().getColumn(),ex2.getTipo().getToken().getLexeme(),
                    ex2.getTipo().getToken().getLine(),ex2.getTipo().getToken().getColumn()));
                }
                
            }
            
                return new Tipo(ex1.getTipo().getTipo().INDEF,null,null,null,Categoria.BASE,0,null,0,tipoEx1,null,new Token(null, 0, 0));
        }
      
    }
    
    public Tipo evalOpMasConcat(Expresion ex1, Expresion ex2){
        int tipoEx1 = ex1.getTipo().getJerarqui();
        int tipoEx2 = ex2.getTipo().getJerarqui();
        TipoVar tipo = null;
        
        //si alguno de los tipos es String se retornara string  que es jerarquia 7
        if (tipoEx1==7 || tipoEx2==7) {
            System.out.println("Otro String");
            return new Tipo(TipoVar.STRING,null,null,null,Categoria.VAR_TEMPOTAL,0,null,0,7,null,new Token(null, 0, 0));
        } else {
            return evalOpAritmetica(ex1, ex2);
        }
        
    }
    
    public List<String> getErrorsList() {
        return errorsList;
    }

    public void setErrorsList(List<String> errorsList) {
        this.errorsList = errorsList;
    }
    
    
    
}
