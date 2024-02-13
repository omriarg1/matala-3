package assig3_1;

import java.util.concurrent.Semaphore;

public class T1 extends Thread {
	private static boolean hasFinished;
	private static final Object Lock=new Object();
	public T1() {
	}
    public static synchronized boolean hasFinished() {
    	return hasFinished;
    }
    public static synchronized void setHasFinished(boolean val) {
    	hasFinished=val;
    }
	public void run() {
		while (true) {
			synchronized(Lock) {
			if(!hasFinished) {
					System.out.println("A");
					hasFinished=true;
					}
			}
		}
	}
	public synchronized static Object getLock() {
		return Lock;
	}
}