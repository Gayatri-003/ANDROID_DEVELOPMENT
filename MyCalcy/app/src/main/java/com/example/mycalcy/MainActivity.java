package com.example.mycalcy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    int n1,n2,sum=0,diff=0,mul=1,div=1;
    String RES="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.editTextText);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        b6=(Button) findViewById(R.id.button6);
        b7=(Button) findViewById(R.id.button7);
        b8=(Button) findViewById(R.id.button8);
        b9=(Button) findViewById(R.id.button9);
        b10=(Button) findViewById(R.id.button10);
        b11=(Button) findViewById(R.id.button11);
        b12=(Button) findViewById(R.id.button12);
        b13=(Button) findViewById(R.id.button13);
        b14=(Button) findViewById(R.id.button14);
        b15=(Button) findViewById(R.id.button15);
        b16=(Button) findViewById(R.id.button16);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"1";
                et.setText(RES);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"2";
                et.setText(RES);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"3";
                et.setText(RES);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"4";
                et.setText(RES);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"5";
                et.setText(RES);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"6";
                et.setText(RES);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"7";
                et.setText(RES);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"8";
                et.setText(RES);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"9";
                et.setText(RES);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RES = RES+"0";
                et.setText(RES);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(RES);
                sum = sum +n1;
                et.setText(Integer.toString(sum));
                RES = "0";
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(RES);
                diff = n1-diff;
                et.setText(Integer.toString(diff));
                RES = "0";
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(RES);
                mul = mul *n1;
                et.setText(Integer.toString(mul));
                RES = "0";
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(RES);
                div = n1 ;
                et.setText(Integer.toString(n1));
                RES = "0";
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum!=0){
                    int n2 = Integer.parseInt(RES);
                    sum = sum +n2;
                    RES = Integer.toString(sum);
                    et.setText(RES);
                    sum=0;
                }
                else if(diff!=0){
                    int n2 = Integer.parseInt(RES);
                    diff = diff - n2;
                    RES = Integer.toString(diff);
                    et.setText(RES);
                    diff=0;
                }
                else if(mul!=0){
                    int n2 = Integer.parseInt(RES);
                    mul = mul *n2;
                    RES = Integer.toString(mul);
                    et.setText(RES);
                    mul=1;
                }
                else if(div!=0){
                    int n2 = Integer.parseInt(RES);
                    div = div /n2;
                    RES = Integer.toString(div);
                    et.setText(RES);
                    div=1;
                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RES = "0";
                sum =0;diff=0;mul=1;div=1;
                et.setText(RES);
            }
        });




    }
}