package in.raja.service;

import java.util.ArrayList;
import java.util.List;

import in.raja.dao.DogsDetailsDAO;
import in.raja.dao.OrderDAO;
import in.raja.dao.UserDAO;
import in.raja.exception.DbException;
import in.raja.exception.ServiceException;
import in.raja.model.DogDetail;
import in.raja.model.UserDetails;
import in.raja.util.NumberValidator;
import in.raja.validate.PasswordValidation;
import in.raja.validate.DogDetailValidation;

public class DogManager {

	private DogManager() {
		// default constructor
	}

	private static final List<DogDetail> userList = new ArrayList<>();

	public static List<DogDetail> displayDog() {
		return userList;
	}

	public static boolean addDog(DogDetail... product) throws DbException {

		boolean added = false;

		for (DogDetail product1 : product) {
			if (DogDetailValidation.isValidProduct(product1)) {

				DogsDetailsDAO.save(product1);

				added = true;
			}
		}
		return added;
	}

	public static boolean deleteDog(int dogNo) throws Exception {

		boolean isdeleted = false;

		if (NumberValidator.isValidNumber(dogNo, "Invalid Dogno")) {

			DogsDetailsDAO.deleteByDogNo(dogNo);
			isdeleted = true;

		}

		return isdeleted;
	}

	public static boolean deleteOrderById(int orderId) throws Exception {

		boolean isdeleted = false;

		if (NumberValidator.isValidNumber(orderId, "Invalid Dogno")) {
			OrderDAO.deleteByOrderId(orderId);
			isdeleted = true;

		}

		return isdeleted;
	}

	public static List<DogDetail> searchDogByCost(int breedType) throws DbException {

		List<DogDetail> costDetails = DogsDetailsDAO.findAll();

		if (breedType == 1) {
			for (DogDetail breed : DogsDetailsDAO.findAll()) {
				if (breed.getDogPrice() <= 5000) {
					costDetails.add(breed);

				}
			}
		} else if (breedType == 2) {

			for (DogDetail breed : DogsDetailsDAO.findAll())

				if (breed.getDogPrice() > 5000 && breed.getDogPrice() <= 10000) {
					costDetails.add(breed);
				}

		} else if (breedType == 3) {
			for (DogDetail breed : DogsDetailsDAO.findAll())
				if (breed.getDogPrice() > 10000) {
					costDetails.add(breed);

				}
		}

		else if (breedType == 4) {
			for (DogDetail breed : DogsDetailsDAO.findAll())
				costDetails.add(breed);

		}

		return costDetails;
	}

	public static boolean forgotUserDetails(String phoneNumber, String password1, String password2) throws Exception {
		long mobileNo = Long.parseUnsignedLong(phoneNumber);
		boolean change = false;
		if (PasswordValidation.isEqual(password1, password2) && isExist(mobileNo)) {
			change = UserDAO.updatePassword(mobileNo, password1);

		} else {
			throw new ServiceException("Invalid Detailsss");
		}
		return change;
	}

	public static boolean checkAvailable(int dogno) throws Exception {

		boolean isValid = false;

		List<Integer> dogNoList = DogsDetailsDAO.findByDogNo(dogno);
		for (int number : dogNoList) {
			if (number == dogno) {
				isValid = true;
			}
		}

		return isValid;
	}

	public static boolean isExist(long mobileNumber) throws DbException {
		boolean exist = false;
		for (UserDetails add : UserDAO.findAll()) {
			if (add.getphoneNumber() == mobileNumber) {
				exist = true;
				break;
			}
		}
		return exist;
	}

}