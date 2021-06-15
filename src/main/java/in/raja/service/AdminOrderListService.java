package in.raja.service;



import java.sql.SQLException;

import in.raja.dao.OrderDAO;
import in.raja.dao.ProductDAO;
import in.raja.model.AdminOrderList;


public class AdminOrderListService {




	public static boolean acceptOrder(int orderId) {
		return ProductDAO.acceptOrder(orderId);
	}

	public static boolean rejectOrder(int orderId) {
		return ProductDAO.rejectOrder(orderId);
	}

	
	


	public static boolean addOrder(AdminOrderList obj) throws SQLException {
		
	    	    OrderDAO.saveOrder(obj);
    	   
       
	return true;
		
	}
	
	
}
