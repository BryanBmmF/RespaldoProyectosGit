/*
 * Clase Lexema 
 */
package analizadorlexico.backend;

/**
 *
 * @author bryan
 */
public class Lexema {
    
        private String lexema;
        private String token;
        private int numeroFila;
        private int numeroColumna;

        public Lexema(String lexema, String token, int numeroFila, int numeroColumna) {
                this.lexema = lexema;
                this.token = token;
                this.numeroFila = numeroFila;
                this.numeroColumna = numeroColumna;
        }
        public Lexema(){
        
        }

        public String getLexema() {
                return lexema;
        }

        public void setLexema(String lexema) {
                this.lexema = lexema;
        }

        public String getToken() {
                return token;
        }

        public void setToken(String token) {
                this.token = token;
        }

        public int getNumeroFila() {
                return numeroFila;
        }

        public void setNumeroFila(int numeroFila) {
                this.numeroFila = numeroFila;
        }

        public int getNumeroColumna() {
                return numeroColumna;
        }

        public void setNumeroColumna(int numeroColumna) {
                this.numeroColumna = numeroColumna;
        }        
        
    
}
