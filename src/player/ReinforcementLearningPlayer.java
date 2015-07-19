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

	private boolean printScore = true;
	private int printOn = 10;

	private int games = 0;
	private int wins = 0;
	private int losses = 0;
	private int ties = 0;

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
		games ++;
		try {
			turnRepository.addGains(movesMade, tieGain);
			ties++;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (games == printOn) {
			printStanding();
		}
	}

	@Override
	public void addWin(boolean won, Board board) {
		games ++;
		try {
			if (won) {
				wins++;
				turnRepository.addGains(movesMade, winGain);
			} else {
				losses++;
				turnRepository.addGains(movesMade, lossGain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (games == printOn) {
			printStanding();
		}
	}

	private void printStanding() {
		System.out.println("W/L/T:" + wins + "/" + losses + "/" + ties);
		games = 0;
		wins = 0;
		losses = 0;
		ties = 0;
	}

	public int getWinGain() {
		return winGain;
	}
	public void setWinGain(int winGain) {
		this.winGain = winGain;
	}
	public int getLossGain() {
		return lossGain;
	}
	public void setLossGain(int lossGain) {
		this.lossGain = lossGain;
	}
	public int getTieGain() {
		return tieGain;
	}
	public void setTieGain(int tieGain) {
		this.tieGain = tieGain;
	}
	public boolean isPrintScore() {
		return printScore;
	}
	public void setPrintScore(boolean printScore) {
		this.printScore = printScore;
	}
	public int getPrintOn() {
		return printOn;
	}
	public void setPrintOn(int printOn) {
		this.printOn = printOn;
	}

}
