package com.example.databasecnf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    SQLiteDatabase db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    db1 = openOrCreateDatabase("myDb", Context.MODE_PRIVATE, null);
                    db1.execSQL("create table if not exists userdata(Name varchar(30),Email varchar(30))");

                    ContentValues cv1 = new ContentValues();
                    cv1.put("Name", "Gayatri");
                    cv1.put("Email", "gm@123");
                    db1.insert("userdata", null, cv1);
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, ShowData.class);
                startActivity(i1);
            }
        });
    }
}