package in.raja.service;

import in.raja.dao.UserDao;
import in.raja.util.StringValidation;

public class UserRegister {


	UserDao userDao = new UserDao();

	/**
	 * This method is used to add medicine
	 * @param medicine
	 * @return
	 */

	
	public boolean checkUser(String username, String password) {
		boolean isChecked = false;
		if (StringValidation.isValidString(username, password) && userDao.findUser(username, password)) {
				isChecked = true;
		}
		return isChecked;

	}

}