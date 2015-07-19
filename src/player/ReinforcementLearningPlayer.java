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

	private int winGain = 10;
	private int lossGain = -30;
	private int tieGain = 1;

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
		try {
			turnRepository.addGains(movesMade, tieGain);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addWin(boolean won, Board board) {
		try {
			turnRepository.addGains(movesMade, (won) ? winGain : lossGain);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
