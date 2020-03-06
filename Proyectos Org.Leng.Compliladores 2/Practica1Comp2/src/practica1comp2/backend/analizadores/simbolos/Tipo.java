/*
 * Un tipo
 */
package practica1comp2.backend.analizadores.simbolos;

import practica1comp2.backend.instrucciones.TipoDim;

/**
 *
 * @author bryan
 */
public class Tipo {
    private TipoVar tipo;
    private int inicio;
    private int fin;
    private TipoDim dim; //solo debe almacenar las dimensiones del array
    private Integer rInicial;
    private Integer rFinal;
    private boolean isArray;
    private int jerarqui ;
    private Token token;

    public Tipo(TipoVar tipo, int inicio, int fin, TipoDim dim) {
        this.tipo = tipo;
        this.inicio = inicio;
        this.fin = fin;
        this.dim = dim;
        this.isArray = false;
    }

    public Tipo(TipoVar tipo, Integer rInicial, Integer rFinal, int jerarqui, Token token) {
        this.tipo = tipo;
        this.rInicial = rInicial;
        this.rFinal = rFinal;
        this.jerarqui = jerarqui;
        this.token = token;
        this.isArray = false;
    }

    public Tipo(TipoVar tipo, int jerarqui, Token token) {
        this.tipo = tipo;
        this.jerarqui = jerarqui;
        this.token = token;
        this.isArray = false;
    }

    public TipoVar getTipo() {
        return tipo;
    }

    public void setTipo(TipoVar tipo) {
        this.tipo = tipo;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public TipoDim getDim() {
        return dim;
    }

    public void setDim(TipoDim dim) {
        this.dim = dim;
    }

    public Integer getrInicial() {
        return rInicial;
    }

    public void setrInicial(Integer rInicial) {
        this.rInicial = rInicial;
    }

    public Integer getrFinal() {
        return rFinal;
    }

    public void setrFinal(Integer rFinal) {
        this.rFinal = rFinal;
    }

    public boolean isIsArray() {
        return isArray;
    }

    public void setIsArray(boolean isArray) {
        this.isArray = isArray;
    }

    public int getJerarqui() {
        return jerarqui;
    }

    public void setJerarqui(int jerarqui) {
        this.jerarqui = jerarqui;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
    
    
    
}
