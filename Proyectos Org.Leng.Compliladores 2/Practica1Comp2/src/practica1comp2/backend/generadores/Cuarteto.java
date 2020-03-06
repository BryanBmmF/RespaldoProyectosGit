/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.generadores;

/**
 *
 * @author bryan
 */
public class Cuarteto {
    private Operador op;
    private String result;
    private String arg1;
    private String arg2;

    public Cuarteto(Operador op, String result, String arg1, String arg2) {
        this.op = op;
        this.result = result;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    
    public String imprimir(){
        String cod = "";
        switch (op) {
            case MAS:
                cod = result+" = "+arg1+"+"+arg2; 
                break;
            case MENOS:
                cod = result+" = "+arg1+"-"+arg2; 
                break;
            case POR:
                cod = result+" = "+arg1+"*"+arg2; 
                break;
            case DIV:
                cod = result+" = "+arg1+"/"+arg2; 
                break;
            case MOD:
                cod = result+" = "+arg1+"%"+arg2; 
                break;
            case ASIG:
                cod = result+" = "+arg1; 
                break;
            case ASIG_AR:
                cod =  arg2+"["+result+"]"+" = "+arg1; 
                break;
            case ASIG_AR2:
                cod = result+" = "+arg1+"["+arg2+"]";
                break;
            case DECL:
                cod = result+" = "+arg1; 
                break;
            case ETIQ:
                cod = result+" : "; 
                break;
            case IF_IGUAL:
                cod = " if ("+arg1+ " == "+arg2 + ") goto "+result ; 
		break;
            case IF_NOIGUAL:
                cod = " if ("+arg1+ " != "+arg2 + ") goto "+result ; 
		break;
            case IF_MAYOR:
                cod = " if ("+arg1+ " > "+arg2 + ") goto "+result ; 
		break;
            case IF_MAY_IGUAL:
                cod = " if ("+arg1+ " >= "+arg2 + ") goto "+result ; 
		break;
            case IF_MENOR:
                cod = " if ("+arg1+ " < "+arg2 + ") goto "+result ; 
		break;
            case IF_MEN_IGUAL:
                cod = " if ("+arg1+ " <= "+arg2 + ") goto "+result ; 
		break;
            case GOTO:
                cod = " goto "+result ; 
		break;
            case PRINT:
                cod = " print "+result ; 
		break;
            case PRINTLN:
                cod = " println "+result ; 
		break;
            default:
                //throw new AssertionError();//error en la generacin de codigo
        }
        return cod;
    }
    
    public void impEspecialArreglo(){
    
    }

    public Operador getOp() {
        return op;
    }

    public void setOp(Operador op) {
        this.op = op;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }
    
}
