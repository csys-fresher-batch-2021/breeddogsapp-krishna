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
import in.raja.exception.ValidatorException;
import in.raja.model.DogDetails;
import in.raja.model.UserDetails;
import in.raja.model.forgotUser;
import in.raja.util.NumberValidator;
import in.raja.util.PasswordValidator;
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
					System.out.println(registerDetails1);

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

	
	
	/*
	 * public List<DogDetails> addStock(DogDetails... products) {
	 * 
	 * boolean added = false; for (DogDetails product : products) { try {
	 * ProductDAO.save(product); } catch (SQLException e) { e.printStackTrace(); }
	 * added = true; } return taskList; }
	 */
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

	public static List<DogDetails> searchBreedByName(int type) {

		List<DogDetails> availableDetails = ProductDAO.findAll();
		availableDetails.removeAll(availableDetails);

		if (type == 5) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String labrador = null;
				if (breed.getDogName().toLowerCase() == labrador) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 6) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String pitbull = null;
				if (breed.getDogName().toLowerCase() == pitbull) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 7) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String germanshephered = null;
				if (breed.getDogName().toLowerCase() == germanshephered) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 8) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String pomeranian = null;
				if (breed.getDogName().toLowerCase() == pomeranian) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 9) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String doberman = null;
				if (breed.getDogName().toLowerCase() == doberman) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 10) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String kombai = null;
				if (breed.getDogName().toLowerCase() == kombai) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 11) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String siberianhusky = null;
				if (breed.getDogName().toLowerCase() == siberianhusky) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 12) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String greatdane = null;
				if (breed.getDogName().toLowerCase() == greatdane) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 13) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String rottweiler = null;
				if (breed.getDogName().toLowerCase() == rottweiler) {
					availableDetails.add(breed);

				}

			}
		}

		if (type == 14) {
			for (DogDetails breed : ProductDAO.findAll()) {

				String dalmatian = null;
				if (breed.getDogName().toLowerCase() == dalmatian) {
					availableDetails.add(breed);

				}

			}
		}
		return availableDetails;

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
			
			System.out.println("has changed" + change);

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


public static boolean isExist(long mobileNumber) throws Exception {
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