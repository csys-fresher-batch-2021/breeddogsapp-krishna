package in.raja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				
				System.out.println(connection);
				String sql ="INSERT INTO placeorder_dogs(order_dogno , orderuser_phoneno , orderuser_address ) VALUES (?, ?, ?)";

				pst = connection.prepareStatement(sql);
				
				System.out.println(UserPlaceOrder);

				
				
				
				
				
				pst.setInt(1, UserPlaceOrder.getDogno());

				pst.setLong(2, UserPlaceOrder.getphoneno());
				pst.setString(3, UserPlaceOrder.getAddress());

				
				pst.executeUpdate();

				System.out.println(UserPlaceOrder);
		       }
		 
		 
		 catch (SQLException e) {

				e.printStackTrace();
				
			} finally {

				ConnectionUtil.closeConnection(pst, connection);
			}
	}


	public static void delete(int dogno) throws Exception{
		String sql = "DELETE FROM placeorder_dogs where order_dogno = ?;";
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


	
}
		 
















