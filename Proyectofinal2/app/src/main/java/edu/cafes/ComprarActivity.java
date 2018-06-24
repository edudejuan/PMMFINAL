package edu.cafes;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

public class ComprarActivity extends AppCompatActivity {
    float precioTotal;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        ImageView fotoCafe = findViewById(R.id.activity_comprar_foto_cafe);
        TextView nombreCafe = findViewById(R.id.activity_comprar_nombre_cafe);
        TextView descripcionCafe = findViewById(R.id.activity_comprar_descripcion_cafe);
        final TextInputEditText direccion = findViewById(R.id.activity_comprar_direccion);
        final TextView precio = findViewById(R.id.activity_comprar_precio);
        RadioButton local = findViewById(R.id.activity_comprar_local);
        RadioButton domicilio = findViewById(R.id.activity_comprar_domicilio);
        final CheckBox extraCrema = findViewById(R.id.activity_comprar_crema);
        final CheckBox extraHelado = findViewById(R.id.activity_comprar_helado);
        Button pedir = findViewById(R.id.activity_comprar_boton_pedir);

        final Cafe cafe = (Cafe) getIntent().getSerializableExtra("cafe");
        precioTotal = cafe.getPrecio();

        fotoCafe.setImageResource(cafe.getFotoID());
        nombreCafe.setText(cafe.getNombre());
        descripcionCafe.setText(cafe.getDescripcion());
        precio.setText(String.format(Locale.getDefault(), "%.2f €", cafe.getPrecio()));
//aqui se comprueba si esta apretao el boton

        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (direccion.isEnabled()) {
                    direccion.setEnabled(false);
                }
            }
        });

        domicilio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!direccion.isEnabled()) {
                    direccion.setEnabled(true);
                }
            }
        });
//Formateo del precio 2f(maximo 2 decimales) de tipo float
        extraCrema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extraCrema.isChecked()) {
                    precioTotal++;
                    precio.setText(String.format(Locale.getDefault(), "%.2f €", precioTotal));
                } else {
                    precioTotal--;
                    precio.setText(String.format(Locale.getDefault(), "%.2f €", precioTotal));
                }
            }
        });

        extraHelado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extraHelado.isChecked()) {
                    precioTotal++;
                    precio.setText(String.format(Locale.getDefault(), "%.2f €", precioTotal));
                } else {
                    precioTotal--;
                    precio.setText(String.format(Locale.getDefault(), "%.2f €", precioTotal));
                }
            }
        });

        pedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = cafe.getNombre();
                String direccionPedido="Local";
// Si la direccion esta seleccionada y hay texto se recogerá esa información sino se selecciona Local
                if (direccion.isEnabled() && !direccion.getText().toString().isEmpty()) {
                    direccionPedido = direccion.getText().toString();
                }
                SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(getApplicationContext());
                Pedido pedido = new Pedido(nombre, direccionPedido, precioTotal);

                Pedido.insertarPedido(sqLiteHelper, pedido);
                sqLiteHelper.close();
            }
        });
    }
}
