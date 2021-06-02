package in.raja.service;


import in.raja.dao.OrderDAO;
import in.raja.model.AdminOrderList;


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
