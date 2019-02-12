package main;

/**
 * Hilos
 *
 * @author jose - 15.03.2018
 * @Title: HiloSimpleRunnable
 * @Description: description
 *
 * Changes History
 */
public class HiloSimpleRunnable implements Runnable {

	private char character ;

	public HiloSimpleRunnable(char character) {
		this.character = character;
	}
	
	
	@Override
	public void run() {
		for (int count = 1, row = 1; row < 20; row++, count++) {
			for (int i = 0; i < count; i++) {
				System.out.print(character);
				if ((i % 3) == 0) {
					try {
						Thread.sleep(300);
						//System.out.println("-----------" + character);
					} catch (Exception e) {
					}
					
				}
			}
			System.out.print('\n');
		}
	}

}
