package com.test.tt101301.data;

import android.content.Context;

import java.util.List;

/**
 * Created by teacher on 2016/10/17.
 */

public class StudentDAODBImpl implements StudentDAO {
    Context context;
    public StudentDAODBImpl(Context context)
    {
        this.context = context;
    }

    @Override
    public List getList() {
        return null;
    }

    @Override
    public void add(Student s) {

    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void delete(Student s) {

    }

    @Override
    public Student getItem(int ID) {
        return null;
    }
}
