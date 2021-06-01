package in.raja.validate;


import in.raja.dao.ProductDAO;
import in.raja.model.UserDetails;
import in.raja.util.PasswordValidator;
import in.raja.util.StringValidator;
import in.raja.util.numberValidator;

public class userValidation {

	private userValidation() {
		//Default constructor
	}
	

	/**
	 * This method is used to check whether, 
	 * The item id,brand name,item name and category should not to be null and empty string input
	 * And quantity and rate of the product should not lesser than zero
	 * @param product
	 * @return
	 */
	public static boolean isValidUserDetail(UserDetails userDetails) {
		
		System.out.println(userDetails);
		
		boolean valid = false;
		boolean userpassword1 = StringValidator.isValidUsername(userDetails.getpassword1());
		boolean userphonenumber =numberValidator.isValidNumber(userDetails.getphoneNumber(),"userPhoneNo is Empty");
		

		
		if (  userpassword1 && userphonenumber  ) {
			
			valid = true;
			
		}
		
		return valid;
	}
	
	public static boolean checkDogName(String value) {
		
		boolean valid = false;
		if(StringValidator.isValidString(value,"Dog name is empty")) {
			
			valid = true;
		}
		
		return valid;
	}

	
	
	
	
	
	


}