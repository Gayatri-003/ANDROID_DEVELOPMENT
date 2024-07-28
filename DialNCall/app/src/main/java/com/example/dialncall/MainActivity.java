package com.example.dialncall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText et1;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.editTextTextPassword);
        b3=(Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                String str2 = et1.getText().toString();
                if (str2.equals("1234")) {
                    Intent i1 = new Intent(MainActivity.this, dialncall.class);
                    startActivity(i1);
                } else {
                    Toast.makeText(MainActivity.this, "Access Denied!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}