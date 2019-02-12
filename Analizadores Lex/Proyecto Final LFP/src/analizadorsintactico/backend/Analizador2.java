/*
 * Analizador mejorado Sintactico
 */
package analizadorsintactico.backend;

import analizadorsintactico.gui.JFramePrincipal;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author bryan
 */
public class Analizador2 {
        //listas a utilizar en el analisis
        private ArrayList<String> errores;
        private ArrayList<EstructuraCl> estructurasValidas;
        private ArrayList<EstructuraCl> estructurasInvalidas;
        private ArrayList<Identificador> identificadores;
        private JFramePrincipal frame;
        private Lexem lexemaTemp;
        private Identificador ident;
        
        
        //miembros a utilizar
        private Enum[] token;
        private AlfabetoPila simboloAux;
        private Token tokenAux;
        private AlfabetoPila simboloCimaPila;
        private Estado estadoAux;
        private Estado estadoActual;
        private Lexem nextToken;
        private Lexem nextTokenAux;
        private int entrada;
        private boolean asig;
        private Pila pila;
        private Estructura estructra;
        private Estructura estructraAux;
        private String contenidoSalida;
        private String contenidoErr;
        private String contenidoExpres;
        private File file;
        private int repeticion;
        private int marcaIn;
        private int marcaInAux;
        private int fila;
        private int columna;
        private int inicioAsignacion;
        private boolean condicional;
        //constantes necesarias
        public static final String ERROR_ESTRUCT_INICIAL="ERROR se esperaba un inicio de estructura";
        public static final String ERROR_NUM_IDENT_LITERAL="Error se esperaba un Numero, Literal o Identificador";
        public static final String ERROR_NUM_IDENT="ERROR se esperaba un Numero o Identificador";
        public static final String ERROR_ESCRIBIR_FIN="ERROR se esperaba un ESCRIBIR o un FIN";
        public static final String ERROR_VERDADERO_FALSO="ERROR se esperaba un VERDADERO o un FALSO";
        public static final String ERROR_FIN="ERROR se esperaba un FIN ";
        public static final String ERROR_INICIO="ERROR se esperaba un INICIAR";
        public static final String ERROR_ENTONCES="ERROR se esperaba un ENTONCES";
        public static final String ERROR_IGUAL="ERROR se esperaba el signo = ";
        public static final String ERROR_PARENTESIS_IZQ="ERROR se esperaba el signo (, un Numero o Identificador";
        
        public Analizador2(JFramePrincipal frame, File file ){
                this.frame=frame;
                this.file=file;
                this.errores= new ArrayList();
                
                this.estructurasValidas= new ArrayList();
                this.estructurasInvalidas = new ArrayList();
                this.identificadores = new ArrayList();
                
                this.estadoActual= estadoAux.q0;
                this.estructra = null;
                this.simboloAux=null;
                this.tokenAux=null;
                this.entrada=0;
                this.repeticion=1;
                this.marcaIn=0;
                this.marcaInAux=1;
                this.fila=0;
                this.columna=0;
                this.inicioAsignacion=0;
                this.contenidoSalida="";
                this.contenidoErr="";
                this.contenidoExpres="";
                this.asig=false;
                this.condicional=true;
                this.pila= new Pila();
                
        }
        
        public void analizarSintaxis(ArrayList<Lexem> lista){
            
                /*Se implementa un analizador Sintactico que reconoce estructuras 
                   mediante el uso de un automata de pila*/
                System.out.println(""+lista.size());
                
                while (entrada<lista.size() || pila.vacia()!=true) {
                        switch (estadoActual) {
                                case q0:
                                        procesarEstadoQ0();
                                        break;
                                case q1:
                                        procesarEstadoQ1();
                                        break;
                                case q2:
                                        
                                        procesarEstadoQ2(lista);
                                        break;
                                default:
                                        throw new AssertionError();
                        }
                }
               
               
        }
        /*Metodos para procesamiento de estados Q0, Q1, Q2, y Q3*/
        public void procesarEstadoQ0(){
                pila.apilar(simboloAux.Z0);
                estadoActual=estadoAux.q1;
        }
        public void procesarEstadoQ1(){
                pila.apilar(simboloAux.S0);
                estadoActual=estadoAux.q2;
        }
        public void procesarEstadoQ2(ArrayList<Lexem> lista){
                
                simboloCimaPila = (AlfabetoPila)pila.cima();
               
                switch (simboloCimaPila) {
                        case S0: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()== tokenAux.ESCRIBIR) {//Una estructura Escritura
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S1);
                                        pila.apilar(simboloAux.ESCRIBIR);
                                        asignarEstructura(estructraAux.ESCRITURA);
                                        entrada--;//el indice de entrada no avanza
                                } else if (nextToken.getToken()==tokenAux.REPETIR) {//Una estructura Repetir
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S3);
                                                pila.apilar(simboloAux.REPETIR);
                                                asignarEstructura(estructraAux.REPETIR);
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.SI) { //Una estructura Condicional
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.S9);
                                                        pila.apilar(simboloAux.SI);
                                                        asignarEstructura(estructraAux.CONDICIONAL);
                                                        entrada--;//el indice de entrada no avanza
                                                } else if (nextToken.getToken()==tokenAux.NUMERO || nextToken.getToken()==tokenAux.PARENTESIS_IZQUIERDO) {
                                                                //es una expresion
                                                                pila.desapilar();
                                                                pila.apilar(simboloAux.E);
                                                                asignarEstructura(estructraAux.EXPRESION);
                                                                entrada--;//el indice de entrada no avanza
                                                        } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                                        nextTokenAux= lista.get(entrada+1); //Pre analisis 1
                                                                        if (nextTokenAux.getToken()==tokenAux.IGUAL) { //Una estructura Expresion
                                                                                //es una asignacion por el pre analisis del simbolo de entrada y el de entrada +1
                                                                                pila.desapilar();
                                                                                pila.apilar(simboloAux.S11);
                                                                                pila.apilar(simboloAux.IDENTIFICADOR);
                                                                                asignarEstructura(estructraAux.ASIGNACION);
                                                                                lexemaTemp= nextToken; //se almacena el lexema identificador
                                                                                asig=true;
                                                                                inicioAsignacion=entrada; //se marca el inicio de la asignacion
                                                                                entrada--;//el indice de entrada no avanza
                                                                        } else {
                                                                                    //es una expresion
                                                                                    pila.desapilar();
                                                                                    pila.apilar(simboloAux.E);
                                                                                    asignarEstructura(estructraAux.EXPRESION);
                                                                                    entrada--;//el indice de entrada no avanza
                                                                            }
                                                                        
                                                                        
                                                                } else  {
                                                                            notificarError(ERROR_ESTRUCT_INICIAL);
                                                                    }

                                break;
                        }
                        case S1: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.LITERAL) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S2);
                                        pila.apilar(simboloAux.LITERAL);
                                        //se agrega texto a la salida
                                        agregarTextoSalida(nextToken.getLexema().substring(1,(nextToken.getLexema().length()-1)));
                                        entrada--;//el indice de entrada no avanza
                                } else if (nextToken.getToken()==tokenAux.NUMERO) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S2);
                                                pila.apilar(simboloAux.NUMERO);
                                                //se agrega texto a la salida
                                                agregarTextoSalida(nextToken.getLexema());
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.S2);
                                                        pila.apilar(simboloAux.IDENTIFICADOR);
                                                        //se agrega texto a la salida
                                                        agregarTextoSalida(""+buscarIdent(nextToken.getLexema()));
                                                        entrada--;//el indice de entrada no avanza
                                                } else  {
                                                            notificarError(ERROR_NUM_IDENT_LITERAL);
                                                    }

                                break;
                        }
                        case S2: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.FIN) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.FIN);
                                        entrada--;//el indice de entrada no avanza
                                } else  {
                                            notificarError(ERROR_FIN);
                                    }

                                break;
                        }
                        case S3: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.NUMERO) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S4);
                                        //pila.apilar(simboloAux.INICIAR);
                                        pila.apilar(simboloAux.NUMERO);
                                        repeticion = Integer.parseInt(nextToken.getLexema());//numero de repeticiones
                                        entrada--;//el indice de entrada no avanza
                                } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S4);
                                                //pila.apilar(simboloAux.INICIAR);
                                                pila.apilar(simboloAux.IDENTIFICADOR);
                                                repeticion = buscarIdent(nextToken.getLexema());//numero de repeticiones
                                                entrada--;//el indice de entrada no avanza
                                        } else  {
                                                    notificarError(ERROR_NUM_IDENT);
                                            }

                                break;
                        }
                        case S4: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.INICIAR) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S5);
                                        pila.apilar(simboloAux.INICIAR);
                                        entrada--;//el indice de entrada no avanza
                                } else  {
                                            notificarError(ERROR_INICIO);
                                    }

                                break;
                        }
                        case S5: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.ESCRIBIR) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S6);
                                        pila.apilar(simboloAux.ESCRIBIR);
                                        if (marcaIn==0) {
                                                marcaIn=entrada;//se marca donde esta la entrada para regresarla segun la repeticion
                                        }
                                        entrada--;//el indice de entrada no avanza
                                } else if (nextToken.getToken()==tokenAux.FIN) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.FIN);
                                                entrada--;//el indice de entrada no avanza
                                        } else  {
                                                    notificarError(ERROR_ESCRIBIR_FIN);
                                            }

                                break;
                        }
                        case S6: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.LITERAL) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S7);
                                        pila.apilar(simboloAux.LITERAL);
                                        //se agrega texto a la salida
                                        agregarTextoSalida(nextToken.getLexema().substring(1,(nextToken.getLexema().length()-1)));
                                        entrada--;//el indice de entrada no avanza
                                } else if (nextToken.getToken()==tokenAux.NUMERO) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S7);
                                                pila.apilar(simboloAux.NUMERO);
                                                //se agrega texto a la salida
                                                agregarTextoSalida(nextToken.getLexema());
                                                entrada--;//el indice de entrada no avanza
                                        } else if (nextToken.getToken()==tokenAux.IDENTIFICADOR) {
                                                        pila.desapilar();
                                                        pila.apilar(simboloAux.S7);
                                                        pila.apilar(simboloAux.IDENTIFICADOR);
                                                        //se agrega texto a la salida
                                                        agregarTextoSalida(""+buscarIdent(nextToken.getLexema()));
                                                        entrada--;//el indice de entrada no avanza
                                                } else  {
                                                            notificarError(ERROR_NUM_IDENT_LITERAL);
                                                    }
                                break;
                        }
                        case S7: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.FIN) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S8);
                                        pila.apilar(simboloAux.FIN);
                                        entrada--;//el indice de entrada no avanza
                                } else  {
                                               notificarError(ERROR_FIN);
                                        }
                                break;
                        }
                        case S8: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.ESCRIBIR) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S6);
                                        pila.apilar(simboloAux.ESCRIBIR);
                                        entrada--;//el indice de entrada no avanza
                                } else if (nextToken.getToken()==tokenAux.FIN) {
                                                evaluarRepeticion();                                    
                                        } else  {
                                                    notificarError(ERROR_ESCRIBIR_FIN);
                                            }

                                break;
                        }
                        case S9: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.VERDADERO) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S10);
                                        pila.apilar(simboloAux.VERDADERO);
                                        entrada--;//el indice de entrada no avanza
                                } else if (nextToken.getToken()==tokenAux.FALSO) {
                                                pila.desapilar();
                                                pila.apilar(simboloAux.S10);
                                                pila.apilar(simboloAux.FALSO);
                                                condicional=false;//la condicional se vuelve falsa 
                                                entrada--;//el indice de entrada no avanza
                                        } else  {
                                                    notificarError(ERROR_VERDADERO_FALSO);
                                            }


                                break;
                        }
                        case S10: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.ENTONCES) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.S5);
                                        pila.apilar(simboloAux.ENTONCES);
                                        entrada--;//el indice de entrada no avanza
                                } else  {
                                            notificarError(ERROR_ENTONCES);
                                    }
                                break;
                        }
                        case S11: {
                                nextToken= lista.get(entrada);
                                if (nextToken.getToken()==tokenAux.IGUAL) {
                                        pila.desapilar();
                                        pila.apilar(simboloAux.FIN);
                                        pila.apilar(simboloAux.E);
                                        pila.apilar(simboloAux.IGUAL);
                                        entrada--;//el indice de entrada no avanza
                                } else  {
                                            notificarError(ERROR_IGUAL);
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
                                                } else  {
                                                            notificarError(ERROR_PARENTESIS_IZQ);
                                                    }
                                 break;
                        }
                        case Z0: { 
                                procesarEstadoQ3(lista.size(),lista);
                                condicional=true;
                                entrada--;//el indice de entrada no avanza
                                break;
                        }
                        case ERROR: {
                                if (entrada==lista.size()) {//a llegado EOF y ahun no esta Z0 en la cima de la pila
                                        entrada--; //la entrada no avanza mas
                                        pila.desapilar();
                                } else {
                                            tratarError(lista);
                                    }
                               
                                break;
                        }
                        //SE DESAPILAN LOS SIMBOLOS TERMINALES
                        case ESCRIBIR:
                                pila.desapilar();//el indice de entrada avanza
                                break;
                        case FIN:
                                pila.desapilar();  
                                break;
                        case REPETIR:
                                pila.desapilar();
                                break;
                        case INICIAR:
                                pila.desapilar();
                                break;
                        case SI:
                                pila.desapilar();
                                break;
                        case VERDADERO:
                                pila.desapilar();
                                break;
                        case FALSO:
                                pila.desapilar();
                                break;
                        case ENTONCES:
                                pila.desapilar();
                                break;
                        case LITERAL:
                                pila.desapilar();
                                break;
                        case NUMERO:
                                pila.desapilar();
                                break;
                        case IDENTIFICADOR:
                                pila.desapilar();
                                break;
                        case SUMA:
                                pila.desapilar();
                                break;
                        case MULTIPLICACION:
                                pila.desapilar();
                                break;
                        case IGUAL:
                                pila.desapilar();
                                break;
                        case PARENTESIS_IZQUIERDO:
                                pila.desapilar();
                                break;
                        case PARENTESIS_DERECHO:
                                pila.desapilar();
                                break;
                        default:
                                throw new AssertionError();
                }
                entrada++; //el indice de entrada avanza

        }
        public void procesarEstadoQ3(int longLista,ArrayList<Lexem> lista){
                if (entrada>=longLista) { //si llego al EOF
                        if (errores.isEmpty()) {
                                procesarEstructura(lista);

                                ControladorDeArchivos controlador = new ControladorDeArchivos();
                                controlador.exportarAarchivo2(file, contenidoSalida,".txt");//se exporta el archivo de salida

                                //mostrar estructuras en tabla
                                frame.limpiarListaErrSintac();
                                frame.limpiarTabla(frame.devolverTablaEstrucValid());
                                frame.cargarTablaEstructI(estructurasValidas,frame.devolverTablaEstrucValid());
                                estructurasValidas.clear();
                                System.out.println("FIN DE ANALISIS SINTACTICO!!!!");
                                pila.desapilar();
                        } else { 
                                    frame.limpiarTabla(frame.devolverTablaEstrucValid());//se muestran las estructuras que fueron correctas
                                    if (!estructurasValidas.isEmpty()) {
                                            frame.cargarTablaEstructI(estructurasValidas,frame.devolverTablaEstrucValid());
                                            estructurasValidas.clear();
                                    }

                                    frame.agregarErrorSintactico(errores);//se despliegan errores sintacticos
                                    for(String err: errores){
                                            System.out.println(""+err);
                                    }
                                    System.out.println("FIN DE ANALISIS SINTACTICO!!!!");
                                    pila.desapilar();
                            }
                        
                        
                } else {
                            procesarEstructura(lista);
                            pila.desapilar();
                            estadoActual= estadoAux.q0;
                        
                    }
        }
        //metodo para agregar texto a la salida
        public void agregarTextoSalida(String texto){
                if (condicional) {
                        contenidoSalida=contenidoSalida+texto+"\n";
                }
        }
        //metodo para asignar estructura entrante
        public void asignarEstructura(Estructura estruc){
                estructra= estruc;
                fila= nextToken.getNumeroFila();
                columna= nextToken.getNumeroColumna();
        
        }
        //metodo para procesar una estructura despues de ser aceptada
        public void procesarEstructura(ArrayList<Lexem> lista){
                System.out.println("La estructura "+estructra.toString()+" es CORRECTA!!! con: "+entrada+" tokens eval");
                //agregar estructura
                estructurasValidas.add(new EstructuraCl(estructra, fila, columna));

                if (estructra==estructraAux.ASIGNACION) { //si es una asignacion se realiza las operaciones
                        for (int i = (inicioAsignacion+2); i < (entrada-1); i++) {
                                if (lista.get(i).getToken()==tokenAux.IDENTIFICADOR) { //si es un identificador
                                        //se busca el valor del identificador
                                        contenidoExpres= contenidoExpres+buscarIdent(lista.get(i).getLexema());

                                } else { //si no es un numero operador o parentesis
                                        contenidoExpres= contenidoExpres+lista.get(i).getLexema();
                                }

                        }
                        System.out.println(contenidoExpres);
                        ConvertidorIn_Post c = new ConvertidorIn_Post();
                        String post =c.toPosfijo(contenidoExpres);  //la expresion se convierte a postOrden
                        System.out.println(post);
                        int resultado=c.evaluarPosfijo(post);   //se evalua el resultado de la expresion en postOrden
                        System.out.println("Resultado: "+resultado);

                        establecerValorIdent(lexemaTemp.getLexema(), resultado); //se establece el valor del identificador
                        contenidoExpres="";
                }
        }
        //metodo para evaluar repeticiones de la estructura REPETIR
        public void evaluarRepeticion(){
                if (marcaInAux<repeticion) { //si hay alguna repeticion vuelve a S5
                        pila.desapilar();
                        pila.apilar(simboloAux.S5);
                        entrada= marcaIn;// la entrada regresa al Inicio de ESCRITURAS
                        marcaInAux++; // se aumenta el auxiliar que cuenta repeticiones
                        entrada--;//el indice de entrada no avanza
                } else { //si no hay ninguna repeticion de la estructura
                            pila.desapilar();
                            pila.apilar(simboloAux.FIN);
                            marcaIn=0;
                            marcaInAux=1;
                            repeticion=1;
                            entrada--;//el indice de entrada no avanza
                    }
        
        }
        //tratamiento de errores
        public void tratarError(ArrayList<Lexem> lista){
                nextToken= lista.get(entrada);
                if (nextToken.getToken()==tokenAux.ESCRIBIR ||nextToken.getToken()==tokenAux.REPETIR
                        ||nextToken.getToken()==tokenAux.SI ||nextToken.getToken()==tokenAux.NUMERO 
                        ||nextToken.getToken()==tokenAux.IDENTIFICADOR ||nextToken.getToken()==tokenAux.PARENTESIS_IZQUIERDO) {

                        pila.desapilar();
                        pila.apilar(simboloAux.S0);

                        //se agrega el error cargado
                        errores.add("       en lugar de : "+contenidoErr);
                        
                        //se reinicia la cadena de error y el contador no avanza
                        contenidoErr="";
                        entrada--;

                } else {
                            //no esta en la entrada aun un simbolo de sincronizacion de otra estructura, sigue el error
                            contenidoErr= contenidoErr+nextToken.getLexema();
                            //el contador avanza y sigue estando en error
                    }
                                
        }
        //notificacion de errores
        public void notificarError(String error){
                //entra a un estado de error
                pila.vaciarPila(); //se vacia la pila
                pila.apilar(simboloAux.Z0); //marca de fondo de pila
                pila.apilar(simboloAux.ERROR); //se apila el estado error
                errores.add(error
                        + "  Fila: "+nextToken.getNumeroFila()
                        + " Colum: "+nextToken.getNumeroColumna());
                
                contenidoErr= contenidoErr+nextToken.getLexema();
        }
        //metodo para evaluar identificadores devuelve el valor si lo encuentra
        public int buscarIdent(String nombre){
                boolean encontrado=false;
                int valorIdent=0;
                int cont=0;
                while(encontrado==false && cont<identificadores.size()){
                        if (identificadores.get(cont).getNombre().equals(nombre)) {
                                encontrado=true;
                                valorIdent= identificadores.get(cont).getValor();
                        }
                        cont++;
                }
                return valorIdent;
        }
        //metodo para establecer valor de Identificadores
        public void establecerValorIdent(String nombre, int result){
                boolean encontrado=false;
                int cont=0;
                while(encontrado==false && cont<identificadores.size()){
                        if (identificadores.get(cont).getNombre().equals(nombre)) {
                                encontrado=true;
                                //se agrega el nuevo valor del identificador
                                identificadores.get(cont).setValor(result);
                        }
                        cont++;
                }
                if (encontrado==false) {//si no se encontro se crea el nuevo identificador
                        identificadores.add(new Identificador(nombre, result));
                }
        }
}
