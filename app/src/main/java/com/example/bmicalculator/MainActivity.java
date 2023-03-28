package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;



import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Button calbtn;
    private Button reset;
    private TextInputEditText height;
    private TextInputEditText weight;
    private TextView  BMI_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calbtn= findViewById(R.id.btnCal);
        reset = findViewById(R.id.btnreset);
        height = findViewById(R.id.ht);
        weight = findViewById(R.id.wt);
        BMI_display = findViewById(R.id.BMI);

        reset.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                height.setText("");
                weight.setText("");
                BMI_display.setText("BMI");

                height.setError(null);
                weight.setError(null);


            }



        });




        calbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String he = height.getText().toString().trim();
                String we = weight.getText().toString().trim();
                if (he.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input Incomplete", Toast.LENGTH_SHORT).show();
                    height.setError("required");    return;
                }
                if (we.isEmpty()) {Toast.makeText(MainActivity.this, "Input Incomplete", Toast.LENGTH_SHORT).show();
                    weight.setError("required");    return;}

                double  inh = Double.parseDouble(height.getText().toString());
                double  inw = Double.parseDouble(weight.getText().toString());
                inh=inh/100;
                double r_BMI = inw/(inh*inh);
                String rr =Double.toString(r_BMI);
                BMI_display.setText(rr);




            }

        });

    }
}
