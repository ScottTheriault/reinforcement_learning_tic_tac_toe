package database;

import game.Board;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;
import moves.Move;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TurnRepository {

	private Connection connection;

	public TurnRepository() throws SQLException {
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reinforcement_learning", "root", "root");
	}

	public List<Move> getPosibleMoves(Board board) throws SQLException {
		List<Move> moves = new ArrayList<Move>();

		String sql = "SELECT * FROM turn_" + board.getMoves() + " WHERE ";

		for (int x = 0; x<3; x++) {
			for (int y = 0; y<3; y++) {
				sql += "`" + x + "-" +y +"`";
				char point = board.getSpace(x, y);
				if (point == Board.FIRST) {
					sql += " = 0";
				} else if (point == Board.SECOND) {
					sql += " = 1";
				} else {
					sql += " IS NULL ";
				}

				sql += " AND ";
			}
		}

		//remove last " AND "
		sql = sql.substring(0, sql.length() - 4);

		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);

		ResultSet results = statement.executeQuery();

		while (results.next()) {
			Move move = new Move();
			move.setId(results.getInt("id"));
			move.setValue(results.getInt("value"));

			String moveString[] = results.getString("move").split("-");

			if (Util.isInteger(moveString[0]) && Util.isInteger(moveString[1])) {
				int[] moveChord = {Integer.parseInt(moveString[0]), Integer.parseInt(moveString[1])};
				move.setMove(moveChord);
			}

			moves.add(move);
		}

		if (moves.isEmpty()) {
			moves = addAndGetAllPosibleMoves(board);
		}

		return moves;
	}

	private List<Move> addAndGetAllPosibleMoves(Board board) throws SQLException {
		String sql = "INSERT INTO turn_" + board.getMoves() + " (";
		for (int x=0; x<3; x++) {
			for (int y=0; y<3; y++) {
				sql += "`" + x +"-" + y + "`, ";
			}
		}
		sql += "move) VALUE (";

		for (int x=0; x<3; x++) {
			for (int y=0; y<3; y++) {
				sql += Util.squareValue(board, x, y) + ", ";
			}
		}

		for (int x=0; x<3; x++) {
			for (int y=0; y<3; y++) {
				if (board.getSpace(x, y) == '\0') {
					PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql + "'" + x + "-" + y + "')");
					statement.execute();
				}
			}
		}

		List<Move> moves = new ArrayList<Move>();

		return moves;
	}
}
