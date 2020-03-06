package Objetos;

public class TipoVar {
    private String tipo;
    private String padre;
    
    public TipoVar(String tipo,String padre){
        this.tipo=tipo;
        this.padre=padre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }
    
}
