package in.raja.dao;

import java.util.ArrayList;
import java.util.List;

import in.raja.model.AdminOrderList;
import in.raja.model.UserDetails;

public class AdminOrder {
	
	
	private static List<AdminOrderList> adminOrderList= new ArrayList<>();

	
	
public static void placeOrder(AdminOrderList order) {
		adminOrderList.add(order);
	
	
}
public static List<AdminOrderList> getOrder() {
	
return adminOrderList;

	
}










}
