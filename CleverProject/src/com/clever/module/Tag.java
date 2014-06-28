package com.clever.module;

import java.util.ArrayList;

/*
 * Definition for category.
 */
public class Tag {
	private int tagID;
	private String tagName;
	// Every category has many articles.
	private ArrayList<Doc> docs = new ArrayList<Doc>();

	public Tag(int id, String name) {
		this.tagID = id;
		this.tagName = name;
	}

	public int getTagID() {
		return tagID;
	}

	public void setTagID(int tagID) {
		this.tagID = tagID;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public ArrayList<Doc> getDocs() {
		return docs;
	}

	public void setDocs(ArrayList<Doc> docs) {
		this.docs = docs;
	}
}
