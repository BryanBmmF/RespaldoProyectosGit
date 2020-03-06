package Objetos;

import frames.Reporte;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jflexCup.lexico;
import jflexCup.parser;

public class ManejoDatos {

    private List<TokError> errores;
    private List<Variable> variables;
    private List<Arreglo> arreglos;
    private File archivo;
    private File archivoC;
    public  String contenido;
    private List<Instruccion> instrucciones;
    public List<Variable> vars3d;
    public List<Variable> varsC;
    

    public ManejoDatos() {
        errores = new ArrayList<>();
        variables = new ArrayList<>();
        arreglos = new ArrayList<>();
        instrucciones = new ArrayList<>();
        vars3d = new ArrayList();
        varsC = new ArrayList();
    }
    //Gestion codigo 3 direcciones

    public void addVar3d(Variable variable) {
        vars3d.add(variable);
    }

    //Gestion de los analizadores
    public void analizarCodigo(String texto) {
        this.errores.clear();
        this.variables.clear();
        this.vars3d.clear();
        this.instrucciones.clear();
        this.varsC.clear();
        try {
            new parser(new lexico(new StringReader(texto), errores), this).parse();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada");
        }
        new Reporte(this, errores).setVisible(true);
    }
    //Gestion de Variables

    public boolean existeVariable(Variable variable) {
        boolean resultado = false;
        for (int i = 0; i < variables.size(); i++) {
            if (variable.getNombre().equals(variables.get(i).getNombre())) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public Variable getVariable(String nombre, int fila, int columna) {
        Variable resultado = null;
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getNombre().equals(nombre)) {
                resultado = variables.get(i);
                break;
            } else if (variables.size() - 1 == i) {
                errores.add(new TokError(nombre, "no se encontro variable", fila, columna));
            }
        }
        return resultado;
    }

    public void agregarVariable(Variable variable, int fila, int columna) {
        if (!existeVariable(variable)) {
            this.variables.add(variable);
        } else {
            this.errores.add(new TokError(variable.getNombre(), "Variable ya existe", fila, columna));
        }
    }

    public void agregarInstruccion(String dest, String op, String op1, String op2, int fila, int columna) {

    }

    public void addInstruccion(Instruccion instruccion) {
        this.instrucciones.add(instruccion);
    }

    public void agregarVariableArreglo(Arreglo arreglo) {
        this.arreglos.add(arreglo);
    }

    //Gestion de Archivos
    public void setContenido(String contenido){
        this.contenido=contenido;
    }
    
    public File getArchivo() {
        return archivo;
    }

    public void agregarFile(File archivo) {
        this.archivo = archivo;
    }

    public void quitarArchivo() {
        this.archivo = null;
    }
    public void addFileC(File file){
        this.archivoC=file;
    }
    public File getFileC(){
        return this.archivoC;
    }

    //Manejo de Errores
    public void addErrores(String token, String tipo, int fila,    int columna) {
        errores.add(new TokError(token, tipo, fila, columna));
    }

    //generarCodigo
    public String getCodigo3d() {
        String codigo = "";
        for (int i = 0; i < vars3d.size(); i++) {
            codigo += vars3d.get(i).getNombre() + "=" + vars3d.get(i).getValor() + "\n";
        }
        codigo += "\n";
        for (int i = 0; i < instrucciones.size(); i++) {
            String destino = instrucciones.get(i).getDest();
            switch (destino) {
                case "if":
                    codigo += "if(" + instrucciones.get(i + 1).getOp1() + instrucciones.get(i + 1).getOp() + instrucciones.get(i + 1).getOp2() + ") goto " + instrucciones.get(i).getOp1() + "\n";
                    codigo += "goto " + instrucciones.get(i).getOp2() + "\n";
                    codigo += instrucciones.get(i).getOp1() + ":\n";
                    i++;
                    break;
                case "ifUn":
                    codigo += "if(" + instrucciones.get(i + 1).getOp1() + ") goto " + instrucciones.get(i).getOp1() + "\n";
                    codigo += "goto " + instrucciones.get(i).getOp2() + "\n";
                    codigo += instrucciones.get(i).getOp1() + ":\n";
                    i++;
                    break;
                case "else":
                    codigo += "goto " + instrucciones.get(i).getOp2() + "\n";
                    codigo += instrucciones.get(i).getOp1() + ":\n";
                    break;
                case "finWhile":
                    codigo += "goto " + instrucciones.get(i).getOp1() + "\n";
                    codigo += instrucciones.get(i).getOp2() + ":\n";
                    break;
                case "fin":
                    codigo += instrucciones.get(i).getOp1() + ":\n";
                    break;
                case "while":
                    codigo += instrucciones.get(i).getOp() + ":\n";
                    codigo += "if(" + instrucciones.get(i + 1).getOp1() + instrucciones.get(i + 1).getOp() + instrucciones.get(i + 1).getOp2() + ") goto " + instrucciones.get(i).getOp1() + "\n";
                    codigo += "goto " + instrucciones.get(i).getOp2() + "\n";
                    codigo += instrucciones.get(i).getOp1() + ":\n";
                    i++;
                    break;
                case "prints":
                    codigo += instrucciones.get(i).getDest() + " " + instrucciones.get(i).getOp1() + "\n";
                    break;
                case "printn":
                    codigo += instrucciones.get(i).getDest() + " " + instrucciones.get(i).getOp1() + "\n";
                    break;
                case "scanS":
                    codigo += instrucciones.get(i).getDest() + " " + instrucciones.get(i).getOp1() + "\n";
                    break;
                case "scanN":
                    codigo += instrucciones.get(i).getDest() + " " + instrucciones.get(i).getOp1() + "\n";
                    break;
                case "break":
                    codigo += "break\n";
                    break;
                case "Arreglo":
                    break;
                default:
                    codigo += instrucciones.get(i).getDest() + "=" + instrucciones.get(i).getOp1() + instrucciones.get(i).getOp() + instrucciones.get(i).getOp2() + "\n";
                    break;
            }
        }
        return codigo;
    }

    public String getCodigoC() {
        String codigo = "#include <stdio.h>\n#include <stdbool.h>\n";
        codigo += "int main(){ \n";
        for (int i = 0; i < vars3d.size(); i++) {
            String tipo = vars3d.get(i).getTipo();
            switch (tipo) {
                case "String":
                    codigo += "char " + vars3d.get(i).getNombre() + "[50] =" + vars3d.get(i).getValor() + ";\n";
                    break;
                case "boolean":
                    codigo += "bool " + vars3d.get(i).getNombre() + "=" + vars3d.get(i).getValor() + ";\n";
                    break;
                case "Arreglo":
                    break;
                default:
                    codigo += vars3d.get(i).getTipo() + " " + vars3d.get(i).getNombre() + "=" + vars3d.get(i).getValor() + ";\n";
                    break;
            }

        }
        for (int i = 0; i < varsC.size(); i++) {
            codigo += varsC.get(i).getTipo() + " " + varsC.get(i).getNombre() + ";\n";

        }
        for (int i = 0; i < instrucciones.size(); i++) {
            String destino = instrucciones.get(i).getDest();
            switch (destino) {
                case "if":
                    codigo += "if(" + instrucciones.get(i + 1).getOp1() + instrucciones.get(i + 1).getOp() + instrucciones.get(i + 1).getOp2() + ") {\n";
                    i++;
                    break;
                case "prints":
                    codigo += "printf(" + instrucciones.get(i).getOp1() + ");\n";
                    break;
                case "printn":
                    String tipo = this.getVariable(instrucciones.get(i).getOp1(), 0, 0).getTipo();
                    switch (tipo) {
                        case "int":
                            codigo += "printf(\"%i\"," + instrucciones.get(i).getOp1() + ");\n";
                            break;
                        case "float":
                            codigo += "printf(\"%f\"," + instrucciones.get(i).getOp1() + ");\n";
                            break;
                        case "String":
                            codigo += "printf(\"%s\"," + instrucciones.get(i).getOp1() + ");\n";
                            break;
                        default:
                            break;
                    }
                    break;
                case "scanN":
                    String tipo1 = this.getVariable(instrucciones.get(i).getOp1(), 0, 0).getTipo();
                    switch (tipo1) {
                        case "int":
                            codigo += "scanf(\"%i\",&" + instrucciones.get(i).getOp1() + ");\n";
                            break;
                        case "float":
                            codigo += "scanf(\"%f\",&" + instrucciones.get(i).getOp1() + ");\n";
                            break;
                        default:
                            break;
                    }
                    break;
                case "scanS":
                    codigo += "scanf(\"%s\"," + instrucciones.get(i).getOp1() + ");\n";
                    break;
                case "ifUn":
                    codigo += "if(" + instrucciones.get(i + 1).getOp1() + ") {\n";
                    i++;
                    break;
                case "else":
                    codigo += "} else { \n";
                    break;
                case "finWhile":
                    codigo += "}\n";
                    break;
                case "fin":
                    codigo += "}\n";
                    break;
                case "while":
                    codigo += "while(" + instrucciones.get(i + 1).getOp1() + instrucciones.get(i + 1).getOp() + instrucciones.get(i + 1).getOp2() + ") {\n";
                    i++;
                    break;
                case "break":
                    codigo += "break;\n";
                    break;
                default:
                    codigo += instrucciones.get(i).getDest() + "=" + instrucciones.get(i).getOp1() + instrucciones.get(i).getOp() + instrucciones.get(i).getOp2() + ";\n";
                    break;
            }
        }
        codigo += "return 0;\n}";
        return codigo;
    }
}
