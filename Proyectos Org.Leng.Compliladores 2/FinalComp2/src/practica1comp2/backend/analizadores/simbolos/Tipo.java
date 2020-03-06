/*
 * Un tipo
 */
package practica1comp2.backend.analizadores.simbolos;

import java.math.BigInteger;
import java.util.List;
import practica1comp2.backend.instrucciones.TipoDim;

/**
 *
 * @author bryan
 */
public class Tipo {
    /* nombre--Tipo--dimensiones--rInicial--rFinal--Categoria--numParam--ListParamTipos--Ambito--jerarquiaTipo--subPadre--Token*/
    
    private String nombre;
    private TipoVar tipo;
    private TipoDim dim; //solo debe almacenar las dimensiones del array de cada dimension
    private BigInteger rInicial;
    private BigInteger rFinal;
    private Categoria categoria;
    private int numParam; //setear despues de reconocer el subPrograma
    private List<Tipo> parametros; //setear despues de rconocer el subprograma
    private int ambito; //se puede setear despues de reconocer la estructura
    private int jerarqui;
    private String subPadre; //se puede setear despues de reconocer la estructura
    private Token token;

    public Tipo(TipoVar tipo, TipoDim dim, BigInteger rInicial, BigInteger rFinal, Categoria categoria, int numParam, List<Tipo> parametros, int ambito, int jerarqui, String subPadre, Token token) {
        this.tipo = tipo;
        this.dim = dim;
        this.rInicial = rInicial;
        this.rFinal = rFinal;
        this.categoria = categoria;
        this.numParam = numParam;
        this.parametros = parametros;
        this.ambito = ambito;
        this.jerarqui = jerarqui;
        this.subPadre = subPadre;
        this.token = token;
    }
   

    public TipoVar getTipo() {
        return tipo;
    }

    public void setTipo(TipoVar tipo) {
        this.tipo = tipo;
    }

    public TipoDim getDim() {
        return dim;
    }

    public void setDim(TipoDim dim) {
        this.dim = dim;
    }

    public BigInteger getrInicial() {
        return rInicial;
    }

    public void setrInicial(BigInteger rInicial) {
        this.rInicial = rInicial;
    }

    public BigInteger getrFinal() {
        return rFinal;
    }

    public void setrFinal(BigInteger rFinal) {
        this.rFinal = rFinal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getNumParam() {
        return numParam;
    }

    public void setNumParam(int numParam) {
        this.numParam = numParam;
    }

    public List<Tipo> getParametros() {
        return parametros;
    }

    public void setParametros(List<Tipo> parametros) {
        this.parametros = parametros;
    }

    public int getAmbito() {
        return ambito;
    }

    public void setAmbito(int ambito) {
        this.ambito = ambito;
    }

    public int getJerarqui() {
        return jerarqui;
    }

    public void setJerarqui(int jerarqui) {
        this.jerarqui = jerarqui;
    }

    public String getSubPadre() {
        return subPadre;
    }

    public void setSubPadre(String subPadre) {
        this.subPadre = subPadre;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    
    
}
