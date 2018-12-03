package com.bwei.yangjun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {
    public SQLite(Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table users(id integer primary key autoincrement," +
                "_id text," +
                "name text)");
        db.execSQL("create table persons(id integer primary key autoincrement," +
                "_id text," +
                "name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
