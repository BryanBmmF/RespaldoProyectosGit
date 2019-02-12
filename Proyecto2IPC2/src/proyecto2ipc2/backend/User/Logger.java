/*
    Clase Logger para instanciar un login unico durante la ejecucion del programa 
    se utiliza patron Singleton
 */
package proyecto2ipc2.backend.User;

/**
 *
 * @author bryan
 */
public class Logger {
        
        private static Logger log;
        private String user;
        private String establecimiento;
        private int idEstablecimiento;
        private Logger(){
        
        }
        
        public static Logger getInstance(){
                if (log==null) { //se crea una unica instancia de Logger
                        log= new Logger();            
                }
                return log;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getEstablecimiento() {
            return establecimiento;
        }

        public void setEstablecimiento(String establecimiento) {
            this.establecimiento = establecimiento;
        }

        public int getIdEstablecimiento() {
            return idEstablecimiento;
        }

        public void setIdEstablecimiento(int idEstablecimiento) {
            this.idEstablecimiento = idEstablecimiento;
        }

        
        
}
