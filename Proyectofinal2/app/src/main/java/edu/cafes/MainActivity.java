package edu.cafes;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
//desde MainActivity  vas a las otras 3 actividades
public class MainActivity extends AppCompatActivity implements ListaCafesAdapter.ItemClickListener {
    private ListaCafesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.activity_main_recycler);

        // Creamos un array para almacenar todos los cafés
        ArrayList<Cafe> cafes = new ArrayList<>();
        // Creamos lo necesario para usar la base de datos
        SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(this);
        Cursor cursor = Cafe.obtenerCafes(sqLiteHelper);

        // Leemos en la base de datos los cafés
        while (cursor.moveToNext()) {
            cafes.add(new Cafe(cursor));
        }
        // Cerramos el cursor y la base de datos
        sqLiteHelper.close();
        cursor.close();

        // Creamos el adaptador y lo llenamos con el array
        adapter = new ListaCafesAdapter(cafes);
        // Le añadimos el onItemClick()
        adapter.setItemClickListener(this);

        // Configuramos la RecyclerView y le añadimos el adaptador
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
//Crea menu y cuando seleccionas una opción va a una pantalla u otra
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_principal_pedidos:
                intent = new Intent(MainActivity.this, PedidosActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_principal_acerca_de:
                intent = new Intent(MainActivity.this, AcercaDeActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
//sobreescribir el OnItemClick del adaptador ListaCafesAdapter. Son las actividades las que tienen que manejar los eventos
    @Override
    public void onItemClick(View view, final int position) {
        Cafe cafe = adapter.getCafe(position);

        Intent intent = new Intent(this, ComprarActivity.class);
        intent.putExtra("cafe", cafe);
        startActivity(intent);
    }

}
