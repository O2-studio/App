package com.clever.module;

import java.util.ArrayList;
import java.util.Date;

/*
 * Definition for articles. 
 */
public class Doc {
	private int docID;
	private String content;
	private Date createTime;
	// One article may belongs to different categories(tags).
	private ArrayList<Integer> tagIDs;
	private int voteUp;
	private int voteDown;

	// Comments for article. They will not be assigned values until article is
	// clicked.
	private ArrayList<Comment> comments;

	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<Integer> getTags() {
		return tagIDs;
	}

	public void setTags(ArrayList<Integer> tagIDs) {
		this.tagIDs = tagIDs;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getVoteUp() {
		return voteUp;
	}

	public void setVoteUp(int voteUp) {
		this.voteUp = voteUp;
	}

	public int getVoteDown() {
		return voteDown;
	}

	public void setVoteDown(int voteDown) {
		this.voteDown = voteDown;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

}
