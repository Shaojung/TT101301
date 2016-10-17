package com.test.tt101301.data;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by teacher on 2016/10/17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by teacher on 2016/10/17.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    final static String DB_NAME = "address.sqlite";
    final static int VERSION = 1;

    public MyDBHelper(Context context)
    {
        super(context, DB_NAME, null, VERSION);
    }

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"phonebook\" ( `_id` INTEGER PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `Tel` TEXT, `Addr` TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DATA", "This is onUpgrad");
    }
}