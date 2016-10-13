package com.test.tt101301;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.test.tt101301.data.Student;

import java.util.ArrayList;

/**
 * Created by teacher on 2016/10/13.
 */

public class MyStudentAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> mylist;
    public boolean chks[];

    public MyStudentAdapter (Context context, ArrayList<Student> s)
    {
        mylist = s;
        chks = new boolean[mylist.size()];
        this.context = context;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.myitem, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        CheckBox chk = (CheckBox) v.findViewById(R.id.checkBox);
        chk.setChecked(chks[position]);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chks[position] = isChecked;
            }
        });

        tv.setText(mylist.get(position).Name);
        return v;
    }
}
