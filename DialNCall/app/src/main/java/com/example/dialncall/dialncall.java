package com.example.dialncall;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class dialncall extends Activity {
    EditText et2;
    Button b1,b2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialncall);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        et2=(EditText) findViewById(R.id.editTextText);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et2.getText().toString();
                Intent i1 = new Intent(Intent.ACTION_CALL);
                i1.setData(Uri.parse("tel: " + str));
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_CALL);
                i2.setData(Uri.parse("tel: 100"));
                startActivity(i2);
            }
        });
    }
}
