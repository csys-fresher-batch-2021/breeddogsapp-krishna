package in.raja.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.raja.dao.OrderDAO;
import in.raja.dao.ProductDAO;
import in.raja.dao.UserDao;
import in.raja.exception.UtilException;
import in.raja.model.DogDetails;
import in.raja.model.UserDetails;
import in.raja.util.NumberValidator;
import in.raja.validate.ProductValidation1;
import in.raja.validate.userValidation;

public class DogManager {

	public DogManager() {
		// default constructor
	}

	private static final List<DogDetails> userList = new ArrayList<>();

	public static List<DogDetails> displayDog() {
		return userList;
	}

	public boolean addUser(UserDetails... registerDetails) {
		boolean added = false;

		for (UserDetails registerDetails1 : registerDetails) {
			if (userValidation.isValidUserDetail(registerDetails1)) {
				try {

					UserDao user = new UserDao();
					user.save2(registerDetails1);
				} catch (SQLException e) {
					e.printStackTrace();

				}

				added = true;
			}
		}
		return added;
	}

	public boolean addDog(DogDetails... product) {

		boolean added = false;

		for (DogDetails product1 : product) {
			if (ProductValidation1.isValidProduct(product1)) {
				try {
					ProductDAO.save(product1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				added = true;
			}
		}
		return added;
	}

	
	

	public static boolean deleteDog(int dogno) throws Exception {

		boolean isdeleted = false;

		if (NumberValidator.isValidNumber(dogno, "Invalid Dogno")) {

			ProductDAO.delete(dogno);
			isdeleted = true;

		}

		return isdeleted;
	}

	public static boolean deleteOrder(int dogno) throws Exception {

		boolean isdeleted = false;

		if (NumberValidator.isValidNumber(dogno, "Invalid Dogno")) {

			OrderDAO.delete(dogno);
			isdeleted = true;

		}

		return isdeleted;
	}


	public static List<DogDetails> searchBreedByCost(int breedType) {

		List<DogDetails> costDetails = ProductDAO.findAll();

		costDetails.removeAll(costDetails);

		if (breedType == 1) {
			for (DogDetails breed : ProductDAO.findAll()) {
				if (breed.getDogPrice() <= 5000) {
					costDetails.add(breed);

				}
			}
		} else if (breedType == 2) {
			for (DogDetails breed : ProductDAO.findAll())
				if (breed.getDogPrice() > 5000 && breed.getDogPrice() <= 10000) {
					costDetails.add(breed);
				}

		} else if (breedType == 3) {
			for (DogDetails breed : ProductDAO.findAll())
				if (breed.getDogPrice() > 10000) {
					costDetails.add(breed);

				}
		}

		else if (breedType == 4) {
			for (DogDetails breed : ProductDAO.findAll())
				costDetails.add(breed);

		}

		return costDetails;
	}

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
	
	
	
	public static boolean forgotUserDetails(String phoneNumber, String password1, String password2) throws Exception {
		long mobileNo = Long.parseUnsignedLong(phoneNumber);
		boolean change = false;
		if (isEqual(password1, password2) &&  isExist(mobileNo)) {
			change = UserDao.updatePassword(mobileNo, password1);
			

		} else {
			throw new UtilException("Invalid Detailsss");
		}
		return change;
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


public static boolean checkAvailable(int dogno) throws Exception {

	boolean isValid = false;

	List<Integer> dogNoList = ProductDAO.searchDogAvailability(dogno);
	for (int number : dogNoList) {
		if (number == dogno) {
			isValid = true;
		}
	}

	return isValid;
}


public static boolean isExist(long mobileNumber)  {
	boolean exist = false;
	for (UserDetails add : UserDao.findAll()) {
		if (add.getphoneNumber() == mobileNumber) {
			exist = true;
			break;
		}
	}
	return exist;
}


}