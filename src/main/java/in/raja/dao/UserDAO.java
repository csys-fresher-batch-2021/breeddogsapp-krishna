package in.raja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.raja.exception.DbException;
import in.raja.model.UserDetails;
import in.raja.util.ConnectionUtil;

public class UserDAO {

	/**
	 * This method is used to store user details in db
	 * 
	 * @param patient
	 */

	public void save(UserDetails registerDetails) throws DbException

	{

		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.CreateConnection();

			String sql = "INSERT INTO userdetails(username,emailid,password,phonenumber,city) values (?,?,?,?,?)";
			pst = connection.prepareStatement(sql);

			pst.setString(1, registerDetails.getName());
			pst.setString(2, registerDetails.getUserMail());
			pst.setString(3, registerDetails.getpassword1());
			pst.setLong(4, registerDetails.getphoneNumber());
			pst.setString(5, registerDetails.getcity());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			throw new DbException("Can't insert user details");

		} finally {
			ConnectionUtil.closeConnection(pst, connection);

		}
	}

	/**
	 * This method is used to get user details
	 * 
	 * @param username
	 * @param password
	 */

	public static boolean updatePassword(long phoneNumber, String newPassword) throws DbException {

		boolean isChanged = false;
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.CreateConnection();

			String sql = "UPDATE userdetails SET password = ? where phonenumber = ? ";
			pst = connection.prepareStatement(sql);
			pst.setString(1, newPassword);
			pst.setLong(2, phoneNumber);

			int rs = pst.executeUpdate();

			if (rs == 1) {
				isChanged = true;
			} else {
				throw new DbException("Can't update the password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}

		return isChanged;

	}

	public static List<UserDetails> findAll() throws DbException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<UserDetails> userList = new ArrayList<>();

		try {

			// Step 1: Get the connection
			connection = ConnectionUtil.CreateConnection();

			// Step 2: Query
			String sql = "select * from userdetails";
			pst = connection.prepareStatement(sql);
			// Step 3: execute query

			rs = pst.executeQuery();

			while (rs.next()) {

				String userName = rs.getString("username");
				String emailId = rs.getString("emailid");
				String password = rs.getString("password");
				String city = rs.getString("city");
				long phoneNumber = rs.getLong("phonenumber");

				// Store the data in model
				UserDetails userDetails = new UserDetails(userName, emailId, password, city, phoneNumber, null);
				// Store all products in list
				userList.add(userDetails);

			}

		} catch (SQLException e) {

			throw new DbException("Can't able to display the user details.");
		} finally {

			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return userList;
	}

	public static UserDetails findUserByUsername(String userName) throws DbException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		UserDetails user = null;

		try {

			// Step 1: Get the connection
			connection = ConnectionUtil.CreateConnection();

			// Step 2: Query
			String sql = "select * from userdetails where username=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, userName);
			// Step 3: execute query

			rs = pst.executeQuery();

			while (rs.next()) {

				String userName1 = rs.getString("username");
				String emailId = rs.getString("emailid");
				String password = rs.getString("password");
				String city = rs.getString("city");
				long phoneNumber = rs.getLong("phonenumber");

				// Store the data in model
				user = new UserDetails(userName1, emailId, password, city, phoneNumber, null);
				// Store all products in list

			}

		} catch (SQLException e) {

			throw new DbException("Can't able to display the user details.");
		} finally {

			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return user;
	}

	public static boolean findByUsernameAndPassword(String username, String password) throws DbException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		boolean valid = false;

		try {
			connection = ConnectionUtil.CreateConnection();

			String sql = "select username,password from userdetails where username = ? and password = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				valid = true;
			}
		} catch (SQLException e) {
			throw new DbException("Can't able to find the user in list.");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}

		return valid;
	}

	public static int findByUsername(String userName) throws DbException {
		int id = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String url = "select id,username from userdetails ";
			con = ConnectionUtil.CreateConnection();

			pst = con.prepareStatement(url);

			rs = pst.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("id");
				String user = rs.getString("username");
				if (user.equals(userName)) {
					id = userId;
					break;
				}
			}
		} catch (SQLException e) {

			throw new DbException("Can't able to get the userId by username");
		} finally {
			ConnectionUtil.closeConnection(rs, pst, con);

		}
		return id;
	}

}
