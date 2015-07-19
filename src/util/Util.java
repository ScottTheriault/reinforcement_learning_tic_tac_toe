package util;

import game.Board;

public class Util {

	public static boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static String squareValue(Board board, int x, int y) {
		char boardSpace = board.getSpace(x, y);
		String ret = "NULL";
		if (boardSpace == Board.FIRST) {
			ret = "0";
		} else if (boardSpace == Board.SECOND) {
			ret = "1";
		}
		return ret;
	}

}
