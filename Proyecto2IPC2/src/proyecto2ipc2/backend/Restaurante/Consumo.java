/*
 * 
 */
package proyecto2ipc2.backend.Restaurante;

import java.io.Serializable;
import java.time.LocalDate;
import proyecto2ipc2.backend.Hotel.Cliente;

/**
 *
 * @author bryan
 */
public class Consumo {
        private int idConsumo;
        private int numeroPorciones;
        private Menu menu;
        private Cliente cliente;
        private LocalDate fecha;
        private Restaurante restaurante;

        public Consumo(int idConsumo, int numeroPorciones, Menu menu, Cliente cliente, LocalDate fecha, Restaurante restaurante) {
                this.idConsumo = idConsumo;
                this.numeroPorciones = numeroPorciones;
                this.menu = menu;
                this.cliente = cliente;
                this.fecha = fecha;
                this.restaurante = restaurante;
        }

        public Consumo(int numeroPorciones, Menu menu, Cliente cliente, LocalDate fecha, Restaurante restaurante) {
                this.numeroPorciones = numeroPorciones;
                this.menu = menu;
                this.cliente = cliente;
                this.fecha = fecha;
                this.restaurante = restaurante;
        }

        public int getIdConsumo() {
            return idConsumo;
        }

        public void setIdConsumo(int idConsumo) {
            this.idConsumo = idConsumo;
        }

        public int getNumeroPorciones() {
            return numeroPorciones;
        }

        public void setNumeroPorciones(int numeroPorciones) {
            this.numeroPorciones = numeroPorciones;
        }

        public Menu getMenu() {
            return menu;
        }

        public void setMenu(Menu menu) {
            this.menu = menu;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public Restaurante getRestaurante() {
            return restaurante;
        }

        public void setRestaurante(Restaurante restaurante) {
            this.restaurante = restaurante;
        }
        
        
        
    
}
