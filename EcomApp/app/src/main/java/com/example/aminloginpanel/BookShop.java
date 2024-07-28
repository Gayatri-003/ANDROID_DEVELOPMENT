package com.example.aminloginpanel;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BookShop extends Activity implements AdapterView.OnItemSelectedListener{

    Spinner sp1, sp2, sp3;
    Button b1,b2;
    TextView tv5;
    String selectedValueSp1, selectedValueSp2, selectedValueSp3,ret=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookshop);
        BookShop obj = this;
        tv5=(TextView) findViewById(R.id.tv5);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);

        sp1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.branch, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        sp2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);

        sp3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.sem, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);

        sp1.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);
        sp3.setOnItemSelectedListener(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {                    // Check for null on each selected value
                    if (selectedValueSp1 != null && selectedValueSp2 != null && selectedValueSp3 != null) {
                        switch (selectedValueSp1) {
                            case "Computer Science":
                                switch (selectedValueSp2) {
                                    case "First":
                                        if ("I".equals(selectedValueSp3)) {
                                            ret = "1750";
                                        } else {
                                            ret = "1250";
                                        }
                                        break;
                                    case "Second":
                                        if (selectedValueSp3.equals("I")) {
                                            ret = "1150";
                                        } else {
                                            ret = "1350";
                                        }
                                        break;
                                    case "Third":
                                        if (selectedValueSp3.equals("I")) {
                                            ret = "1000";
                                        } else {
                                            ret = "1300";
                                        }
                                        break;
                                    case "Fourth":
                                        if (selectedValueSp3.equals("I")) {
                                            ret = "1050";
                                        } else {
                                            ret = "1450";
                                        }
                                        break;
                                }
                                break;
                            case "Aerospace Engineering":
                                switch (selectedValueSp2) {
                                    case "First":
                                        if ("I".equals(selectedValueSp3)) {
                                            ret = "2750";
                                        } else {
                                            ret = "2250";
                                        }
                                        break;
                                    case "Second":
                                        if (selectedValueSp3.equals("I")) {
                                            ret = "2150";
                                        } else {
                                            ret = "2350";
                                        }
                                        break;
                                    case "Third":
                                        if (selectedValueSp3.equals("I")) {
                                            ret = "2000";
                                        } else {
                                            ret = "2300";
                                        }
                                        break;
                                    case "Fourth":
                                        if (selectedValueSp3.equals("I")) {
                                            ret = "2050";
                                        } else {
                                            ret = "2450";
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                    tv5.setText(ret);
                } catch (Exception e) {
                    Toast.makeText(BookShop.this, "" + e, Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage("7219360159",null,"Order Placed for "+selectedValueSp1+": "+selectedValueSp2+": "+selectedValueSp3+".\n Total Cost is "+ret,null,null);
                Toast.makeText(obj, "Order Placed Successfully!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
        if (parent.getId() == R.id.spinner1) {
            selectedValueSp1 = text;
        } else if (parent.getId() == R.id.spinner2) {
            selectedValueSp2 = text;
        } else if (parent.getId() == R.id.spinner3) {
            selectedValueSp3 = text;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
