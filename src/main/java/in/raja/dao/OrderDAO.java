package in.raja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.raja.model.AdminOrderList;
import in.raja.util.ConnectionUtil;

public class OrderDAO {
	
	
	
	
	static Connection connection = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	
	public static void saveOrder(AdminOrderList UserPlaceOrder) throws SQLException{
		
		Connection connection = null;
		 PreparedStatement pst = null;
		

		 try {


				connection = ConnectionUtil.CreateConnection();
				
				String sql ="INSERT INTO placeorder_dogs( order_dogno , orderuser_phoneno , orderuser_address  ,status ,user_id ) VALUES ( ?, ?, ?,?,?)";

				pst = connection.prepareStatement(sql);
				

				
				
				
				

				
				pst.setInt(1, UserPlaceOrder.getDogno());

				pst.setLong(2, UserPlaceOrder.getPhoneno());
				pst.setString(3, UserPlaceOrder.getAddress());
				
				pst.setString(4, UserPlaceOrder.getStatus());

				pst.setInt(5, UserPlaceOrder.getUserid());


				
				pst.executeUpdate();

		       }
		 
		 
		 catch (SQLException e) {

				e.printStackTrace();
				
			} finally {

				ConnectionUtil.closeConnection(pst, connection);
			}
	}


	public static void delete(int dogno) throws Exception{
		String sql = "DELETE FROM placeorder_dogs where order_dogno = ?";
		try {
			connection = ConnectionUtil.CreateConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, dogno);
			pst.executeUpdate();
			}
		
		
		
		catch (SQLException e) {
			throw new Exception("DogsRow can't be deleted");
		} 
		
		
		finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		
		
		
	}

	
	public static int getId(String userName) throws Exception {
		int id = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String url = "select user_id,user_username from register_user ";
			con = ConnectionUtil.CreateConnection();
			
            pst = con.prepareStatement(url);
			
            rs = pst.executeQuery();
            while (rs.next()) {
				int userId = rs.getInt("user_id");
				String user = rs.getString("user_username");
				if (user.equals(userName)) {
					id = userId;
					break;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		return id;
	}

	
	
	public static List<AdminOrderList> orderList(String userName) throws Exception{

		
		
		 Connection connection = null;
		 PreparedStatement pst = null;
		 ResultSet rs = null;	
		
		
		
		List<AdminOrderList> orderList = new ArrayList<>();

		try {

			// Step 1: Get the connection
			connection = ConnectionUtil.CreateConnection();

			// Step 2: Query
			String sql ="select * from placeorder_dogs where user_id = ? ";
			pst = connection.prepareStatement(sql);
			// Step 3: execute query


	         int id =getId(userName);
 
	         pst.setInt(1, id);

		
			rs = pst.executeQuery();
			
			
			while (rs.next()) {

				
				int dogno = rs.getInt("order_dogno");
			long userPhoneno = rs.getLong("orderuser_phoneno");
				String userAddress = rs.getString("orderuser_address");
				String status = rs.getString("status");
				int userId = rs.getInt("user_id");
				int orderId = rs.getInt("order_id");



				// Store the data in model
				AdminOrderList product = new AdminOrderList(  dogno, userPhoneno,userAddress, status,userId , orderId);
				// Store all products in list
				orderList.add(product);

				
			}
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return orderList;
	}



	
	
	
	
	

}
		 
















