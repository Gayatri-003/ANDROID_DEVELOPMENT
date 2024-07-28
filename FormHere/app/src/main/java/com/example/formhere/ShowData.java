package com.example.formhere;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;

public class ShowData extends Activity {
    SQLiteDatabase db1;
    ListView lst1;
    TextView tv2,tv4,tv6,tv8;
    String name[]= new String[20];
    String dob[]= new String[20];
    String email[]= new String[20];
    String contact[]= new String[20];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata);
        lst1=(ListView) findViewById(R.id.lst);
        try {
            db1 = openOrCreateDatabase("MyDatabase", Context.MODE_PRIVATE, null);
            tv2=(TextView) findViewById(R.id.tv2);
            tv4=(TextView) findViewById(R.id.tv4);
            tv6=(TextView) findViewById(R.id.tv6);
            tv8=(TextView) findViewById(R.id.tv8);

            Cursor c1 = db1.rawQuery("Select * from Fields", null);
            int index=0;
            while (c1.moveToNext()) {
                /*String str1 = c1.getString(0);
                tv2.setText(str1);
                String str2 = c1.getString(1);
                tv4.setText(str2);
                String str3 = c1.getString(2);
                tv6.setText(str3);
                String str4 = c1.getString(3);
                tv8.setText(str4);*/

                name[index] = c1.getString(0);
                dob[index] = c1.getString(1);
                email[index] = c1.getString(2);
                contact[index] = c1.getString(3);
                index++;
            }

            LevelAdapter lvl = new LevelAdapter(ShowData.this,name,dob,email,contact);
            lst1.setAdapter(lvl);

        } catch (Exception e) {
            Toast.makeText(ShowData.this, ""+e, Toast.LENGTH_SHORT).show();;
        }
    }
    }
