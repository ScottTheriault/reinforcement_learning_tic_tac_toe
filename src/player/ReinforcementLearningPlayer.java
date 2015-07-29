package player;

import game.Board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import moves.Move;
import database.TurnRepository;

public class ReinforcementLearningPlayer implements Player {

	private TurnRepository turnRepository;

	private List<Move> movesMadeGame;
	private Map<Integer, Move> movesMadeAll;

	private int winGain = 10;
	private int lossGain = -10;
	private int tieGain = 1;

	private int movesBonus = 4;

	private boolean printScore = true;
	private int printOn = 10;

	private int games = 0;
	private int wins = 0;
	private int losses = 0;
	private int ties = 0;

	public ReinforcementLearningPlayer() throws SQLException {
		turnRepository = new TurnRepository();
		movesMadeGame = new ArrayList<Move>();
		movesMadeAll = new HashMap<Integer, Move>();
	}

	@Override
	public void move(Board board) {
		List<Move> moves = null;
		try {
			moves = turnRepository.getPosibleMoves(board);
			for (Move move: moves) {
				if (movesMadeAll.containsKey(move.getId())) {
					move.setValue(movesMadeAll.get(move.getId()).getValue());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}

		int totalValue = 0;
		for (Move move : moves) {
			if (move.getValue() > 0) {
				totalValue+=move.getValue();
			}
		}

		Random random = new Random();
		int moveScore = random.nextInt(totalValue) +1;

		for (Move move: moves) {
			if (move.getValue() > 0) {
				moveScore-=move.getValue();
			}
			if (moveScore <= 0) {
				board.move(move.getMove()[0], move.getMove()[1]);
				movesMadeGame.add(move);
				return;
			}
		}
	}

	@Override
	public void tieGame(Board board) {
		games ++;
		updateValues(tieGain, board);
		ties++;

		if (games == printOn) {
			printStanding();
		}
	}

	@Override
	public void addWin(boolean won, Board board) {
		games ++;
		if (won) {
			wins++;
			updateValues(winGain, board);
		} else {
			losses++;
			updateValues(lossGain, board);
		}
		if (games == printOn) {
			printStanding();
		}
	}

	private void updateValues(int gain, Board board) {
		for (int i = 0; i < movesMadeGame.size(); i++) {
			Move move = movesMadeGame.get(i);
			int bonusGain = Math.max(0, movesBonus - movesMadeGame.size() + i);
			int value = move.getValue() + gain + (gain > 0 ? bonusGain : -bonusGain);
			move.setValue(value);
			if (movesMadeAll.containsKey(move.getId())) {
				Move allMove = movesMadeAll.get(move.getId());
				allMove.setValue(value);
			} else {
				movesMadeAll.put(move.getId(), move);
			}
		}
		movesMadeGame = new ArrayList<Move>();
	}

	public void save() {
		try {
			turnRepository.updateMoves(movesMadeAll.entrySet().iterator());
			movesMadeAll = new HashMap<Integer, Move>();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		movesMadeAll = new HashMap<Integer, Move>();
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
