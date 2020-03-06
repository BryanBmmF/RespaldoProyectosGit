package Objetos;

public class Instruccion {
    private String dest;
    private String op;
    private String op1;
    private String op2;

    public Instruccion(String dest, String op, String op1, String op2) {
        this.dest = dest;
        this.op = op;
        this.op1 = op1;
        this.op2 = op2;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }
    
}
