// Ofek caspi - 208895367
// Omri argaman - 314772351	

package assig3_3;

public class CucumbersThread extends Thread {
	SlicerMachine Slicer;
	private int NumberOfSaladsToPrepare;

	public CucumbersThread (SlicerMachine s,int n) {
		Slicer=s;
		NumberOfSaladsToPrepare=n;
	}
	public void run() {
		while(true) {
		while(Slicer.getNumOfCucumbers()==3) {
			try {
					synchronized(Slicer) {
						Slicer.wait();
						}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(Slicer.getNumOfCucumbers()<3 && Slicer.getNumOfPreparedSalads()<NumberOfSaladsToPrepare) {
			Slicer.addOneCucumber();
		}
		}
	}

}
