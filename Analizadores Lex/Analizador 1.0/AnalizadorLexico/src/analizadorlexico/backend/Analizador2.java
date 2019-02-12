/*
 * Analizador mejorado
 */
package analizadorlexico.backend;

import analizadorlexico.backend.Lexema;
import analizadorlexico.gui.JFramePrincipal;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class Analizador2 {
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
        private int contLinea;
        private int contBloqueComent;
        private int contColumna;
        private int posicionInicialBloque;
        public static final char[] LETRAS={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
                                                            'p','q','r','s','t','u','v','w','x','y','z',
                                            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
                                                            'P','Q','R','S','T','U','V','W','X','Y','Z'};
        public static final char[] LETRAS_2={'a','d','g','h','j','k','l','m','n','o',
                                                            'q','u','x','y','z',
                                            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
                                                            'P','Q','R','S','T','U','V','W','X','Y','Z'};
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
        public static final char LETRA_R='r';
        public static final char LETRA_S='s';
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
        
        public Analizador2(JFramePrincipal frame){
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
                this.contBloqueComent=1;
                this.contColumna=1;
                this.posicionInicialBloque=0;
                this.lexema="";            
        }
        //metodo para evaluar inicios con palabras reservadas
        public void evaluarPrimeraEtapa(char caracter){
                if (caracter==LETRA_B) {
                        realizarTransicion(1, lexema+caracter);
                } else if (caracter==LETRA_C) {
                                realizarTransicion(18, lexema+caracter);
                        } else if (caracter==LETRA_E) {
                                        realizarTransicion(8, lexema+caracter);
                                } else if (caracter==LETRA_F) {
                                                realizarTransicion(26, lexema+caracter);
                                        } else if (caracter==LETRA_I) {
                                                        realizarTransicion(41, lexema+caracter);
                                                } else if (caracter==LETRA_P) {
                                                                realizarTransicion(63, lexema+caracter);
                                                } else if (caracter==LETRA_S) {
                                                                realizarTransicion(88, lexema+caracter);
                                        } else if (caracter==LETRA_R) {
                                                        realizarTransicion(98, lexema+caracter);
                                } else if (caracter==LETRA_T) {
                                                realizarTransicion(104, lexema+caracter);
                        } else if (caracter==LETRA_V) {
                                        realizarTransicion(111, lexema+caracter);
                } else if (caracter==LETRA_W) {
                                realizarTransicion(115, lexema+caracter);
                } else {
                            evaluarSegundaEtapa(caracter);
                    }
                
        }
        //metodo para evaluar inicio de identificador, literal, comentarios, y numeros enteros /o decimales
        public void evaluarSegundaEtapa(char caracter){
                if (caracter==GUION_BAJO || evaluarSimbolo(LETRAS_2, caracter)) {
                        realizarTransicion(120, lexema+caracter);
                } else if (caracter==COMILLA_DOBLE) {
                                realizarTransicion(122, lexema+caracter);
                        } else if (caracter==DIAGONAL) {
                                        realizarTransicion(125, lexema+caracter);
                                        posicionInicialBloque=contColumna;
                                } else if (caracter==CERO) {
                                                realizarTransicion(130, lexema+caracter);
                                } else if (caracter==SIGNO_NEGATIVO || caracter==SIGNO_POSITIVO) {
                                                realizarTransicion(132, lexema+caracter);
                        } else if (evaluarSimbolo(NUMEROS_1_9, caracter)) {
                                        realizarTransicion(136, lexema+caracter);
                } else {
                            evaluarTerceraEtapa(caracter);
                    }
        }
        //metodo para evaluar inicio de signos de agrupacion, puntuacion, operadores, espacios/tab o saltos de lineas, incluyendo
        //posibles errores de simbolos invalidos
        public void evaluarTerceraEtapa(char caracter){
                if (evaluarSimbolo(SIGNOS_AGRUPACION, caracter)) {
                        realizarTransicion(138, lexema+caracter);
                } else if (evaluarSimbolo(OPERADORES, caracter)) {
                                realizarTransicion(139, lexema+caracter);
                        } else if (evaluarSimbolo(SIGNOS_PUNTUACION, caracter)) {
                                        realizarTransicion(140, lexema+caracter);
                                } else if (caracter==ESPACIO || caracter==TAB) {
                                                realizarTransicion(0, "");    
                                        } else if (caracter==SALTO) {
                                                        realizarTransicion(0, "");
                                                        //CUANDO ES UN SALTO NO DISMINUIMOS EL INDICE GENERAL PORQUE ESTE TIENE QUE SEGUIR SU CURSO
                                                        //Y ASI PUEDE PASAR AL CARACTER QUE VIENE ENSEGUIDA DEL SALTO DE LINEA
                                                        contLinea++;// se aumenta para saltar de linea
                                                        contColumna=0;//cero ya que mas adelante se aumenta y vuelve a ser 1
                                                } else {
                                                            reportarError(contColumna, ""+caracter, contLinea);
                                                    }
        }
        public void analizar(String texto){
            iniciarMiembros();
                char caracter;
                for (indice = 0; indice < texto.length(); indice++) {
                        caracter= texto.charAt(indice);
                        //evaluacion de los estados se compara con cada caracter que pueda ser inicial
                        switch (estado) { //al momento de regresar al estado cero reportar el token o lexema que esta en un estado inicial
                                case 0:
                                        evaluarPrimeraEtapa(caracter);
                                    break;
                                case 1:
                                        realizarTransicionPalabraReserv(caracter, LETRA_O, 2);
                                    break;
                                case 2:
                                        realizarTransicionPalabraReserv(caracter, LETRA_O, 3);
                                    break;
                                case 3:
                                        realizarTransicionPalabraReserv(caracter, LETRA_L, 4);
                                     break;
                                case 4:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 5);
                                    break;
                                case 5:
                                        realizarTransicionPalabraReserv(caracter, LETRA_A, 6);
                                    break;
                                case 6:
                                        realizarTransicionPalabraReserv(caracter, LETRA_N, 7);
                                    break;
                                case 7:
                                        //aceptar lexema palabra reservada boolean
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 8:
                                        realizarTransicionPalabraReservDoble(caracter, LETRA_L,LETRA_X,9,12); //doble
                                    break;
                                case 9:
                                        realizarTransicionPalabraReserv(caracter, LETRA_S, 10);
                                    break;
                                case 10:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 11);
                                    break;
                                case 11:
                                        //aceptar lexema palabra reservada else
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 12:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 13);
                                    break;
                                case 13:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 14);
                                    break;
                                case 14:
                                        realizarTransicionPalabraReserv(caracter, LETRA_N, 15);
                                    break;
                                case 15:
                                        realizarTransicionPalabraReserv(caracter, LETRA_D, 16);
                                    break;
                                case 16:
                                        realizarTransicionPalabraReserv(caracter, LETRA_S, 17);
                                    break;
                                case 17:
                                        //aceptar lexema palabra reservada extends
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 18:
                                        realizarTransicionPalabraReservDoble(caracter, LETRA_L, LETRA_A, 19, 23);
                                    break;
                                case 19:
                                        realizarTransicionPalabraReserv(caracter, LETRA_A, 20);
                                    break;
                                case 20:
                                        realizarTransicionPalabraReserv(caracter, LETRA_S, 21);
                                    break;
                                case 21:
                                        realizarTransicionPalabraReserv(caracter, LETRA_S, 22);
                                    break;
                                case 22:
                                        //se acepta la palabra class
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 23:
                                        realizarTransicionPalabraReserv(caracter, LETRA_S,24);
                                    break;
                                case 24:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 25);
                                    break;
                                case 25:
                                        //se acepta la palabra case
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 26:
                                        realizarTransicionPalabraReservCuadruple(caracter, LETRA_O, LETRA_A, LETRA_L, LETRA_I, 27, 29, 33, 37);
                                    break;
                                case 27:
                                        realizarTransicionPalabraReserv(caracter, LETRA_R, 28);
                                    break;
                                case 28:
                                        //aceptar lexema palabra reservada for
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 29:
                                        realizarTransicionPalabraReserv(caracter, LETRA_L, 30);
                                    break;
                                case 30:
                                        realizarTransicionPalabraReserv(caracter, LETRA_S, 31);
                                    break;
                                case 31:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 32);
                                    break;
                                case 32:
                                        //aceptar lexema palabra reservada false
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 33:
                                        realizarTransicionPalabraReserv(caracter, LETRA_O, 34);
                                    break;
                                case 34:
                                        realizarTransicionPalabraReserv(caracter, LETRA_A, 35);
                                    break;
                                case 35:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 36);
                                    break;
                                case 36:
                                        //aceptar lexema palabra reservada float
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 37:
                                        realizarTransicionPalabraReserv(caracter, LETRA_N, 38);
                                    break;
                                case 38:
                                        realizarTransicionPalabraReserv(caracter, LETRA_A, 39);
                                    break;
                                case 39:
                                        realizarTransicionPalabraReserv(caracter, LETRA_L, 40);
                                    break;
                                case 40:
                                        //aceptar lexema palabra reservada final
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 41:
                                        realizarTransicionPalabraReservTriple(caracter, LETRA_F, LETRA_M, LETRA_N, 42, 43, 55);
                                    break;
                                case 42:
                                        //aceptar lexema palabra reservada if
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 43:
                                        realizarTransicionPalabraReserv(caracter, LETRA_P, 44);
                                    break;
                                case 44:
                                        realizarTransicionPalabraReservDoble(caracter, LETRA_O, LETRA_L, 45,48);
                                    break;
                                case 45:
                                        realizarTransicionPalabraReserv(caracter, LETRA_R, 46);
                                    break;
                                case 46:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 47);
                                    break;
                                case 47:
                                        //aceptar lexema palabra reservada import
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 48:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 49);
                                    break;
                                case 49:
                                        realizarTransicionPalabraReserv(caracter, LETRA_M, 50);
                                    break;
                                case 50:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 51);
                                    break;
                                case 51:
                                        realizarTransicionPalabraReserv(caracter, LETRA_N, 52);
                                    break;
                                case 52:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 53);
                                    break;
                                case 53:
                                        realizarTransicionPalabraReserv(caracter, LETRA_S, 54);
                                    break;
                                case 54:
                                        //aceptar lexema palabra reservada implements
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 55:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 56);
                                    break;
                                case 56:
                                        realizarTransicionPalabraReservAux(caracter, LETRA_E, 57);
                                    break;
                                case 57:
                                        realizarTransicionPalabraReserv(caracter, LETRA_R, 58);
                                    break;
                                case 58:
                                        realizarTransicionPalabraReserv(caracter, LETRA_F, 59);
                                    break;
                                case 59:
                                        realizarTransicionPalabraReserv(caracter, LETRA_A, 60);
                                    break;
                                case 60:
                                        realizarTransicionPalabraReserv(caracter, LETRA_C, 61);
                                    break;
                                case 61:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 62);
                                    break;
                                case 62:
                                        //aceptar lexema palabra reservada interface
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 63:
                                        realizarTransicionPalabraReservTriple(caracter, LETRA_U,LETRA_R,LETRA_A, 64,69,82);
                                    break;
                                case 64:
                                        realizarTransicionPalabraReserv(caracter, LETRA_B, 65);
                                    break;
                                case 65:
                                        realizarTransicionPalabraReserv(caracter, LETRA_L, 66);
                                    break;
                                case 66:
                                        realizarTransicionPalabraReserv(caracter, LETRA_I, 67);
                                    break;
                                case 67:
                                        realizarTransicionPalabraReserv(caracter, LETRA_C, 68);
                                    break;
                                case 68:
                                        //aceptar lexema palabra reservada public
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 69:
                                        realizarTransicionPalabraReservDoble(caracter, LETRA_I,LETRA_O, 70,75);
                                    break;
                                case 70:
                                        realizarTransicionPalabraReserv(caracter, LETRA_V, 71);
                                    break;
                                case 71:
                                        realizarTransicionPalabraReserv(caracter, LETRA_A, 72);
                                    break;
                                case 72:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 73);
                                    break;
                                case 73:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 74);
                                    break;
                                case 74:
                                        //aceptar lexema palabra reservada private
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 75:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 76);
                                    break;
                                case 76:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 77);
                                    break;
                                case 77:
                                        realizarTransicionPalabraReserv(caracter, LETRA_C, 78);
                                    break;
                                case 78:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 79);
                                    break;
                                case 79:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 80);
                                    break;
                                case 80:
                                        realizarTransicionPalabraReserv(caracter, LETRA_D, 81);
                                    break;
                                case 81:
                                        //aceptar lexema palabra reservada protected
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 82:
                                        realizarTransicionPalabraReserv(caracter, LETRA_C, 83);
                                    break;
                                case 83:
                                        realizarTransicionPalabraReserv(caracter, LETRA_K, 84);
                                    break;
                                case 84:
                                        realizarTransicionPalabraReserv(caracter, LETRA_A, 85);
                                    break;
                                case 85:
                                        realizarTransicionPalabraReserv(caracter, LETRA_G, 86);
                                    break;
                                case 86:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 87);
                                    break;
                                case 87:
                                        //aceptar lexema palabra reservada package
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 88:
                                        realizarTransicionPalabraReservDoble(caracter, LETRA_T,LETRA_H, 89,94);
                                    break;
                                case 89:
                                        realizarTransicionPalabraReserv(caracter, LETRA_A,90);      
                                    break;
                                case 90:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 91);
                                    break;
                                case 91:
                                        realizarTransicionPalabraReserv(caracter, LETRA_I, 92);
                                    break;
                                case 92:
                                        realizarTransicionPalabraReserv(caracter, LETRA_C, 93);
                                    break;
                                case 93:
                                        //aceptar lexema palabra reservada static
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 94:
                                        realizarTransicionPalabraReserv(caracter, LETRA_O, 95);
                                    break;
                                case 95:
                                        realizarTransicionPalabraReserv(caracter, LETRA_R, 96);
                                    break;
                                case 96:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 97);
                                    break;
                                case 97:
                                        //aceptar lexema palabra reservada short
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 98:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 99);
                                    break;
                                case 99:
                                        realizarTransicionPalabraReserv(caracter, LETRA_T, 100);
                                    break;
                                case 100:
                                        realizarTransicionPalabraReserv(caracter, LETRA_U, 101);
                                    break;
                                case 101:
                                        realizarTransicionPalabraReserv(caracter, LETRA_R, 102);
                                    break;
                                case 102:
                                        realizarTransicionPalabraReserv(caracter, LETRA_N, 103);
                                    break;
                                case 103:
                                        //aceptar lexema palabra reservada return
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 104:
                                        realizarTransicionPalabraReservDoble(caracter, LETRA_H,LETRA_R,105, 108);
                                    break;
                                case 105:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 106);
                                    break;
                                case 106:
                                        realizarTransicionPalabraReserv(caracter, LETRA_N, 107);
                                    break;
                                case 107:
                                        //aceptar lexema palabra reservada then
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));                                        retrocederIndices();
                                    break;
                                case 108:
                                        realizarTransicionPalabraReserv(caracter, LETRA_U, 109);
                                    break;
                                case 109:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 110);
                                    break;
                                case 110:
                                        //aceptar lexema palabra reservada true
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 111:
                                        realizarTransicionPalabraReserv(caracter, LETRA_O, 112);
                                    break;
                                case 112:
                                        realizarTransicionPalabraReserv(caracter, LETRA_I, 113);
                                    break;
                                case 113:
                                        realizarTransicionPalabraReserv(caracter, LETRA_D, 114);
                                    break;
                                case 114:
                                        //aceptar lexema palabra reservada void
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 115:
                                        realizarTransicionPalabraReserv(caracter, LETRA_H, 116);
                                    break;
                                case 116:
                                        realizarTransicionPalabraReserv(caracter, LETRA_I, 117);
                                    break;
                                case 117:
                                        realizarTransicionPalabraReserv(caracter, LETRA_L, 118);
                                    break;
                                case 118:
                                        realizarTransicionPalabraReserv(caracter, LETRA_E, 119);
                                    break;
                                case 119:
                                        //aceptar lexema palabra reservada while
                                        aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                        ///////fin de palabras reservadas/////////
                                    break;
                                case 120://estados para un identificador
                                        realizarTransicionIdentificador(caracter);
                                    break;
                                case 121://aceptar identificador
                                        aceptarIdentificador(caracter);
                                    break;
                                case 122://estados para una literal
                                        realizarTransicionLiteral(caracter,texto);
                                    break;
                                case 123:
                                        realizarTransicionLiteral(caracter,texto);
                                    break;
                                case 124://aceptar literal
                                        aceptarLexema(LITERAL, contLinea,(contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 125://estados para comentarios de linea y de bloque
                                        realizarTransicionComentario1(caracter, texto);
                                    break;
                                case 126:
                                        realizarTransicionComentario2(caracter, texto);
                                    break;
                                case 127:
                                        realizarTransicionComentario3(caracter, texto);
                                    break;
                                case 128:
                                        realizarTransicionComentario4(caracter, texto);
                                    break;
                                case 129://aceptar comentario de bloque
                                        aceptarLexema(COMENTARIO_BLOQUE, (contLinea+1)-contBloqueComent,posicionInicialBloque);
                                        retrocederIndices();
                                        contBloqueComent=1;
                                    break;
                                case 130://estados para numero enteros y reales
                                        realizarTransicionNumeros1(caracter, texto);//estado de aceptacion 0
                                    break;
                                case 131:
                                        realizarTransicionNumeros2(caracter, texto);
                                    break;
                                case 132://estado de aceptacion operador
                                        realizarTransicionNumeros3(caracter, texto);
                                    break;
                                case 133:
                                        realizarTransicionNumeros4(caracter, texto);
                                    break;
                                case 134:
                                        realizarTransicionNumeros5(caracter, texto);
                                    break;
                                case 135://estado de aceptacion numero real
                                        realizarTransicionNumeros6(caracter, texto);
                                    break;
                                case 136://estado de aceptacion numero entero
                                        realizarTransicionNumeros7(caracter, texto);
                                    break;
                                case 137:
                                        realizarTransicionNumeros8(caracter, texto);
                                    break;
                                case 138:///estados para signos de agrupacion operadores y puntuacion
                                        aceptarLexema(SIGNO_AGRUPACION, contLinea, (contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 139:
                                        aceptarLexema(OPERADOR, contLinea, (contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                case 140:
                                        aceptarLexema(SIGNO_PUNTUACION, contLinea, (contColumna-lexema.length()));
                                        retrocederIndices();
                                    break;
                                default:
                                    throw new AssertionError();
                                    
                        }
                        contColumna++;
                }
                System.out.println("--------------------------------------------");
                if (lexemasEvaluadosValidos.size()>0) {
                        imprimirLexemas(lexemasEvaluadosValidos);
                        lexemasEvaluadosValidos.clear();
                }
//                if (lexemasEvaluadosInvalidos.size()>0) {
//                        imprimirLexemas(lexemasEvaluadosInvalidos);
//                        lexemasEvaluadosInvalidos.clear();
//                }
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
                frame.limpiarTabla();
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
                } else {
                            realizarTransicionIdentificador(caracter);
                    }
        }
         public void realizarTransicionPalabraReservAux(char caracter,char caracterComparacion, int nextEstadoPReser){
                if (caracter==caracterComparacion) {
                        realizarTransicion(nextEstadoPReser, lexema+caracter);
                } else {
                            aceptarLexema(lexema, contLinea,(contColumna-lexema.length()));
                            retrocederIndices();
                    }
        }
        public void realizarTransicionPalabraReservDoble(char caracter,char caracterComparacion,char caracterComparacion2, int nextEstadoPReser, int nextEstadoPReser2){
                if (caracter==caracterComparacion) {
                        realizarTransicion(nextEstadoPReser,lexema+caracter);
                } else if (caracter==caracterComparacion2) {
                                realizarTransicion(nextEstadoPReser2,lexema+caracter);
                                //esta siguiente parte se puede meter en un metodo para ahorrar codigo de la doble triple y cuadruple
                        } else {
                                    realizarTransicionIdentificador(caracter);
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
                                } else {
                                            realizarTransicionIdentificador(caracter);
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
                                        } else {
                                                    realizarTransicionIdentificador(caracter);
                                            }
    }
        public void realizarTransicionIdentificador(char caracter){
                if (evaluarSimbolo(LETRAS, caracter)||evaluarSimbolo(NUMEROS_1_9, caracter)
                        ||caracter==CERO||caracter==GUION||caracter==GUION_BAJO) {
                        realizarTransicion(121, lexema+caracter);
                } else {
                            reportarError((contColumna-lexema.length()), lexema, contLinea);
                    }
        }
        public void aceptarIdentificador(char caracter){
                if (evaluarSimbolo(LETRAS, caracter)||evaluarSimbolo(NUMEROS_1_9, caracter)
                        ||caracter==CERO||caracter==GUION||caracter==GUION_BAJO) {//si es letra guiones o digitos
                        realizarTransicion(121, lexema+caracter);
                } else {
                            aceptarLexema(IDENTIFICADOR, contLinea, (contColumna-lexema.length()));
                            retrocederIndices();
                    }
        }
        public void realizarTransicionLiteral(char caracter,String texto){
                if (caracter==COMILLA_DOBLE) {//si es comilla doble
                        realizarTransicion(124, lexema+caracter);
                } else if(caracter==SALTO||(texto.length()-1)==indice){// si es un salto o fin de linea sin cierre de literal
                                reportarError((contColumna-lexema.length()), lexema, contLinea);
                                contLinea++;// se aumenta para saltar de linea
                                contColumna=0;//cero ya que mas adelante se aumenta y vuelve a ser 1
                        } else {
                                    realizarTransicion(123, lexema+caracter);
                            }
        }
        public void realizarTransicionComentario1(char caracter,String texto){
                if (caracter==DIAGONAL) {//si es diagonal
                        realizarTransicion(126, lexema+caracter);
                } else if (caracter==ASTERISCO) {//si es asterisco
                                realizarTransicion(127, lexema+caracter);
                        } else if(caracter==SALTO ||(texto.length()-1)==indice){// si es un salto o fin de linea sin cierre de literal
                                        aceptarLexema(OPERADOR, contLinea,(contColumna-lexema.length())); //si es una unica diagonal se acepta como operador
                                        realizarTransicion(0, "");
                                        contLinea++;// se aumenta para saltar de linea
                                        contColumna=0;//cero ya que mas adelante se aumenta y vuelve a ser 1
                                } else {
                                            aceptarLexema(OPERADOR, contLinea,(contColumna-lexema.length())); //si es una unica diagonal se acepta como operador
                                            retrocederIndices();
                                    }
        }
        public void realizarTransicionComentario2(char caracter,String texto){
                if(caracter==SALTO ||(texto.length()-1)==indice){// si es un salto o fin de linea sin cierre de literal
                        aceptarLexema(COMENTARIO_LINEA, contLinea,(contColumna-lexema.length()));
                        realizarTransicion(0, "");
                        contLinea++;// se aumenta para saltar de linea
                        contColumna=0;//cero ya que mas adelante se aumenta y vuelve a ser 1
                } else {
                             realizarTransicion(126, lexema+caracter);
                    }
        }
        public void realizarTransicionComentario3(char caracter,String texto){
                if (caracter==ASTERISCO) {//si es un asterisco
                        realizarTransicion(128, lexema+caracter);
                } else {
                           evaluarSaltoComentarioBloque(caracter, texto);
                    }
        }
        public void realizarTransicionComentario4(char caracter,String texto){
                if (caracter==ASTERISCO) {//si es asterisco
                        realizarTransicion(128, lexema+caracter);
                } else  if (caracter==DIAGONAL) {//si es diagonal
                                realizarTransicion(129, lexema+caracter);
                        } else {
                                    evaluarSaltoComentarioBloque(caracter, texto);
                            }
        }
        public void realizarTransicionNumeros1(char caracter,String texto){
                if (caracter==PUNTO) {//si es un punto
                        realizarTransicion(137, lexema+caracter);
                } else if (caracter==CERO || evaluarSimbolo(NUMEROS_1_9, caracter)) {//si es un cero
                                realizarTransicion(131, lexema+caracter);
                        } else {    
                                    //aceptarLexEspacioSalto(caracter, NUMERO_ENTERO);
                                    aceptarLexema(NUMERO_ENTERO, contLinea, (contColumna-lexema.length()));
                                    retrocederIndices();
                            }
        }
        public void realizarTransicionNumeros2(char caracter,String texto){
                if (caracter==CERO || evaluarSimbolo(NUMEROS_1_9, caracter) ||caracter==PUNTO) {//si es un cero
                                realizarTransicion(131, lexema+caracter);
                        } else {    
                                    //reportarLexEspacioSalto(caracter, "");
                                    reportarError((contColumna-lexema.length()), lexema, contLinea);
                                    retrocederIndices();//caso especial para reconocer el salto
                            }
        }
        public void realizarTransicionNumeros3(char caracter,String texto){
                if (caracter==CERO) {//si es un cero
                        realizarTransicion(133, lexema+caracter);
                } else if(evaluarSimbolo(NUMEROS_1_9, caracter)){// si es un numero 1_9
                                realizarTransicion(136, lexema+caracter);
                        } else {    
                                    aceptarLexema(OPERADOR, contLinea, (contColumna-lexema.length()));
                                    retrocederIndices();
                            }
        }
        public void realizarTransicionNumeros4(char caracter,String texto){
                if (caracter==PUNTO) {//si es un punto
                        realizarTransicion(134, lexema+caracter);
                } else if (caracter==CERO || evaluarSimbolo(NUMEROS_1_9, caracter)) {//si es un cero
                                realizarTransicion(131, lexema+caracter);
                        }else {    
                                    //reportarLexEspacioSalto(caracter, "");
                                    reportarError((contColumna-lexema.length()), lexema, contLinea);
                                   
                            }
        }
        public void realizarTransicionNumeros5(char caracter,String texto){
                if (caracter==CERO) {//si es un punto
                        realizarTransicion(134, lexema+caracter);
                } else if(evaluarSimbolo(NUMEROS_1_9, caracter)){// si es un espacio o tab
                                realizarTransicion(135, lexema+caracter);
                        } else {    
                                    //reportarLexEspacioSalto(caracter, "");
                                    reportarError((contColumna-lexema.length()), lexema, contLinea);
                                    retrocederIndices();//caso donde se retrocede para evaluar el caracter que viene despues
                            }
        }
        public void realizarTransicionNumeros6(char caracter,String texto){
                 if (caracter==CERO || evaluarSimbolo(NUMEROS_1_9, caracter)) {//si es un punto
                        realizarTransicion(135, lexema+caracter);
                } else {    
                            //aceptarLexEspacioSalto(caracter, NUMERO_DECIMAL);
                            aceptarLexema(NUMERO_DECIMAL, contLinea, (contColumna-lexema.length()));
                            retrocederIndices();
                    }
        }
        public void realizarTransicionNumeros7(char caracter,String texto){
                 if (caracter==PUNTO) {//si es un punto
                        realizarTransicion(137, lexema+caracter);
                } else if (caracter==CERO || evaluarSimbolo(NUMEROS_1_9, caracter)) {//si es un punto
                                realizarTransicion(136, lexema+caracter);
                        } else {    
                                    aceptarLexema(NUMERO_ENTERO, contLinea, (contColumna-lexema.length()));
                                    retrocederIndices();
                            }
        }
        public void realizarTransicionNumeros8(char caracter,String texto){
                if (caracter==CERO || evaluarSimbolo(NUMEROS_1_9, caracter)) {//si es un punto
                        realizarTransicion(135, lexema+caracter);
                } else {    
                              //reportarLexEspacioSalto(caracter, "");
                              reportarError((contColumna-lexema.length()), lexema, contLinea);
                    }
        }
        public void evaluarSaltoComentarioBloque(char caracter,String texto){
                if(caracter==SALTO){// si es un salto o fin de linea sin cierre de literal
                        realizarTransicion(127, lexema+caracter);
                        contLinea++;// se aumenta para saltar de linea
                        contColumna=0;//cero ya que mas adelante se aumenta y vuelve a ser 1
                        contBloqueComent++;
                } else if((texto.length()-1)==indice){// si llega al fin de linea y nunca se cerro el comentario
                                reportarError(posicionInicialBloque, lexema, (contLinea+1)-contBloqueComent);
                        } else {
                                    realizarTransicion(127, lexema+caracter);//sigue en el mismo estado esperando asterisco
                            }
        }
        //metodo para evaluar espacios y saltos y aceptar lexemas correctos
        public void aceptarLexEspacioSalto(char caracter,String token){            
                if(caracter==ESPACIO || caracter==TAB){// si es un espacio o tab
                        aceptarLexema(token, contLinea,(contColumna-lexema.length()));
                        retrocederIndices();
                } else if(caracter==SALTO){// si es un salto
                                aceptarLexema(token, contLinea,(contColumna-lexema.length()));
                                realizarTransicion(0, "");
                                contLinea++;// se aumenta para saltar de linea
                                contColumna=0;//cero ya que mas adelante se aumenta y vuelve a ser 1
                        } else {    
                                    aceptarLexema(token, contLinea,(contColumna-lexema.length()));
                                    reportarError(contColumna, lexema, contLinea);
                            } 
        }
        //metodo para evaluar espacios y saltos y reportar errores lexicos
        public void reportarLexEspacioSalto(char caracter,String token){            
                if(caracter==ESPACIO || caracter==TAB){// si es un espacio o tab
                                reportarError(contColumna, lexema, contLinea);
                } else if(caracter==SALTO){// si es un salto
                                reportarError(contColumna, lexema, contLinea);
                                //CUANDO ES UN SALTO NO DISMINUIMOS EL INDICE GENERAL PORQUE ESTE TIENE QUE SEGUIR SU CURSO
                                //Y ASI PUEDE PASAR AL CARACTER QUE VIENE ENSEGUIDA DEL SALTO DE LINEA ESTO SE HACE EN TODOS
                                //LOS ESTADOS DE TODO EL AUTOMATA SALVO CASOS ESPECIALES EN DONDE SE INDIQUE LO CONTRARIO
                                contLinea++;// se aumenta para saltar de linea
                                contColumna=0;//cero ya que mas adelante se aumenta y vuelve a ser 1
                        } else {    
                                    reportarError(contColumna, lexema, contLinea);
                            } 
        }
        public void aceptarLexema(String token,int numeroFila,int numeroColumna){            
                lexemasEvaluadosValidos.add(new Lexema(lexema, token, numeroFila,numeroColumna));   
        }
        public void retrocederIndices(){            
                realizarTransicion(0, "");//se reinicia el estado y el lexema
                contColumna--;
                indice--;// se retrocede el indice y el contador de columna para empezar a evaluar un nuevo lexema     
        }  
        public void reportarError(int columna,String error,int numeroDeFila){
                System.out.println("Error Lexico : "+error+"  Fila: "+numeroDeFila+" Columna: "+columna);
                realizarTransicion(0, "");//se reinicia el automata
        }
       
    
}
