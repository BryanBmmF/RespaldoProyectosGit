
import animales.Aguila;
import animales.Animal;
import animales.Coral;
import interfaces.Desplazar;
import interfaces.Volar;
import vehiculos.Avion;
import vehiculos.Barco;
import vehiculos.Bicicleta;
import vehiculos.Vehiculo;


/**
 *
 * @author jose
 */
public class run {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Vehiculo[] misVehiculos = new Vehiculo[10];
		Volar[] voladores = new Volar[10];
		Desplazar[] desplazar = new Desplazar[10];
		Animal[] animales = new Animal[2];
		
		Avion avion1 = new Avion();
		Bicicleta bicicleta1 = new Bicicleta();
		Aguila aguila = new Aguila();
		Barco barco1 = new Barco();
				
		misVehiculos[0] = avion1;
		voladores[0] = avion1;
		voladores[1] = aguila;
		
		
		misVehiculos[1] = bicicleta1;
		misVehiculos[2] = barco1;
		
		Object bicicleta2 = new Bicicleta();
		
		Coral coral1 = new Coral();
		animales[0] = coral1;
		animales[1] = aguila;
		
		//((Desplazar) bicicleta2).recorrerDistancia(5);
		//((Vehiculo) bicicleta2).llenarTanque(10);
		
		
		//avion1.recorrerDistancia(3);
		//aguila.recorrerDistancia(3);
		
		Desplazar[] vehiculosDesplazar = asignarDesplazar(misVehiculos);
		recorrer(vehiculosDesplazar, 3);
		Desplazar[] voladoresDesplazar = asignarDesplazar(voladores);
		recorrer(voladoresDesplazar, 3);
		Desplazar[] animalesDesplazar = asignarDesplazar(animales);
		recorrer(animalesDesplazar, 3);
		
		
		
		
		
	}
	
	public static void recorrer(Desplazar[] elementos, int metros) {
		for (Desplazar elemento : elementos) {
			if (elemento != null) {
				elemento.recorrerDistancia(metros);
			}
		}
	}
	
	public static Desplazar[] asignarDesplazar(Object[] elementos) {
		Desplazar[] desplazar = new Desplazar[elementos.length];
		int index = 0;
		for (Object elemento : elementos) {
			if (elemento != null && elemento instanceof Desplazar) {
				desplazar[index] = (Desplazar) elemento;
				index++;
			}
		}
		return desplazar;
	}
	
}
