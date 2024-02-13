package assig3_2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class GamePlay {// heads or tale
	private boolean coin_available_;
	private int rounds_counter_;
	private Semaphore sem;
	public GamePlay() {
		sem = new Semaphore(1, true);
		
	}
	//Make the coin available 
	public synchronized void makeCoinAvail(boolean val) {
		if (val == true) {
			coin_available_ = val;
			this.notifyAll();
		} else {
			coin_available_ = val;
		}
	}
//Flip coin
	public boolean flipCoin() throws InterruptedException {
		Random rnd = new Random();
		while (!coin_available_) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for coin");
				synchronized (this) {
					this.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(this) {
			if(!coin_available_)//visibility
			{sem.release();return false;}
		if(getNumOfRounds()==10)//End game
			{rounds_counter_++;return false;}
		makeCoinAvail(false);
		System.out.println(Thread.currentThread().getName() + " is flipping  coin");
		rounds_counter_++;
		makeCoinAvail(true);
		sem.release();
		return rnd.nextBoolean();
		}
	}
	public synchronized int getNumOfRounds() {
		return rounds_counter_;
	}
}
