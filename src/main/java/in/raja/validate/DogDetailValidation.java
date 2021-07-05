package in.raja.validate;

import in.raja.model.DogDetail;
import in.raja.util.NumberValidator;
import in.raja.util.StringValidator;

public class DogDetailValidation {

	private DogDetailValidation() {
		// Default constructor
	}

	/**
	 * This method is used to check whether, The item id,brand name,item name and
	 * category should not to be null and empty string input And quantity and rate
	 * of the product should not lesser than zero
	 * 
	 * @param product
	 * @return
	 */
	public static boolean isValidProduct(DogDetail dogDetail) {
		boolean valid = false;
		boolean dogname = checkDogName(dogDetail.getDogName());
		boolean dogage = NumberValidator.isValidNumber(dogDetail.getAge(), "Dog age is empty");
		boolean doggender = StringValidator.isValidString(dogDetail.getGender(), "Dog gender is Empty");
		boolean dogplace = StringValidator.isValidString(dogDetail.getPlace(), "Dog place is Empty");
		boolean dogprice = NumberValidator.isValidNumber(dogDetail.getPrice(), "Dog price is Empty");
		boolean doginsurance = StringValidator.isValidString(dogDetail.getInsurance(), "Dog insurance is Empty");

		if (dogplace && dogname && dogage && dogprice && doggender && doginsurance) {

			valid = true;

		}

		return valid;
	}

	public static boolean checkDogName(String value) {

		boolean valid = false;
		if (StringValidator.isValidString(value, "Dog name should not be empty or null")) {

			valid = true;
		}

		return valid;
	}
}
