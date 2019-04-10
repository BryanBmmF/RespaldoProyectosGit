/*
 * Clase Log
 */
package proyecto1compi1.backend.usuarios;

import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class Log {
        private static Log log;
        private String user;
        private String pass;
        private LocalDate fecha;
        private Log(){
        
        }
        
        public static Log getInstance(){
                if (log==null) { //se crea una unica instancia de Log
                        log= new Log();            
                }
                return log;
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

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }
        
        
        
        
    
}
