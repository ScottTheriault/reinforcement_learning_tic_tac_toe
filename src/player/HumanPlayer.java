package player;

import game.Board;

import java.util.Scanner;

//Human player you control
public class HumanPlayer implements Player {

	private Scanner KB;

	public HumanPlayer() {
		KB = new Scanner(System.in);
	}

	@Override
	public void move(Board board) {
		board.print();

		System.out.println("Down: ");
		int x = KB.nextInt();
		System.out.println("Across: ");
		int y = KB.nextInt();

		board.move(x,y);
	}

	@Override
	public void tieGame(Board board) {
		board.print();
		System.out.println("You Tied :-|");
		
	}

	@Override
	public void addWin(boolean first_win, Board board) {
		board.print();
		System.out.println((first_win) ? "You Win :-)" : "You Lost :-(");
	}

}
