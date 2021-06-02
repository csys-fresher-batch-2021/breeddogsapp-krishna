package in.raja.validate;

import in.raja.service.UserService;

public class UserValidate {

	private UserValidate() {
		/**
		 * constructor
		 */
	}

	public static boolean validateUser( String password1, String password2,
			String phoneNumber) {
		boolean isValid = false;

		if (password1.equals(password2) && phoneNumber.length() == 10 && password1.trim().length() >= 5) {
		

			isValid = true;
		}
		return isValid;
	}

	public static boolean checkUser(String phonenumber, String passWord) {
		long mobileNo = Long.parseLong(phonenumber);
		boolean isValid = false;
		if (phonenumber.length() == 10 && mobileNo % 1000000000 != 0 
              && passWord.trim().length() >= 5) {
			isValid = UserService.checkUser(phonenumber, passWord);
		}
		return isValid;

		
	}

	
}
