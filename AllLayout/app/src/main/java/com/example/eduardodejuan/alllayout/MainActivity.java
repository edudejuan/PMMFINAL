package com.example.eduardodejuan.alllayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonLinear = (Button) findViewById(R.id.buttonLinear);
        final Button buttonTable = (Button) findViewById(R.id.buttonTable);
        final Button buttonRelative = (Button) findViewById(R.id.buttonRelative);
        final Button buttonGrid = (Button) findViewById(R.id.buttonGrid);

        buttonLinear.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Linear.class);
                startActivity(miIntent);
            }
        });

        buttonTable.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Table.class);
                startActivity(miIntent);
            }
        });

        buttonRelative.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Relative.class);
                startActivity(miIntent);
            }
        });

        buttonGrid.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Grid.class);
                startActivity(miIntent);
            }
        });
    }
}