package in.raja.service;

import java.util.List;

import in.raja.dao.AdminOrder;
import in.raja.model.AdminOrderList;
import in.raja.model.DogDetails;

public class AdminOrderListService {

	
	private static AdminOrder placeOrders = new AdminOrder();



	public static boolean addOrder(int dogno,String address)
	{
	  boolean isAdded = false;
	  {   
		AdminOrderList order = new AdminOrderList(dogno,address);
		boolean isValid = DogManager.checkAvailable(dogno);
		if(isValid)
		{	
			placeOrders.placeOrder(order);
			isAdded = true;
		    
		}
		return isAdded;

    }
	 

}
}