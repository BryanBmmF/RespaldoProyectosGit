/*
 * 
 */
package analizadorlexico.backend;

import analizadorlexico.gui.JFramePrincipal;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class Analizador {
        
        //listas a utilizar en el analisis
        private ArrayList<String> errores;
        private ArrayList<String> lexemas;
        private ArrayList<Lexema> lexemasEvaluadosValidos;
        private ArrayList<Lexema> lexemasEvaluadosInvalidos;
        private JFramePrincipal frame;
        private ArrayList<String> tokens;
        private Lexema lexemaNew;
        //variaables y constantes necesarias
        private int indice;
        private int estado;
        private String lexema;
        private boolean aceptar;
        private boolean comentBloque=false;
        private boolean estadoFinal=false;
        private int contLinea=1;
        private int contColumna=1;
        private static int columnaBloque=0;
        private static int filaBloque=0;
        public static int numeroLineas;
        public static final char[] LETRAS={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
                                                            'p','q','r','s','t','u','v','w','x','y','z',
                                            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
                                                            'P','Q','R','S','T','U','V','W','X','Y','Z'};
        public static final String[] PALABRAS_RESERVADAS={"boolean","else","extends","class","case","for","false","final",
                                                 "if","import","int","implements","interface","public","private","package",
                                                        "protected","static","short","return","then","true","void","while"};
        public static final char[] NUMEROS_1_9={'1','2','3','4','5','6','7','8','9'};
        public static final char[] SIGNOS_AGRUPACION={'(',')','[',']','{','}'};
        public static final char[] SIGNOS_PUNTUACION={',',':',';','.'};
        public static final char[] OPERADORES={'%','*'};
        public static final char CERO='0';
        public static final char ESPACIO=' ';
        public static final char TAB='\t';
        public static final char SALTO='\n';
        public static final char COMILLA_DOBLE='\"';
        public static final char COMILLA_SIMPLE='\'';
        
        public static final char LETRA_A='a';
        public static final char LETRA_B='b';
        public static final char LETRA_C='c';
        public static final char LETRA_D='d';
        public static final char LETRA_E='e';
        public static final char LETRA_F='f';
        public static final char LETRA_G='g';
        public static final char LETRA_H='h';
        public static final char LETRA_I='i';
        public static final char LETRA_J='j';
        public static final char LETRA_K='k';
        public static final char LETRA_L='l';
        public static final char LETRA_M='m';
        public static final char LETRA_N='n';
        public static final char LETRA_O='o';
        
        public static final char LETRA_P='p';
        public static final char LETRA_Q='q';
        public static final char LETRA_S='s';
        public static final char LETRA_R='r';
        public static final char LETRA_T='t';
        public static final char LETRA_U='u';
        public static final char LETRA_V='v';
        public static final char LETRA_W='w';
        public static final char LETRA_X='x';
        public static final char LETRA_Y='y';
        public static final char LETRA_Z='z';
       
        public static final char DIAGONAL='/';
        public static final char ASTERISCO='*';
        public static final char SIGNO_POSITIVO='+';
        public static final char SIGNO_NEGATIVO='-';
        public static final char PUNTO='.';
        public static final char GUION_BAJO='_';
        public static final char GUION='-';
        
        //estados
        public static final int ESTADO_0=0;
        public static final int ESTADO_1=1;
        public static final int ESTADO_2=2;
        public static final int ESTADO_3=3;
        public static final int ESTADO_4=4;
        public static final int ESTADO_5=5;
        public static final int ESTADO_6=6;
        public static final int ESTADO_7=7;
        public static final int ESTADO_8=8;
        public static final int ESTADO_9=9;
        public static final int ESTADO_10=10;
        public static final int ESTADO_11=11;
        public static final int ESTADO_12=12;
        public static final int ESTADO_13=13;
        public static final int ESTADO_14=14;
        public static final int ESTADO_15=15;
        public static final int ESTADO_16=16;
        public static final int ESTADO_17=17;
        public static final int ESTADO_18=18;
        public static final int ESTADO_19=19;
        
        //tokens
        public static final String NUMERO_ENTERO="Numero Entero";
        public static final String NUMERO_DECIMAL="Numero Decimal";
        public static final String IDENTIFICADOR="Identificador";
        public static final String PALABRA_RESERVADA="Palabra Reservada";
        public static final String LITERAL="Literal";
        public static final String COMENTARIO_LINEA="Comentario de Linea";
        public static final String COMENTARIO_BLOQUE="Comentario de Bloque";
        public static final String OPERADOR="Operador Aritmetico";
        public static final String SIGNO_AGRUPACION="Signo de Agrupacion";
        public static final String SIGNO_PUNTUACION="Signo de puntuacion";
        
        public Analizador(JFramePrincipal frame){
                this.frame=frame;
                this.errores= new ArrayList();
                this.lexemas= new ArrayList();
                this.tokens= new ArrayList();
                this.lexemaNew= new Lexema();
                this.lexemasEvaluadosValidos= new ArrayList();
                this.lexemasEvaluadosInvalidos = new ArrayList();
        
        }
        public void iniciarMiembros(){             
                this.indice=0;
                this.estado=0;
                this.contLinea=1;
                this.contColumna=1;
                
                this.estadoFinal=false;
                this.lexema="";
                this.aceptar=true;
        }
        //analizador de tokens 
        public void analizarTodoLexema(String texto,int numeroDeFila){
                if (comentBloque==false) {
                    iniciarMiembros();
                }
                char caracter;
                for (indice = 0; indice < texto.length(); indice++) {
                        caracter= texto.charAt(indice);
                        //evaluacion de estados para este automata
                        switch (estado) {
                                case ESTADO_0:
                                        if (evaluarSimbolo(NUMEROS_1_9, caracter)) {// si es un numero se posiciona en el estado 3
                                                realizarTransicion(ESTADO_3, ""+caracter);
                                        } else if(caracter==SIGNO_POSITIVO || caracter==SIGNO_NEGATIVO){// si es un signo se posiciona en el estado 2
                                                        realizarTransicion(ESTADO_2, ""+caracter);
                                                } else if(caracter==CERO){// si es un cero se posiciona en el estado 1
                                                                realizarTransicion(ESTADO_1, ""+caracter);
                                                        } else if (evaluarSimbolo(LETRAS, caracter)) {// si es un una letra o un guion bajo se posiciona en el estado 6
                                                                        realizarTransicion(ESTADO_6, ""+caracter);
                                                                } else if(caracter==GUION_BAJO){// si GUION_BAJO se posiciona en el estado 7
                                                                                realizarTransicion(ESTADO_7, ""+caracter);
                                                                        } else if (caracter==COMILLA_DOBLE) {// si es un una comilla se posiciona en el estado 8
                                                                                        realizarTransicion(ESTADO_8, ""+caracter);
                                                                                } else if (caracter==DIAGONAL) {// si es un una diagonal se posiciona en el estado 12
                                                                                                realizarTransicion(ESTADO_12, ""+caracter);
                                                                                        } else if (evaluarSimbolo(SIGNOS_AGRUPACION, caracter)) {// si es un SIGNO AGRUPACION se posiciona en el estado 17
                                                                                                        realizarTransicion(ESTADO_17, ""+caracter);
                                                                                                } else if (evaluarSimbolo(OPERADORES, caracter)){// si es OPERADOR se posiciona en el estado 18
                                                                                                                realizarTransicion(ESTADO_18,  ""+caracter);
                                                                                                        } else if (evaluarSimbolo(SIGNOS_PUNTUACION, caracter)){// si SIGNO PUNTUACION se posiciona en el estado 19
                                                                                                                        realizarTransicion(ESTADO_19,  ""+caracter);
                                                                                                                } else if (caracter==ESPACIO || caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                                                                                                realizarTransicion(ESTADO_0, "");
                                                                                                                        } else{//ERROR EN CARACTER
                                                                                                                                reportarError(indice, caracter, numeroDeFila,ESTADO_0);
                                                                                                                            }
                            
                                    break;
                                case ESTADO_1:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es ESPACIO O TAB que indica la separacion de palabras    
                                                if (aceptar) {
                                                        aceptarLexema(NUMERO_ENTERO,numeroDeFila);
                                                } else {
                                                        rechazarLexema(NUMERO_ENTERO,numeroDeFila);
                                                    }
                                        } else if(caracter==PUNTO){// si es un punto se posiciona en el estado 4
                                                        realizarTransicion(ESTADO_4, lexema+caracter);
                                                } else{
                                                        reportarError(indice, caracter, numeroDeFila,ESTADO_1);
                                                        aceptar=false;
                                                    }
                            
                                    break;
                                case ESTADO_2:
                                        if(evaluarSimbolo(NUMEROS_1_9, caracter)){// si es un numero se posiciona en el estado 3
                                                realizarTransicion(ESTADO_3, lexema+caracter);
                                        } else if(caracter==CERO){ // si es CERO
                                                        realizarTransicion(ESTADO_1, lexema+caracter);// si es un cero se posiciona en el estado 1
                                                } else if (caracter==ESPACIO || caracter==TAB){// si es espacio o tab
                                                                aceptarLexema(OPERADOR,numeroDeFila);// se acepta ya que es tomada como un operador
                                                        } else{//ERROR EN CARACTER
                                                                reportarError(indice, caracter, numeroDeFila,ESTADO_2);
                                                                aceptar=false;
                                                            }
                                    break;
                                case ESTADO_3:
                                        if (caracter==ESPACIO || caracter==TAB) {// si es un espacio o tab se llega a aceptar la cadena
                                                if (aceptar) {
                                                        aceptarLexema(NUMERO_ENTERO,numeroDeFila);
                                                } else {
                                                        rechazarLexema(NUMERO_ENTERO,numeroDeFila);
                                                }                                         
                                        } else if(evaluarSimbolo(NUMEROS_1_9, caracter)|| caracter==CERO){// si es un numero o un cero se posiciona en el estado 3
                                                        realizarTransicion(ESTADO_3, lexema+caracter);
                                                } else if(caracter==PUNTO){// si es un punto se posiciona en el estado 4
                                                                realizarTransicion(ESTADO_4, lexema+caracter);
                                                        } else{//ERROR CARACTER
                                                                reportarError(indice, caracter, numeroDeFila,ESTADO_3);
                                                                aceptar=false;
                                                            }
                            
                                    break;
                                case ESTADO_4:
                                        if (caracter==ESPACIO || caracter==TAB) {// si es un espacio o tab se rechaza la cadena
                                                rechazarLexema(NUMERO_DECIMAL,numeroDeFila);
                                        } else if(evaluarSimbolo(NUMEROS_1_9, caracter)|| caracter==CERO){// si es un numero o un cero se posiciona en el estado 5
                                                        realizarTransicion(ESTADO_5, lexema+caracter);
                                                } else{ //ERROR CARACTER
                                                        reportarError(indice, caracter, numeroDeFila,ESTADO_4);
                                                        aceptar=false;
                                                    }
                            
                                    break;
                                case ESTADO_5:
                                        if (caracter==ESPACIO || caracter==TAB) {// si es un esacio o tab se llega a aceptar la cadena
                                                if (aceptar) {
                                                        aceptarLexema(NUMERO_DECIMAL,numeroDeFila);
                                                } else {
                                                        rechazarLexema(NUMERO_DECIMAL,numeroDeFila);
                                                }
                                        } else if(evaluarSimbolo(NUMEROS_1_9, caracter)|| caracter==CERO){// si es un numero o un cero se posiciona en el estado 5
                                                        realizarTransicion(ESTADO_5, lexema+caracter);
                                                } else{//ERROR CARACTER
                                                        reportarError(indice, caracter, numeroDeFila,ESTADO_5);
                                                        aceptar=false;
                                                    }
                            
                                    break;
                                
                                case ESTADO_6:
                                        if(evaluarSimbolo(LETRAS, caracter)||evaluarSimbolo(NUMEROS_1_9, caracter)
                                                ||caracter==CERO||caracter==GUION||caracter==GUION_BAJO){ //si letra, digito, guion bajo o guion medio se posicion a en estado 6 
                                                realizarTransicion(ESTADO_6, lexema+caracter);
                                        } else if (caracter==ESPACIO || caracter==TAB) {// si es un espacio o tab se llega a aceptar la cadena
                                                        if (aceptar) {
                                                                aceptarLexemaIdentificador(numeroDeFila);
                                                        } else {
                                                                rechazarLexema(IDENTIFICADOR,numeroDeFila);
                                                        }
                                                } else {//otro simbolo
                                                        reportarError(indice, caracter, numeroDeFila,ESTADO_6);
                                                        aceptar=false;
                                                    }
                            
                                    break;
                                 case ESTADO_7:
                                        if (evaluarSimbolo(LETRAS, caracter) ||evaluarSimbolo(NUMEROS_1_9, caracter)
                                                ||caracter==CERO) {// si es un una letra o un guion O DIGITO bajo se posiciona en el estado 6
                                                realizarTransicion(ESTADO_6, lexema+caracter);
                                        } else if(caracter==GUION_BAJO||caracter==GUION){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(ESTADO_7, lexema+caracter);
                                                } else if(caracter==ESPACIO || caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                                rechazarLexema(IDENTIFICADOR,numeroDeFila);
                                                        } else{ //ERROR CARACTER
                                                                reportarError(indice, caracter, numeroDeFila,ESTADO_7);
                                                                aceptar=false;
                                                            }
                                    break;
                                case ESTADO_8:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio y llega al final de linea  
                                                rechazarLexema(LITERAL,numeroDeFila);
                                        } else if(caracter==ESPACIO ||caracter==TAB){ //si es espacio se posicion a en estado 11  
                                                        realizarTransicion(ESTADO_11, lexema+caracter);
                                                } else{
                                                        realizarTransicion(ESTADO_9, lexema+caracter); //cualquier caracter
                                                    }

                                    break;
                                case ESTADO_9:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                rechazarLexema(LITERAL,numeroDeFila);
                                        } else if(caracter==COMILLA_DOBLE){ //si es COMILLA DOBLE se posicion a en estado 10     
                                                        realizarTransicion(ESTADO_10, lexema+caracter);
                                                } else{
                                                        realizarTransicion(ESTADO_9, lexema+caracter); //cualquier caracter
                                                    }
                            
                                        
                                    break;
                                case ESTADO_10:
                                        if (caracter==ESPACIO || caracter==TAB) {// si es un espacio o tab se llega a aceptar la cadena
                                                if (aceptar) {
                                                        aceptarLexema(LITERAL,numeroDeFila);
                                                } else {
                                                        rechazarLexema(LITERAL,numeroDeFila);
                                                }
                                        } else{ //ERROR CARACTER
                                                reportarError(indice, caracter, numeroDeFila,ESTADO_10);
                                                aceptar=false;
                                            }
                                        
                                    break;
                                case ESTADO_11:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                rechazarLexema(LITERAL,numeroDeFila);
                                        } else if(caracter==ESPACIO ||caracter==TAB){ //si es ESPACIO O TAB se posicion a en estado 11     
                                                        realizarTransicion(ESTADO_11, lexema+caracter);
                                                } else{
                                                        realizarTransicion(ESTADO_9, lexema+caracter); //cualquier caracter
                                                    }
                            
                                        
                                    break;
                                case ESTADO_12:
                                        if(caracter==DIAGONAL){ //si es otra diagonal se posiciona en estado 13 
                                                realizarTransicion(ESTADO_13, lexema+caracter);
                                        } else if(caracter==ASTERISCO){ //si es ASTERISCO se posicion a en estado 14     
                                                        realizarTransicion(ESTADO_14, lexema+caracter);
                                                } else if (caracter==ESPACIO || caracter==TAB){// si es espacio o tab
                                                                aceptarLexema(OPERADOR,numeroDeFila);// se acepta ya que es tomada como un operador
                                                        } else{ //ERROR CARACTER
                                                                reportarError(indice, caracter, numeroDeFila,ESTADO_12);
                                                                aceptar=false;
                                                            }

                                    break;
                                case ESTADO_13:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                if (aceptar) {
                                                        aceptarLexema(COMENTARIO_LINEA,numeroDeFila);
                                                } else {
                                                        rechazarLexema(COMENTARIO_LINEA,numeroDeFila);
                                                }
                                        } else{//cualquier simbolo
                                                        realizarTransicion(ESTADO_13, lexema+caracter); //cualquier caracter
                                                    }
                            
                                        
                                    break;
                                 case ESTADO_14:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                realizarTransicion(ESTADO_15, lexema+caracter+"\n");
                                                comentBloque=true;
                                                System.out.println(""+indice);
                                                columnaBloque=columnaBloque+indice;
                                                filaBloque++;
                                        } else if(caracter==ASTERISCO){// si es ASTERISCO se posiciona en el estado 15
                                                        realizarTransicion(ESTADO_15, lexema+caracter);
                                                }else{//cualquier simbolo
                                                        realizarTransicion(ESTADO_14, lexema+caracter); //cualquier caracter
                                                    }
                            
                                        
                                    break;
                                case ESTADO_15:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                realizarTransicion(ESTADO_15, lexema+caracter+"\n");
                                                comentBloque=true;
                                                System.out.println(""+indice);
                                                columnaBloque=columnaBloque+indice;
                                                filaBloque++;
                                        } else if(caracter==ASTERISCO){// si es ASTERISCO se posiciona en el estado 15
                                                        realizarTransicion(ESTADO_15, lexema+caracter);
                                                } else if(caracter==DIAGONAL){// si es DIAGONAL se posiciona en el estado 16
                                                                realizarTransicion(ESTADO_16, lexema+caracter);
                                                                //aceptar=true;
                                                        }else{//cualquier simbolo
                                                                realizarTransicion(ESTADO_14, lexema+caracter); //cualquier caracter
                                                                //aceptar=false;
                                                            }
                            
                                        
                                    break;
                                case ESTADO_16:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es un espacio se posiciona ACEPTA/RECHAZA  
                                                if (aceptar) {
                                                        aceptarLexemaBloque(COMENTARIO_BLOQUE, numeroDeFila);
                                                } else {
                                                        rechazarLexema(COMENTARIO_BLOQUE,numeroDeFila);
                                                }
                                                comentBloque=false;
                                                columnaBloque=0;
                                                filaBloque=0;
                                        } else{//cualquier simbolo
                                                        reportarError(indice, caracter, numeroDeFila,ESTADO_16);
                                                        //aceptar=false;
                                                    }
                            
                                        
                                    break;
                                 case ESTADO_17:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es ESPACIO O TAB se ACEPTA/RECHAZA
                                                aceptarLexema(SIGNO_AGRUPACION,numeroDeFila);
                                        } else{//cualquier simbolo
                                                reportarError(indice, caracter, numeroDeFila,ESTADO_17);
                                                //aceptar=false;
                                            }
                                    break;
                                case ESTADO_18:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es ESPACIO O TAB se ACEPTA/RECHAZA
                                                aceptarLexema(OPERADOR,numeroDeFila);
                                        } else{//cualquier simbolo
                                                reportarError(indice, caracter, numeroDeFila,ESTADO_18);
                                                //aceptar=false;
                                            }
                                    break;
                                case ESTADO_19:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es ESPACIO O TAB se ACEPTA/RECHAZA 
                                                aceptarLexema(SIGNO_PUNTUACION,numeroDeFila);
                                        } else{//cualquier simbolo
                                                reportarError(indice, caracter, numeroDeFila,ESTADO_19);
                                                //aceptar=false;
                                            }
                                    break;
                                
                               
                                
                                
                                default:
                                    throw new AssertionError();
                        }
                        contLinea++;
                       
                }
                System.out.println("--------------------------------------------");
                if (lexemasEvaluadosValidos.size()>0) {
                        imprimirLexemas(lexemasEvaluadosValidos);
                        lexemasEvaluadosValidos.clear();
                }
                if (lexemasEvaluadosInvalidos.size()>0) {
                        imprimirLexemas(lexemasEvaluadosInvalidos);
                        lexemasEvaluadosInvalidos.clear();
                }
                /**/
            
        }
        
        public boolean evaluarSimbolo(char[] simbolos, char caracter){
                boolean encontrado=false;
                int cont=0;
                while(encontrado==false && cont<simbolos.length){
                        if (simbolos[cont]==caracter) {
                                encontrado=true;
                        }
                        cont++;
                }
                return encontrado;
        }
         public void imprimirLexemas(ArrayList<Lexema> lexemas){
                for(Lexema lexemaV:lexemas){
                        System.out.println("Lexema: "+lexemaV.getLexema()+"  Token: "+lexemaV.getToken()+
                                "  Fila: "+lexemaV.getNumeroFila()+"  Columna: "+lexemaV.getNumeroColumna());
                }
                frame.cargarTablaLexemas(lexemas);
                       
        }
        
        public void imprimirErrores(){
                for (int i = 0; i < errores.size(); i++) {
                        System.out.println(errores.get(i));
                }
        }
        public void realizarTransicion(int posicion,String acarreoLexema){
                estado=posicion; //el estado se coloca en la posicion especificada
                lexema=acarreoLexema;    //se actualiza el lexema   
        }
        public void realizarTransicionPalabraReserv(char caracter,char caracterComparacion, int nextEstadoPReser){
      
                if (caracter==caracterComparacion) {
                        realizarTransicion(nextEstadoPReser, lexema+caracter);
                } else if (evaluarSimbolo(LETRAS, caracter)||evaluarSimbolo(NUMEROS_1_9, caracter)
                        ||caracter==CERO||caracter==GUION||caracter==GUION_BAJO) {
                                realizarTransicion(121, lexema+caracter);                         
                        } else if(caracter==ESPACIO || caracter==TAB){// si es un signo se posiciona en el estado 2
                                        //aceptar lexema
                                        realizarTransicion(0, "");                                     
                                } else if(caracter==SALTO){// si es un signo se posiciona en el estado 2
                                            realizarTransicion(0, "");
                                            contLinea++;
                                            contColumna=1;
                                    } else {
                                                reportarError(contColumna, caracter, contLinea, 0);
                                        }
        }
        public void realizarTransicionPalabraReservDoble(char caracter,char caracterComparacion,char caracterComparacion2, int nextEstadoPReser, int nextEstadoPReser2){
      
                if (caracter==caracterComparacion) {
                        realizarTransicion(nextEstadoPReser,lexema+caracter);
                } else if (caracter==caracterComparacion2) {
                                realizarTransicion(nextEstadoPReser2,lexema+caracter);
                                //esta siguiente parte se puede meter en un metodo para ahorrar codigo de la doble triple y cuadruple
                        } else if (evaluarSimbolo(LETRAS, caracter)||evaluarSimbolo(NUMEROS_1_9, caracter)
                                ||caracter==CERO||caracter==GUION||caracter==GUION_BAJO) {
                                        realizarTransicion(121, lexema+caracter);
                                } else if(caracter==ESPACIO || caracter==TAB){// si es un signo se posiciona en el estado 2
                                                //aceptar lexema
                                                realizarTransicion(0, "");
                                        } else if(caracter==SALTO){// si es un signo se posiciona en el estado 2
                                                    realizarTransicion(0, "");
                                                    contLinea++;
                                                    contColumna=1;
                                            } else {
                                                        reportarError(contColumna, caracter, contLinea, 0);
                                                }
        }
        public void realizarTransicionPalabraReservTriple(char caracter,char caracterComparacion,char caracterComparacion2,
                char caracterComparacion3, int nextEstadoPReser, int nextEstadoPReser2, int nextEstadoPReser3){
      
                if (caracter==caracterComparacion) {
                        realizarTransicion(nextEstadoPReser,lexema+caracter);
                } else if (caracter==caracterComparacion2) {
                                realizarTransicion(nextEstadoPReser2,lexema+caracter);
                        } else if (caracter==caracterComparacion3) {
                                        realizarTransicion(nextEstadoPReser3,lexema+caracter);
                                } else if (evaluarSimbolo(LETRAS, caracter)||evaluarSimbolo(NUMEROS_1_9, caracter)
                                        ||caracter==CERO||caracter==GUION||caracter==GUION_BAJO) {
                                                realizarTransicion(121, lexema+caracter);
                                        } else if(caracter==ESPACIO || caracter==TAB){// si es un signo se posiciona en el estado 2
                                                        //aceptar lexema
                                                        realizarTransicion(0, "");
                                                } else if(caracter==SALTO){// si es un signo se posiciona en el estado 2
                                                            realizarTransicion(0, "");
                                                            contLinea++;
                                                            contColumna=1;
                                                    } else {
                                                                reportarError(contColumna, caracter, contLinea, 0);
                                                        }
        }
        public void realizarTransicionPalabraReservCuadruple(char caracter,char caracterComparacion,char caracterComparacion2, char caracterComparacion4,
                char caracterComparacion3, int nextEstadoPReser, int nextEstadoPReser2, int nextEstadoPReser3, int nextEstadoPReser4){
      
                if (caracter==caracterComparacion) {
                        realizarTransicion(nextEstadoPReser,lexema+caracter);
                } else if (caracter==caracterComparacion2) {
                                realizarTransicion(nextEstadoPReser2,lexema+caracter);
                        } else if (caracter==caracterComparacion3) {
                                        realizarTransicion(nextEstadoPReser3,lexema+caracter);
                                } else if (caracter==caracterComparacion4) {
                                                realizarTransicion(nextEstadoPReser4,lexema+caracter);
                                        } else if (evaluarSimbolo(LETRAS, caracter)||evaluarSimbolo(NUMEROS_1_9, caracter)
                                                        ||caracter==CERO||caracter==GUION||caracter==GUION_BAJO) {
                                                        realizarTransicion(121, lexema+caracter);
                                                } else if(caracter==ESPACIO || caracter==TAB){// si es un signo se posiciona en el estado 2
                                                                //aceptar lexema
                                                                realizarTransicion(0, "");
                                                        } else if(caracter==SALTO){// si es un signo se posiciona en el estado 2
                                                                    realizarTransicion(0, "");
                                                                    contLinea++;
                                                                    contColumna=1;
                                                            } else {
                                                                        reportarError(contColumna, caracter, contLinea, 0);
                                                                }
        }
        public void aceptarLexema(String token,int numeroFila){            
                lexemasEvaluadosValidos.add(new Lexema(lexema, token, numeroFila, (indice+1)-lexema.length()));
                realizarTransicion(0, "");//se reinicia el estado y el lexema
                indice--;// se retrocede el indice para empezar a evaluar un nuevo lexema     
        }
        public void aceptarLexemaBloque(String token,int numeroFila){            
                lexemasEvaluadosValidos.add(new Lexema(lexema, token, (numeroFila-filaBloque), (columnaBloque)));
                realizarTransicion(0, "");//se reinicia el estado y el lexema
                indice--;// se retrocede el indice para empezar a evaluar un nuevo lexema     
        }
        public void rechazarLexema(String token,int numeroFila){
                lexemasEvaluadosInvalidos.add(new Lexema(lexema, token, numeroFila, (indice+1)-lexema.length()));
                realizarTransicion(0, "");//se reinicia el estado y el lexema
                indice--;// se retrocede el indice para empezar a evaluar un nuevo lexema     
        }
        public void aceptarLexemaIdentificador(int numeroFila){
                boolean encontrada=false;
                int cont =0;
                //se busca la palabra reservada
                while(encontrada==false && cont<PALABRAS_RESERVADAS.length){
                        if (lexema.equals(PALABRAS_RESERVADAS[cont])) {
                                encontrada=true;
                        }
                        cont++;
                }
                if (encontrada) {
                        aceptarLexema(PALABRA_RESERVADA, numeroFila);
                } else{
                        aceptarLexema(IDENTIFICADOR, numeroFila);
                }
                
        }
       
        public void reportarError(int indice,char caracter,int numeroDeFila,int estActual){
                System.out.println("Error Lexico en Simbolo: "+caracter+"  Fila: "+numeroDeFila+" Columna: "+(indice+1));
                estado=estActual;
                lexema=lexema+caracter;
                //errores.add(""+caracter);
        }
        public void reportarError2(int numeroColumna,char caracter,int numeroDeFila,int estado){
                System.out.println("Error Lexico en Simbolo: "+caracter+"  Fila: "+numeroDeFila+" Columna: "+(numeroColumna));
                estado=estado;
                //lexema=lexema+caracter;
                //errores.add(""+caracter);
        }

        public int getNumeroLineas() {
            return numeroLineas;
        }

        public void setNumeroLineas(int numeroLineas) {
            this.numeroLineas = numeroLineas;
        }
        
        
}
