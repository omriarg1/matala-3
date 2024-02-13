// Ofek caspi - 208895367
// Omri argaman - 314772351	

package assig3_3;

public class SlicerThread extends Thread {
	SlicerMachine Slicer;
	CucumbersThread Cucumbers;
	TomatoesThread Tomatoes;
	private int N;
	public SlicerThread(SlicerMachine s,CucumbersThread c,TomatoesThread t,int n) {
		Cucumbers=c;
		Tomatoes=t;
		N=n;
		Slicer=s;
	}
	public void run() {
		Cucumbers.start();
		Tomatoes.start();
		while(Slicer.getNumOfPreparedSalads()<N) {
			Slicer.sliceVegetables();
		}
		Cucumbers.interrupt();
		Tomatoes.interrupt();
	}
}
