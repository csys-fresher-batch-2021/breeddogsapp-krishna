package in.raja.util;



import in.raja.exception.UtilException;


public class numberValidator {

	private  numberValidator(){
		//Default Constructor
	}
	/**
	 * This method used to check quantity and rate should greater than zero
	 * 
	 * @param value
	 * @return true whether the value is greater then zero
	 */
	public static boolean isValidNumber(long value,String message) {

		if (value <= 0) {
			throw new UtilException(message);
		} else {

			return true;
		}
	}
	
	/**
	 * This method is used to convert the string into integer
	 * @param input
	 * @param errorMessage
	 * @return
	 */
	public static int parseInt(String input, String errorMessage) {
		try {
			return  Integer.parseInt(input);
		}
		catch(NumberFormatException e) {
			throw new UtilException(errorMessage);
		}
	}
	
	/**
	 * This method is used to convert the string into long
	 * @param input
	 * @param errorMessage
	 * @return
	 */
	public static long parseLong(String input, String errorMessage) {
		try {
			return  Long.parseLong(input);
		}
		catch(NumberFormatException e) {
			throw new UtilException(errorMessage);
		}
	}
	
	
	/**
	 * Mobile number should not be empty Mobile number should be starting digit in 6
	 * to 9 After 9 number should be any digit between 0 to 9
	 * 
	 * @param phoneno
	 * @return true or false
	 */

}


