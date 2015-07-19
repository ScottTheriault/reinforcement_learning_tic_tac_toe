package run;

import game.Game;

import java.sql.SQLException;
import java.util.Scanner;

import player.HumanPlayer;
import player.Player;
import player.RandomLookaheadPlayer;
import player.ReinforcementLearningPlayer;
import util.Util;

public class Run {

	private static Scanner KB;

	private static Player humanPlayer;
	private static RandomLookaheadPlayer randomLookaheadPlayer;
	private static ReinforcementLearningPlayer rlPlayer1;
	private static ReinforcementLearningPlayer rlPlayer2;

	private static boolean alternatingTurns = true;

	public static void main(String[] args) throws SQLException {
		KB = new Scanner(System.in);

		humanPlayer = new HumanPlayer();
		randomLookaheadPlayer = new RandomLookaheadPlayer();
		rlPlayer1 = new ReinforcementLearningPlayer();
		rlPlayer2 = new ReinforcementLearningPlayer();

		mainMenu();
	}

	private static void mainMenu() {
		System.out.println("Main Menu:");
		System.out.println("__________");
		System.out.println("(1) Play");
		System.out.println("(2) Options");
		System.out.println("(3) Exit");

		String option = KB.nextLine();

		switch (option){
			case "1": playMenu();
				break;
			case "2": optionMenu();
				break;
			case "3": exit();
			default : mainMenu();
		}
	}

	private static void playMenu() {
		Player player1 = getPlayer(1);
		Player player2 = getPlayer(2);

		int rounds = getRounds();

		for (int i = 0; i<rounds; i++) {
			Game game = new Game(player1, player2);
			game.play();
			if (alternatingTurns) {
				game = new Game(player2, player1);
				game.play();
			}
		}

		mainMenu();
	}

	private static void optionMenu() {
		System.out.println("Option Menu:");
		System.out.println("____________");

		System.out.println("(1) Random Lookahead:" + ((randomLookaheadPlayer.getLookahead_set() == RandomLookaheadPlayer.LOOKAHEAD_1) ? "ON" : "OFF"));
		System.out.println("(2) Alternating Turns:" + ((alternatingTurns) ? "ON" : "OFF"));
		System.out.println("(3) Main Menu:");

		String option = KB.nextLine();

		switch (option){
		case "1": randomLookaheadPlayer.setLookahead_set(randomLookaheadPlayer.getLookahead_set()^RandomLookaheadPlayer.LOOKAHEAD_1);
			break;
		case "2": alternatingTurns = !alternatingTurns;
			break;
		case "3": mainMenu();
			return;
		}

		optionMenu();
	}

	private static void exit() {
		System.out.println("Good By");
		System.exit(0);
	}

	private static Player getPlayer(int number) {
		System.out.println("Player " + number + ":");
		System.out.println("_________");

		System.out.println("(1) Human");
		System.out.println("(2) Random Lookahead");
		System.out.println("(3) Reinforcement Learning Player 1");
		System.out.println("(4) Reinforcement Learning Player 2");

		Player player;

		String option = KB.nextLine();

		switch (option){
			case "1": player = humanPlayer;
				break;
			case "2": player = randomLookaheadPlayer;
				break;
			case "3": player = rlPlayer1;
				break;
			case "4": player = rlPlayer2;
				break;
			default : return getPlayer(number);
		}

		return player;
	}

	private static int getRounds() {
		System.out.println("Number of rounds: ");
		String rounds = KB.nextLine();

		if (Util.isInteger(rounds)) {
			int ret = Integer.parseInt(rounds);
			return ret;
		}
		return getRounds();
	}
}
