package in.raja.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	 * @return
	 * @throws SQLException
	 * @throws DbException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws Exceptionrrij
	 */

	public static boolean save(DogDetail dogDetail) throws DbException, FileNotFoundException, IOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int res = 0;

		try {

			connection = ConnectionUtil.CreateConnection();
			File dogImageFile = new File("D:\\images\\" + dogDetail.getDogImage());

			try (FileInputStream image1 = new FileInputStream(dogImageFile)) {

				String sql = "INSERT INTO breed_dogs(dog_image , dog_age, dog_name,  dog_gender, dog_place, dog_price, dog_insurance ) VALUES (? , ?, ?, ?, ?, ?, ?)";

				pst = connection.prepareStatement(sql);

				pst.setBinaryStream(1, image1, dogImageFile.length());

				pst.setInt(2, dogDetail.getDogAge());

				pst.setString(3, dogDetail.getDogName());

				pst.setString(4, dogDetail.getDogGender());
				pst.setString(5, dogDetail.getDogPlace());
				pst.setInt(6, dogDetail.getDogPrice());
				pst.setString(7, dogDetail.getDogInsurance());
				res = pst.executeUpdate();
			}
			// insert,update and delete

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DbException("Unable to save dog details");

		} finally {

			ConnectionUtil.closeConnection(pst, connection);
		}
		return res == 1;

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

	public static byte[] retireveDogImage(String dogNo) {
		Connection connection = null;
		Statement st = null;
		byte[] imgBytes = null;
		try {
			connection = ConnectionUtil.CreateConnection();
			st = connection.createStatement();
			int dog_no = Integer.parseInt(dogNo);
			ResultSet rs = st.executeQuery("SELECT dog_image FROM  breed_dogs WHERE dog_no ='" + dog_no + "'");
			if (rs != null) {
				while (rs.next()) {
					imgBytes = rs.getBytes(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(st, connection);

		}
		return imgBytes;
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
				InputStream dogimage = rs.getBinaryStream(1);
				int dogno = rs.getInt("dog_no");

				String dogname = rs.getString("dog_name");
				int dogage = rs.getInt("dog_age");
				String doggender = rs.getString("dog_gender");
				String doglocation = rs.getString("dog_place");
				int dogprice = rs.getInt("dog_price");
				String doginsurance = rs.getString("dog_insurance");

				// Store the data in model
				DogDetail dogDetails = new DogDetail(dogimage, dogno, dogname, dogage, doggender, doglocation, dogprice,
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
