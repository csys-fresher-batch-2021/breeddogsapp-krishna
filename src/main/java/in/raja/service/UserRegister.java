package in.raja.service;

import in.raja.dao.UserDAO;
import in.raja.exception.DbException;
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

	public boolean checkUser(String username, String password) throws DbException {
		boolean isChecked = false;
		if (StringValidator.isValidString(username, password) && UserDAO.findByUsernameAndPassword(username, password)) {
			isChecked = true;
		}
		return isChecked;

	}

}