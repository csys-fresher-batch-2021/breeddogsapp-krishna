package in.raja.service;

import in.raja.dao.DogsDetailsDAO;
import in.raja.dao.OrderDAO;
import in.raja.exception.DbException;
import in.raja.model.AdminOrderList;

public class AdminOrderListService {

	private AdminOrderListService() {
		// default constructor
	}

	public static boolean acceptOrder(int orderId, int dogNo) throws DbException {

		boolean isAccepted = OrderDAO.updateOrderStatus(orderId, "Accepted");
		DogsDetailsDAO.updateDogStatus(dogNo, true);
		return isAccepted;

	}

	public static boolean rejectOrder(int orderId, int dogNo) throws DbException {
		DogsDetailsDAO.updateDogStatus(dogNo, false);
		return OrderDAO.updateOrderStatus(orderId, "Rejected");
	}

	public static boolean addOrder(AdminOrderList obj) throws DbException {

		OrderDAO.save(obj);

		return true;

	}

}
