package run;

import game.Game;

import java.util.Scanner;

import player.HumanPlayer;
import player.Player;
import player.RandomLookaheadPlayer;
import util.Util;

public class Run {

	private static Scanner KB;

	private static Player humanPlayer;
	private static Player randomLookaheadPlayer;

	public static void main(String[] args) {
		KB = new Scanner(System.in);

		humanPlayer = new HumanPlayer();
		randomLookaheadPlayer = new RandomLookaheadPlayer();

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
		}

		mainMenu();
	}

	private static void optionMenu() {
		System.out.println("Option Menu:");
		System.out.println("____________");
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

		Player player;

		String option = KB.nextLine();

		switch (option){
			case "1": player = humanPlayer;
				break;
			case "2": player = randomLookaheadPlayer;
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
