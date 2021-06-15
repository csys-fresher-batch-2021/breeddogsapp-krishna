package in.raja.service;



import in.raja.exception.ValidatorException;
import in.raja.model.UserDetails;
import in.raja.util.StringValidator;

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
			UserDetails user = new UserDetails(userName, mail, password1, phoneNumber, mobileNo, phoneNumber);
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
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean rejectIfValueEmpty(String name, String password) {
		boolean isEmpty = false;
		try {
			boolean validName = StringValidator.isValidString(name, "User name shouldn't empty");
			boolean validPassword = StringValidator.isValidString(password, "Password shouldn't empty");

			if (validName && validPassword) {
				isEmpty = true;
			}

		} catch (Exception e) {
			throw new ValidatorException(e.getMessage());
		}

		return isEmpty;
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
