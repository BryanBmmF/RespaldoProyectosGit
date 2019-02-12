/*
 *clase carwash
 */
package examenfinal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class CarWash extends Thread{

    
    public static List<Cliente> listaClientes= new ArrayList<>();
        private String empleado;

	private Cliente cliente;

	private long initialTime;

    public CarWash(String empleado, Cliente cliente, long initialTime) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }
    public CarWash(){
    }
    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        System.out.println("El empleado " + this.empleado + " COMIENZA A DARLE SERIVCIO" 
					+ this.cliente.getNombre() + " EN EL TIEMPO: " 
					+ (System.currentTimeMillis() - this.initialTime) / 1000 
					+ "seg");

        this.esperarXsegundos(tiemposCarros(empleado, empleado));
        System.out.println("El Empleado " + this.empleado + " HA TERMINADO DE REALIZAR EL SERVICIO " 
                            + this.cliente.getNombre() + " EN EL TIEMPO: " 
                            + (System.currentTimeMillis() - this.initialTime) / 1000 
                            + "seg");
	}

	private void esperarXsegundos(int segundos) {
            try {
                Thread.sleep(segundos * 1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
	}    
    public void ingresarClientes(Cliente cliente){
        
        listaClientes.add(cliente);
        
    }
    public int tiemposCarros(String carro, String servicio){
        int tiempo=0;
        switch(carro){
            case "Sedan":{tiempo=4;
                break;
            }
            case "Pick-UP":{
                tiempo=5;
                break;
            }
            case "Camioneta":{
                tiempo=6;
                break;
            }
            case "Pesado":{
                tiempo=7;
                break;
            }
        }
        return tiempo;
    }
    
        
 }
