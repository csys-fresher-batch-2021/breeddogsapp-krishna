package in.raja.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.raja.exception.UtilException;

public class PasswordValidator {

	private PasswordValidator() {
		// Default constructor

	}

	/**
	 * Validate the password would contain, minimum of 8 character maximum of 20
	 * characters Small and capital Alphabets Some numerical Some special character
	 * And no whitespace character should be accepted
	 * 
	 * @param password
	 * @return boolean value
	 */
	public static boolean isValidPassword(String password) {

		String check = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(password);
		if (m.matches()) {
			return true;
		} else {
			throw new UtilException("Insufficient password characters");
		}
	}
}
