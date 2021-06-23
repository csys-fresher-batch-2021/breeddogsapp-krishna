package in.raja.service;

import java.util.ArrayList;
import java.util.List;

import in.raja.model.UserDetails;

public class UserData {

	private UserData() {
		/**
		 * Adding private constructor
		 */
	}

	private static List<UserDetails> userList = new ArrayList<>();
	private static List<UserDetails> dogList;

	public static void addUser(UserDetails user) {
		userList.add(user);

	}

	/**
	 * this method is used to return all users in the list
	 * 
	 * @return
	 */
	public static List<UserDetails> getUsers1() {
		return dogList;
	}
}