package com.test.tt101301;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.test.tt101301.data.Student;
import com.test.tt101301.data.StudentDAOFileImpl;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void clickAdd(View v)
    {
        EditText edName = (EditText) findViewById(R.id.edName);
        EditText edTel = (EditText) findViewById(R.id.edTel);
        EditText edAddr = (EditText) findViewById(R.id.edAddr);

        StudentDAOFileImpl impl = new StudentDAOFileImpl(this);
        impl.add(new Student(edName.getText().toString(), edTel.getText().toString(), edAddr.getText().toString()));
        finish();
    }
}
