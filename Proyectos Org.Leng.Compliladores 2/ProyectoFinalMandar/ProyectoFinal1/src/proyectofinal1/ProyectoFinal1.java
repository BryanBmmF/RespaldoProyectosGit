/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal1;

import GUI.EditorTexto;
import Analizadores.Cup.parser;
import Analizadores.Flex.Lexer;
import CErrores.CErrores;
import Instructions.Instruction;
import Objetos.Condicion;
import Objetos.Cuarteto;
import Objetos.Dato;
import Objetos.ExpresionAritmetica;
import Objetos.ExpresionBooleana;
import Objetos.ExpresionUnica;
import Objetos.Token;
import java.io.StringReader;
import javax.swing.JTextArea;
import Objetos.Logica;
import Tablas.TablaSimbolos.Simbolos;
import Tablas.TablaSimbolos.TablaSimbolos;
import Valores.Temporales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class ProyectoFinal1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
//            String h = "";
//            StringReader r = new StringReader(h);
//            Lexer lex = new Lexer(r, new JTextArea(), null);
//            parser par = new parser(lex);
//            //par.parse();
//            List<ExpresionAritmetica> expresiones = new ArrayList<>();
//            List<ExpresionAritmetica> expresiones2 = new ArrayList<>();
//
//            TablaSimbolos tablaSimbolos = new TablaSimbolos();
//            ArrayList<String> lista = new ArrayList<>();
//            ArrayList<String> lista2 = new ArrayList<>();
//            ArrayList<Instruction> instructions = new ArrayList<>();
//            lista.add("t1");
//            lista.add("t2");
//            
//            lista2.add("Byte");
//            lista2.add("Boolean");
//            Simbolos sim = new Simbolos("juan", "VARIABLE", "Byte", 0);
//            Simbolos sim2 = new Simbolos("luis", "ARREGLO", "Double", 0, 2, lista, null);
//            Simbolos sim3 = new Simbolos("funcion", "SUBPROGRAMA", "String", 0, 2, lista2, instructions, "t9");
//            Simbolos sim4 = new Simbolos("JUAN", "VARIABLE", "Boolean", 0);
//            tablaSimbolos.addElementInAmbit(sim);
//            tablaSimbolos.addElementInAmbit(sim2);
//            tablaSimbolos.addElementInAmbit(sim3);
//            tablaSimbolos.addElementInAmbit(sim4);
//
//            ExpresionAritmetica expr1 = new ExpresionAritmetica(new Dato(new Token("juan", 1, 2), "VARIABLE", null));
//            ExpresionAritmetica expr2 = new ExpresionAritmetica(new Dato(new Token("TRUE", 1, 2), "Boolean", null));
//            ExpresionAritmetica expr3 = new ExpresionAritmetica(new Dato(new Token("TRUE", 1, 2), "Integer", null));
//            ExpresionAritmetica expr4 = new ExpresionAritmetica(new Token("-",0,0), expr1, expr2);
//            ExpresionAritmetica expr5 = new ExpresionAritmetica(new Dato(new Token("TRUE", 1, 2), "Boolean", null));
//
//            expresiones.add(expr3);
//            expresiones.add(expr5); 
//            
//            expresiones2.add(expr1);
//            expresiones2.add(expr2);
//            
//            expr1.asignarAmbito(0);
//            expr2.asignarAmbito(0);
//            expr3.asignarAmbito(0);
//            expr4.asignarAmbito(0);
//            expr5.asignarAmbito(0);
//            
//            ExpresionAritmetica exprarreglo = new ExpresionAritmetica(new Dato(new Token("luis", 1, 2), "ARREGLO", expresiones));
//            ExpresionAritmetica exprfuncion = new ExpresionAritmetica(new Dato(new Token("funcion", 1, 2), "SUBPROGRAMA", expresiones2));
//            ExpresionAritmetica expr = new ExpresionAritmetica(new Token("+",0,0), exprarreglo, exprfuncion);
//            exprarreglo.asignarAmbito(0);
//
//            String validar = exprarreglo.validarClases(tablaSimbolos, Logica.crearTabla());
//            System.out.println(validar);
//            
//            for (int i = 0; i < CErrores.getListaErrores().size(); i++) {
//                System.out.println(CErrores.getListaErrores().get(i).getMensaje());
//                
//            }
//            
//            
//            
//            ExpresionBooleana exprbol1 = new ExpresionBooleana(new Dato(new Token("JUAN", 1, 2), "VARIABLE", expresiones));
//            ExpresionBooleana exprbol2 = new ExpresionBooleana(new Condicion(">", exprarreglo, exprfuncion));
//            ExpresionBooleana exprbol3 = new ExpresionBooleana("AND", exprbol1, exprbol2);
//            exprbol1.setAmbito(1);
//            exprbol2.setAmbito(2);
//            exprbol3.setAmbito(3);
//            String valor = exprbol3.validarClases(tablaSimbolos, Logica.crearTabla());
//            //System.out.println(valor);
//            
//            
//            ExpresionUnica exprunica1 = new ExpresionUnica(new Dato(new Token("funcion", 1, 2), "SUBPROGRAMA", expresiones2));
//            exprunica1.setAmbito(6);
//            
//            String valor1 = exprunica1.validarClases(tablaSimbolos, Logica.crearTabla());
//            System.out.println(valor1);


//            
//            List<String> tamanos = new ArrayList<>();
//            tamanos.add("t8");
//            tamanos.add("t9");
//            
//            
//            List<String> valores = new ArrayList<>();
//            valores.add("t1");
//            valores.add("t2");
//            
//            List<Cuarteto> lista= new ArrayList<>();
//            
//            operarDimensiones(tamanos, valores, lista);
//            
//            for (int i = 0; i < lista.size(); i++) {
//                System.out.println(lista.get(i).make3D());
//                
   //         }
            

            EditorTexto e = new EditorTexto();
            e.setVisible(true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    
//     public static void operarDimensiones(List<String> tamanos, List<String> valores, List<Cuarteto> lista) {
//        int j=0;
//        for (int i = 0; i < valores.size(); i++) {
//            if (i + 1 == valores.size()) {
//                sumarDimensiones(valores.get(i),Temporales.actualTemporal("Long"),Temporales.siguienteTemporal("Long"),lista);
//            } else {
//                while(j<valores.size()-1){
//                    multiplicarDimensiones(valores.get(j),tamanos.get(j+1),Temporales.siguienteTemporal("Long"),lista);
//                }
//                j++;
//            }
//        }
//     }
//        
//    public static void multiplicarDimensiones(String valor, String dimension, String temporal, List<Cuarteto> lista) {
//        Cuarteto cuarteto = Cuarteto.MakeOperacion("", temporal,"*", valor, dimension);
//        lista.add(cuarteto);
//    }
//
//    public static void sumarDimensiones(String valor, String ultimoTemporal, String temporal, List<Cuarteto> lista) {
//        Cuarteto cuarteto = Cuarteto.MakeOperacion("", temporal,"*+",ultimoTemporal,valor);
//        lista.add(cuarteto);
//    }
        

}
//hola amigos