// Ofek caspi - 208895367
// Omri argaman - 314772351	

package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		// YOUR CODE HERE: use threads to prepare N salads (as the user requested)
		SlicerMachine Slicer = new SlicerMachine();
		CucumbersThread CucumbersT = new CucumbersThread(Slicer, numOfSaladsToPrepare);
		TomatoesThread TomatoesT = new TomatoesThread(Slicer, numOfSaladsToPrepare);
		SlicerThread SlicerT = new SlicerThread(Slicer, CucumbersT, TomatoesT, numOfSaladsToPrepare);
		//running the threads
		try {
			SlicerT.start();
			SlicerT.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		scan.close();
	}

}
