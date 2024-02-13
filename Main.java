// Ofek caspi - 208895367
// Omri argaman - 314772351	

package assig3_1;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args){
	        T1 t1 = new T1();
	        T2 t2 = new T2();
	        T3 t3 = new T3();
	        t1.start();
	        t2.start();
	        t3.start();
	}

}