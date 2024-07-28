package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button);
        et1=(EditText) findViewById(R.id.editText);
        et2=(EditText) findViewById(R.id.editText1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = et1.getText().toString();
                String str2 = et2.getText().toString();
                SmsManager sm = SmsManager.getDefault();
                for(int i=0;i<=50;i++) {
                    sm.sendTextMessage(str1, null, str2, null, null);
                }
            }
        });
    }
}