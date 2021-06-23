package in.raja.validate;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {
	public static boolean isValidPassword(String phonenumber) {

		// Regex to check valid password.
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the password is empty
		// return false
		if (phonenumber == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given password
		// and regular expression.
		Matcher m = p.matcher(phonenumber);

		// Return if the password
		// matched the ReGex
		return m.matches();
	}

	
	
	
	public static boolean isEqual(String password1, String password2) throws SQLException {
		boolean isMatch = false;
		if (password1.equals(password2)) {
			isMatch = true;
		} else {
			throw new SQLException("Confirm password is not matched");
		}
		return isMatch;
	}
}
