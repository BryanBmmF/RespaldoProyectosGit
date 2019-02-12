/*
 * Convertidor de Inorden a PostOrden
 */
package analizadorsintactico.backend;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 *
 * @author bryan
 */
public class ConvertidorIn_Post {
        //Declaración de la pila
        private Stack<Character> pila;
        
        public ConvertidorIn_Post(){
                this.pila= new Stack<Character>();
        }
        /**
         * Metodo que transforma una exprecion de infijo a posfijo
         * @param operacion es la exprecion matematica
         * @return devuelve un String con la exprecion en postfijo o devuelve un null si la exprecion no se
         * evaluo correctamente
         */
        public String toPosfijo(String infijo){             
                String salida="";
                char[] cadena = infijo.toCharArray();

                for(int c=0;c<cadena.length;c++){
                        char caracter = cadena[c];
                        if(caracter=='('){
                                pila.push(caracter);
                        } else if(caracter==')') {                
                                        while(true){
                                                if(pila.empty()){
                                                        String retorno = generarError(infijo,c);
                                                        retorno+="Operacion invalida numero de parentesis impares";
                                                        //areaTexto.setText(retorno);
                                                        System.out.println(retorno);
                                                        return null;
                                                }
                                                char temp = pila.pop().charValue();
                                                if(temp=='('){
                                                        break;
                                                } else {
                                                            salida+=" "+temp;
                                                    }
                                        }//fin del wile
                                } else if(Character.isDigit(caracter)) {
                                                salida+=" "+caracter;                
                                                c++;
                                                busqueda : for( ; c<cadena.length;c++){
                                                                if(Character.isDigit(cadena[c])){
                                                                        salida+=cadena[c];
                                                                } else {
                                                                            c--;
                                                                            break busqueda;
                                                                    }                    
                                                }                
                                        } else if(caracter=='+'||caracter=='-'||caracter=='/'||caracter=='*'||caracter=='^'){   
                                                    if(pila.empty()){
                                                            pila.push(caracter);
                                                    } else {
                                                                while(true){                    
                                                                        if(esDeMayorPresedencia(caracter)){                            
                                                                                pila.push(caracter);
                                                                                break;
                                                                        } else {
                                                                                    salida+=" "+pila.pop();
                                                                            }  
                                                                }                                 
                                                        }               
                                            } else{
                                                        String retorno = generarError(infijo,c);
                                                        retorno+="caracter no valido para la exprecion : '"+caracter+"'";
                                                        //areaTexto.setText(retorno);
                                                        System.out.println(retorno);
                                                        return null;
                                                }
                }//fin del for
                if(!pila.empty()){
                        do{
                                char temp = pila.pop().charValue();
                                salida+=" "+temp;                
                        }while(!pila.empty());
                }
                
                return salida.trim();
        }
        
        /**
        * Metodo que genera la posicion en la que se genero el error en tienpo de evaluar la expreción
        * @param infijo es la exprecion en infijo que se esta evaluando
        * @param indice es la pacion en que se encontro el error
        * @return devuelve el String indicando la posicion exacta del error
        */
        public String generarError(String infijo,int indice){
                String error[] = new String[infijo.length()];
                for(int c=0;c<error.length;c++){
                        error[c]="  ";
                }
                error[indice]="^";

                String error2="";
                for(int c=0;c<error.length;c++){
                        error2+=error[c];
                }
                return infijo+"\n"+error2+"\n";
        }
    
    
        /**
        * Metodo utilizado para saber si el caracter es de mayor presedencia que el que se
        * encuentra en la ultma posicion de la pila
        * @param caracter caracter que se evaluara para meterse a la pila
        * @return devuelve true si el caracter es de mayor presedencia, false de lo contrario
        */
        public boolean esDeMayorPresedencia(char caracter){
                if(pila.empty()){
                        return true;
                }
                if(caracter==pila.peek().charValue()){
                        return false;
                }
                if(caracter=='^'){
                        return true;
                }
                if( (caracter=='*'&&pila.peek().charValue()=='/')||(caracter=='/'&&pila.peek().charValue()=='*')){
                        return false;
                }
                if( (caracter=='+'&&pila.peek().charValue()=='-')||(caracter=='-'&&pila.peek().charValue()=='+')){
                        return false;
                } else if(caracter=='-'||caracter=='+'){
                        char temp = pila.peek().charValue();
                        if(temp=='*'||temp=='/'){
                                return false;
                        }
                }
                return true;        
        }
         /**
         * Metodo que evalua la exprecion posfija y devuelve el valor real de la evaluacion
         * @param posfijo es la exprecon en posfijo
         * @return  devuleve la evaluacion de la exprecion
         */
        public int evaluarPosfijo(String posfijo){              
                ArrayList<String> token = new ArrayList<String>();

                StringTokenizer st = new StringTokenizer(posfijo," ");
                
                while(st.hasMoreTokens()){
                        token.add(st.nextToken());
                }
                if(token.size()==1){
                        return Integer.parseInt(token.get(0));                
                }
                int c=0;
                //areaTexto.append(token.toString()+"\n");
                while(token.size()!=1){
                        String operador = token.get(c);
                        if(operador.equals("+")||operador.equals("-")||operador.equals("*")||operador.equals("/")||operador.equals("^")){
                                String operando1=token.get(c-1);
                                String operando2 =token.get(c-2);

                                token.remove(c);
                                token.remove(c-1);
                                token.remove(c-2);
                                if(operador.equals("+")){
                                        try {
                                                String suma = (Integer.parseInt(operando2)+Integer.parseInt(operando1))+"";
                                                token.add(c-2,suma);
                                                c=0;
                                        } catch (Exception e) {
                                                //areaTexto.setText("Error al comvertir un operando\n"+e);
                                                return 0;
                                        }                    
                                } else if(operador.equals("*")){
                                                try {
                                                        String multiplicacion = (Integer.parseInt(operando2)*Integer.parseInt(operando1))+"";
                                                        token.add(c-2,multiplicacion);
                                                        c=0;
                                                } catch (Exception e) {
                                                        //areaTexto.setText("Error al comvertir un operando\n"+e);
                                                        return 0;
                                                }    
                                         } else {
                                                    try {
                                                            String potencia = (Integer.parseInt(operando2)^Integer.parseInt(operando1))+"";
                                                            token.add(c-2,potencia);
                                                            c=0;
                                                    } catch (Exception e) {
                                                            //areaTexto.setText("Error al comvertir un operando\n"+e);
                                                            return 0;
                                                    }   
                                            }
                                        //areaTexto.append(token.toString()+"\n");
                        } else{
                                c++;
                            }
                }


                try {            
                        return Integer.parseInt(token.get(0));            
                } catch (Exception e) {
                        //areaTexto.setText("Error al parsear el resultado\n"+e);
                        return 0;
                }

        }
}
