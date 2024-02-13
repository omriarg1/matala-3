package assig3_2;

public class Main {

	public static void main(String[] args) {
		GamePlay game = new GamePlay();
		Gamer Gamer1 = new Gamer(game);
		Gamer Gamer2 = new Gamer(game);
		Judge judge = new Judge(game);
		Thread t1 = new Thread(Gamer1, "Gamer 1");
		Thread t2 = new Thread(Gamer2, "Gamer 2");
		Thread judgeThread = new Thread(judge);
		//starting threads
		t1.start();
		t2.start();
		judgeThread.start();
		try {//waiting for game to end
			t1.join();
			t2.join();
		}  catch (InterruptedException e) {
			e.printStackTrace();
		}
		//interrupting Threads
		t1.interrupt();
		t2.interrupt();
		judgeThread.interrupt();
		if (Gamer1.getScore() == Gamer2.getScore()) {
			System.out.println("Tie");
		}
		if (Gamer1.getScore() > Gamer2.getScore()) {
			System.out.println("Gamer 1 wins");

		} else if (Gamer1.getScore() < Gamer2.getScore()) {
			System.out.println("Gamer 2 wins");
		}
	}
}