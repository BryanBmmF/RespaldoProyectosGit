/*
 * Procesador de Texto
 */
package analizadorlexico.backend;
import analizadorlexico.gui.JFramePrincipal;

/**
 *
 * @author bryan
 */
public class Procesador {
        private Analizador2 analizador2;
        private JFramePrincipal frame;
        private String espacio=" ";
        private String cadenaVacia="";
        
        public Procesador(JFramePrincipal frame){
                this.frame=frame;
                this.analizador2= new Analizador2(this.frame);
        }
        public void procesarTexto(String texto){
                String lineaDeTexto=cadenaVacia;
                char simbolo;
                for (int j = 0; j < texto.length(); j++) {
                        simbolo= texto.charAt(j);
                        switch (simbolo) {
                                case '\r':
                                case '\b':
                                case '\f':
                                        break;

                                default:
                                        lineaDeTexto = lineaDeTexto+simbolo;

                        }
                                
                }
                //se procede a analizar
                analizador2.analizar(lineaDeTexto+espacio);
        }
        
    
}
