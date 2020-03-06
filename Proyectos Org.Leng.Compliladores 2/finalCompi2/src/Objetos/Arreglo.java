package Objetos;

import java.util.ArrayList;
import java.util.List;

public class Arreglo {

    private String nombre;
    private String tipo;
    private int dimension;
    private int tamano;
    private List<Variable> variables;

    public Arreglo(String nombre, String tipo, int dimension, int tamano) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dimension = dimension;
        this.tamano = tamano;
        this.variables = new ArrayList<>();
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < tamano; i++) {
            switch (tipo) {
                case "int":
                    variables.add(new Variable(tipo, nombre,"0"));
                    break;
                case "float":
                    variables.add(new Variable(tipo, nombre, "0f"));
                    break;
                case "String":
                    variables.add(new Variable(tipo, nombre, ""));
                    break;
                case "boolean":
                    variables.add(new Variable(tipo, nombre,"false"));
                    break;  
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void addVariable(Variable variable) {
        variables.add(variable);
    }

    public Variable getVarIndex(int index) {
        return variables.get(index);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

}
