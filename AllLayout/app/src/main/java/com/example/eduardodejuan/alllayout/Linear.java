package com.example.eduardodejuan.alllayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Linear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        final Button botonVerde = (Button) findViewById(R.id.botonPrueba);
        final CheckBox checkVerde = (CheckBox) findViewById(R.id.checkPrueba);

        botonVerde.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                checkVerde.setVisibility(View.VISIBLE);
            }
        });
    }
}
