package in.raja.service;

import java.io.IOException;
import java.sql.SQLException;
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
import in.raja.validate.DogDetailValidation;
import in.raja.validate.PasswordValidation;

public class DogManager {

	private DogManager() {
		// default constructor
	}

	private static final List<DogDetail> userList = new ArrayList<>();

	public static List<DogDetail> displayDog() {
		return userList;
	}

	public static boolean addDog(DogDetail... dogDetails) throws DbException, IOException {

		boolean added = false;

		for (DogDetail details : dogDetails) {
			if (DogDetailValidation.isValidProduct(details)) {

				DogsDetailsDAO.save(details);

				added = true;
			}
		}
		return added;
	}

	public static byte[] retireveImage(String imageName) {
		byte[] image;

		image = DogsDetailsDAO.retireveDogImage(imageName);

		return image;
	}

	public static boolean deleteDog(int dogNo) throws DbException {

		boolean isdeleted = false;

		if (NumberValidator.isValidNumber(dogNo, "Invalid Dogno")) {

			DogsDetailsDAO.deleteByDogNo(dogNo);
			isdeleted = true;

		}

		return isdeleted;
	}

	public static boolean deleteOrderById(int orderId) throws DbException {

		boolean isdeleted = false;

		if (NumberValidator.isValidNumber(orderId, "Invalid Dogno")) {
			OrderDAO.deleteByOrderId(orderId);
			isdeleted = true;

		}

		return isdeleted;
	}

	public static List<DogDetail> searchDogByCost(int breedType) throws DbException {

		List<DogDetail> costDetails = DogsDetailsDAO.findAll();
		costDetails.clear();
		if (breedType == 1) {
			for (DogDetail breed : DogsDetailsDAO.findAll()) {
				if (breed.getPrice() <= 5000) {
					costDetails.add(breed);

				}
			}
		} else if (breedType == 2) {

			for (DogDetail breed : DogsDetailsDAO.findAll())

				if (breed.getPrice() > 5000 && breed.getPrice() <= 10000) {
					costDetails.add(breed);
				}

		} else if (breedType == 3) {
			for (DogDetail breed : DogsDetailsDAO.findAll())
				if (breed.getPrice() > 10000) {
					costDetails.add(breed);

				}
		}

		else if (breedType == 4) {
			for (DogDetail breed : DogsDetailsDAO.findAll())
				costDetails.add(breed);

		}

		return costDetails;
	}

	public static boolean forgotUserDetails(String phoneNumber, String password1, String password2)
			throws DbException, ServiceException, SQLException {
		long mobileNo = Long.parseUnsignedLong(phoneNumber);
		boolean change = false;
		if (PasswordValidation.isEqual(password1, password2) && isExist(mobileNo)) {
			change = UserDAO.updatePassword(mobileNo, password1);

		} else {
			throw new ServiceException("Invalid Detailsss");
		}
		return change;
	}

	public static boolean checkAvailable(int dogno) throws DbException {

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