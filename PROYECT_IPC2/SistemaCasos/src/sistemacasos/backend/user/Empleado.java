/*
 * Clase Empleado
 */
package sistemacasos.backend.user;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author bryan
 */
public class Empleado {
        private String CUI;
        private String nombre;
        private String tipo;
        private int edad;
        private String especialidad;
        private String estado;
        public static final String PROP_CUI = "CUI";
        public static final String ESTADO_ASIGNADO = "Asignado";
        public static final String ESTADO_NO_ASIGNADO = "No_Asignado";

        public Empleado(String CUI, String nombre, String tipo, int edad, String especialidad, String estado) {
                this.CUI = CUI;
                this.nombre = nombre;
                this.tipo = tipo;
                this.edad = edad;
                this.especialidad = especialidad;
                this.estado = estado;
        }
        //agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
        private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

        public Empleado() {

        }

        public String getCUI() {
                return CUI;
        }

        public void setCUI(String CUI) {//Se ha agregado un lanzador de evento cuando se cambia el valor del miembro CUI
                String anterior = this.CUI;
                this.CUI = CUI;
                propertySupport.firePropertyChange(PROP_CUI, anterior, CUI);
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public int getEdad() {
                return edad;
        }

        public void setEdad(int edad) {
                this.edad = edad;
        }

        public String getEspecialidad() {
                return especialidad;
        }

        public void setEspecialidad(String especialidad) {
                this.especialidad = especialidad;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }
    
        @Override//Puede ser cualquier otro metodo que copie los valores de los miembros a un nuevo objeto Empleado
	public Empleado clone() {
		return new Empleado(this.CUI, this.nombre, this.tipo, this.edad, this.especialidad,this.estado);
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
