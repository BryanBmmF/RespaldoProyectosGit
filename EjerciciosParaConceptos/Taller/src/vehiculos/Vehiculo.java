package vehiculos;

//final a nivel de clase 
//me dice que no puedo heredar de esta clase
      //-->
public class Vehiculo {
	int cantidadLlantas;
	String tipoMotor;
	String tipoAceite;
        
	//constructor del padre vheiculo
	public Vehiculo(int cantidadLlantas, String tipoMotor, String tipoAceite) {
		this.cantidadLlantas = cantidadLlantas;
		this.tipoMotor = tipoMotor;
		this.tipoAceite = tipoAceite;
	}
        
        //final a nivel de metodo
	//final para evitar que se sobrecargue en una clase jija
	public final void cambioAceite() {
		System.out.println("Ya se cambio aceite");
	}
	
	public void cambioLlantas() {
		System.out.println("Ya se cambio llantas");
	}
	
	public int verCantidadLlantas() {
		return this.cantidadLlantas;
	}
	
	
}
