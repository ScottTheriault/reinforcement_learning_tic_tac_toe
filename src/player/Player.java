package player;

import game.Board;

public interface Player {

	public void move(Board board);

	public void tieGame(Board board);

	public void addWin(boolean first_win, Board board);

}
