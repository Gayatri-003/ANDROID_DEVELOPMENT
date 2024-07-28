package com.example.formhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText et1,et2,et3,et4;
    SQLiteDatabase db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        et1=(EditText) findViewById(R.id.editTextText);
        et2=(EditText) findViewById(R.id.editTextText2);
        et3=(EditText) findViewById(R.id.editTextText3);
        et4=(EditText) findViewById(R.id.editTextText4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String str = et1.getText().toString();
                    String str1 = et2.getText().toString();
                    String str2 = et3.getText().toString();
                    String str3 = et4.getText().toString();

                    db1 = openOrCreateDatabase("MyDatabase", Context.MODE_PRIVATE, null);
                    db1.execSQL("create table if not exists Fields(Name varchar(30),DOB varchar(10),Email varchar(20),Contact varchar(10))");

                    ContentValues cv1 = new ContentValues();
                    cv1.put("Name", "" + str);
                    cv1.put("DOB", "" + str1);
                    cv1.put("Email", "" + str2);
                    cv1.put("Contact", "" + str3);

                    db1.insert("Fields", null, cv1);
                    Toast.makeText(MainActivity.this, "Data Inserted.", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, ""+e, Toast.LENGTH_SHORT).show();;
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i1 = new Intent(MainActivity.this, ShowData.class);
                    startActivity(i1);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, ""+e, Toast.LENGTH_SHORT).show();;
                }
            }
        });
        }
    }