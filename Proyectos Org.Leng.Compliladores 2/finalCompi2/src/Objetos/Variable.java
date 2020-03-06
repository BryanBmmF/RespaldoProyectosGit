package Objetos;

public class Variable {

    private String tipo;
    private String nombre;
    private String valor;
    public Variable(String tipo,String nombre,String valor){
        this.tipo=tipo;
        this.nombre=nombre;
        this.valor=valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }
    public int getValorI() {
        if(valor.contains("f")){
            return (int)Float.parseFloat(valor);
        }else{
            return Integer.parseInt(valor);
        }
        
    }
    public float getValorF(){
        if(valor.contains("f")){
            return Float.parseFloat(valor);
        }else{
            return Float.parseFloat(valor.concat("f")); 
        }
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
