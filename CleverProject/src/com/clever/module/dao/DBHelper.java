package com.clever.module.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "clever.db";
	private static final int VERSION = 1;

	public DBHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS doc (docid integer primary key autoincrement, content text, createTime text, voteup integer, votedown integer)");
		// db.execSQL("CREATE TABLE IF NOT EXISTS tag (docid integer primary key autoincrement, content text, createTime text, voteup integer, votedown integer)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS doc");
	}

}
