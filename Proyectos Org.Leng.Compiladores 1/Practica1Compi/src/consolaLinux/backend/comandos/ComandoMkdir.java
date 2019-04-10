/*
 * Comando Mkdir (Crear directorios "Carpetas")
 */
package consolaLinux.backend.comandos;

/**
 *
 * @author bryan
 */
public class ComandoMkdir {
        private String token;
        private String path;

        public ComandoMkdir(String token, String path) {
            this.token = token;
            this.path = path;
        }
       
        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
    }
        
        
}
