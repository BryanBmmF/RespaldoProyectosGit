/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jpmazate
 */
public class Instruccion {
    
    private String tipoMovimiento;
    private int tiempo;
    private String velocidad;
    
    private int distancia;
    private int angulo;
    private String lado;
    private boolean instr2;
    
    

    public Instruccion(String tipoMovimiento, int tiempo, String velocidad) {
        this.tipoMovimiento = tipoMovimiento;
        this.tiempo = tiempo;
        this.velocidad = velocidad;
        this.instr2 = false;
    }

    public Instruccion(String tipoMovimiento, int distancia, int angulo, String lado,String velocidad) {
        this.tipoMovimiento = tipoMovimiento;
        this.distancia = distancia;
        this.angulo = angulo;
        this.lado = lado;
        this.velocidad = velocidad;
        this.instr2 = true;
    }
    
    

    
    
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    public boolean isInstr2() {
        return instr2;
    }

    public void setInstr2(boolean instr2) {
        this.instr2 = instr2;
    }
    
    
    
}
