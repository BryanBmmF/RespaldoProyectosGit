package mecanicos;

import vehiculos.Moto;
import vehiculos.Vehiculo;

/**
 * Taller
 * @author jose - 21.02.2018 
 * @Title: Mecanico
 * @Description: description
 *
 * Changes History
 */
public class Mecanico {
    
        //constantes en clases
    //static y final en miembros
    
    //static porque esta enlazado a la clase. me dice que puedo enlazar el miembro salario, para que forme parte de la clase y no dell objeto
    //public para ser visible en todo el paquete 
    //final para que no se pueda cambiar el valor que se le asigno en la clase 
        public static final int SALARIO_HORA=50;
        
	private String CUI;
	private String nombre;
	private Vehiculo asignado;
	private String apellido;
	
	public Mecanico(String nuevoCUI, String nuevoNombre,
		   String nuevoApellido) {
		this.CUI = nuevoCUI;
		this.nombre = nuevoNombre;
		this.apellido = nuevoApellido;
		//this.verDatos();
	}
	
	public Mecanico(String CUI) {
		this.CUI = CUI;
	}
	
	public void especificarDatos(String nuevoCUI, String nuevoNombre,
		   String nuevoApellido) {
		this.CUI = nuevoCUI;
		this.nombre = nuevoNombre;
		this.apellido = nuevoApellido;
	}
	
	public void asignarVehiculo(Vehiculo vehiculo) {
		this.asignado = vehiculo;
		System.out.println("vehiculo asignado con el numero de llantas: "
			   + asignado.verCantidadLlantas());
                
                //casteo casting
                //instandof  para especificar algo 
                
                //devolver instancias
                //cambiar mascaras
                
               if(vehiculo instanceof Moto){
                   System.out.println("Se asigno una moto");
                   
                   
                   
               }
	}
	
	public void cambiarNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}
	
	public void verDatos() {
		System.out.println("CUI: " + CUI);
		System.out.println("nombre: " + nombre);
		System.out.println("apellido: " + apellido);
	}

}