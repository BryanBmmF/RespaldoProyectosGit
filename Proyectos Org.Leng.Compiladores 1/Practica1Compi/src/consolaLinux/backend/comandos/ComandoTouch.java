/*
 * Comando Touch (crear archivos)
 */
package consolaLinux.backend.comandos;

/**
 *
 * @author bryan
 */
public class ComandoTouch {
        private String token;
        private String path;

        public ComandoTouch(String token, String path) {
            this.token = token;
            this.path = path;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
            
}
