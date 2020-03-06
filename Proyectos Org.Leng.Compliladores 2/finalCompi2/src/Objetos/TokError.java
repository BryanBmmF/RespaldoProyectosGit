package Objetos;

public class TokError {
    private String token;
    private String tipo;
    private int fila;
    private int columna;

    public TokError(String token, String tipo, int fila, int columna) {
        this.token = token;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
}
