/*
 * Clase para cancelacion de tarjetas
 */
package practicaformal2;

/**
 *
 * @author bryan
 */
public class Cancelacion {
    
    private String  numeroDeTarjeta;
    
    public Cancelacion(String numeroDeTarjeta){
    
        this.numeroDeTarjeta= numeroDeTarjeta;
         mostrarPar();
    }
     public void mostrarPar(){
         System.out.println("Cancelacion de tarjeta: "+numeroDeTarjeta);
     }
}
