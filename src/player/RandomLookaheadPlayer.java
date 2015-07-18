package player;

import game.Board;

import java.util.Random;

//Plays a random move or looks a head x moves to create optimal move
public class RandomLookaheadPlayer implements Player {

	Random ran;

	public RandomLookaheadPlayer() {
		ran = new Random();
	}

	@Override
	public void move(Board board) {
		randomMove(board);
	}

	private void randomMove(Board board) {
		int move = ran.nextInt(9-board.getMoves());
		int[] empty = {-1,-1};

		while (move != -1) {
			empty = nextEmpty(empty, board);
			move--;
		}
		board.move(empty[0], empty[1]);
	}

	private int[] nextEmpty(int[] empty, Board board) {
		if (empty[0] < 0 || empty[1] < 0) {
			empty[0] = 0;
			empty[1] = 0;
			if (board.getSpace(0, 0) == null) {
				return empty;
			}
		}

		while(empty[0] < 3) {
			while (empty[1] < 2) {
				empty[1]++;
				if (board.getSpace(empty[0], empty[1]) == null) {
					return empty;
				}
			}
			empty[0]++;
			empty[1]=-1;
		}
		//should never happen
		int[] err = {-1, -1};
		return err;
	}

	@Override
	public void tieGame(Board board) {}
	@Override
	public void addWin(boolean first_win, Board board) {}

}
