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
public class ComandoCd {
        
        private String token;
        private String path;

        public ComandoCd(String token, String path) {
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
