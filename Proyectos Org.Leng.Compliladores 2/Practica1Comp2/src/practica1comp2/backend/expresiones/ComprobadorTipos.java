/*
 * Comprobador de tipos
 */
package practica1comp2.backend.expresiones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.analizadores.simbolos.Token;

/**
 *
 * @author bryan
 */
public class ComprobadorTipos {
    private List<String> errorsList;
    
    public ComprobadorTipos(List<String> errorsList) {
        this.errorsList = errorsList;
    }
    
    public boolean isFloat(String decim){
        if (decim.charAt(decim.length()-1)=='f') {
            return true;            
        }
        return false;
    }
    
    public Tipo tipoEntero(Token id){
        //parsear a long
        TipoVar tipo = null;
        try {
             long ent = Long.parseLong(id.getLexeme());
        } catch(NumberFormatException e) {
            errorsList.add(String.format("El entero '%s' en, linea: %d columna: %d no es Valido.", id.getLexeme(), id.getLine(), id.getColumn()));
            return new Tipo(tipo.INDEF, 0,id);
        }
        return new Tipo(tipo.INT, 4,id); //el de mayor jerarquia
        
    }
    
    public Tipo tipoDecimal(Token id){
        //parsear a long
        TipoVar tipo = null;
        try {
             double dec = Double.parseDouble(id.getLexeme());
        } catch(NumberFormatException e) {
            errorsList.add(String.format("El Decimal '%s' en, linea: %d columna: %d no es Valido.", id.getLexeme(), id.getLine(), id.getColumn()));
            return new Tipo(tipo.INDEF, 0,id);
        }
        
        if (id.getLexeme().charAt(id.getLexeme().length()-1)=='f') {
            return new Tipo(tipo.FLOAT, 5,id);
        }
       
        return new Tipo(tipo.DOUBLE, 6,id); //el de mayor jerarquia
        
    }
    
    public Tipo evalOpAritmetica(Expresion ex1, Expresion ex2){
        int tipoEx1 = ex1.getTipo().getJerarqui();
        int tipoEx2 = ex2.getTipo().getJerarqui();
        
        if ((tipoEx1>=2 && tipoEx1<=6) && (tipoEx2>=2 && tipoEx2<=6) ) {
            //los tipos se pueden evaluar pero el resultado sera el de mayor jerarquia
            if (tipoEx1>=tipoEx2) {
                return new Tipo(ex1.getTipo().getTipo(), tipoEx1, new Token(null, 0, 0));
            } else {
                return new Tipo(ex2.getTipo().getTipo(), tipoEx2, new Token(null, 0, 0));
            }
            
        } else {
            if (ex1.getLugarTemp().charAt(0)=='t' || ex2.getLugarTemp().charAt(0)=='t') {
                //para no tirar los errores de los temporales tambien
                errorsList.add(String.format("No se puede operar el Tipo del Temporal que generara  '%s' con '%s'",
                        ex1.getLugarTemp(),ex2.getLugarTemp()));
            } else {
                errorsList.add(String.format("Los Tipos de '%s' en, linea: %d columna: %d"
                    + " y %s en, linea: %d columna: %d no pueden evaluarse porque no son compatibles.", ex1.getTipo().getToken().getLexeme(),
                    ex1.getTipo().getToken().getLine(), ex1.getTipo().getToken().getColumn(),ex2.getTipo().getToken().getLexeme(),
                    ex2.getTipo().getToken().getLine(),ex2.getTipo().getToken().getColumn()));
            }
            
                return new Tipo(ex1.getTipo().getTipo().INDEF, 0, new Token(null, 0, 0));
        }
      
    }
    
    public Tipo evalOpMasConcat(Expresion ex1, Expresion ex2){
        int tipoEx1 = ex1.getTipo().getJerarqui();
        int tipoEx2 = ex2.getTipo().getJerarqui();
        TipoVar tipo = null;
        
        //si alguno de los tipos es String se retornara string  que es jerarquia 7
        if (tipoEx1==7 || tipoEx2==7) {
            System.out.println("Otro String");
            return new Tipo(tipo.STRING, 7, new Token(null, 0, 0));
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
