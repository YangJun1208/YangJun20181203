package com.bwei.yangjun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private SQLite sqLite;
    private SQLiteDatabase database;
    public PersonDao(Context context){
        sqLite=new SQLite(context);
        database=sqLite.getReadableDatabase();
    }

    public void add(String _id,String name){
        ContentValues values = new ContentValues();
        values.put("_id",_id);
        values.put("name",name);
        database.insert("persons",null,values);
    }

    public List<UsersBean> select(){
        ArrayList<UsersBean> list = new ArrayList<>();
        Cursor cursor = database.query("persons", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            UsersBean usersBean = new UsersBean(id, name);
            list.add(usersBean);
        }
        return list;
    }
}
