package player;

import game.Board;

import java.util.Random;

//Plays a random move or looks a head x moves to create optimal move
public class RandomLookaheadPlayer implements Player {

	public static final int LOOKAHEAD_0 = 0;
	public static final int LOOKAHEAD_1 = 1;

	private int lookahead_set = 1;

	Random ran;

	public RandomLookaheadPlayer() {
		ran = new Random();
	}

	@Override
	public void move(Board board) {
		boolean moved = false;

		if (lookahead_set == LOOKAHEAD_1) {
			moved = lookahead1(board);
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

	private boolean winningMove(Board board, char piece) {
		boolean moved = false;
		moved=winningLine(board, piece, false);
		if (!moved) {
			moved=winningLine(board, piece, true);
		} if (!moved) {
			moved=winningDiagonal(board, piece, false);
		} if (!moved) {
			moved=winningDiagonal(board, piece, true);
		}
		return moved;
	}

	private boolean winningLine(Board board, char piece, boolean flip) {
		for (int x = 0; x<3; x++) {
			for (int y = 0; y<3; y++) {
				boolean move = true;
				char spot = (!flip) ? board.getSpace(x, y) : board.getSpace(y, x);
				if (spot != '\0') {
					move = false;
				}

				for (int yAgain = 0; yAgain < 3; yAgain++) {
					char otherSpot = (!flip) ? board.getSpace(x, yAgain) : board.getSpace(yAgain, x);
					if (y != yAgain && piece != otherSpot) {
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

	private boolean winningDiagonal(Board board, char piece, boolean flip) {
		int emptyX = -1;
		int emptyY = -1;

		char fill1 = '\0';
		char fill2 = '\0';

		for (int i = 0; i < 3; i++) { //Top left to bottom right
			char space = (!flip) ? board.getSpace(i, i) : board.getSpace(i, 2-i);
			if (space == '\0') {
				emptyX = i;
				emptyY = (!flip) ? i : 2-i;
			} else if (fill1 == '\0') {
				fill1 = space;
			} else {
				fill2 = space;
			}
		}

		if (emptyX != -1 && emptyY != -1 && (fill1^fill2) == 0) {
			board.move(emptyX, emptyY);
			return true;
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
			if (board.getSpace(0, 0) == '\0') {
				return empty;
			}
		}

		while(empty[0] < 3) {
			while (empty[1] < 2) {
				empty[1]++;
				if (board.getSpace(empty[0], empty[1]) == '\0') {
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
