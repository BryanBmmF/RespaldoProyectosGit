/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.Restaurante;

import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class IngresosRestaurante {
        private int id;
        private Double ingreso;
        private LocalDate fecha;
        private Restaurante restaurante;

        public IngresosRestaurante(Double ingreso, LocalDate fecha, Restaurante restaurante) {
            this.ingreso = ingreso;
            this.fecha = fecha;
            this.restaurante = restaurante;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Double getIngreso() {
            return ingreso;
        }

        public void setIngreso(Double ingreso) {
            this.ingreso = ingreso;
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
