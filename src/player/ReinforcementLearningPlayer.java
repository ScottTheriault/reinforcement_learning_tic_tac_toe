package player;

import game.Board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import moves.Move;
import database.TurnRepository;

public class ReinforcementLearningPlayer implements Player {

	private TurnRepository turnRepository;

	private List<Move> movesMade;

	public ReinforcementLearningPlayer() throws SQLException {
		turnRepository = new TurnRepository();
		movesMade = new ArrayList<Move>();
	}

	@Override
	public void move(Board board) {
		List<Move> moves = null;
		try {
			moves = turnRepository.getPosibleMoves(board);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}

		int totalValue = 0;
		for (Move move : moves) {
			totalValue+=move.getValue();
		}

		Random random = new Random();
		int moveScore = random.nextInt(totalValue) +1;

		for (Move move: moves) {
			moveScore-=move.getValue();
			if (moveScore <= 0) {
				board.move(move.getMove()[0], move.getMove()[1]);
				movesMade.add(move);
				return;
			}
		}
	}

	@Override
	public void tieGame(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWin(boolean won, Board board) {
		// TODO Auto-generated method stub
		
	}

}
