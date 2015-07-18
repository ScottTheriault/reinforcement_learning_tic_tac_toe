package player;

import game.Board;

import java.util.Random;

//Plays a random move or looks a head x moves to create optimal move
public class RandomLookaheadPlayer implements Player {

	public static final int LOOKAHEAD_0 = 0;
	public static final int LOOKAHEAD_1 = 1;
	public static final int LOOKAHEAD_2 = 2;

	private int lookahead_set = 1;

	Random ran;

	public RandomLookaheadPlayer() {
		ran = new Random();
	}

	@Override
	public void move(Board board) {
		boolean moved = false;

		if (lookahead_set == LOOKAHEAD_1 || lookahead_set == LOOKAHEAD_2) {
			moved = lookahead1(board);
		}

		if (!moved && lookahead_set == LOOKAHEAD_2) {
			moved = lookahead2(board);
		}

		if (!moved) {
			randomMove(board);
		}
	}

	//checks if can win this turn, if can't win, looks to prevent other from winning next turn
	private boolean lookahead1(Board board) {
		boolean moved = false;
		moved = winningMove(board, board.getTurnPiece());

		if(!moved) {
			moved = winningMove(board, board.getNextTurnPiece());
		}
		return moved;
	}

	private boolean lookahead2(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean winningMove(Board board, String piece) {
		boolean moved = false;
		moved=winningLine(board, piece, false);
		if (!moved) {
			moved=winningLine(board, piece, true);
		}
		return moved;
	}

	private boolean winningLine(Board board, String piece, boolean flip) {
		for (int x = 0; x<3; x++) {
			for (int y = 0; y<3; y++) {
				boolean move = true;
				String spot = (!flip) ? board.getSpace(x, y) : board.getSpace(y, x);
				if (spot != null) {
					move = false;
				}

				for (int yAgain = 0; yAgain < 3; yAgain++) {
					String otherSpot = (!flip) ? board.getSpace(x, yAgain) : board.getSpace(yAgain, x);
					if (y != yAgain && !piece.equals(otherSpot)) {
						move = false;
					}
				}

				if (move) {
					if (!flip) {
						board.move(x, y);
					} else {
						board.move(y, x);
					}
					return true;
				}
			}
		}
		return false;
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
