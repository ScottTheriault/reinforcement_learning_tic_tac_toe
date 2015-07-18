package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TurnRepository {

	private Connection connection;
	public TurnRepository() throws SQLException {
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reinforcement_learning", "root", "root");
	}
}
