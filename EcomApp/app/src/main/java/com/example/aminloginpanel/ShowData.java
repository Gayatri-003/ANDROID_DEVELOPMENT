package com.example.aminloginpanel;

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
    String Name[]= new String[20];
    String Address[]= new String[20];
    String Contact[]= new String[20];
    String Email[]= new String[20];
    String Password[]=new String[20];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata);
        lst1=(ListView) findViewById(R.id.lst);
        try {
            db1 = openOrCreateDatabase("MyDatabase", Context.MODE_PRIVATE, null);

            Cursor c1 = db1.rawQuery("Select * from Fields", null);
            int index=0;
            while (c1.moveToNext()) {
                Name[index] = c1.getString(0);
                Address[index] = c1.getString(1);
                Contact[index] = c1.getString(2);
                Email[index] = c1.getString(3);
                Password[index]=c1.getString(4);
                index++;
            }

            LevelAdapter lvl = new LevelAdapter(ShowData.this,Name,Address,Contact,Email,Password);
            lst1.setAdapter(lvl);

        } catch (Exception e) {
            Toast.makeText(ShowData.this, ""+e, Toast.LENGTH_SHORT).show();;
        }
    }
    }
