package empresarial.backend.recursoshumanos;

import empresarial.backend.modelos.Empleado;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Escritorio
 *
 * @author jose - 23.03.2017
 * @Title: ManejadorRH
 * @Description: description
 *
 * Changes History
 */
public class ManejadorRH {
	
	List<Empleado> empleados = new ArrayList<>();

	public ManejadorRH() {
		empleados.add(new Empleado("1111", "empleado 1", LocalDate.parse("2001-05-06"), 2700, 4));
		empleados.add(new Empleado("2222", "empleado 2", LocalDate.parse("1990-05-06"), 12700, 8));
		empleados.add(new Empleado("3333", "empleado 3", LocalDate.parse("1987-05-06"), 7000, 8));
		empleados.add(new Empleado("4444", "empleado 4", LocalDate.parse("2005-05-06"), 3700, 4));
		empleados.add(new Empleado("5555", "empleado 5", LocalDate.parse("1960-05-06"), 1700, 4));
		
	}
	

	public List<Empleado> consultarEmpleados() {
		return empleados;
	}
	
	public Empleado agregarEmpleado(String CUI, String nombre, 
		String fechaNacimiento, String salario, String horasLaborales)
		throws DateTimeParseException, NumberFormatException {//se lanza el error de conversion de fecha si lo hay o converios del salario
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");// se establece el formato de fecha
		LocalDate fecha = LocalDate.parse(fechaNacimiento, formato);// se parsea la fecha recibida
		Empleado nuevo = new Empleado(CUI, nombre, fecha, Double.parseDouble(salario), Double.parseDouble(horasLaborales));
		empleados.add(nuevo);
		return nuevo;
		
	}
	//este metodo retorna la referencia a un empleado el cual existe en una lista, se requiere un cui u otro valor para poder buscarlo
	public Empleado buscarEmpeladoPorCUI(String CUI) {
		for (Empleado empleado : empleados) {
			if (empleado.getCUI().equalsIgnoreCase(CUI)) {// se compara el cui y si existe se devuelve el objeto empleado
				return empleado;
			}
		}
		return null;
	}
	
	public void actualizarEmpleado(String CUI, Empleado empleado) {
		Empleado aCambiar = buscarEmpeladoPorCUI(CUI); // se busca el empleado al cual se le cambiaran los valores y se devuelve para almacenarlo en este nuevo
		aCambiar.setCUI(empleado.getCUI()); // se establecen los nuevos miembros
                aCambiar.setNombre(empleado.getNombre());
                aCambiar.setFechaNacimiento(empleado.getFechaNacimiento());
                aCambiar.setSalario(empleado.getSalario());
                aCambiar.setHorasLaborales(empleado.getHorasLaborales());
		//todos los demas campos
	}
}
