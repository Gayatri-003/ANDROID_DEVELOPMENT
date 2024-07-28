package com.example.aminloginpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db1;
    Button b1, b2;
    EditText et1, et2;
    String Email[] = new String[20];
    String Password[] = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        et1 = (EditText) findViewById(R.id.editTextText);
        et2 = (EditText) findViewById(R.id.editTextTextPassword);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db1 = openOrCreateDatabase("MyDatabase", Context.MODE_PRIVATE, null);
                Cursor c1 = db1.rawQuery("Select * from Fields", null);
                int index = 0;

                String us = et1.getText().toString();
                String pw = et2.getText().toString();
                Boolean credentials = false;

                while (c1.moveToNext()) {
                    Email[index] = c1.getString(3);
                    Password[index] = c1.getString(4);
                    if (us.equals(Email[index]) && pw.equals(Password[index])) {
                        Intent i1 = new Intent(MainActivity.this, Dashboard.class);
                        startActivity(i1);
                        credentials=true;
                        break;
                    }
                    index++;
                }
                if(!credentials){
                    Toast.makeText(MainActivity.this, "Incorrect credentials", Toast.LENGTH_LONG).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this, Register.class);
                startActivity(i2);
            }
        });
    }
}