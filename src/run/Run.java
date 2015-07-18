package run;

import game.Game;
import player.HumanPlayer;
import player.Player;

public class Run {

	public static void main(String[] args) {
		Player player1 = new HumanPlayer();
		Player player2 = new HumanPlayer();
		Game game = new Game(player1, player2);
		game.play();
	}
}
