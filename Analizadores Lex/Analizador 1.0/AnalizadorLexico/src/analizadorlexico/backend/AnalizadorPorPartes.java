/*
 * annaliza diferentes tokenes
 */
package analizadorlexico.backend;

import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class AnalizadorPorPartes {
    
        //listas a utilizar en el analisis
        private ArrayList<String> errores;
        private ArrayList<String> lexemas;
        private ArrayList<String> tokens;
        //variaables y constantes necesarias
        private int indice;
        private int estado;
        private String lexema;
        private boolean aceptar;
        private boolean comentBloque=false;
        private int contLineas;
        private int numeroLineas;
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
        public static final char[] OPERADORES={'+','%','-','*','/'};
        public static final char CERO='0';
        public static final char ESPACIO=' ';
        public static final char TAB='\t';
        public static final char COMILLA_DOBLE='\"';
        public static final char COMILLA_SIMPLE='\'';
       
        public static final char DIAGONAL='/';
        public static final char ASTERISCO='*';
        public static final char SIGNO_POSITIVO='+';
        public static final char SIGNO_NEGATIVO='-';
        public static final char PUNTO='.';
        public static final char GUION_BAJO='_';
        public static final char GUION='-';
      
        public AnalizadorPorPartes(){
                this.errores= new ArrayList();
                this.lexemas= new ArrayList();
                this.tokens= new ArrayList(); 
        
        }
        public void iniciarMiembros(){             
                this.indice=0;
                this.estado=0;
                this.contLineas=0;
               
                this.lexema="";
                this.aceptar=true;
        }
        //evaluamos numeros enteros con y sin signo
        public void analizarNumeros(String texto,int numeroDeFila){
                iniciarMiembros();
                char caracter;
                for (indice = 0; indice < texto.length(); indice++) {
                        caracter= texto.charAt(indice);
                        //evaluacion de estados para el determinado automata
                        switch (estado) {
                                case 0:
                                        if (evaluarSimbolo(NUMEROS_1_9, caracter)) {// si es un numero se posiciona en el estado 3
                                                realizarTransicion(3, ""+caracter);
                                        } else if(caracter==SIGNO_POSITIVO || caracter==SIGNO_NEGATIVO){// si es un signo se posiciona en el estado 2
                                                        realizarTransicion(2, ""+caracter);
                                                } else if(caracter==CERO){// si es un cero se posiciona en el estado 1
                                                                realizarTransicion(1, ""+caracter);
                                                        } else if(caracter==ESPACIO || caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                                        realizarTransicion(0, "");
                                                                } else{
                                                                        reportarError(indice, caracter, numeroDeFila,0);
                                                                    }
                            
                                    break;
                                case 1:
                                        if(caracter==ESPACIO || caracter==TAB){ //si caracter es espacio que indica la separacion de palabras    
                                                if (aceptar) {
                                                        aceptarLexema();
                                                } else {
                                                        rechazarLexema();
                                                }
                                        } else if(caracter==PUNTO){// si es un punto se posiciona en el estado 4
                                                        realizarTransicion(4, lexema+caracter);
                                                } else{
                                                        reportarError(indice, caracter, numeroDeFila,1);
                                                        aceptar=false;
                                                    }
                            
                                    break;
                                case 2:
                                        if(evaluarSimbolo(NUMEROS_1_9, caracter)){// si es un numero se posiciona en el estado 3
                                                realizarTransicion(3, lexema+caracter);
                                        } else if(caracter==CERO){
                                                        realizarTransicion(1, lexema+caracter);// si es un cero se posiciona en el estado 1
                                                } else{
                                                        reportarError(indice, caracter, numeroDeFila,2);
                                                        aceptar=false;
                                                    }
                                    break;
                                case 3:
                                        if (caracter==ESPACIO || caracter==TAB) {// si es un espacio o tab se llega a aceptar la cadena
                                                if (aceptar) {
                                                        aceptarLexema();
                                                } else {
                                                        rechazarLexema();
                                                }                                         
                                        } else if(evaluarSimbolo(NUMEROS_1_9, caracter)|| caracter==CERO){// si es un numero o un cero se posiciona en el estado 3
                                                        realizarTransicion(3, lexema+caracter);
                                                } else if(caracter==PUNTO){// si es un punto se posiciona en el estado 4
                                                                realizarTransicion(4, lexema+caracter);
                                                        } else{
                                                                reportarError(indice, caracter, numeroDeFila,3);
                                                                aceptar=false;
                                                            }
                            
                                    break;
                                case 4:
                                        if (caracter==ESPACIO || caracter==TAB) {// si es un espacio o tab se rechaza la cadena
                                                rechazarLexema();
                                        } else if(evaluarSimbolo(NUMEROS_1_9, caracter)|| caracter==CERO){// si es un numero o un cero se posiciona en el estado 5
                                                        realizarTransicion(5, lexema+caracter);
                                                } else{
                                                        reportarError(indice, caracter, numeroDeFila,4);
                                                        aceptar=false;
                                                    }
                            
                                    break;
                                case 5:
                                        if (caracter==ESPACIO || caracter==TAB) {// si es un esacio o tab se llega a aceptar la cadena
                                                if (aceptar) {
                                                        aceptarLexema();
                                                } else {
                                                        rechazarLexema();
                                                }
                                        } else if(evaluarSimbolo(NUMEROS_1_9, caracter)|| caracter==CERO){// si es un numero o un cero se posiciona en el estado 5
                                                        realizarTransicion(5, lexema+caracter);
                                                } else{
                                                        reportarError(indice, caracter, numeroDeFila,5);
                                                        aceptar=false;
                                                    }
                            
                                    break;
                                default:
                                    throw new AssertionError();
                        }
                        
                       
                }
                System.out.println("--------------------------------------------");
                if (lexemas.size()>0) {
                        imprimirLexemas();
                        lexemas.clear();
                }
                if (errores.size()>0) {
                        imprimirErrores();
                        errores.clear();
                }
                
        }
        public void analizarLiteral(String texto,int numeroDeFila){
                iniciarMiembros();
                char caracter;
                for (indice = 0; indice < texto.length(); indice++) {
                        caracter= texto.charAt(indice);
                        //evaluacion de estados para el determinado automata
                        switch (estado) {
                                case 0:
                                        if (caracter==COMILLA_DOBLE) {// si es un una comilla se posiciona en el estado 1
                                                realizarTransicion(1, lexema+caracter);
                                        } else if(caracter==ESPACIO || caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(0, "");
                                                } else{
                                                        reportarError(indice, caracter, numeroDeFila,0);
                                                        aceptar=false;
                                                    }
                                    break;
                                case 1:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio y llega al final de linea  
                                                rechazarLexema();
                                        } else if(caracter==ESPACIO ||caracter==TAB){ //si es espacio se posicion a en estado 4  
                                                        realizarTransicion(4, lexema+caracter);
                                                } else{
                                                        realizarTransicion(2, lexema+caracter); //cualquier caracter
                                                    }

                                    break;
                                case 2:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                rechazarLexema();
                                        } else if(caracter==COMILLA_DOBLE){ //si letra, digito, guion bajo o guion medio se posicion a en estado 2     
                                                        realizarTransicion(3, lexema+caracter);
                                                } else{
                                                        realizarTransicion(2, lexema+caracter); //cualquier caracter
                                                    }
                            
                                        
                                    break;
                                case 3:
                                        if (caracter==ESPACIO || caracter==TAB) {// si es un espacio o tab se llega a aceptar la cadena
                                                if (aceptar) {
                                                        aceptarLexemaPalabraReserv();
                                                } else {
                                                        rechazarLexema();
                                                }
                                        } else{
                                                reportarError(indice, caracter, numeroDeFila,3);
                                                aceptar=false;
                                            }
                                        
                                    break;
                                case 4:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                rechazarLexema();
                                        } else if(caracter==ESPACIO ||caracter==TAB){ //si letra, digito, guion bajo o guion medio se posicion a en estado 2     
                                                        realizarTransicion(4, lexema+caracter);
                                                } else{
                                                        realizarTransicion(2, lexema+caracter); //cualquier caracter
                                                    }
                            
                                        
                                    break;
                                
                                default:
                                    throw new AssertionError();
                        }
                        
                       
                }
                System.out.println("--------------------------------------------");
                if (lexemas.size()>0) {
                        imprimirLexemas();
                        lexemas.clear();
                }
                if (errores.size()>0) {
                        imprimirErrores();
                        errores.clear();
                }
                
            
        }
         public void analizarIdentificador(String texto,int numeroDeFila){
                iniciarMiembros();
                char caracter;
                for (indice = 0; indice < texto.length(); indice++) {
                        caracter= texto.charAt(indice);
                        //evaluacion de estados para el determinado automata
                        switch (estado) {
                                case 0:
                                        if (evaluarSimbolo(LETRAS, caracter)) {// si es un una letra o un guion bajo se posiciona en el estado 1
                                                realizarTransicion(1, lexema+caracter);
                                        } else if(caracter==GUION_BAJO){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(2, lexema+caracter);
                                                } else if(caracter==ESPACIO || caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                                realizarTransicion(0, "");
                                                        } else{
                                                                reportarError(indice, caracter, numeroDeFila,0);
                                                                aceptar=false;
                                                            }
                                    break;
                                case 1:
                                        if(evaluarSimbolo(LETRAS, caracter)||evaluarSimbolo(NUMEROS_1_9, caracter)
                                                ||caracter==CERO||caracter==GUION||caracter==GUION_BAJO){ //si letra, digito, guion bajo o guion medio se posicion a en estado 2  
                                                realizarTransicion(1, lexema+caracter);
                                        } else if (caracter==ESPACIO || caracter==TAB) {// si es un espacio o tab se llega a aceptar la cadena
                                                        if (aceptar) {
                                                                aceptarLexemaPalabraReserv();
                                                        } else {
                                                                rechazarLexema();
                                                        }
                                                } else {//otro simbolo
                                                        reportarError(indice, caracter, numeroDeFila,1);
                                                        aceptar=false;
                                                    }
                            
                                    break;
                                 case 2:
                                        if (evaluarSimbolo(LETRAS, caracter) ||evaluarSimbolo(NUMEROS_1_9, caracter)
                                                ||caracter==CERO) {// si es un una letra o un guion bajo se posiciona en el estado 1
                                                realizarTransicion(1, lexema+caracter);
                                        } else if(caracter==GUION_BAJO||caracter==GUION){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(2, lexema+caracter);
                                                } else if(caracter==ESPACIO || caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                                rechazarLexema();
                                                        } else{
                                                                reportarError(indice, caracter, numeroDeFila,2);
                                                                aceptar=false;
                                                            }
                                    break;
                                
                                default:
                                    throw new AssertionError();
                        }
                        
                       
                }
                System.out.println("--------------------------------------------");
                if (lexemas.size()>0) {
                        imprimirLexemas();
                        lexemas.clear();
                }
                if (errores.size()>0) {
                        imprimirErrores();
                        errores.clear();
                }
                
            
        }
         public void analizarComentarioSimple(String texto,int numeroDeFila){
                iniciarMiembros();
                char caracter;
                for (indice = 0; indice < texto.length(); indice++) {
                        caracter= texto.charAt(indice);
                        //evaluacion de estados para el determinado automata
                        switch (estado) {
                                case 0:
                                        if (caracter==DIAGONAL) {// si es un una diagonal se posiciona en el estado 1
                                                realizarTransicion(1, lexema+caracter);
                                        } else if(caracter==ESPACIO || caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(0, "");
                                                } else{
                                                        reportarError(indice, caracter, numeroDeFila,0);
                                                        aceptar=false;
                                                    }
                                    break;
                                case 1:
                                        if(caracter==DIAGONAL){ //si es otra diagonal se posiciona en estado 2 
                                                realizarTransicion(2, lexema+caracter);
                                        } else{
                                                reportarError(indice, caracter, numeroDeFila,2);
                                                aceptar=false;
                                            }

                                    break;
                                case 2:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                if (aceptar) {
                                                        aceptarLexemaPalabraReserv();
                                                } else {
                                                        rechazarLexema();
                                                }
                                        } else{//cualquier simbolo
                                                        realizarTransicion(2, lexema+caracter); //cualquier caracter
                                                    }
                            
                                        
                                    break;
                               
                                
                                default:
                                    throw new AssertionError();
                        }
                        
                       
                }
                System.out.println("--------------------------------------------");
                if (lexemas.size()>0) {
                        imprimirLexemas();
                        lexemas.clear();
                }
                if (errores.size()>0) {
                        imprimirErrores();
                        errores.clear();
                }
                /**/
            
        }
         public void analizarComentarioDeBloque(String texto,int numeroDeFila){
                if (comentBloque==false) {
                    iniciarMiembros();
                }
                char caracter;
                for (indice = 0; indice < texto.length(); indice++) {
                        caracter= texto.charAt(indice);
                        //evaluacion de estados para el determinado automata
                        switch (estado) {
                                case 0:
                                        if (caracter==DIAGONAL) {// si es un una diagonal se posiciona en el estado 1
                                                realizarTransicion(1, lexema+caracter);
                                        } else if(caracter==ESPACIO || caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(0, "");
                                                } else{
                                                        reportarError(indice, caracter, numeroDeFila,0);
                                                        aceptar=false;
                                                    }
                                    break;
                                case 1:
                                        if(caracter==ASTERISCO){ //si es un asterisco se posiciona en estado 2 
                                                realizarTransicion(2, lexema+caracter);
                                        } else{
                                                reportarError(indice, caracter, numeroDeFila,1);
                                                aceptar=false;
                                            }

                                    break;
                                case 2:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                realizarTransicion(3, lexema+caracter+"\n");
                                                comentBloque=true;
                                        } else if(caracter==ASTERISCO){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(3, lexema+caracter);
                                                }else{//cualquier simbolo
                                                        realizarTransicion(2, lexema+caracter); //cualquier caracter
                                                    }
                            
                                        
                                    break;
                                case 3:
                                        if((caracter==ESPACIO || caracter==TAB) && (texto.length()-1)==indice){ //si es un espacio se posiciona en estado 2  
                                                realizarTransicion(3, lexema+caracter+"\n");
                                                comentBloque=true;
                                        } else if(caracter==ASTERISCO){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(3, lexema+caracter);
                                                } else if(caracter==DIAGONAL){// si es espacio o tab se posiciona en el estado 0
                                                                realizarTransicion(4, lexema+caracter);
                                                                //aceptar=true;
                                                        }else{//cualquier simbolo
                                                                realizarTransicion(2, lexema+caracter); //cualquier caracter
                                                                //aceptar=false;
                                                            }
                            
                                        
                                    break;
                                case 4:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es un espacio se posiciona en estado 2  
                                                if (aceptar) {
                                                        aceptarLexemaPalabraReserv();
                                                } else {
                                                        rechazarLexema();
                                                }
                                                comentBloque=false;
                                        } else{//cualquier simbolo
                                                        reportarError(indice, caracter, numeroDeFila,4);
                                                        //aceptar=false;
                                                    }
                            
                                        
                                    break;
                               
                                
                                default:
                                    throw new AssertionError();
                        }
                        contLineas++;
                       
                }
                System.out.println("--------------------------------------------");
                if (lexemas.size()>0) {
                        imprimirLexemas();
                        lexemas.clear();
                }
                if (errores.size()>0) {
                        imprimirErrores();
                        errores.clear();
                }
                /**/
            
        }
         public void analizarUnCaracter(String texto,int numeroDeFila){
                iniciarMiembros();
                char caracter;
                for (indice = 0; indice < texto.length(); indice++) {
                        caracter= texto.charAt(indice);
                        //evaluacion de estados para el determinado automata
                        switch (estado) {
                                case 0:
                                        if (evaluarSimbolo(SIGNOS_AGRUPACION, caracter)) {// si es un una diagonal se posiciona en el estado 1
                                                realizarTransicion(1, lexema+caracter+" Signo de Agrupacion");
                                        } else if(evaluarSimbolo(SIGNOS_PUNTUACION, caracter)){// si es espacio o tab se posiciona en el estado 0
                                                        realizarTransicion(2,  lexema+caracter+" Signo de Puntuacion");
                                                } else if(evaluarSimbolo(OPERADORES, caracter)){// si es espacio o tab se posiciona en el estado 0
                                                                realizarTransicion(3,  lexema+caracter+" Signo de Operacion");
                                                        } else if(evaluarSimbolo(LETRAS, caracter)){// si es espacio o tab se posiciona en el estado 0
                                                                        realizarTransicion(4,  lexema+caracter+" Identificador");
                                                                } else if(caracter==ESPACIO||caracter==TAB){// si es espacio o tab se posiciona en el estado 0
                                                                                realizarTransicion(0,"");
                                                                        } else{
                                                                                reportarError(indice, caracter, numeroDeFila,0);
                                                                            }
                                    break;
                                case 1:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es otra diagonal se posiciona en estado 2 
                                                aceptarLexema();
                                        }
                                    break;
                                case 2:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es otra diagonal se posiciona en estado 2 
                                                aceptarLexema();
                                        }
                                    break;
                                case 3:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es otra diagonal se posiciona en estado 2 
                                                aceptarLexema();
                                        } 
                                    break;
                                case 4:
                                        if(caracter==ESPACIO || caracter==TAB){ //si es otra diagonal se posiciona en estado 2 
                                                aceptarLexema();
                                        } 
                                    break;
                               
                                
                                default:
                                    throw new AssertionError();
                        }
                        
                       
                }
                System.out.println("--------------------------------------------");
                if (lexemas.size()>0) {
                        imprimirLexemas();
                        lexemas.clear();
                }
                if (errores.size()>0) {
                        imprimirErrores();
                        errores.clear();
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
        public void imprimirLexemas(){
                for (int i = 0; i < lexemas.size(); i++) {
                        System.out.println(lexemas.get(i));
                }
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
        public void aceptarLexema(){
                lexemas.add("Lexema Valido: "+lexema);//se agrega el lexema
                realizarTransicion(0, "");//se reinicia el estado y el lexema
                indice--;// se retrocede el indice para empezar a evaluar un nuevo lexema     
        }
        public void aceptarLexemaPalabraReserv(){
                boolean encontrada=false;
                int cont =0;
                while(encontrada==false && cont<PALABRAS_RESERVADAS.length){
                        if (lexema.equals(PALABRAS_RESERVADAS[cont])) {
                                encontrada=true;
                        }
                        cont++;
                }
                if (encontrada) {
                        lexemas.add("Lexema Valido Palabra reservada: "+lexema);//se agrega el lexema
                        realizarTransicion(0, "");//se reinicia el estado y el lexema
                        indice--;// se retrocede el indice para empezar a evaluar un nuevo lexema   
                } else{
                        lexemas.add("Lexema Valido: "+lexema);//se agrega el lexema
                        realizarTransicion(0, "");//se reinicia el estado y el lexema
                        indice--;// se retrocede el indice para empezar a evaluar un nuevo lexema     
                }
                
        }
        public void rechazarLexema(){
                lexemas.add("Lexema Invalido: "+lexema);//se agrega el lexema
                realizarTransicion(0, "");//se reinicia el estado y el lexema
                indice--;// se retrocede el indice para empezar a evaluar un nuevo lexema     
        }
        public void reportarError(int indice,char caracter,int numeroDeFila,int estActual){
                System.out.println("Error Lexico en Simbolo: "+caracter+"  Fila: "+numeroDeFila+" Columna: "+(indice+1));
                estado=estActual;
                lexema=lexema+caracter;
                errores.add(""+caracter);
        }

        public int getNumeroLineas() {
            return numeroLineas;
        }

        public void setNumeroLineas(int numeroLineas) {
            this.numeroLineas = numeroLineas;
        }
}
