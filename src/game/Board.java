package game;

public class Board {

	final public static char FIRST = 'X';
	final public static char SECOND = 'Y';
	final public static char TIE = 'T';

	private int moves = 0;
	private boolean firstWin = false;
	private boolean secondWin = false;
	
	private char[][] board;

	public Board() {
		board = new char[3][3];
	}

	public void move(int x, int y) {
		if (board[x][y] == '\0') {
			board[x][y] = getTurnPiece();
			checkFinished(x, y);
			moves++;
		} else {
			System.out.println("Invalid Move: " + x + ": " + y);
			moves = 9;
		}
	}

	private void checkFinished(int x, int y) {
		boolean win = false;

		if (board[x][y] == board[x][0] && board[x][y] == board[x][1] && board[x][y] == board[x][2]) { //Across
			win = true;
		} else if (board[x][y] == board[0][y] && board[x][y] == board[1][y] && board[x][y] == board[2][y]) { //Down
			win = true;
		} else if (x == y && board[x][y] == board[0][0] && board[x][y] == board[1][1] && board[x][y] == board[2][2]) { //Top left to bottom right
			win = true;
		} else if (2-x == y && board[x][y] == board[0][2] &&  board[x][y] == board[1][1] && board[x][y] == board[2][0]) { //Top right to bottom left
			win = true;
		}

		if (win) {
			if (board[x][y] == FIRST) {
				firstWin = true;
			} else {
				secondWin = true;
			}
		}
	}

	public void print() {
		for (int i = 0; i < board.length; i++) {
			for (int n = 0; n < board[i].length; n++) {
				System.out.print((board[i][n] != '\0') ? " " + board[i][n] + " " : "   ");
				if (n != board[i].length - 1) {
					System.out.print("|");
				}
			}
			if (i != board.length - 1) {
				System.out.println("");
				System.out.print("___________");
			}
			System.out.println("");
		}
	}

	public char getTurnPiece() {
		return (moves%2 == 0) ? FIRST : SECOND;
	}

	public char getNextTurnPiece() {
		return (moves%2 == 0) ? SECOND : FIRST;
	}

	public char getSpace(int x, int y) {
		return board[x][y];
	}

	public boolean isFinished() {
		return (moves == 9 || firstWin || secondWin);
	}

	public boolean isFirst_win() {
		return firstWin;
	}


	public boolean isSecond_win() {
		return secondWin;
	}

	public int getMoves() {
		return moves;
	}

}