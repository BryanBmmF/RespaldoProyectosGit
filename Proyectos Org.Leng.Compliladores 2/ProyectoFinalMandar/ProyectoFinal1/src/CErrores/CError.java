/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CErrores;

import Objetos.Dato;

/**
 *
 * @author jpmazate
 */
public class CError {
    
    private String tipoError;
    private String tipoErrorSemantico;
    private Dato dato;
    private Integer ambito;
    private String tipo;
    private Integer fila;
    private Integer columna;
    private String mensaje;
    

    public CError(String tipoError, String tipoErrorSemantico, Dato dato, Integer ambito, String tipo, Integer fila, Integer columna, String mensaje) {
        this.tipoError = tipoError;
        this.dato = dato;
        this.ambito = ambito;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.mensaje = mensaje;
        this.tipoErrorSemantico = tipoErrorSemantico;
    }

    public String getTipoError() {
        return tipoError;
    }

    public void setTipoError(String tipoError) {
        this.tipoError = tipoError;
    }

    public Dato getDato() {
        return dato;
    }

    public void setDato(Dato dato) {
        this.dato = dato;
    }

    public Integer getAmbito() {
        return ambito;
    }

    public void setAmbito(Integer ambito) {
        this.ambito = ambito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
 
}