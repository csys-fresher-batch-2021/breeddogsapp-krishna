package in.raja.service;

import in.raja.dao.UserDAO;
import in.raja.exception.DbException;
import in.raja.exception.ServiceException;
import in.raja.exception.UtilException;
import in.raja.util.StringValidator;

public class UserRegister {

	UserDAO userDAO = new UserDAO();

	/**
	 * This method is used to add medicine
	 * 
	 * @param medicine
	 * @return
	 * @throws DbException
	 */

	public static boolean checkUser(String username, String password) throws DbException {
		boolean isChecked = false;
		try {
			if (StringValidator.isValidString(username, "UserName should not be empty or null")
					&& StringValidator.isValidString(password, "Password should not be empty or null")
					&& UserDAO.findByUsernameAndPassword(username, password, false)) {
				isChecked = true;
			}
		} catch (UtilException e) {
			throw new ServiceException(e.getMessage());
		}
		return isChecked;

	}

	public boolean checkAdmin(String username, String password) throws DbException {
		boolean isChecked = false;
		try {
			if (StringValidator.isValidString(username, "UserName should not be empty or null")
					&& StringValidator.isValidString(password, "Password should not be empty or null")
					&& UserDAO.findByUsernameAndPassword(username, password, true)) {
				isChecked = true;
			}
		} catch (UtilException e) {
			throw new ServiceException(e.getMessage());
		}
		return isChecked;

	}

}