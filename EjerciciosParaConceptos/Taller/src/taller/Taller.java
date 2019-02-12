package taller;

//importanto clases  ctrl+shift+i
import mecanicos.Mecanico;
import vehiculos.Camion;
import vehiculos.Moto;
import vehiculos.Sedan;

/**
 *
 * @author jose
 */
public class Taller {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Object objeto = new Object();
                                                                       
                System.out.println("El salario hora general es: "+Mecanico.SALARIO_HORA);
		
		//inicializacion mecanico pedro
		Mecanico mecanicoPedro = new Mecanico("2547896578548", "Pedro", "Apellido");
		//mecanicoPedro.especificarDatos();
		
		mecanicoPedro.verDatos();
		
		Mecanico mecanicoJuan = new Mecanico("2222222222", "Juan", "Apellido");
		
		
		
		Sedan sedan1 = new Sedan(4, "1200", "A1");
		Sedan sedan2 = new Sedan(4, "1300", "A1");
		
		 
		
		Moto moto1 = new Moto(2, "250", "M");
		
		Camion camion1 = new Camion(8, "3000", "C1");
		
		mecanicoPedro.asignarVehiculo(moto1);
		
		mecanicoJuan.asignarVehiculo(camion1);
		
		
	}
	
}
