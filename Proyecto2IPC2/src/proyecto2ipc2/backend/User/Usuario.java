/*
 * Clase Usuario
 */
package proyecto2ipc2.backend.User;


/**
 *
 * @author bryan
 */
public class Usuario {
        //Atributos
        private String user;
        private String pass;
        private String nombre;
        private String cui;
        private String tipo;
        private String estado;
        private Double slario;

        public Usuario(String user, String pass, String nombre, String cui, String tipo, String estado, Double salario) {
                this.user = user;
                this.pass = pass;
                this.nombre = nombre;
                this.cui = cui;
                this.tipo = tipo;
                this.estado = estado;
                this.slario= salario;
        }

        public Usuario(String user, String nombre, String cui, String tipo, Double slario) {
            this.user = user;
            this.nombre = nombre;
            this.cui = cui;
            this.tipo = tipo;
            this.slario = slario;
        }
        
        public Usuario(String user) {
            this.user = user;
        }

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

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCui() {
            return cui;
        }

        public void setCui(String cui) {
            this.cui = cui;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Double getSlario() {
            return slario;
        }

        public void setSlario(Double slario) {
            this.slario = slario;
        }
        
        
}
