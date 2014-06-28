package com.clever.module;

/*
 * Definition for comments under one article. 
 */
public class Comment {
	private int comID;
	private String comment;

	// To indicate comment belongs to which article and which user.
	private int docID;
	private int userID;

	public int getComID() {
		return comID;
	}

	public void setComID(int comID) {
		this.comID = comID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
