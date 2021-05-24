package in.raja.service;

import in.raja.dao.UserData;
import in.raja.model.UserDetails;

public class UserService {

	private UserService() {
		/**
		 * Constructor
		 */
	}

	public static boolean insertUser(String userName, String mail, String password1, String phoneNumber) {
		boolean isValid = false;
		
		long mobileNo = Long.parseLong(phoneNumber);

		if (phoneNumber.length() == 10 && password1.trim().length() >= 5) {
			UserDetails user = new UserDetails(userName, mail, password1, mobileNo);
			UserData.addUser(user);
		}
		return isValid;
		
	
	
	}

	public static boolean checkUser(String phoneNumber, String password1) {
		boolean isValid = false;
		long mobileNo = Long.parseLong(phoneNumber);
		for (UserDetails user : UserData.getUsers1()) {
			if (user.getphoneNumber() == mobileNo) {
				if (user.getpassword1().equals(password1)) {
					isValid = true;
				}
				break;
			}
		}
		return isValid;
	}

	public static String getUserName(String userId) {
		String name = null;
		long mobileNo = Long.parseLong(userId);
		for (UserDetails user : UserData.getUsers1()) {
			if (user.getphoneNumber() == mobileNo) {
				name = user.getName();
				break;
			}
		}
		return name;
	}

}
