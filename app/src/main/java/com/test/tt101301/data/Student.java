package com.test.tt101301.data;

/**
 * Created by teacher on 2016/10/13.
 */

public class Student {
    public int ID;
    public String Name;
    public String Tel;
    public String Addr;

    public Student(String n, String t, String a)
    {
        this.Name = n;
        this.Tel = t;
        this.Addr = a;
    }

    @Override
    public String toString()
    {
        return this.Name + "," + this.Tel + "," + this.Addr;
    }
}
