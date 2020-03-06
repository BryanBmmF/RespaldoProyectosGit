package Tablas.TablaSimbolos;

import Instructions.Instruction;
import Objetos.Cuarteto;
import Objetos.ExpresionAritmetica;
import Valores.Temporales;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Simbolos {

    private String nombre;//numeros
    private String categoria;//arreglo
    private String tipo;//double
    private Integer numeroParameteros;//nada
    private List<String> listaParametros;//nada
    private List<String> temporalesParametros;
    private Integer ambito;
    private List<Instruction> instruccionesFuncion;
    private Integer vecesUsadaLaFuncion;
    private Integer numeroDimensiones;
    private List<String> tamanoDimensiones;
    private List<ExpresionAritmetica> cuartetosDimensiones;
    private String tSalida;
    private String dimensionGeneral;
    private String etSalida;
    
//constructor variable
    public Simbolos( String nombre, String categoria, String tipo, Integer ambito) {
        
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.ambito = ambito;
    }
// constructor subprograma
    public Simbolos( String nombre, String categoria, String tipo, Integer ambito, Integer numeroParameteros, List<String> listaParametros,  List<Instruction> instruccionesFuncion, String tSalida,String etSalida) {
        
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.numeroParameteros = numeroParameteros;
        this.listaParametros = listaParametros;
        this.ambito = ambito;
        this.instruccionesFuncion = instruccionesFuncion;
        this.tSalida = tSalida;
        this.etSalida = etSalida;
        this.vecesUsadaLaFuncion = 0;
        if(!tipo.equals("void")){
        Temporales.agregarT(tSalida, tipo);    
        }
        
        
    }
    
    
    //constructor para arreglo
    public Simbolos( String nombre, String categoria, String tipo,Integer ambito,Integer numeroDimensiones, List<String> tamanoDimensiones, List<ExpresionAritmetica> cuartetosDimensiones){
        
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.ambito = ambito;
        this.numeroDimensiones = numeroDimensiones;
        this.tamanoDimensiones = tamanoDimensiones;
        this.cuartetosDimensiones = cuartetosDimensiones;
    }

    public String getDimensionGeneral() {
        return dimensionGeneral;
    }

    public void setDimensionGeneral(String dimensionGeneral) {
        this.dimensionGeneral = dimensionGeneral;
    }

    public List<String> getTemporalesParametros() {
        return temporalesParametros;
    }

    public void setTemporalesParametros(List<String> temporalesParametros) {
        this.temporalesParametros = temporalesParametros;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEtSalida() {
        return etSalida;
    }

    public void setEtSalida(String etSalida) {
        this.etSalida = etSalida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumeroParameteros() {
        return numeroParameteros;
    }

    public void setNumeroParameteros(Integer numeroParameteros) {
        this.numeroParameteros = numeroParameteros;
    }

    public List<String> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(List<String> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public Integer getAmbito() {
        return ambito;
    }

    public void setAmbito(Integer ambito) {
        this.ambito = ambito;
    }

    public List<Instruction> getInstruccionesFuncion() {
        return instruccionesFuncion;
    }

    public void setInstruccionesFuncion(List<Instruction> instruccionesFuncion) {
        this.instruccionesFuncion = instruccionesFuncion;
    }

    public List<ExpresionAritmetica> getCuartetosDimensiones() {
        return cuartetosDimensiones;
    }

    public void setCuartetosDimensiones(List<ExpresionAritmetica> cuartetosDimensiones) {
        this.cuartetosDimensiones = cuartetosDimensiones;
    }

    
    
    public String gettSalida() {
        return tSalida;
    }

    public void settSalida(String tSalida) {
        this.tSalida = tSalida;
    }

     

    public Integer getVecesUsadaLaFuncion() {
        return vecesUsadaLaFuncion;
    }

    public void setVecesUsadaLaFuncion(Integer vecesUsadaLaFuncion) {
        this.vecesUsadaLaFuncion = vecesUsadaLaFuncion;
    }

    public Integer getNumeroDimensiones() {
        return numeroDimensiones;
    }

    public void setNumeroDimensiones(Integer numeroDimensiones) {
        this.numeroDimensiones = numeroDimensiones;
    }

    public List<String> getTamanoDimensiones() {
        return tamanoDimensiones;
    }

    public void setTamanoDimensiones(List<String> tamanoDimensiones) {
        this.tamanoDimensiones = tamanoDimensiones;
    }

}
