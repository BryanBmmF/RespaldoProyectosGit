/*
 * Clase Proyecto
 */
package sistemacasos.backend.proyects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class Proyecto {
        //Atributos
        private int id;
        private String userAdminProyecto;
        private String nombre;
        private String tipo;
        private LocalDate fechaCreacion;
        private String estado;
        
        public static final String ESTADO_ACTIVO = "Activo";
        public static final String ESTADO_NO_ACTIVO = "Inactivo";

        public Proyecto(int id, String userAdminProyecto, String nombre, String tipo, LocalDate fechaCreacion, String estado) {
                this.id = id;
                this.userAdminProyecto = userAdminProyecto;
                this.nombre = nombre;
                this.tipo = tipo;
                this.fechaCreacion = fechaCreacion;
                this.estado = estado;
        }
        public Proyecto(){
        
        }
        //agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
        private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getUserAdminProyecto() {
                return userAdminProyecto;
        }

        public void setUserAdminProyecto(String userAdminProyecto) {
                this.userAdminProyecto = userAdminProyecto;
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

        public LocalDate getFechaCreacion() {
                return fechaCreacion;
        }

        public void setFechaCreacion(LocalDate fechaCreacion) {
                this.fechaCreacion = fechaCreacion;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }
        @Override//Puede ser cualquier otro metodo que copie los valores de los miembros a un nuevo objeto Empleado
	public Proyecto clone() {
		return new Proyecto(this.id,this.userAdminProyecto,this.nombre,this.tipo,this.fechaCreacion,this.estado);
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

