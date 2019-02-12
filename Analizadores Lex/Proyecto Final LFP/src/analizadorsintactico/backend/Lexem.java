/*
 *Clase Lexema
 */
package analizadorsintactico.backend;

/**
 *
 * @author bryan
 */
public class Lexem {
        
        private String lexema;
        private Token token;
        private int numeroFila;
        private int numeroColumna;

        public Lexem() {
        }

        public Lexem(String lexema, Token token, int numeroFila, int numeroColumna) {
                this.lexema = lexema;
                this.token = token;
                this.numeroFila = numeroFila;
                this.numeroColumna = numeroColumna;
        }

        public String getLexema() {
                return lexema;
        }

        public void setLexema(String lexema) {
                this.lexema = lexema;
        }

        public Token getToken() {
                return token;
        }

        public void setToken(Token token) {
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
