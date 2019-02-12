package tienda.cajero;

import tienda.cliente.Cliente;

/**
 * Hilos
 *
 * @author jose - 14.03.2017
 * @Title: CajeroThread
 * @Description: description
 *
 * Changes History
 */
public class CajeroThread extends Thread {

	private String nombre;
	private Cliente cliente;
	private long tiempoInicialReferencia;

	public CajeroThread(String nombre, Cliente cliente, long tiempoInicialReferencia) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.tiempoInicialReferencia = tiempoInicialReferencia;
	}

	@Override
	public void run() {
		procesarCompra(cliente, tiempoInicialReferencia);
	}

	public void procesarCompra(Cliente cliente, long tiempoInicialReferencia) {
		System.out.println("La cajera " + this.nombre
			   + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre()
			   + " EN EL TIEMPO: " + (System.currentTimeMillis() - tiempoInicialReferencia) / 1000
			   + "seg");
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {
			this.esperar(cliente.getCarroCompra()[i]);
			System.out.println("Se ha procesado el producto " + (i + 1)
				   + " del cliente " + this.cliente.getNombre()  + ". Tiempo que duró el proceso: " + cliente.getCarroCompra()[i] + "seg."
				   + "->Tiempo que ha pasado: "
				   + (System.currentTimeMillis() - this.tiempoInicialReferencia) / 1000
				   + "seg");
		}
		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR "
			   + cliente.getNombre() + " EN EL TIEMPO: "
			   + (System.currentTimeMillis() - tiempoInicialReferencia) / 1000 + "seg");

	}

	private void esperar(int segundos) {
		try {
			Thread.sleep(segundos * 500);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
