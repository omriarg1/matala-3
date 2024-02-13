// Ofek caspi - 208895367
// Omri argaman - 314772351	

package assig3_2;

import java.util.concurrent.Semaphore;
public class Judge implements Runnable{
private GamePlay Game;
public void run() {
	judge();
}
public Judge(GamePlay Game) {
	this.Game=Game;
}
public void judge() {
	while(!Thread.currentThread().isInterrupted()) {
		Game.makeCoinAvail(false);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Judge is interrupted");
		}
		Game.makeCoinAvail(true);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Judge is interrupted");
		}
	}
	}
}



