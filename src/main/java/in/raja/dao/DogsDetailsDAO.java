package in.raja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.raja.exception.DbException;
import in.raja.model.DogDetail;
import in.raja.util.ConnectionUtil;

public class DogsDetailsDAO {

	private DogsDetailsDAO() {
		// Default constructor
	}

	static Connection connection = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	/**
	 * This method is used to add the product in the Database
	 * 
	 * @param product
	 * @throws SQLException
	 * @throws DbException
	 * @throws Exceptionrrij
	 */

	public static void save(DogDetail dogDetail) throws DbException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.CreateConnection();

			String sql = "INSERT INTO breed_dogs(dog_age, dog_name,  dog_gender, dog_place, dog_price, dog_insurance ) VALUES ( ?, ?, ?, ?, ?, ?)";

			pst = connection.prepareStatement(sql);

			pst.setInt(1, dogDetail.getDogAge());

			pst.setString(2, dogDetail.getDogName());

			pst.setString(3, dogDetail.getDogGender());
			pst.setString(4, dogDetail.getDogPlace());
			pst.setInt(5, dogDetail.getDogPrice());
			pst.setString(6, dogDetail.getDogInsurance());
			pst.executeUpdate();

			// insert,update and delete

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DbException("Unable to save dog details");

		} finally {

			ConnectionUtil.closeConnection(pst, connection);
		}

	}

	public static void deleteByDogNo(int dogno) throws DbException {
		String sql = "DELETE FROM breed_dogs where dog_no = ?";
		try {
			connection = ConnectionUtil.CreateConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, dogno);
			pst.executeUpdate();
		}

		catch (SQLException e) {
			throw new DbException("DogsRow can't be deleted");
		}

		finally {
			ConnectionUtil.closeConnection(pst, connection);
		}

	}

	public static List<DogDetail> findAll() throws DbException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<DogDetail> dogList = new ArrayList<>();

		try {

			// Step 1: Get the connection
			connection = ConnectionUtil.CreateConnection();

			// Step 2: Query
			String sql = "select * from breed_dogs where sold_status=false ";
			pst = connection.prepareStatement(sql);
			// Step 3: execute query

			rs = pst.executeQuery();

			while (rs.next()) {

				int dogno = rs.getInt("dog_no");
				String dogname = rs.getString("dog_name");
				int dogage = rs.getInt("dog_age");
				String doggender = rs.getString("dog_gender");
				String doglocation = rs.getString("dog_place");
				int dogprice = rs.getInt("dog_price");
				String doginsurance = rs.getString("dog_insurance");

				// Store the data in model
				DogDetail dogDetails = new DogDetail(dogno, dogname, dogage, doggender, doglocation, dogprice,
						doginsurance);
				// Store all products in list
				dogList.add(dogDetails);

			}

		} catch (SQLException e) {

			throw new DbException("DogDetails are not displayed , please check.");

		} finally {

			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return dogList;
	}

	public static List<Integer> findByDogNo(int orderDogno) throws DbException {

		int orderDogNo = 0;
		List<Integer> dogNoList = new ArrayList<>();
		String sql = "select  * FROM breed_dogs where dog_no = ?";
		try {
			connection = ConnectionUtil.CreateConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, orderDogno);

			rs = pst.executeQuery();

			while (rs.next()) {
				orderDogNo = rs.getInt("dog_no");
				dogNoList.add(orderDogNo);

			}
		} catch (SQLException e) {

			throw new DbException("DogDetails are not displayed , please check.");
		} finally {

			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return dogNoList;

	}

	public static boolean updateDogStatus(int dogno, boolean status) throws DbException {
		String sql = "update breed_dogs set sold_status = ? where dog_no = ?";
		try {
			connection = ConnectionUtil.CreateConnection();
			pst = connection.prepareStatement(sql);
			pst.setBoolean(1, status);
			pst.setInt(2, dogno);
			pst.executeUpdate();
		}

		catch (SQLException e) {
			throw new DbException("Can't update the Dog Status");
		}

		finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
		return status;

	}

}
