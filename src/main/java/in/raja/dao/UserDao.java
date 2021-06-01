package in.raja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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