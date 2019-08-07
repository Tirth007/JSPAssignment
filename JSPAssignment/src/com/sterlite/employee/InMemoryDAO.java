package com.sterlite.employee;

import java.math.BigInteger;
import java.util.HashMap;

public class InMemoryDAO {
	private static HashMap<String, User> registeredUsers  = new HashMap<String, User>();

	public InMemoryDAO() {
		
	}
	public void addUsers() {
		BigInteger number = new BigInteger("9429365892");
		User user = new User("Tirth","Tirth","tirth.doshi@sterlite.com",number,"Ahmedabad","GET");
		registeredUsers.put("Tirth", user);
		user = new User("Dhrumil","Dhrumil","dhrumil.oza@sterlite.com",number,"Bhavnagar","GET");
		registeredUsers.put("Dhrumil", user);
	}
	public void insertUser(String username, User user) {
		registeredUsers.put(username, user);
	}
	
	public HashMap<String, User> getUsers(){
		return registeredUsers;
	}
	
	public boolean userExist(String username) {
		if(registeredUsers.containsKey(username)) {
			return true; 
		}
		return false;
	}
	
	public User getUser(String username) {
		if(registeredUsers.containsKey(username)) {
			return registeredUsers.get(username);
		}
		return null;
	}
	
	public boolean removeUser(String username) {
		if(registeredUsers.containsKey(username)) {
			registeredUsers.remove(username);
			return true;
		}
		return false;
	}
}
