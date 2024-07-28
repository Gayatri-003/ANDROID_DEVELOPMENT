package com.example.databasecnf;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ShowData extends Activity {
    SQLiteDatabase db1;
    ListView lst1;
    String name[] = new String[20];
    String email[]= new String[20];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata);
        lst1=(ListView) findViewById(R.id.lst);
        try {
            db1 = openOrCreateDatabase("myDb", Context.MODE_PRIVATE, null);
            int count=0;
            Cursor c1 = db1.rawQuery("Select * from userdata", null);

            while (c1.moveToNext()) {
                /*String str = c1.getString(0);
                Toast.makeText(ShowData.this, "" + str, Toast.LENGTH_LONG).show();
                String str1 = c1.getString(1);
                Toast.makeText(ShowData.this, "" + str1, Toast.LENGTH_LONG).show();*/
                name[count] = c1.getString(0);
                email[count]= c1.getString(1);
                count++;
            }

            LevelAdapter lvl = new LevelAdapter(ShowData.this,name,email,email);
            lst1.setAdapter(lvl);
        }
        catch(Exception e){
            //Toast.makeText(ShowData.this, "" + e, Toast.LENGTH_LONG).show();

        }
    }
}
