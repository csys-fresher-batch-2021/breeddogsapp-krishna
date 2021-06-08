package in.raja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.raja.exception.DAOException;
import in.raja.exception.UtilException;
import in.raja.model.DogDetails;
import in.raja.model.UserDetails;
import in.raja.util.ConnectionUtil;

public class UserDao {

	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * This method is used to store user details in db
	 * 
	 * @param patient
	 */

public   void save2(UserDetails registerDetails) throws SQLException 
	
	{

		 Connection connection = null;
		 PreparedStatement pst = null;
		 
		 try {
				connection = ConnectionUtil.CreateConnection();

				System.out.println(connection);
				
				
				String sql = "INSERT INTO register_user(user_username, user_emailid, user_password  ,user_phonenumber    , user_city) values (?,?,?,?,?)";
				pst = connection.prepareStatement(sql);
                
				pst.setString(1, registerDetails.getName());
				pst.setString(2, registerDetails.getUserMail());
				pst.setString(3, registerDetails.getpassword1());
				pst.setLong(4, registerDetails.getphoneNumber());
				pst.setString(5, registerDetails.getcity());
				pst.executeUpdate();
				
		 }
		 catch (SQLException e) {
			 
			 
				e.printStackTrace();

		}
		 finally {
				ConnectionUtil.closeConnection(pst, connection);
 
		 }
	}
	/**
	 * This method is used to get user details
	 * 
	 * @param username
	 * @param password
	 */


public static boolean updatePassword(long phoneNumber, String newPassword) throws Exception {

	boolean isChanged = false;
	Connection connection = null;
	PreparedStatement pst = null;

	try {
		connection = ConnectionUtil.CreateConnection();

		String sql ="UPDATE register_user SET user_password = ? where user_phonenumber = ? ";
		pst = connection.prepareStatement(sql);
		pst.setString(1, newPassword);
		pst.setLong(2, phoneNumber);

		int rs = pst.executeUpdate();

		if (rs == 1) {
			isChanged = true;
		} else {
			throw new UtilException("Cannot Change the password");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		ConnectionUtil.closeConnection(pst, connection);
	}

	return isChanged;

}





public static List<UserDetails> findAll() {

	
	

	 Connection connection = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;	
	
	
	
	List<UserDetails> userList = new ArrayList<>();

	try {

		// Step 1: Get the connection
		connection = ConnectionUtil.CreateConnection();

		// Step 2: Query
		String sql ="select * from register_user";
		pst = connection.prepareStatement(sql);
		// Step 3: execute query

		rs = pst.executeQuery();
		
		
		while (rs.next()) {

			String user_username = rs.getString("user_username");
			String user_emailid = rs.getString("user_emailid");
			String user_password = rs.getString("user_password");
			String user_city = rs.getString("user_city");
			long user_phonenumber = rs.getLong("user_phonenumber");
			

			// Store the data in model
			UserDetails userDetails = new UserDetails(user_username, user_emailid, user_password, user_city, user_phonenumber, null);
			// Store all products in list
			userList.add(userDetails);

			
		}
		
		System.out.println(userList);

	} catch (SQLException e) {
		
		e.printStackTrace();
	} finally {
		
		ConnectionUtil.closeConnection(rs, pst, connection);
	}
	return userList;
}












	public   boolean findUser(String username, String password) {
		boolean valid = false;

		try {
			connection = ConnectionUtil.CreateConnection();

			String sql = "select user_username,user_password from register_user where user_username = ? and user_password = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				valid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}

		return valid;
	}
}



















