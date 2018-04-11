package com.example.eduardodejuan.checkbox1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        final CheckBox chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        final CheckBox chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);

        Button btnHobby = (Button)findViewById(R.id.btnHobby);
        final TextView txthobby = (TextView)findViewById(R.id.txtHobby);

        btnHobby.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                String strMessage = "";

                if(chkBoxCycling.isChecked()) {
                    strMessage+="Cycling ";
                }

                if(chkBoxTeaching.isChecked()) {
                    strMessage+="Teaching ";
                }

                if(chkBoxBlogging.isChecked()) {
                    strMessage+="Blogging ";
                }

                txthobby.setText(strMessage);
            } //OnClick
        });

    } //OnCreate

}//MainActivity