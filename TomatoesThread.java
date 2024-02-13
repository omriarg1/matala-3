package assig3_3;

public class TomatoesThread extends Thread {
	SlicerMachine Slicer;
	private int NumberOfSaladsToPrepare;

	public TomatoesThread (SlicerMachine s,int n) {
		Slicer=s;
		NumberOfSaladsToPrepare=n;
	}
	public void run() {
		while(true) {
		while(Slicer.getNumOfTomatoes()==2) {
			try {
				synchronized(Slicer) {
				Slicer.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(Slicer.getNumOfTomatoes()<2&& Slicer.getNumOfPreparedSalads()<NumberOfSaladsToPrepare) {
			  Slicer.addOneTomato();
		}
		}
	}
}
