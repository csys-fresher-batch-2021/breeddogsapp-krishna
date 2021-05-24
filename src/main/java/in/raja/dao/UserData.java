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
	
	/*
	 * Create array list to store all users
	 */
	private static List<UserDetails> userList = new ArrayList<>();

	public static void addUser(UserDetails user) {
		userList.add(user);
		System.out.println("details added"+userList);
		
	}
	
   
    public static List<UserDetails> getUsers1() {
    	return userList;
    }
}