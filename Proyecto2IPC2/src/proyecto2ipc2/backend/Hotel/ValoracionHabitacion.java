/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.Hotel;

import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class ValoracionHabitacion {
        private int id;
        private int puntuacion;
        private String Comentario;
        private LocalDate fecha;
        private Cliente cliente;
        private Habitacion habitacion;
        private Hotel hotel;

        public ValoracionHabitacion(int puntuacion, String Comentario, LocalDate fecha, Cliente cliente, Habitacion habitacion, Hotel hotel) {
                this.puntuacion = puntuacion;
                this.Comentario = Comentario;
                this.fecha = fecha;
                this.cliente = cliente;
                this.habitacion = habitacion;
                this.hotel = hotel;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPuntuacion() {
            return puntuacion;
        }

        public void setPuntuacion(int puntuacion) {
            this.puntuacion = puntuacion;
        }

        public String getComentario() {
            return Comentario;
        }

        public void setComentario(String Comentario) {
            this.Comentario = Comentario;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public Habitacion getHabitacion() {
            return habitacion;
        }

        public void setHabitacion(Habitacion habitacion) {
            this.habitacion = habitacion;
        }

        public Hotel getHotel() {
            return hotel;
        }

        public void setHotel(Hotel hotel) {
            this.hotel = hotel;
        }
        
        
    
}
