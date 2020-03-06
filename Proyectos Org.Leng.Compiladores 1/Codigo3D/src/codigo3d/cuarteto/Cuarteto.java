/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo3d.cuarteto;

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
            case MULT:
                cod = result+" = "+arg1+"*"+arg2; 
                break;
            case ASIGN:
                cod = result+" = "+arg1; 
                break;
            default:
                throw new AssertionError();
        }
        return cod;
    }
    
}
