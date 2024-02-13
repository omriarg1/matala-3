package assig3_1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class T2 extends Thread {
	private static boolean didWork;
	private Object lock;

	public T2() {
		lock = T1.getLock();
		didWork = false;
	}

	public synchronized static boolean didWork() {
		return didWork;
	}

	public synchronized static void setdidWork(boolean Val) {
		didWork = Val;
	}

	public void run() {
		while (true) {
			synchronized (lock) {
				if (T1.hasFinished()) {
					System.out.println("B");
					didWork = true;
				}
			}
		}
	}
}