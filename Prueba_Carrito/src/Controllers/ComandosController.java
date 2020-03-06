/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Instruccion;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortException;

/**
 *
 * @author jpmazate
 */
public class ComandosController {

    PanamaHitek_Arduino arduino;
    final double VEL_ALTA_DISTANCIA = 0.0411861614;
    final double VEL_MEDIA_DISTANCIA = 0.0355618777;
    final double VEL_BAJA_DISTANCIA = 0.0287521564;

    final double VEL_ALTA_ANGULO = 0.0548780488;
    final double VEL_MEDIA_ANGULO = 0.0430278884;
    final double VEL_BAJA_ANGULO = 0.0345887779;

    public ComandosController(PanamaHitek_Arduino arduino) {
        this.arduino = arduino;
    }

    public PanamaHitek_Arduino getArduino() {
        return arduino;
    }

    public void setArduino(PanamaHitek_Arduino arduino) {
        this.arduino = arduino;
    }

    public double convertirAngulo(int angulo, String velocidad) {
        double tiempo;
        double vel;

        if (velocidad.equals("h")) {
            vel = this.VEL_ALTA_ANGULO;
        } else if (velocidad.equals("i")) {
            vel = this.VEL_MEDIA_ANGULO;
        } else {
            vel = this.VEL_BAJA_ANGULO;
        }
        tiempo = angulo / vel;

        return tiempo;
    }

    public double convertirDistancia(int distancia, String velocidad) {
        double tiempo;
        double vel;

        if (velocidad.equals("h")) {
            vel = this.VEL_ALTA_DISTANCIA;
        } else if (velocidad.equals("i")) {
            vel = this.VEL_MEDIA_DISTANCIA;
        } else {
            vel = this.VEL_BAJA_DISTANCIA;
        }
        tiempo = distancia / vel;

        return tiempo;
    }

    public void adelante(Instruccion instruccion) throws ArduinoException, SerialPortException, InterruptedException {
        double tiempoAngulo = convertirAngulo(instruccion.getAngulo(), instruccion.getVelocidad());
        double tiempoDistancia = convertirDistancia(instruccion.getDistancia(), instruccion.getVelocidad());
        long v = (long) tiempoAngulo;
        long va = (long) tiempoDistancia;
        arduino.sendData(instruccion.getVelocidad());
        arduino.sendData(instruccion.getLado());
        Thread.sleep((long) tiempoAngulo);
        arduino.sendData(instruccion.getTipoMovimiento());
        Thread.sleep((long) tiempoDistancia);
    }

    public void atras(Instruccion instruccion) throws ArduinoException, SerialPortException, InterruptedException {
        double tiempoAngulo = convertirAngulo(instruccion.getAngulo(), instruccion.getVelocidad());
        double tiempoDistancia = convertirDistancia(instruccion.getDistancia(), instruccion.getVelocidad());
        long v = (long) tiempoAngulo;
        long va = (long) tiempoDistancia;
        arduino.sendData(instruccion.getVelocidad());
        arduino.sendData(instruccion.getLado());
        Thread.sleep((long) tiempoAngulo);
        arduino.sendData(instruccion.getTipoMovimiento());
        Thread.sleep((long) tiempoDistancia);
    }

    public void moverseConTiempo(Instruccion instruccion) throws ArduinoException, SerialPortException, InterruptedException {
        arduino.sendData(instruccion.getTipoMovimiento());
        Thread.sleep(instruccion.getTiempo());
    }

    public void velocidad(String velocidad) throws ArduinoException, SerialPortException {
        arduino.sendData(velocidad);
    }

    public void parar() throws ArduinoException, SerialPortException {
        arduino.sendData("c");
    }

}
