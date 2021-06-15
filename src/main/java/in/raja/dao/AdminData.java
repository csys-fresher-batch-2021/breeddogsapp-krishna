package in.raja.dao;

import java.util.ArrayList;
import java.util.List;

import in.raja.model.AdminDetails;

public class AdminData {
	private AdminData() {
		/**
		 * constructor
		 */
	}

	/*
	 * Create array list to store all admins
	 * 
	 */
	
	
	private static List<AdminDetails> adminList = new ArrayList<>();

	static {
		AdminDetails admin1 = new AdminDetails("raja", 9626848802l, "k1234");
		AdminDetails admin2 = new AdminDetails("maha", 9999999999l, "a1234");
		adminList.add(admin1);
		adminList.add(admin2);
		
		
		
	}

	/**
	 * This method is used to return admins
	 * 
	 * @return
	 */
	public static List<AdminDetails> getAdmin() {
		return adminList;
	}
}









