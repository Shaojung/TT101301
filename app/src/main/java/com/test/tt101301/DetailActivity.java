package com.test.tt101301;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.test.tt101301.data.Student;
import com.test.tt101301.data.StudentDAOFileImpl;

public class DetailActivity extends AppCompatActivity {
    Student s;
    EditText ed1, ed2, ed3;
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        StudentDAOFileImpl impl = new StudentDAOFileImpl(this);
        ID = getIntent().getIntExtra("ID", 0);
        s = impl.getItem(ID);
        Log.d("DATA", s.toString());

        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);

        ed1.setText(s.Name);
        ed2.setText(s.Tel);
        ed3.setText(s.Addr);

    }
    public void clickUpdate(View v)
    {
        Student t = new Student(ID, ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString());
        StudentDAOFileImpl impl = new StudentDAOFileImpl(this);
        impl.update(t);
        finish();
    }
    public void clickDelete(View v)
    {
        Student t = new Student(ID, ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString());
        StudentDAOFileImpl impl = new StudentDAOFileImpl(this);
        impl.delete(t);
        finish();
    }
}
