/*
 * clase Caso 
 */
package sistemacasos.backend.cases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class Caso {
        //Atributos
        private String tipo;
        private int numeroEtapas;
        private LocalDate fechaCreacion;

        public Caso(String tipo, int numeroEtapas, LocalDate fechaCreacion) {
                this.tipo = tipo;
                this.numeroEtapas = numeroEtapas;
                this.fechaCreacion = fechaCreacion;
        }
        public Caso(){
        
        }
        
        //agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
        private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public int getNumeroEtapas() {
                return numeroEtapas;
        }

        public void setNumeroEtapas(int numeroEtapas) {
                this.numeroEtapas = numeroEtapas;
        }

        public LocalDate getFechaCreacion() {
                return fechaCreacion;
        }

        public void setFechaCreacion(LocalDate fechaCreacion) {
                this.fechaCreacion = fechaCreacion;
        }
    
          @Override//Puede ser cualquier otro metodo que copie los valores de los miembros a un nuevo objeto Empleado
	public Caso clone() {
		return new Caso(this.tipo,this.numeroEtapas,this.fechaCreacion);
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
