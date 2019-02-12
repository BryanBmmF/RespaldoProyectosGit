/*
 * Clase Registro de Casos
 */
package sistemacasos.backend.cases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class RegistroCaso {
        private String nombre;
        private int idProyecto;
        private String tipoCaso;
        private String estado;
        private int porcentaje;
        private LocalDate fechaCreacion;
        private LocalDate fechaLimite;

        public RegistroCaso(String nombre, int idProyecto, String tipoCaso, String estado, int porcentaje, LocalDate fechaCreacion, LocalDate fechaLimite) {
                this.nombre = nombre;
                this.idProyecto = idProyecto;
                this.tipoCaso = tipoCaso;
                this.estado = estado;
                this.porcentaje = porcentaje;
                this.fechaCreacion = fechaCreacion;
                this.fechaLimite = fechaLimite;
        }
        public RegistroCaso(){
        
        }
        //agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
        private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
        
        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public int getIdProyecto() {
                return idProyecto;
        }

        public void setIdProyecto(int idProyecto) {
                this.idProyecto = idProyecto;
        }

        public String getTipoCaso() {
                return tipoCaso;
        }

        public void setTipoCaso(String tipoCaso) {
                this.tipoCaso = tipoCaso;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public int getPorcentaje() {
                return porcentaje;
        }

        public void setPorcentaje(int porcentaje) {
                this.porcentaje = porcentaje;
        }

        public LocalDate getFechaCreacion() {
                return fechaCreacion;
        }

        public void setFechaCreacion(LocalDate fechaCreacion) {
                this.fechaCreacion = fechaCreacion;
        }

        public LocalDate getFechaLimite() {
                return fechaLimite;
        }

        public void setFechaLimite(LocalDate fechaLimite) {
                this.fechaLimite = fechaLimite;
        }
        
         @Override//Puede ser cualquier otro metodo que copie los valores de los miembros a un nuevo objeto Empleado
	public RegistroCaso clone() {
		return new RegistroCaso(this.nombre, this.idProyecto, this.tipoCaso, this.estado, this.porcentaje,this.fechaCreacion,this.fechaLimite);
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
