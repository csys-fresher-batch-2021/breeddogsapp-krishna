package in.raja.service;



import java.sql.SQLException;

import in.raja.dao.OrderDAO;
import in.raja.dao.ProductDAO;
import in.raja.model.AdminOrderList;


public class AdminOrderListService {




	public static boolean acceptOrder(int orderId,int dogNo) throws Exception {
		
		
		boolean isAccepted = ProductDAO.acceptOrder(orderId);
		OrderDAO.updateDogStatus(dogNo,true);
		return isAccepted;
		
	}

	public static boolean rejectOrder(int orderId,int dogNo) throws Exception {
		OrderDAO.updateDogStatus(dogNo,false);
		return ProductDAO.rejectOrder(orderId);
	}

	
	


	public static boolean addOrder(AdminOrderList obj) throws SQLException {
		
	    	    OrderDAO.saveOrder(obj);
    	   
       
	return true;
		
	}
	
	
}
