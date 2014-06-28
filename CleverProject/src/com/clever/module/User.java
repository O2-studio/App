package com.clever.module;

import java.util.ArrayList;

/*
 * Definition for User. User has its customized categories(Tag).
 */
public class User {
	private int userID;
	private String userName;
	private ArrayList<Tag> tags = new ArrayList<Tag>();

	private static User user = null;

	private User() {
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	public static User getUser() {
		if (null == user)
			user = new User();
		return user;
	}

}
