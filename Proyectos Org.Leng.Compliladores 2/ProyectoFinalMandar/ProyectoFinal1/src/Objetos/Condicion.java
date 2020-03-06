package Objetos;

import CErrores.CErrores;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Valores.Etiquetas;
import Valores.Temporales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Condicion {

    private Token operator;
    private ExpresionAritmetica left;
    private ExpresionAritmetica right;
    private Dato literalValue;
    private Integer ambito;
    private String tipoExpresion;
    private TablaSimbolos table;
    private TablaTipos tablaTipos;
    private boolean tieneString;
    private String valorFuncion="";
    private String tipoDato;

    public Condicion(Token operator, ExpresionAritmetica left, ExpresionAritmetica right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String validarClases(TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        asignarTablas(tablaSimbolos, tablaTipos);
        return operarClases();

    }

    public String operarClases() {
        if (operator != null) {
            String valor1 = left.validarClases(table, tablaTipos);
            String valor2 = right.validarClases(table, tablaTipos);
            if (valor1 != null && (valor1.equals("Long") || valor1.equals("Byte") || valor1.equals("Integer") || valor1.equals("Double") || valor1.equals("Float"))) {
                if (valor2 != null && (valor2.equals("Long") || valor2.equals("Byte") || valor2.equals("Integer") || valor2.equals("Double") || valor2.equals("Float"))) {
                    return "Boolean";
                } else {
                    CErrores.agregarError("SEMANTICO", "TIPO_NUMERICO", null, null, "ARREGLO", operator.getLine(), operator.getColumn(), "LA EXPRESION NO ES DE TIPO NUMERICA EN LA CONDICION, OPERADOR:  " + operator.getLexeme());
                    return null;
                }

            } else {
                CErrores.agregarError("SEMANTICO", "TIPO_NUMERICO", null, null, "ARREGLO", operator.getLine(), operator.getColumn(), "LA EXPRESION NO ES DE TIPO NUMERICA EN LA CONDICION, OPERADOR:  " + operator.getLexeme());
                return null;
            }
        }
        return null;
    }

    public void asignarTablas(TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        this.table = tablaSimbolos;
        this.tablaTipos = tablaTipos;
//        if(left!=null){
//            left.asignarTablas(tablaTipos, tablaSimbolos);
//        }
//        if(right!=null){
//            right.asignarTablas(tablaTipos, tablaSimbolos);
//        }
    }

    public boolean validarParametroFuncion(String nombre, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        if (operator != null) {
            return left.validarParametroFuncion(nombre, tablaSimbolos, tablaTipos) && right.validarParametroFuncion(nombre, tablaSimbolos, tablaTipos);
        } else {
            return false;
        }

    }

    public Token getOperator() {
        return operator;
    }

    public ExpresionAritmetica getLeft() {
        return left;
    }

    public void setLeft(ExpresionAritmetica left) {
        this.left = left;
    }

    public ExpresionAritmetica getRight() {
        return right;
    }

    public void setRight(ExpresionAritmetica right) {
        this.right = right;
    }

    public TablaTipos getTablaTipos() {
        return tablaTipos;
    }

    public void setTablaTipos(TablaTipos tablaTipos) {
        this.tablaTipos = tablaTipos;
    }

    public boolean isTieneString() {
        return tieneString;
    }

    public void setTieneString(boolean tieneString) {
        this.tieneString = tieneString;
    }

    public TablaSimbolos getTable() {
        return table;
    }

    public void setTable(TablaSimbolos table) {
        this.table = table;
    }

    public Dato getLiteralValue() {
        return literalValue;
    }

    public void setLiteralValue(Dato literalValue) {
        this.literalValue = literalValue;
    }

    public Integer getAmbito() {
        return ambito;
    }

    public void setAmbito(Integer ambito) {
        this.ambito = ambito;
    }

    public String getTipoExpresion() {
        return tipoExpresion;
    }

    public void setTipoExpresion(String tipoExpresion) {
        this.tipoExpresion = tipoExpresion;
    }

    public void asignarAmbito(int ambito) {
        this.ambito = ambito;
        left.asignarAmbito(ambito);
        right.asignarAmbito(ambito);
    }
    
    
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
        left.asignarValorFuncion(idFuncion);
        right.asignarValorFuncion(idFuncion);
    }
    
    

    public List<Cuarteto> execute() {
        List<Cuarteto> lista, lista1, lista2;
        Cuarteto cuarteto;
        String resultado1, resultado2;
        Cuarteto cuartetoGoto,cuartetoEtiqueta,cuartetoIf1;

        lista = new ArrayList<>();
        lista1 = left.execute();
        lista2 = right.execute();
        resultado1 = lista1.get(lista1.size() - 1).getValorT();
        resultado2 = lista2.get(lista2.size() - 1).getValorT();
        
            String etiquetaTrue = Etiquetas.siguienteEtiqueta();
            String etiquetaFalse = Etiquetas.siguienteEtiqueta();
            String etiquetaSalida = Etiquetas.siguienteEtiqueta();
            
            Cuarteto.unirCuartetos(lista1, lista2);

            String valorFinal = Temporales.siguienteTemporal("Integer");
            
            cuartetoIf1 = new Cuarteto();
            cuartetoIf1.setOperador("IFF");
            cuartetoIf1.setResultado(resultado1+operator.getLexeme()+resultado2);

            lista1.add(cuartetoIf1);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaTrue);
            lista1.add(cuartetoGoto);
            
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaFalse);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaTrue);
            lista1.add(cuartetoEtiqueta);
            cuarteto = Cuarteto.MakeOperacionIgualAsignacion(valorFinal, "1", ambito + "","Boolean","Boolean");

            lista1.add(cuarteto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaFalse);
            lista1.add(cuartetoEtiqueta);

            cuarteto = Cuarteto.MakeOperacionIgualAsignacion(valorFinal, "0", ambito + "","Boolean","Boolean");
            lista1.add(cuarteto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaSalida);
            lista1.add(cuartetoEtiqueta);
        

        return lista1;
    }
    

}
