package moves;


public class Move {

	private int id;
	private int value = 1000;
	private int moves;
	private int[] move;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getMoves() {
		return moves;
	}
	public void setMoves(int moves) {
		this.moves = moves;
	}
	public int[] getMove() {
		return move;
	}
	public void setMove(int[] move) {
		this.move = move;
	}

}
