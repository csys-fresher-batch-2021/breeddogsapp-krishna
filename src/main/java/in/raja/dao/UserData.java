package in.raja.dao;

import java.util.ArrayList;
import java.util.List;

import in.raja.model.UserDetails;

public class UserData {

	private UserData() {
		/**
		 * constructor
		 */
	}
	
	private static List<UserDetails> userList = new ArrayList<>();

	public static void addUser(UserDetails user) {
		userList.add(user);
		
	}
	
   /**
    * this method is used to return all users in the list
    * @return
    */
    public static List<UserDetails> getUsers1() {
    	return userList;
    }
}