package in.raja.service;

import java.util.List;

import in.raja.dao.AdminOrder;
import in.raja.dao.OrderDAO;
import in.raja.model.AdminOrderList;
import in.raja.model.DogDetails;


public class AdminOrderListService {


	public static boolean addOrder(int dogno, long phoneno, String address) throws Exception {
		

		boolean isAdded = false;
		{
			AdminOrderList order = new AdminOrderList(dogno, phoneno, address);
			boolean isValid = DogManager.checkAvailable(dogno);
			OrderDAO.saveOrder(order);
			if (isValid) {
				isAdded = true;

			}
		}
		return isAdded;

	}

}
