package in.raja.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.raja.exception.UtilException;

public class EmailValidator {

	private EmailValidator() {
		// Default constructor
	}

	public static boolean isValidEmail(String email) {

		String check = "^[a-zA-Z0-9_!#$%&.-]+@[a-zA-Z0-9.-]+$";
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			return true;
		} else {
			throw new UtilException("Invalid email format");
		}
	}
}
