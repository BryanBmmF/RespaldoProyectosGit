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
        private Analizador analizador;
        private Analizador2 analizador2;
        private JFramePrincipal frame;
        private String espacio=" ";
        private String cadenaVacia="";
        
        public Procesador(JFramePrincipal frame){
                this.frame=frame;
                this.analizador= new Analizador(this.frame);
                this.analizador2= new Analizador2(this.frame);
        }
        public void procesarTexto(String texto){
//                String[] lineasDeTexto= texto.split("\n");
//                String lineaDeTexto=cadenaVacia;
//                analizador.setNumeroLineas(lineasDeTexto.length);
//                int numeroDeFila;
//                char simbolo;
//                for (int i = 0; i < lineasDeTexto.length; i++) {
//                        //se procede a limpiar estas lineas de texto de caracteres especiales
//                        for (int j = 0; j < lineasDeTexto[i].length(); j++) {
//                                simbolo= lineasDeTexto[i].charAt(j);
//                                switch (simbolo) {
//                                        case '\r':
//                                        case '\b':
//                                        case '\f':
//                                                break;
//
//                                        default:
//                                                lineaDeTexto = lineaDeTexto+simbolo;
//                                
//                                }
//                                
//                        }
//                        //se procede a analizarNumeros esta linea de texto
//                        numeroDeFila=i+1;
//                        analizador.analizarTodoLexema(lineaDeTexto+espacio, numeroDeFila);
//                        lineaDeTexto=cadenaVacia;//la linea de texto se limpia para procesar la siguiente linea
//                        
//                        
//                }
                  
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
