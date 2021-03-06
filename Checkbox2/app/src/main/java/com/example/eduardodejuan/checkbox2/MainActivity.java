package com.example.eduardodejuan.checkbox2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxPatin;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHobby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialUISetup();
    }//OnCreate

    public void initialUISetup()  {
        chkBoxPatin = (CheckBox) findViewById(R.id.chkBoxPatin);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        btnHobby = (Button)findViewById(R.id.btnHobby);
        txtHobby = (TextView)findViewById(R.id.txtHobby);

        btnHobby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                getHobbyClick(v);
            }
        });
    }//initialUISetup

    public void getHobbyClick(View v) {
        String strMessage = "";
        if(chkBoxPatin.isChecked())
        {
            strMessage+="Patin  ";
        }
        if(chkBoxTeaching.isChecked())
        {
            strMessage+="Teaching ";
        }
        if(chkBoxBlogging.isChecked())
        {
            strMessage+="Blogging ";
        }
        showTextNotification(strMessage);
    }//getHobbyClick

    public void showTextNotification(String msgToDisplay) {
        txtHobby.setText(msgToDisplay);
        //Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();

    }//showTextNotification

}//MainActivity
