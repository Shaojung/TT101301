package com.test.tt101301;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.test.tt101301.data.Student;
import com.test.tt101301.data.StudentDAOFileImpl;

public class DetailActivity extends AppCompatActivity {
    Student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        StudentDAOFileImpl impl = new StudentDAOFileImpl(this);
        int ID = getIntent().getIntExtra("ID", 0);
        s = impl.getItem(ID);
        Log.d("DATA", s.toString());

    }
}
