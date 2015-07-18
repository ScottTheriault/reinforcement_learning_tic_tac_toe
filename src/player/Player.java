package player;

import game.Board;

public interface Player {

	public void move(Board board);

	public void tieGame(Board board);

	public void addWin(boolean won, Board board);

}
