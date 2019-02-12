package main;

import tienda.cajero.Cajero;
import tienda.cajero.CajeroThread;
import tienda.cliente.Cliente;

/**
 *
 * @author jose
 */
public class run {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
//		HiloSimple hilo = new HiloSimple("HiloSimple");
//		HiloSimpleRunnable hiloRunnable = new HiloSimpleRunnable('X');
//		HiloSimpleRunnable hiloRunnable2 = new HiloSimpleRunnable('Y');
//		Thread hiloRunnableConThread = new Thread(hiloRunnable2, "runable con envoltura");
//		Thread hiloRunnableEnvoltura = new Thread(hiloRunnable);
//		System.out.println("inicio hilo simple");
//		hilo.start();
//		hiloRunnable.run();
//		hiloRunnableEnvoltura.start();
//		System.out.println("DESPUES DEL HILO");
//		System.out.println("ejecutando: " + hiloRunnableConThread.getName());
//		hiloRunnableConThread.start();
//		
		
		
		
		
		/*System.out.println("Logica de calculo de cuadrados");
		for (int i = 0; i < 50; i++) {
			System.out.println("i = " + i + ", i * i = " + i * i);
		}*/
		
//		tiempo en que inician las cajeras
		long tiempoReferencia = System.currentTimeMillis();
		
		Cliente cliente1 = new Cliente("cliente1", new int[]{2, 2, 1, 5, 2, 3});
		Cliente cliente2 = new Cliente("cliente2", new int[]{1, 3, 5, 1, 1});
//		Cajero cajera1 = new Cajero("Cajera1");
//		Cajero cajera2 = new Cajero("Cajera2");
//		
//		
//		cajera1.procesarCompra(cliente1, tiempoReferencia);
//		cajera2.procesarCompra(cliente2, tiempoReferencia);
//		
		CajeroThread cajera1 = new CajeroThread("Cajera1", cliente1, tiempoReferencia);
		CajeroThread cajera2 = new CajeroThread("Cajera2", cliente2, tiempoReferencia);
		
		cajera1.start();
		cajera2.start();
		
		System.out.println("Finaliza hilo principal");
		
		for (int i = 0; i < 200; i++) {
			System.out.println("proceso principal");
			Thread.sleep(100);
		}
	

	}
}
