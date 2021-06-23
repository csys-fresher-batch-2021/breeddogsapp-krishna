package in.raja.validate;

import in.raja.model.UserDetails;
import in.raja.service.UserService;
import in.raja.util.NumberValidator;
import in.raja.util.StringValidator;

public class UserValidate {

	private UserValidate() {
		/**
		 * constructor
		 */
	}

	public static boolean validateUser(String password, String confirmPassword, String phoneNumber) {
		boolean isValid = false;

		if (password.equals(confirmPassword) && phoneNumber.length() == 10 && password.trim().length() >= 5) {

			isValid = true;
		}
		return isValid;
	}

	public static boolean checkUser(String phoneNumber, String password) {
		long mobileNo = Long.parseLong(phoneNumber);
		boolean isValid = false;
		if (phoneNumber.length() == 10 && mobileNo % 1000000000 != 0 && password.trim().length() >= 5) {
			isValid = UserService.checkUser(phoneNumber, password);
		}
		return isValid;

	}

	public static boolean checkDogName(String value) {

		boolean valid = false;
		if (StringValidator.isValidString(value, "Dog name is empty")) {

			valid = true;
		}

		return valid;
	}

	public static boolean isValidUserDetail(UserDetails userDetails) {

		boolean valid = false;
		boolean userpassword1 = StringValidator.isValidUsername(userDetails.getpassword1());
		boolean userphonenumber = NumberValidator.isValidNumber(userDetails.getphoneNumber(), "userPhoneNo is Empty");

		if (userpassword1 && userphonenumber) {

			valid = true;

		}

		return valid;
	}

}
