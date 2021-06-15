package in.raja.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.raja.exception.UtilException;

public class ConnectionUtil {

	private ConnectionUtil() {
		// Default constructor

	}

	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";

	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "Kmahakmaha12345";

	private static final String DB_URL = "jdbc:postgresql://localhost/dogbreed_db";

	public static Connection CreateConnection() {

		Connection connection = null;

		try {
			// Step 1: load the database driver into memory( ClassNotFoundException)
			Class.forName(DRIVER_CLASS_NAME);

			// Step 2: Get the Database Connection (SQLException)

			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

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
		
		
		
		
		
		public static void closeConnection( PreparedStatement pst, Connection connection) {
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
