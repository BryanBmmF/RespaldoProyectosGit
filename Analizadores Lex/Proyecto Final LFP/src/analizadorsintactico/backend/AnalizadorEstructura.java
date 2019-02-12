/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorsintactico.backend;

import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class AnalizadorEstructura {
        public void evaluarEstructuraEscritura(ArrayList<Lexem> lista){
            
                //implmentar un modo panico si se llega a encontrar con un error y seguir normal terminando de 
                //evaluar los tokens de la escritura y luego si esta activado el modo panico
                // tomar como incorrecta toda la estructura
                System.out.println(""+lista.size());
                AlfabetoPila simboloAux = null;
                Token tokenAux = null;
                AlfabetoPila simboloCimaPila;
                Lexem nextToken;
                int entrada=0;
                Pila pila = new Pila();
                pila.apilar(simboloAux.Z0);
                pila.apilar(simboloAux.S0);
                
                while (pila.cima()!=simboloAux.Z0 || entrada<lista.size()) {
                        simboloCimaPila = (AlfabetoPila)pila.cima();
                        nextToken= lista.get(entrada);
                        switch (simboloCimaPila) {
                                case S0:
                                        if (nextToken.getToken()== tokenAux.ESCRIBIR) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S1);
                                                pila.apilar(simboloAux.ESCRIBIR);
                                                entrada--;//el indice de entrada no avanza
                                        }

                                        break;
                                case S1:
                                        if (nextToken.getToken()==tokenAux.LITERAL) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S2);
                                                pila.apilar(simboloAux.LITERAL);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.NUMERO) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.S2);
                                                        pila.apilar(simboloAux.NUMERO);
                                                        entrada--;//el indice de entrada no avanza
                                                } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                                pila.desapilar();
                                                                pila.apilar(simboloAux.S2);
                                                                pila.apilar(simboloAux.IDENTIFICADOR);
                                                                entrada--;//el indice de entrada no avanza
                                                        }
                                        
                                        break;
                                case S2:
                                        if (nextToken.getToken()==tokenAux.FIN) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.FIN);
                                                entrada--;//el indice de entrada no avanza
                                        }
                                        
                                        break;
                                        //SE DESAPILAN LOS SIMBOLOS TERMINALES
                                case ESCRIBIR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case FIN:
                                        pila.desapilar();
                                        //el indice de entrada avanza   
                                        break;
                                case LITERAL:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case NUMERO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case IDENTIFICADOR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                default:
                                        throw new AssertionError();
                        }
                        entrada++;
                }
                if (pila.cima()==simboloAux.Z0) {
                        System.out.println("La estructura escritura es completamente correcta");
                        pila.desapilar();
                } else {
                        System.out.println("La estructura escritura no es correcta");
                    }
        }
        public void evaluarEstructuraRepetir(ArrayList<Lexem> lista){
            
                //implmentar un modo panico si se llega a encontrar con un error y seguir normal terminando de 
                //evaluar los tokens de la escritura y luego si esta activado el modo panico
                // tomar como incorrecta toda la estructura
                System.out.println(""+lista.size());
                AlfabetoPila simboloAux = null;
                Token tokenAux = null;
                AlfabetoPila simboloCimaPila;
                Lexem nextToken;
                int entrada=0;
                Pila pila = new Pila();
                pila.apilar(simboloAux.Z0);
                pila.apilar(simboloAux.S0);
                
                while (pila.cima()!=simboloAux.Z0 || entrada<lista.size()) {
                        simboloCimaPila = (AlfabetoPila)pila.cima();
                        nextToken= lista.get(entrada);
                        switch (simboloCimaPila) {
                                case S0:
                                        if (nextToken.getToken()== tokenAux.REPETIR) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S1);
                                                pila.apilar(simboloAux.REPETIR);
                                                entrada--;//el indice de entrada no avanza
                                        }

                                        break;
                                case S1:
                                        if (nextToken.getToken()==tokenAux.NUMERO) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S2);
                                                //pila.apilar(simboloAux.INICIAR);
                                                pila.apilar(simboloAux.NUMERO);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.S2);
                                                        //pila.apilar(simboloAux.INICIAR);
                                                        pila.apilar(simboloAux.IDENTIFICADOR);
                                                        entrada--;//el indice de entrada no avanza
                                                } 
                                        
                                        break;
                                case S2:
                                        if (nextToken.getToken()==tokenAux.INICIAR) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S3);
                                                pila.apilar(simboloAux.INICIAR);
                                                entrada--;//el indice de entrada no avanza
                                        }
                                        
                                        break;
                                case S3:
                                        if (nextToken.getToken()==tokenAux.ESCRIBIR) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S4);
                                                pila.apilar(simboloAux.ESCRIBIR);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.FIN) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.FIN);
                                                        entrada--;//el indice de entrada no avanza
                                                }
                                        
                                        break;
                                case S4:
                                        if (nextToken.getToken()==tokenAux.LITERAL) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S5);
                                                pila.apilar(simboloAux.LITERAL);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.NUMERO) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.S5);
                                                        pila.apilar(simboloAux.NUMERO);
                                                        entrada--;//el indice de entrada no avanza
                                                } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                                pila.desapilar();
                                                                pila.apilar(simboloAux.S5);
                                                                pila.apilar(simboloAux.IDENTIFICADOR);
                                                                entrada--;//el indice de entrada no avanza
                                                        }
                                        break;
                                case S5:
                                        if (nextToken.getToken()==tokenAux.FIN) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S6);
                                                pila.apilar(simboloAux.FIN);
                                                entrada--;//el indice de entrada no avanza
                                        }
                                        
                                        break;
                                 case S6:
                                        if (nextToken.getToken()==tokenAux.ESCRIBIR) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S4);
                                                pila.apilar(simboloAux.ESCRIBIR);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.FIN) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.FIN);
                                                        entrada--;//el indice de entrada no avanza
                                                }
                                        
                                        break;
                                        //SE DESAPILAN LOS SIMBOLOS TERMINALES
                                case REPETIR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case ESCRIBIR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case FIN:
                                        pila.desapilar();
                                        //el indice de entrada avanza   
                                        break;
                                case INICIAR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case NUMERO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case IDENTIFICADOR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case LITERAL:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                default:
                                        throw new AssertionError();
                        }
                        entrada++;
                }
                if (pila.cima()==simboloAux.Z0) {
                        System.out.println("La estructura Repetir es completamente correcta");
                        pila.desapilar();
                } else {
                        System.out.println("La estructura Repetir no es correcta");
                    }
        }
        
        public void evaluarEstructuraCondicional(ArrayList<Lexem> lista){
            
                //implmentar un modo panico si se llega a encontrar con un error y seguir normal terminando de 
                //evaluar los tokens de la escritura y luego si esta activado el modo panico
                // tomar como incorrecta toda la estructura
                System.out.println(""+lista.size());
                AlfabetoPila simboloAux = null;
                Token tokenAux = null;
                AlfabetoPila simboloCimaPila;
                Lexem nextToken;
                Lexem nextTokenAux;
                int entrada=0;
                Pila pila = new Pila();
                pila.apilar(simboloAux.Z0);
                pila.apilar(simboloAux.S0);
                
                while (pila.cima()!=simboloAux.Z0 || entrada<lista.size()) {
                        simboloCimaPila = (AlfabetoPila)pila.cima();
                        nextToken= lista.get(entrada);
                        switch (simboloCimaPila) {
                                case S0:
                                        if (nextToken.getToken()== tokenAux.SI) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S1);
                                                pila.apilar(simboloAux.SI);
                                                entrada--;//el indice de entrada no avanza
                                        }

                                        break;
                                case S1:
                                        if (nextToken.getToken()==tokenAux.VERDADERO) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S2);
                                                pila.apilar(simboloAux.VERDADERO);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.FALSO) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.S2);
                                                        pila.apilar(simboloAux.FALSO);
                                                        entrada--;//el indice de entrada no avanza
                                                } 
                                       
                                        
                                        break;
                                 case S2: 
                                        if (nextToken.getToken()==tokenAux.ENTONCES) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S3);
                                                pila.apilar(simboloAux.ENTONCES);
                                                entrada--;//el indice de entrada no avanza
                                        } 
                                        break;
                                case S3: 
                                        if (nextToken.getToken()==tokenAux.ESCRIBIR) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S4);
                                                pila.apilar(simboloAux.ESCRIBIR);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.FIN) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.FIN);
                                                        entrada--;//el indice de entrada no avanza
                                                }
                                        break;
                                case S4:
                                        if (nextToken.getToken()==tokenAux.LITERAL) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S5);
                                                pila.apilar(simboloAux.LITERAL);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.NUMERO) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.S5);
                                                        pila.apilar(simboloAux.NUMERO);
                                                        entrada--;//el indice de entrada no avanza
                                                } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                                pila.desapilar();
                                                                pila.apilar(simboloAux.S5);
                                                                pila.apilar(simboloAux.IDENTIFICADOR);
                                                                entrada--;//el indice de entrada no avanza
                                                        }
                                        break;
                                case S5:
                                        if (nextToken.getToken()==tokenAux.FIN) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S6);
                                                pila.apilar(simboloAux.FIN);
                                                entrada--;//el indice de entrada no avanza
                                        }
                                        
                                        break;
                                 case S6:
                                        if (nextToken.getToken()==tokenAux.FIN) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.FIN);
                                                entrada--;//el indice de entrada no avanza
                                        }
                                        break;
                                        //SE DESAPILAN LOS SIMBOLOS TERMINALES
                                case SI:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case VERDADERO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case FALSO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case ENTONCES:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case ESCRIBIR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case FIN:
                                        pila.desapilar();
                                        //el indice de entrada avanza   
                                        break;
                                case NUMERO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case IDENTIFICADOR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case LITERAL:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                default:
                                        throw new AssertionError();
                        }
                        entrada++;
                }
                if (pila.cima()==simboloAux.Z0) {
                        System.out.println("La estructura Condicional es completamente correcta");
                        pila.desapilar();
                } else {
                        System.out.println("La estructura Condicional no es correcta");
                    }
        }
         public void evaluarEstructuraExpresion(ArrayList<Lexem> lista){
            
                //implmentar un modo panico si se llega a encontrar con un error y seguir normal terminando de 
                //evaluar los tokens de la escritura y luego si esta activado el modo panico
                // tomar como incorrecta toda la estructura
                System.out.println(""+lista.size());
                AlfabetoPila simboloAux = null;
                Token tokenAux = null;
                AlfabetoPila simboloCimaPila;
                Lexem nextToken;
                Lexem nextTokenAux;
                int entrada=0;
                Pila pila = new Pila();
                pila.apilar(simboloAux.Z0);
                pila.apilar(simboloAux.S0);
                
                while (pila.cima()!=simboloAux.Z0 || entrada<lista.size()) {
                        simboloCimaPila = (AlfabetoPila)pila.cima();
                        
                        switch (simboloCimaPila) {
                                case S0: {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.E);
                                        entrada--;//el indice de entrada no avanza
                                        
                                        break;
                                }
                                case E: {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.E2);
                                        pila.apilar(simboloAux.T);
                                        entrada--;//el indice de entrada no avanza
                                        
                                        break;
                                }
                                case E2: { 
                                         if (entrada==lista.size()) {//a llegado EOF y ahun no esta Z0 en la cima de la pila
                                                entrada--; //la entrada no avanza mas
                                                pila.desapilar();
                                        } else {
                                                nextToken= lista.get(entrada);
                                                if (nextToken.getToken()==tokenAux.SUMA) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.E2);
                                                        pila.apilar(simboloAux.T);
                                                        pila.apilar(simboloAux.SUMA);
                                                        entrada--;//el indice de entrada no avanza
                                                } else {
                                                            pila.desapilar();
                                                            entrada--;//el indice de entrada no avanza
                                                    }
                                         
                                            }
                                        break;
                                }
                                case T: {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.T2);
                                        pila.apilar(simboloAux.F);
                                        entrada--;//el indice de entrada no avanza
                                        break;
                                }      
                                case T2: {
                                        if (entrada==lista.size()) {//a llegado EOF y ahun no esta Z0 en la cima de la pila
                                                entrada--; //la entrada no avanza mas
                                                pila.desapilar();
                                        } else{
                                                nextToken= lista.get(entrada);
                                                if (nextToken.getToken()==tokenAux.MULTIPLICACION) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.T2);
                                                        pila.apilar(simboloAux.F);
                                                        pila.apilar(simboloAux.MULTIPLICACION);
                                                        entrada--;//el indice de entrada no avanza
                                                } else {
                                                            pila.desapilar();
                                                            entrada--;//el indice de entrada no avanza
                                                    }
                                        
                                        }
                                       
                                        break;
                                }
                                case F: {
                                        nextToken= lista.get(entrada);
                                        if (nextToken.getToken()==tokenAux.PARENTESIS_IZQUIERDO) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.PARENTESIS_DERECHO);
                                                pila.apilar(simboloAux.E);
                                                pila.apilar(simboloAux.PARENTESIS_IZQUIERDO);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.IDENTIFICADOR);
                                                        entrada--;//el indice de entrada no avanza
                                                } else if (nextToken.getToken()==tokenAux.NUMERO) {
                                                                pila.desapilar();
                                                                pila.apilar(simboloAux.NUMERO);
                                                                entrada--;//el indice de entrada no avanza
                                                        }
                                         break;
                                }
                                        //SE DESAPILAN LOS SIMBOLOS TERMINALES
                                case SUMA:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case MULTIPLICACION:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case PARENTESIS_IZQUIERDO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case PARENTESIS_DERECHO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case NUMERO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case IDENTIFICADOR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                default:
                                        throw new AssertionError();
                        }
                        entrada++;
                }
                if (pila.cima()==simboloAux.Z0) {
                        System.out.println("La estructura EXpresion es completamente correcta");
                        pila.desapilar();
                } else {
                        System.out.println("La estructura Expresion no es correcta");
                    }
        }
        public void evaluarEstructuraAsignacion(ArrayList<Lexem> lista){
            
                //implmentar un modo panico si se llega a encontrar con un error y seguir normal terminando de 
                //evaluar los tokens de la escritura y luego si esta activado el modo panico
                // tomar como incorrecta toda la estructura
                System.out.println(""+lista.size());
                AlfabetoPila simboloAux = null;
                Token tokenAux = null;
                AlfabetoPila simboloCimaPila;
                Lexem nextToken;
                Lexem nextTokenAux;
                int entrada=0;
                Pila pila = new Pila();
                pila.apilar(simboloAux.Z0);
                pila.apilar(simboloAux.S0);
                
                while (pila.cima()!=simboloAux.Z0 || entrada<lista.size()) {
                        simboloCimaPila = (AlfabetoPila)pila.cima();
                        
                        switch (simboloCimaPila) {
                                case S0: {
                                        nextToken= lista.get(entrada);
                                        if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.FIN);
                                                pila.apilar(simboloAux.E);
                                                pila.apilar(simboloAux.IGUAL);
                                                pila.apilar(simboloAux.IDENTIFICADOR);
                                                entrada--;//el indice de entrada no avanza
                                        }
                                         break;
                                }
                                        
                                case E: {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.E2);
                                        pila.apilar(simboloAux.T);
                                        entrada--;//el indice de entrada no avanza
                                        
                                        break;
                                }
                                case E2: { 
                                         if (entrada==lista.size()) {//a llegado EOF y ahun no esta Z0 en la cima de la pila
                                                entrada--; //la entrada no avanza mas
                                                pila.desapilar();
                                        } else {
                                                nextToken= lista.get(entrada);
                                                if (nextToken.getToken()==tokenAux.SUMA) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.E2);
                                                        pila.apilar(simboloAux.T);
                                                        pila.apilar(simboloAux.SUMA);
                                                        entrada--;//el indice de entrada no avanza
                                                } else {
                                                            pila.desapilar();
                                                            entrada--;//el indice de entrada no avanza
                                                    }
                                         
                                            }
                                        break;
                                }
                                case T: {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.T2);
                                        pila.apilar(simboloAux.F);
                                        entrada--;//el indice de entrada no avanza
                                        break;
                                }      
                                case T2: {
                                        if (entrada==lista.size()) {//a llegado EOF y ahun no esta Z0 en la cima de la pila
                                                entrada--; //la entrada no avanza mas
                                                pila.desapilar();
                                        } else{
                                                nextToken= lista.get(entrada);
                                                if (nextToken.getToken()==tokenAux.MULTIPLICACION) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.T2);
                                                        pila.apilar(simboloAux.F);
                                                        pila.apilar(simboloAux.MULTIPLICACION);
                                                        entrada--;//el indice de entrada no avanza
                                                } else {
                                                            pila.desapilar();
                                                            entrada--;//el indice de entrada no avanza
                                                    }
                                        
                                        }
                                       
                                        break;
                                }
                                case F: {
                                        nextToken= lista.get(entrada);
                                        if (nextToken.getToken()==tokenAux.PARENTESIS_IZQUIERDO) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.PARENTESIS_DERECHO);
                                                pila.apilar(simboloAux.E);
                                                pila.apilar(simboloAux.PARENTESIS_IZQUIERDO);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.IDENTIFICADOR);
                                                        entrada--;//el indice de entrada no avanza
                                                } else if (nextToken.getToken()==tokenAux.NUMERO) {
                                                                pila.desapilar();
                                                                pila.apilar(simboloAux.NUMERO);
                                                                entrada--;//el indice de entrada no avanza
                                                        }
                                         break;
                                }
                                        //SE DESAPILAN LOS SIMBOLOS TERMINALES
                                case SUMA:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case MULTIPLICACION:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case IGUAL:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case PARENTESIS_IZQUIERDO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case PARENTESIS_DERECHO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case NUMERO:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case IDENTIFICADOR:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                case FIN:
                                        pila.desapilar();
                                        //el indice de entrada avanza
                                        break;
                                default:
                                        throw new AssertionError();
                        }
                        entrada++;
                }
                if (pila.cima()==simboloAux.Z0) {
                        System.out.println("La estructura Asignacion es completamente correcta");
                        pila.desapilar();
                } else {
                        System.out.println("La estructura Asignacion no es correcta");
                    }
        }
}
