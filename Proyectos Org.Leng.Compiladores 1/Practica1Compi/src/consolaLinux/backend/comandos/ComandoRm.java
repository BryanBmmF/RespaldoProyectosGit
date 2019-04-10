/*
 * Comando rm (borrar archivos)
 */
package consolaLinux.backend.comandos;

/**
 *
 * @author bryan
 */
public class ComandoRm {
        private String token;
	private String opciones;
	private String path;

        public ComandoRm(String token, String opciones, String path) {
            this.token = token;
            this.opciones = opciones;
            this.path = path;
        }

        public ComandoRm(String token, String path) {
            this.token = token;
            this.path = path;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getOpciones() {
            return opciones;
        }

        public void setOpciones(String opciones) {
            this.opciones = opciones;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
        
        
}
