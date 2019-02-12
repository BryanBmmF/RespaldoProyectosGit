/*
 * Clase Menu
 */
package proyecto2ipc2.backend.Restaurante;


/**
 *
 * @author bryan
 */
public class Menu {
        private int numero;
        private String tipo;
        private String nombre;
        private String descripcion;
        private Double precio;
        private Double costoFabricacion;
        private int idRestaurante;
        private int promo;

        public Menu(int numero, String tipo, String nombre, String descripcion, Double precio, Double costoFabricacion, int idRestaurante, int promo) {
                this.numero = numero;
                this.tipo = tipo;
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.precio = precio;
                this.costoFabricacion = costoFabricacion;
                this.idRestaurante = idRestaurante;
                this.promo = promo;
        }

        public Menu(int numero, int idRestaurante) {
                this.numero = numero;
                this.idRestaurante = idRestaurante;
        }
        
        public Menu(int numero) {
            this.numero = numero;
        }

        public Menu(int numero, String nombre, Double precio) {
            this.numero = numero;
            this.nombre = nombre;
            this.precio = precio;
        }
        
        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Double getPrecio() {
            return precio;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        public Double getCostoFabricacion() {
            return costoFabricacion;
        }

        public void setCostoFabricacion(Double costoFabricacion) {
            this.costoFabricacion = costoFabricacion;
        }

        public int getIdRestaurante() {
            return idRestaurante;
        }

        public void setIdRestaurante(int idRestaurante) {
            this.idRestaurante = idRestaurante;
        }

        public int getPromo() {
            return promo;
        }

        public void setPromo(int promo) {
            this.promo = promo;
        }
 
        
}
