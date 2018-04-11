package com.example.eduardodejuan.layout2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FUNCIONALIDAD DEL BOTÓN
        final Button botonPrueba = (Button) findViewById(R.id.botonPrueba);
        final TextView etiquetaPrueba = (TextView) findViewById(R.id.etiquetaPrueba);

        Toast.makeText(this, "estoy en pantalla1", Toast.LENGTH_SHORT).show();

        botonPrueba.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                etiquetaPrueba.setText("HOLA");

            }
        });//OnCreate (CIERRE)
    }
}
