/*
 * 
 */
package proyecto2ipc2.backend.Hotel;

/**
 *
 * @author bryan
 */
public class Habitacion {
        private int numero;
        private String tipo;
        private int Nivel;
        private Double precio;
        private String estado;
        private Double costoMant;
        private int idHotel;
        private int promo;

        public Habitacion(int numero, String tipo, int Nivel, Double precio, String estado, Double costoMant, int idHotel, int promo) {
            this.numero = numero;
            this.tipo = tipo;
            this.Nivel = Nivel;
            this.precio = precio;
            this.estado = estado;
            this.costoMant = costoMant;
            this.idHotel = idHotel;
            this.promo = promo;
        }

        public Habitacion(int numero, String tipo, int Nivel, Double precio, String estado) {
            this.numero = numero;
            this.tipo = tipo;
            this.Nivel = Nivel;
            this.precio = precio;
            this.estado = estado;
        }

        public Habitacion(int numero, String tipo, int Nivel, Double precio, String estado, Double costoMant) {
            this.numero = numero;
            this.tipo = tipo;
            this.Nivel = Nivel;
            this.precio = precio;
            this.estado = estado;
            this.costoMant = costoMant;
        }

        public Habitacion(int numero, String tipo, int Nivel, Double precio, String estado, Double costoMant, int idHotel) {
            this.numero = numero;
            this.tipo = tipo;
            this.Nivel = Nivel;
            this.precio = precio;
            this.estado = estado;
            this.costoMant = costoMant;
            this.idHotel = idHotel;
        }

        public Habitacion(int numero, int idHotel) {
            this.numero = numero;
            this.idHotel = idHotel;
        }

        public Habitacion(int numero, Double precio) {
            this.numero = numero;
            this.precio = precio;
        }

        public Habitacion(int numero, String tipo) {
            this.numero = numero;
            this.tipo = tipo;
        }

        public Habitacion(int numero) {
            this.numero = numero;
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

        public int getNivel() {
            return Nivel;
        }

        public void setNivel(int Nivel) {
            this.Nivel = Nivel;
        }

        public Double getPrecio() {
            return precio;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Double getCostoMant() {
            return costoMant;
        }

        public void setCostoMant(Double costoMant) {
            this.costoMant = costoMant;
        }

        public int getIdHotel() {
            return idHotel;
        }

        public void setIdHotel(int idHotel) {
            this.idHotel = idHotel;
        }

        public int getPromo() {
            return promo;
        }

        public void setPromo(int promo) {
            this.promo = promo;
        }
        
        
    
}
