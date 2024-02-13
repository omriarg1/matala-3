// Ofek caspi - 208895367
// Omri argaman - 314772351	

package assig3_1;
import java.util.concurrent.Semaphore;

public class T3 extends Thread {
	private Object lock;
	public T3() {
	lock=T1.getLock();
	}
	public void run() {
		while (true) {
			synchronized(lock) {
			if(T1.hasFinished() && T2.didWork()) {
			    	System.out.println("C");
			    	T1.setHasFinished(false);
			    	T2.setdidWork(false);
			}
			}
	}	
}
}