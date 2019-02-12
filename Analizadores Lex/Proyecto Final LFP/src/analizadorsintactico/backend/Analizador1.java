/*
 * 
 */
package analizadorsintactico.backend;

import analizadorsintactico.gui.JFramePrincipal;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JTable;

/**
 *
 * @author bryan
 */
public class Analizador1 {
    
        private String texto;
        private ArrayList<Lexem> lexemasEvaluadosValidos;
        private ArrayList<Lexem> lexemasEvaluadosInvalidos;
        private JFramePrincipal frame;
        public Analizador1(String texto, JFramePrincipal frame) {
                this.texto = texto;
                this.frame=frame;
                this.lexemasEvaluadosValidos= new ArrayList();
                this.lexemasEvaluadosInvalidos = new ArrayList();
        }
        
        public void analizar(){
                boolean seguir = true;
		Lexer analizador = new Lexer(new StringReader(texto));
		while(seguir) {
			try {
				//Token miToken = analizador.yylex();
                                Lexem lexem = analizador.yylex();
				if (lexem == null) {
					seguir = false;
					break;
				}
				switch (lexem.getToken()) {
					case ERROR:
                                                lexemasEvaluadosInvalidos.add(lexem);
						break;

					default:
                                                lexemasEvaluadosValidos.add(lexem);
                                                break;
				}
			} catch(Exception e) {
				seguir = false;
				break;
			}
			
		}
                System.out.println("------------------------------------------------------------------------");
                if (!lexemasEvaluadosValidos.isEmpty()) {
                        imprimirLexemas(lexemasEvaluadosValidos,frame.devolverTablaLexVal());
                        //almacenar la  lista para enviarla a un segundo analizador para evaluar sintaxis
                        //preguntar si desea continuar con el analisis sintactico
                        if (lexemasEvaluadosInvalidos.isEmpty()) { //si la lista de tokens invalidos esta vacia
                                if (frame.realizarAnalisisSintactico()) {
                                        /**llamamos el metodo que permite cargar la ventana*/
                                        JFileChooser file=new JFileChooser();
                                        file.showSaveDialog(frame);
                                        //instanciamos Analiozado2 (Sintactico)
                                        Analizador2 a = new Analizador2(frame,file.getSelectedFile());
                                        a.analizarSintaxis(lexemasEvaluadosValidos);
                                }
                        }
                        lexemasEvaluadosValidos.clear();
                }
                if (!lexemasEvaluadosInvalidos.isEmpty()) {
                        imprimirLexemas(lexemasEvaluadosInvalidos,frame.devolverTablaLexInval());
                        lexemasEvaluadosInvalidos.clear();
                }
                
        }
        //metodo que imprime lexemas
         public void imprimirLexemas(ArrayList<Lexem> lexemas, JTable tabla){
                for(Lexem lexemaV:lexemas){
                        System.out.println("Lexema: "+lexemaV.getLexema()+"  Token: "+lexemaV.getToken()+
                                "  Fila: "+lexemaV.getNumeroFila()+"  Columna: "+lexemaV.getNumeroColumna());
                }
                frame.limpiarTabla(tabla);
                frame.cargarTablaLexemasI(lexemas,tabla);
                       
        }
        public String getTexto() {
            return texto;
        }

        public void setTexto(String texto) {
            this.texto = texto;
        }
        
        
}
