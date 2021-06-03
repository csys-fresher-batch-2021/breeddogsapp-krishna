package in.raja.validate;

import in.raja.model.DogDetails;
import in.raja.util.StringValidator;

import in.raja.util.numberValidator;

public class ProductValidation1 {

	private ProductValidation1() {
		//Default constructor
	}
	/**
	 * This method is used to check whether, 
	 * The item id,brand name,item name and category should not to be null and empty string input
	 * And quantity and rate of the product should not lesser than zero
	 * @param product
	 * @return
	 */
	public static boolean isValidProduct(DogDetails product) {
		boolean valid = false;
		boolean dogno =  numberValidator.isValidNumber(product.getDogNo(),"Dog NO is Empty");
		boolean dogname = checkDogName(product.getDogName());
		boolean dogage = StringValidator.isValidString(product.getDogAge(),"Dog age is empty");
		boolean doggender = StringValidator.isValidString(product.getDogGender(),"Dog gender is Empty");
		boolean dogplace =StringValidator.isValidString(product.getDogPlace(),"Dog place is Empty");
		boolean dogprice =  numberValidator.isValidNumber(product.getDogPrice(),"Dog price is Empty");
		boolean doginsurance = StringValidator.isValidString(product.getDogInsurance(),"Dog insurance is Empty");

		
		if (dogno && dogplace && dogname && dogage && dogprice && doggender && doginsurance ) {
			
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
