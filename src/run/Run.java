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
	private static ReinforcementLearningPlayer rlPlayer;

	private static boolean alternatingTurns = true;

	public static void main(String[] args) throws SQLException {
		KB = new Scanner(System.in);

		humanPlayer = new HumanPlayer();
		randomLookaheadPlayer = new RandomLookaheadPlayer();
		rlPlayer = new ReinforcementLearningPlayer();

		mainMenu();
	}

	private static void mainMenu() {
		System.out.println("Main Menu:");
		System.out.println("__________");
		System.out.println("(1) Play");
		System.out.println("(2) Options");
		System.out.println("(3) Reinforement Learning Player Options");
		System.out.println("(4) Exit");

		String option = KB.nextLine();

		switch (option){
			case "1": playMenu();
				break;
			case "2": optionMenu();
				break;
			case "3": rlPlayerOptions();
				break;
			case "4": exit();
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

		ReinforcementLearningPlayer RLP = null;

		if (player1 instanceof ReinforcementLearningPlayer) {
			RLP = (ReinforcementLearningPlayer) player1;
		} else if (player2 instanceof ReinforcementLearningPlayer) {
			RLP = (ReinforcementLearningPlayer) player2;
		}

		if (RLP != null) {
			System.out.println("Saving");
			RLP.save();
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

	private static void rlPlayerOptions() {
		System.out.println("Learner Option:");
		System.out.println("______________");

		System.out.println("(1) Win Gain:" + rlPlayer.getWinGain());
		System.out.println("(2) Loss Gain:" + rlPlayer.getLossGain());
		System.out.println("(3) Tie Gain:" + rlPlayer.getTieGain());
		System.out.println("(4) Print Score:" + (rlPlayer.isPrintScore() ? "ON" : "OFF"));
		System.out.println("(5) Print On Games:" + rlPlayer.getPrintOn());
		System.out.println("(6) Main Menu:");

		String option = KB.nextLine();

		switch (option){
			case "1": rlPlayer.setWinGain(getNextInt());
				break;
			case "2": rlPlayer.setLossGain(getNextInt());
				break;
			case "3": rlPlayer.setTieGain(getNextInt());
				break;
			case "4": rlPlayer.setPrintScore(!rlPlayer.isPrintScore());
				break;
			case "5": rlPlayer.setPrintOn(getNextInt());
				break;
			case "6": mainMenu();
				return;
		}

		rlPlayerOptions();
	}

	private static int getNextInt() {
		String num = KB.nextLine();
		if (Util.isInteger(num)) {
			return Integer.parseInt(num);
		} else {
			System.out.println("Not a integer");
			System.exit(1);
		}
		return 0;
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

		Player player;

		String option = KB.nextLine();

		switch (option){
			case "1": player = humanPlayer;
				break;
			case "2": player = randomLookaheadPlayer;
				break;
			case "3": player = rlPlayer;
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
