package empresarial.backend.modelos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Escritorio
 *
 * @author jose - 23.03.2017
 * @Title: Empleado
 * @Description: description
 *
 * Changes History
 */
public class Empleado implements Serializable {

	private String CUI;
	private String nombre;
	private LocalDate fechaNacimiento;
	private double salario;
	private double horasLaborales;

	public static final String PROP_CUI = "CUI";
        public static final String PROP_NOMBRE = "nombre";
        public static final String PROP_FECHA_NAC = "fechaNacimiento";
        public static final String PROP_SALARIO = "salario";
        public static final String PROP_HORAS_LABORALES = "horasLaborales";

	//agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
	private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

	public Empleado() {

	}

	public Empleado(String CUI, String nombre, LocalDate fechaNacimiento, double salario, double horasLaborales) {
		this.CUI = CUI;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
		this.horasLaborales = horasLaborales;
	}

	public String getCUI() {
		return CUI;
	}

	public void setCUI(String CUI) {//Se ha agregado un lanzador de evento cuando se cambia el valor del miembro CUI y los demas
		String anterior = this.CUI;
		this.CUI = CUI;
		propertySupport.firePropertyChange(PROP_CUI, anterior, CUI);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
                String anterior = this.nombre;
		this.nombre = nombre;
                propertySupport.firePropertyChange(PROP_NOMBRE,anterior,nombre);
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
                LocalDate anterior= this.fechaNacimiento;
		this.fechaNacimiento = fechaNacimiento;
                propertySupport.firePropertyChange(PROP_FECHA_NAC,anterior,fechaNacimiento);
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
                double anterior = this.salario;
		this.salario = salario;
                propertySupport.firePropertyChange(PROP_SALARIO,anterior,salario);
	}

	public double getHorasLaborales() {
		return horasLaborales;
	}

	public void setHorasLaborales(double horasLaborales) {
                double anterior = this.horasLaborales;
		this.horasLaborales = horasLaborales;
                propertySupport.firePropertyChange(PROP_HORAS_LABORALES,anterior,horasLaborales);
	}

	@Override//Puede ser cualquier otro metodo que copie los valores de los miembros a un nuevo objeto Empleado
	public Empleado clone() {
		return new Empleado(this.CUI, this.nombre, this.fechaNacimiento, this.salario, this.horasLaborales);
	}

	/**
	 * Metodo especifico para agregar un escucha de cambios
	 *
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}

	/**
	 * Metodo especifico para quitar un escucha de cambios
	 *
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}
}
