/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclases;

/**
 *
 * @author christian
 */
public class carros {
    byte llantas;
    String color;
    byte puertas;
    String marca;
    String modelo;
    byte asientos;

    public byte getLlantas() {
        return llantas;
    }

    public void setLlantas(byte llantas) {
        this.llantas = llantas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte getPuertas() {
        return puertas;
    }

    public void setPuertas(byte puertas) {
        this.puertas = puertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public byte getAsientos() {
        return asientos;
    }

    public void setAsientos(byte asientos) {
        this.asientos = asientos;
    }

    public carros(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    
}
