package com.example.aminloginpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Dashboard extends Activity {

    ImageButton ib1,ib2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db);
        ib1=(ImageButton) findViewById(R.id.imageButton);
        ib2=(ImageButton) findViewById(R.id.imageButton2);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Dashboard.this,BookShop.class);
                startActivity(i3);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    Intent i4 = new Intent(Dashboard.this,electronics.class);
                    startActivity(i4);
                }
        });
    }
}
