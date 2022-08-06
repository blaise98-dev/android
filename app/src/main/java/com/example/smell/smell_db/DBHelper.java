package com.example.smell.smell_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    static final String TABLE_NAME = "tbl_smellTypes";
    static final String _ID = "smell_id";
    static final String TITLE = "smell_title";
    static final String DESCRIPTION = "smell_desc";
    static final String IMAGE_PATH = "image_path";
    static final String HAS_IMAGE = "has_image";
    static final String ADDED_ON = "added_on";
    private static final String DB_NAME = "DB_SMELL";
    private static final int DB_VERSION = 1;
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TITLE + " TEXT NOT NULL, " + DESCRIPTION + " TEXT NOT NULL, "
            + IMAGE_PATH + " TEXT DEFAULT NULL, " + HAS_IMAGE + " INTEGER DEFAULT 0, " + ADDED_ON +
        " TEXT DEFAULT CURRENT_TIMESTAMP);";

    DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}