/*
 * Clase Hotel
 */
package proyecto2ipc2.backend.Hotel;

/**
 *
 * @author bryan
 */
public class Hotel {
        private int id;
        private int numeroHabitaciones;
        private String nombre;
        private String direccion;

        public Hotel(int id, int numeroHabitaciones, String nombre, String direccion) {
            this.id = id;
            this.numeroHabitaciones = numeroHabitaciones;
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public Hotel(int id, String nombre, String direccion) {
            this.id = id;
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public Hotel(String nombre, String direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public Hotel(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
        
        public Hotel(int id) {
            this.id = id;
        }
        
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumeroHabitaciones() {
            return numeroHabitaciones;
        }

        public void setNumeroHabitaciones(int numeroHabitaciones) {
            this.numeroHabitaciones = numeroHabitaciones;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
        
        
        
    
}
