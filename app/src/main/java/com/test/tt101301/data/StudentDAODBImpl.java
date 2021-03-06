package com.test.tt101301.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teacher on 2016/10/17.
 */

public class StudentDAODBImpl implements StudentDAO {
    ArrayList<Student> mylist;
    Context context;
    SQLiteDatabase db;

    public StudentDAODBImpl(Context context)
    {
        this.context = context;
        mylist = new ArrayList<>();
        MyDBHelper helper = new MyDBHelper(context);
        db = helper.getWritableDatabase();

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        db.close();
    }

    @Override
    public List getList() {
        Cursor c = db.query("phonebook", new String[] {"_id", "Name", "Tel", "Addr"}, null, null, null, null, null);
        if (c.moveToFirst())
        {
            do {
                mylist.add(new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)));
            }while(c.moveToNext());
        }
        return mylist;
    }

    @Override
    public void add(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("Name", s.Name);
        cv.put("Tel", s.Tel);
        cv.put("Addr", s.Addr);
        db.insert("phonebook", null, cv);

    }

    @Override
    public void update(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("Name", s.Name);
        cv.put("Tel", s.Tel);
        cv.put("Addr", s.Addr);
        final String strID = String.valueOf(s.ID);
        db.update("phonebook", cv, "_id=?", new String[]{strID});
    }

    @Override
    public void delete(Student s) {
        db.delete("phonebook", "_id=?", new String[] {String.valueOf(s.ID)});
    }

    @Override
    public Student getItem(int ID) {

        Cursor c = db.query("phonebook", new String[] {"_id", "Name", "Tel", "Addr"}, "_id=?", new String[]{String.valueOf(ID)}, null, null, null);
        if (c.moveToFirst())
        {
            return new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3));
        }
        return null;
    }
}
