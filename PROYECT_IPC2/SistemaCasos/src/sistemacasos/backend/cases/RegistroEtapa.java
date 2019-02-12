/*
 * Clase registro de etapa
 */
package sistemacasos.backend.cases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class RegistroEtapa {
        private int idProyecto;
        private String tipoCaso;
        private String nombreCaso;
        private String userDesarrollador;
        private int numeroEtapa;
        private String nombreEtapa;
        private LocalDate fechaRegistro;
        private int horasInvertidas;
        private int costoHora;
        private int dineroInvertido;
        private String estado;
        private String aprobacion;
        private String comentario;

        public RegistroEtapa(int idProyecto, String tipoCaso, String nombreCaso, String userDesarrollador, int numeroEtapa, String nombreEtapa, LocalDate fechaRegistro, int horasInvertidas, int costoHora, int dineroInvertido, String estado, String aprobacion, String comentario) {
                this.idProyecto = idProyecto;
                this.tipoCaso = tipoCaso;
                this.nombreCaso = nombreCaso;
                this.userDesarrollador = userDesarrollador;
                this.numeroEtapa = numeroEtapa;
                this.nombreEtapa = nombreEtapa;
                this.fechaRegistro = fechaRegistro;
                this.horasInvertidas = horasInvertidas;
                this.costoHora = costoHora;
                this.dineroInvertido = dineroInvertido;
                this.estado = estado;
                this.aprobacion = aprobacion;
                this.comentario = comentario;
        }
        
        //agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
        private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

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

        public String getNombreCaso() {
            return nombreCaso;
        }

        public void setNombreCaso(String nombreCaso) {
            this.nombreCaso = nombreCaso;
        }

        public String getUserDesarrollador() {
            return userDesarrollador;
        }

        public void setUserDesarrollador(String userDesarrollador) {
            this.userDesarrollador = userDesarrollador;
        }

        public int getNumeroEtapa() {
            return numeroEtapa;
        }

        public void setNumeroEtapa(int numeroEtapa) {
            this.numeroEtapa = numeroEtapa;
        }

        public String getNombreEtapa() {
            return nombreEtapa;
        }

        public void setNombreEtapa(String nombreEtapa) {
            this.nombreEtapa = nombreEtapa;
        }

        public LocalDate getFechaRegistro() {
            return fechaRegistro;
        }

        public void setFechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

        public int getHorasInvertidas() {
            return horasInvertidas;
        }

        public void setHorasInvertidas(int horasInvertidas) {
            this.horasInvertidas = horasInvertidas;
        }

        public int getCostoHora() {
            return costoHora;
        }

        public void setCostoHora(int costoHora) {
            this.costoHora = costoHora;
        }

        public int getDineroInvertido() {
            return dineroInvertido;
        }

        public void setDineroInvertido(int dineroInvertido) {
            this.dineroInvertido = dineroInvertido;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getAprobacion() {
            return aprobacion;
        }

        public void setAprobacion(String aprobacion) {
            this.aprobacion = aprobacion;
        }

        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }

        public PropertyChangeSupport getPropertySupport() {
            return propertySupport;
        }

        public void setPropertySupport(PropertyChangeSupport propertySupport) {
            this.propertySupport = propertySupport;
        }

         @Override//Puede ser cualquier otro metodo que copie los valores de los miembros a un nuevo objeto Empleado
	public RegistroEtapa clone() {
		return new RegistroEtapa(this.idProyecto,
                this.tipoCaso,
                this.nombreCaso,
                this.userDesarrollador,
                this.numeroEtapa,
                this.nombreEtapa,
                this.fechaRegistro,
                this.horasInvertidas,
                this.costoHora,
                this.dineroInvertido,
                this.estado,
                this.aprobacion,
                this.comentario);
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
