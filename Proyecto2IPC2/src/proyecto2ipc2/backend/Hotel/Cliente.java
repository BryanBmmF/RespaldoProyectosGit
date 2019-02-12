/*
 * 
 */
package proyecto2ipc2.backend.Hotel;

/**
 *
 * @author bryan
 */
public class Cliente {
        private String nit;
        private String cui;
        private String nombre;
        private String telefono;
        private int promo;

        public Cliente(String nit, String cui, String nombre, String telefono) {
            this.nit = nit;
            this.cui = cui;
            this.nombre = nombre;
            this.telefono = telefono;
        }

        public Cliente(String nit, String cui, String nombre, String telefono, int promo) {
            this.nit = nit;
            this.cui = cui;
            this.nombre = nombre;
            this.telefono = telefono;
            this.promo = promo;
        }

        public Cliente(String nit) {
            this.nit = nit;
        }

        public Cliente(String nit, String nombre) {
            this.nit = nit;
            this.nombre = nombre;
        }
        
        public Cliente() {
        }

        public String getNit() {
            return nit;
        }

        public void setNit(String nit) {
            this.nit = nit;
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

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public int getPromo() {
            return promo;
        }

        public void setPromo(int promo) {
            this.promo = promo;
        }
        
        
}
