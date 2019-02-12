/*
 * Clase Usuario
 */
package sistemacasos.backend.user;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author bryan
 */
public class Usuario {
        //Atributos
        private String user;
        private String pass;
        private String cui;
        private String nombre;
        private String tipo;

        public Usuario(String user, String pass, String cui, String nombre, String tipo) {
                this.user = user;
                this.pass = pass;
                this.cui = cui;
                this.nombre = nombre;
                this.tipo = tipo;
        }

         //agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
        private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

        public String getUser() {
                return user;
        }

        public void setUser(String user) {
                this.user = user;
        }

        public String getPass() {
                return pass;
        }

        public void setPass(String pass) {
                this.pass = pass;
        }

        public String getCui() {
                return cui;
        }

        public void setCui(String cui) {
                this.cui = cui;
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
