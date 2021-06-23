package in.raja.service;

import java.util.List;

import in.raja.dao.AdminDataDAO;
import in.raja.model.AdminDetails;

public class AdminService {

	private AdminService() {
		// default constructor
	}

	public static boolean checkAdmin(String phoneNumber, String password) {
		boolean isValid = false;
		long mobileNo = Long.parseLong(phoneNumber);
		List<AdminDetails> adminDetails = AdminDataDAO.findAllAdmin();
		for (AdminDetails admin : adminDetails) {
			if (admin.getPhoneNumber() == mobileNo && admin.getPassWord().equals(password)) {
				isValid = true;
				break;
			}
		}
		return isValid;
	}

	public static boolean getAdminName(String phoneNumber) {
		Object name = null;
		long mobileNo = Long.parseLong(phoneNumber);
		for (AdminDetails admin : AdminDataDAO.findAllAdmin()) {
			if (admin.getPhoneNumber() == mobileNo) {
				name = admin.getName();
				break;
			}
		}
		return (boolean) name;
	}

}
