package in.raja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import in.raja.exception.DbException;
import in.raja.model.AdminOrderList;
import in.raja.util.ConnectionUtil;

public class OrderDAO {

	private OrderDAO() {
		// Default constructor
	}

	static Connection connection = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public static void save(AdminOrderList userPlaceOrder) throws DbException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.createConnection();

			String sql = "INSERT INTO placeorder_dogs( order_dogno , orderuser_phoneno , orderuser_address  ,status ,user_id , order_date , delivery_date ) VALUES ( ?, ?, ?,?,?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setInt(1, userPlaceOrder.getDogNo());

			pst.setLong(2, userPlaceOrder.getPhoneNo());
			pst.setString(3, userPlaceOrder.getAddress());

			pst.setString(4, userPlaceOrder.getStatus());

			pst.setInt(5, userPlaceOrder.getUserId());
			pst.setTimestamp(6, Timestamp.valueOf(userPlaceOrder.getOrderDate()));
			pst.setTimestamp(7, Timestamp.valueOf(userPlaceOrder.getDeliveryDate()));

			pst.executeUpdate();

		}

		catch (SQLException e) {

			throw new DbException("Can't insert Ordered user.");

		} finally {

			ConnectionUtil.closeConnection(pst, connection);
		}
	}

	public static void deleteByDogNo(int dogno) throws DbException {
		String sql = "DELETE FROM placeorder_dogs where order_dogno = ?";
		try {
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, dogno);
			pst.executeUpdate();
		}

		catch (SQLException e) {
			throw new DbException("Can't delete Ordered by DogNo");
		}

		finally {
			ConnectionUtil.closeConnection(pst, connection);
		}

	}

	public static void deleteByOrderId(int orderId) throws DbException {
		String sql = "DELETE FROM placeorder_dogs where order_id = ?";
		try {
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, orderId);
			pst.executeUpdate();
		}

		catch (SQLException e) {
			throw new DbException("Can't delete order details by orderId");
		}

		finally {
			ConnectionUtil.closeConnection(pst, connection);
		}

	}

	public static void updateOrderDetails(long mobileNo, String address, int userId, int orderId) throws DbException {
		String sql = "update placeorder_dogs set orderuser_phoneno = ? ,orderuser_address = ?  where user_id = ? AND order_id = ?";
		try {
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setLong(1, mobileNo);
			pst.setString(2, address);
			pst.setInt(3, userId);
			pst.setInt(4, orderId);
			pst.executeUpdate();
		}

		catch (SQLException e) {
			throw new DbException("Can't update the orderdetails");
		}

		finally {
			ConnectionUtil.closeConnection(pst, connection);
		}

	}

	public static List<AdminOrderList> orderList(String userName) throws DbException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<AdminOrderList> orderList = new ArrayList<>();

		try {

			// Step 1: Get the connection
			connection = ConnectionUtil.createConnection();

			// Step 2: Query
			String sql = "select * from placeorder_dogs where user_id = ? ";
			pst = connection.prepareStatement(sql);
			// Step 3: execute query

			int id = UserDAO.findByUsername(userName);

			pst.setInt(1, id);

			rs = pst.executeQuery();

			while (rs.next()) {
				AdminOrderList orderDetail = new AdminOrderList();
				orderDetail.setDogNo(rs.getInt("order_dogno"));
				orderDetail.setPhoneNo(rs.getLong("orderuser_phoneno"));
				orderDetail.setAddress(rs.getString("orderuser_address"));
				orderDetail.setStatus(rs.getString("status"));
				orderDetail.setUserId(rs.getInt("user_id"));
				orderDetail.setOrderId(rs.getInt("order_id"));
				orderDetail.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
				orderDetail.setDeliveryDate(rs.getTimestamp("delivery_date").toLocalDateTime());
				orderList.add(orderDetail);
			}

		} catch (SQLException e) {

			throw new DbException("Can't able to display the orderlist");
		} finally {

			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return orderList;
	}

	public static List<AdminOrderList> findAll() throws DbException {

		List<AdminOrderList> orderList = new ArrayList<>();
		try {
			connection = ConnectionUtil.createConnection();
			String sql = "select  * from placeorder_dogs order by order_id DESC ";
			pst = connection.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				AdminOrderList adminOrderList = new AdminOrderList();
				adminOrderList.setOrderId(rs.getInt("order_id"));
				adminOrderList.setUserId(rs.getInt("user_id"));
				adminOrderList.setPhoneNo(rs.getLong("orderuser_phoneno"));
				adminOrderList.setAddress(rs.getString("orderuser_address"));
				adminOrderList.setStatus(rs.getString("status"));
				adminOrderList.setDogNo(rs.getInt("order_dogno"));
				adminOrderList.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
				adminOrderList.setDeliveryDate(rs.getTimestamp("delivery_date").toLocalDateTime());

				orderList.add(adminOrderList);
			}
		} catch (SQLException e) {

			throw new DbException("Ordered details are not displayed");
		} finally {

			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return orderList;
	}

	public static boolean updateOrderStatus(int orderId, String status) throws DbException {
		String sql = "update placeorder_dogs set status = ? where order_id= ?";

		boolean isUpdated = false;

		try {
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);

			pst.setString(1, status);
			pst.setInt(2, orderId);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new DbException("can't accept the order details by admin");
		} finally {

			ConnectionUtil.closeConnection(rs, pst, connection);
		}

		return isUpdated;
	}

}
