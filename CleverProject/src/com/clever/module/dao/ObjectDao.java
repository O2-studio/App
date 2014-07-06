package com.clever.module.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.clever.module.Doc;

public class ObjectDao {
	private DBHelper helper;

	public ObjectDao(Context context) {
		helper = new DBHelper(context);
	}

	// The best way is that server has a table that implies which category has
	// updates.
	// With this info, when app is launched client will check this table to know
	// whether there are updates.After that, only tables with updates will get
	// fetched.
	// Fetched data depends on its time stamp.
	// Next thing will be updating old data and inserting new articles.
	public Cursor getAllDoc() {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from doc", null);
		return cursor;
	}

	// Read all data from sqlite to initialize the right list view.
	public List<Doc> getAll() {
		List<Doc> docs = new ArrayList<Doc>();
		Cursor cursor = getAllDoc();
		while (cursor.moveToNext()) {
			if (!("".equals(cursor.getString(1)))) {
				Doc tem = new Doc();
				tem.setDocID(cursor.getInt(0));
				tem.setContent(cursor.getString(1));
				docs.add(tem);
			}
		}
		return docs;
	}

	// Save fetched data, insert new data and update old data.
	public void saveDoc(Doc doc) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(
				"insert OR replace into doc (docid, content, createTime, voteup, votedown) values(?,?,?,?,?)",
				new Object[] { doc.getDocID(), doc.getContent(),
						doc.getCreateTime(), doc.getVoteUp(), doc.getVoteDown() });
		db.close();
	}
}
