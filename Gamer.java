// Ofek caspi - 208895367
// Omri argaman - 314772351	

package assig3_2;

public class Gamer implements Runnable {
	private int goodFlipsCounter;
	private GamePlay Game;

	public void run() {
		play();
	}

	public Gamer(GamePlay thisGame) {
		goodFlipsCounter = 0;
		Game = thisGame;
	}

	public int getScore() {
		return goodFlipsCounter;
	}

	public void play() {//play until interrupted or game ended
		while (!Thread.currentThread().isInterrupted() && Game.getNumOfRounds() <= 10) {
			boolean goodFlip;
			try {
				if (Game.getNumOfRounds() < 10) {
					goodFlip = Game.flipCoin();
					if (goodFlip)
						goodFlipsCounter++;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
