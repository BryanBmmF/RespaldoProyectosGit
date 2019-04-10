/*
 * Comando cp (copiar archivos o directorios)
 */
package consolaLinux.backend.comandos;

/**
 *
 * @author bryan
 */
public class ComandoCp {
        private String token;
        private String pathActual;
        private String pathDestino;

        
        public ComandoCp(String token, String pathActual, String pathDestino) {
            this.token = token;
            this.pathActual = pathActual;
            this.pathDestino = pathDestino;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getPathActual() {
            return pathActual;
        }

        public void setPathActual(String pathActual) {
            this.pathActual = pathActual;
        }

        public String getPathDestino() {
            return pathDestino;
        }

        public void setPathDestino(String pathDestino) {
            this.pathDestino = pathDestino;
        }
        
        
}
