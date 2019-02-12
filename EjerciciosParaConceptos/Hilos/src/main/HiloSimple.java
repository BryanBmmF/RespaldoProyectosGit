package main;

/**
 * Hilos
 *
 * @author jose - 14.03.2018
 * @Title: HiloSimple
 * @Description: description
 *
 * Changes History
 */
public class HiloSimple extends Thread {

	public HiloSimple(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int count = 1, row = 1; row < 20; row++, count++) {
			for (int i = 0; i < count; i++) {
				System.out.print('*');
				if ((i % 2) == 0) {
					try {
						Thread.sleep(500);
						//System.out.println("---------" + this.getName());
						
					} catch (Exception e) {
					}
					
				}
			}
			System.out.print('\n');
		}
	}
}
