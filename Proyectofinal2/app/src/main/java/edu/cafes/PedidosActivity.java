package edu.cafes;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {
    private ListaPedidosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        TextView cabecera = findViewById(R.id.activity_pedidos_cabecera);
        RecyclerView recyclerView = findViewById(R.id.activity_pedidos_recycler);

        ArrayList<Pedido> pedidos = new ArrayList<>();
        SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(this);
        Cursor cursor = Pedido.obtenerPedidos(sqLiteHelper);

        while (cursor.moveToNext()) {
            pedidos.add(new Pedido(cursor));
        }
        sqLiteHelper.close();
        cursor.close();

        adapter = new ListaPedidosAdapter(pedidos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Si no hay ningún pedido, cambiamos la cabecera de la actividad
        if (pedidos.isEmpty()) {
            cabecera.setText(getText(R.string.pedido_cabecera_sin_pedidos));
        }
    }
}
