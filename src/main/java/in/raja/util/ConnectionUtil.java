package in.raja.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.raja.exception.UtilException;

public class ConnectionUtil {

	private ConnectionUtil() {
		// Default constructor

	}

	private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");

	public static Connection createConnection() {

		Connection connection = null;

		try {
			// Step 1: load the database driver into memory( ClassNotFoundException)
			Class.forName(driverClass);

			// Step 2: Get the Database Connection (SQLException)

			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new UtilException("Unable to get the database connection");

		}
		return connection;

	}

	public static void closeConnection(ResultSet rs, PreparedStatement pst, Connection connection) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new UtilException("There no connection to close");
		}
	}

	public static void closeConnection(Statement pst, Connection connection) {
		try {

			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new UtilException("There no connection to close");
		}
	}

}
