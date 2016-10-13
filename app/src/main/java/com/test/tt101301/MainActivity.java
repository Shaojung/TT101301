package com.test.tt101301;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.test.tt101301.data.Student;
import com.test.tt101301.data.StudentDAOFileImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentDAOFileImpl impl = new StudentDAOFileImpl();
        impl.add(new Student("AAA", "111", "AA11"));
        ArrayList<Student> mylist = (ArrayList<Student>) impl.getList();
        for (Student s : mylist)
        {
            Log.d("DATA", s.toString());
        }
    }
}
