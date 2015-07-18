package run;

import game.Game;
import player.HumanPlayer;
import player.Player;
import player.RandomLookaheadPlayer;

public class Run {

	public static void main(String[] args) {
		Player humanPlayer = new HumanPlayer();
		Player randomLookaheadPlayer = new RandomLookaheadPlayer();
		Game game = new Game(humanPlayer, randomLookaheadPlayer);
		game.play();
	}
}
