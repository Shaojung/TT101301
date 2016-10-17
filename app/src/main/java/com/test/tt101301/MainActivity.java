package com.test.tt101301;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.tt101301.data.Student;
import com.test.tt101301.data.StudentDAO;
import com.test.tt101301.data.StudentDAOFactory;
import com.test.tt101301.data.StudentDAOFileImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Student> mylist;
    MyStudentAdapter adapter;
    final static String STORAGE_TYPE = "DB"; // File or DB
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StudentDAO impl = StudentDAOFactory.createStudentDAO(this, MainActivity.STORAGE_TYPE);
        mylist = (ArrayList<Student>) impl.getList();
        String names[] = new String[mylist.size()];
        for (int i=0;i<mylist.size();i++)
        {
            names[i] = mylist.get(i).Name;
        }
        adapter = new MyStudentAdapter(MainActivity.this, mylist);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                int ID = mylist.get(position).ID;
                it.putExtra("ID", ID);
                startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("ADD");
        menu.add("DELETE");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().equals("ADD"))
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        if (item.getTitle().equals("DELETE"))
        {
            StudentDAOFileImpl impl = new StudentDAOFileImpl(this);
            for (int i=mylist.size()-1;i>=0;i--)
            {
                if (adapter.chks[i] == true)
                {
                    impl.delete(new Student(mylist.get(i).ID, "","",""));
                }
            }
            mylist = (ArrayList<Student>) impl.getList();
            String names[] = new String[mylist.size()];
            for (int i=0;i<mylist.size();i++)
            {
                names[i] = mylist.get(i).Name;
            }
            adapter = new MyStudentAdapter(MainActivity.this, mylist);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent it = new Intent(MainActivity.this, DetailActivity.class);
                    int ID = mylist.get(position).ID;
                    it.putExtra("ID", ID);
                    startActivity(it);
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }
}
