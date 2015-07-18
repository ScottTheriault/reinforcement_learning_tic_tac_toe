package game;

import player.Player;

public class Game {

	Player player1, player2;
	Board board;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;

		board = new Board();
	}

	public void play() {
		int turn = 0;

		while (!board.isFinished()) {
			if (turn == 0) {
				player1.move(board);
			} else {
				player2.move(board);
			}
			turn = turn^1; 
		}

		if (!board.isFirst_win() && !board.isSecond_win()) {
			player1.tieGame(board);
			player2.tieGame(board);
		} else {
			player1.addWin(board.isFirst_win(), board);
			player2.addWin(board.isSecond_win(), board);
		}
	}
}
