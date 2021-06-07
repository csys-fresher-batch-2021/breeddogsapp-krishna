package in.raja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.raja.exception.DAOException;
import in.raja.model.AdminOrderList;
import in.raja.model.DogDetails;
import in.raja.model.forgotUser;
import in.raja.util.ConnectionUtil;

public class ProductDAO {

	static Connection connection = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	/**
	 * This method is used to add the product in the Database
	 * 
	 * @param product
	 * @throws SQLException
	 * @throws Exception
	 */

	public static  void save(DogDetails products) throws SQLException {

		
		 Connection connection = null;
		 PreparedStatement pst = null;
		
		try {


			connection = ConnectionUtil.CreateConnection();
			
			System.out.println(connection);
			
			String sql ="INSERT INTO breed_dogs(dog_age, dog_name, dog_no, dog_gender, dog_place, dog_price, dog_insurance ) VALUES (?, ?, ?, ?, ?, ?, ?)";

			
			pst = connection.prepareStatement(sql);
			
			System.out.println(products);


			pst.setString(1, products.getDogAge());

			pst.setString(2, products.getDogName());
			pst.setInt(3, products.getDogNo());

			pst.setString(4, products.getDogGender());
			pst.setString(5, products.getDogPlace());
			pst.setInt(6, products.getDogPrice());
			pst.setString(7, products.getDogInsurance());
			pst.executeUpdate();

			// insert,update and delete
			System.out.println(products);

			System.out.println(products);

		} 
		catch (SQLException e) {

			e.printStackTrace();
			
		} finally {

			ConnectionUtil.closeConnection(pst, connection);
		}

	}
	
	
	
	
	


	
	
	
	
	public static void delete(int dogno) throws Exception{
		String sql = "DELETE FROM breed_dogs where dog_no = ?;";
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

	
	
	
	
	
	
	
	
	
	
	
	

	public static List<DogDetails> findAll() {

		
		

		 Connection connection = null;
		 PreparedStatement pst = null;
		 ResultSet rs = null;	
		
		
		
		List<DogDetails> productList = new ArrayList<>();

		try {

			// Step 1: Get the connection
			connection = ConnectionUtil.CreateConnection();

			// Step 2: Query
			String sql ="select * from breed_dogs";
			pst = connection.prepareStatement(sql);
			// Step 3: execute query

			rs = pst.executeQuery();
			
			
			while (rs.next()) {

				int dogno = rs.getInt("dog_no");
				String dogname = rs.getString("dog_name");
				String dogage = rs.getString("dog_age");
				String doggender = rs.getString("dog_gender");
				String doglocation = rs.getString("dog_place");
				int dogprice = rs.getInt("dog_price");
				String doginsurance = rs.getString("dog_insurance");

				// Store the data in model
				DogDetails product = new DogDetails(  dogno, dogname, dogage, doggender, doglocation, dogprice, doginsurance);
				// Store all products in list
				productList.add(product);

				
			}
			
			System.out.println(productList);

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return productList;
	}

	
	
	
	
	
	





//
//	public Patient search(String searchName) {
//		Patient patient = null;
//		String sql = "select  * FROM breed_dogs where dog_no = ?;";
//		try {
//			connection = ConnectionUtil.CreateConnection();
//			pst = connection.prepareStatement(sql);
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				int patientAge = rs.getInt("patientAge");
//				
//				patient = new Patient(patientName, patientAge, patientGender, reason);
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		} finally {
//			
//			ConnectionUtil.closeConnection(rs, pst, connection);
//		}
//		return productList;
//	}

	
	
	
	
	
	





	public static List<Integer>   searchDogAvailability(int order_dogno) {
		
		int  orderDogNo=0;
		List<Integer> dogNoList = new ArrayList<>();
		String sql = "select  * FROM breed_dogs where dog_no = ?;";
		try {
			connection = ConnectionUtil.CreateConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, order_dogno);

			rs = pst.executeQuery();
			
			
			
			while (rs.next()) {
				 orderDogNo = rs.getInt("dog_no");
				 dogNoList.add(orderDogNo);
				 System.out.println(orderDogNo);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return dogNoList;

	
	
	}
	
	
	
	
	
	
public static List<AdminOrderList>   getOrderDetails() {
		
		
		List<AdminOrderList> orderList = new ArrayList<>();
		String sql = "select  * from placeorder_dogs;";
		try {
			connection = ConnectionUtil.CreateConnection();
			pst = connection.prepareStatement(sql);
			

			rs = pst.executeQuery();
			
			
			
			while (rs.next()) {
				 int  orderDogNo = rs.getInt("order_dogno");
				 Long orderMobileNo = rs.getLong("orderuser_phoneno");
				 String orderAddress = rs.getString("orderuser_address");
				 AdminOrderList adminOrderList = new AdminOrderList(orderDogNo, orderMobileNo, orderAddress);
				 
				 orderList.add(adminOrderList);
				 System.out.println(orderList);
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return orderList;
}
	
	
	
}
	
	

	
	
	
	
	

