/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolaLinux.backend.comandos;

/**
 *
 * @author bryan
 */
public class ComandoChmod {
        
        private String token;
	private String opcionRecursiva;
	private String permisos;
	private String path;

        public ComandoChmod(String token, String opcionRecursiva, String permisos, String path) {
            this.token = token;
            this.opcionRecursiva = opcionRecursiva;
            this.permisos = permisos;
            this.path = path;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
        
        public String getOpcionRecursiva() {
            return opcionRecursiva;
        }

        public void setOpcionRecursiva(String opcionRecursiva) {
            this.opcionRecursiva = opcionRecursiva;
        }

        public String getPermisos() {
            return permisos;
        }

        public void setPermisos(String permisos) {
            this.permisos = permisos;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }       
        
}
