package com.example.aminloginpanel;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class electronics extends Activity implements AdapterView.OnItemSelectedListener {
    Spinner sp1, sp2;
    Button b1,b2;
    TextView tv5;
    EditText et;
    String selectedValueSp1, selectedValueSp2,ret=null,quant;
    int amt=0,cost=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electronics);
        electronics obj = this;
        tv5=(TextView) findViewById(R.id.tv5);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        et=(EditText) findViewById(R.id.quantity);

        sp1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.product, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        sp2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.brand, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);

        sp1.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {// Check for null on each selected value
                    quant = et.getText().toString();
                    amt = Integer.parseInt(quant);
                    if (selectedValueSp1 != null && selectedValueSp2 != null && quant!=null) {
                        switch (selectedValueSp1) {
                            case "Laptop":
                                switch (selectedValueSp2) {
                                    case "Apple/MAC":
                                        cost = 150000*1;
                                        break;
                                    case "Lenovo":
                                        cost = 60000*amt;
                                        break;
                                    case "Hp":
                                        cost = 75000*amt;
                                        break;
                                }
                                break;
                            case "Smart watch":
                                switch (selectedValueSp2) {
                                    case "Apple/MAC":
                                        cost = 80000*amt;
                                        break;
                                    case "Samsung":
                                        cost = 15000*amt;
                                        break;
                                    case "Sony":
                                        cost = 30000*amt;
                                        break;
                                }
                                break;
                            case "Headphone/Eardopes":
                                switch (selectedValueSp2) {
                                    case "Apple/MAC":
                                        cost = 16000*amt;
                                        break;
                                    case "Samsung":
                                        cost = 6000*amt;
                                        break;
                                    case "Sony":
                                        cost = 4000*amt;
                                        break;
                                }
                                break;
                            case "VR Headset":
                                switch (selectedValueSp2) {
                                    case "Apple/MAC":
                                        cost = 53000*amt;
                                        break;
                                    case "Samsung":
                                        cost = 10000*amt;
                                        break;
                                    case "Sony":
                                        cost = 60000*amt;
                                        break;
                                }
                                break;

                        }
                    }
                    tv5.setText(""+cost);
                } catch (Exception e) {
                    Toast.makeText(electronics.this, "" + e, Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage("7219360159",null,"Order Placed for "+selectedValueSp1+": "+selectedValueSp2+": "+"Quantity= "+quant+".\n Total Cost is "+ret,null,null);
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
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
