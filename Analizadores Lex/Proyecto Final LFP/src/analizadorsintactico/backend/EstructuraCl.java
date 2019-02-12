/*
 * Clase Estructura
 */
package analizadorsintactico.backend;

/**
 *
 * @author bryan
 */
public class EstructuraCl {
        private String estruc;
        private Estructura tipo;
        private int Linea;
        private int colum;

        public EstructuraCl() {
        }

        public EstructuraCl(String estruc, Estructura tipo, int Linea, int colum) {
                this.estruc = estruc;
                this.tipo = tipo;
                this.Linea = Linea;
                this.colum = colum;
        }

        public EstructuraCl(Estructura tipo, int Linea, int colum) {
                this.tipo = tipo;
                this.Linea = Linea;
                this.colum = colum;
        }
        
        public String getEstruc() {
                return estruc;
        }

        public void setEstruc(String estruc) {
                this.estruc = estruc;
        }

        public Estructura getTipo() {
                return tipo;
        }

        public void setTipo(Estructura tipo) {
                this.tipo = tipo;
        }

        public int getLinea() {
                return Linea;
        }

        public void setLinea(int Linea) {
                this.Linea = Linea;
        }

        public int getColum() {
                return colum;
        }

        public void setColum(int colum) {
                this.colum = colum;
        }
           
}
