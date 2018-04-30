package com.example.eduardodejuan.checkbox3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chkBoxBici;
    CheckBox chkBoxProgramar;
    CheckBox chkBoxJugar;
    CheckBox chkBoxBañarse;
    Button btnHobby;
    TextView txtHobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialUISetup();
    }//OnCreate

    public void initialUISetup()  {
        chkBoxBici = (CheckBox) findViewById(R.id.chkBoxbici);
        chkBoxProgramar = (CheckBox) findViewById(R.id.chkBoxProgramar);
        chkBoxJugar = (CheckBox) findViewById(R.id.chkBoxJugar);
        chkBoxBañarse = (CheckBox) findViewById(R.id.chkBoxBañarse);
        TextView txtHobby = (TextView)findViewById(R.id.txtHobby);
        chkBoxBici.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxProgramar.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxJugar.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBañarse.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        btnHobby = (Button)findViewById(R.id.btnHobby);
        txtHobby = (TextView)findViewById(R.id.txtHobby);

        btnHobby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                getHobbyClick(v);
            }
        });

    }//initialUISetup

    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener  {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)  {
            if(isChecked)  {
                if(buttonView==chkBoxBici) {
                    showTextNotification("Ir en bici");
                }
                if(buttonView==chkBoxProgramar) {
                    showTextNotification("Programar");
                }
                if(buttonView==chkBoxJugar) {
                    showTextNotification("Jugar");
                }
                if(buttonView==chkBoxBañarse) {
                showTextNotification("Bañarse");
                }
            }
        }//onCheckedChanged
    }//myCheckBoxChangeClicker
        public void getHobbyClick(View v) {
            String strMessage = "";
         if(chkBoxBici.isChecked())
            {
                strMessage+="Bici ";
            }
            if(chkBoxProgramar.isChecked())
            {
                strMessage+="Programar ";
             }
            if(chkBoxJugar.isChecked())
            {
                 strMessage+="Jugar ";
            }
            if(chkBoxBañarse.isChecked())
            {
                strMessage+="Bañarse ";
            }

        showTextNotification(strMessage);
     }//getHobbyClick

    public void showTextNotification(String msgToDisplay)  {
        Toast.makeText(this, msgToDisplay, Toast.LENGTH_LONG).show();
    }//showTextNotification

}//MainActivity
