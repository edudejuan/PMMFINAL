package com.example.eduardodejuan.layoutfin;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class Pantalla2 extends AppCompatActivity {

    RadioButton radioP;
    RadioButton radioO;
    RadioButton radioV;
    Button botonSet;
    Button botonDelete;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        initialUISetup();
    }

    public void initialUISetup() {
        radioP = (RadioButton) findViewById(R.id.radio11);
        radioO = (RadioButton) findViewById(R.id.radio22);
        radioV = (RadioButton) findViewById(R.id.radio333);
        botonSet = (Button) findViewById(R.id.button11);
        botonDelete = (Button) findViewById(R.id.button222);
        textView = (TextView) findViewById(R.id.textView);

        botonSet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getColor(v);
            }
        });

        botonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setBackgroundColor(Color.WHITE);
            }
        });
    }

    public void getColor(View v) {
        if (radioP.isChecked()) {
            textView.setBackgroundColor(Color.RED);
        }
        if (radioO.isChecked()) {
            textView.setBackgroundColor(Color.GREEN);
        }
        if (radioV.isChecked()) {
            textView.setBackgroundColor(Color.BLUE);
        }
    }
}
