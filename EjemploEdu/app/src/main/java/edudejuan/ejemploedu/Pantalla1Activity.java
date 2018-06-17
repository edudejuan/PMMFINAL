package edudejuan.ejemploedu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pantalla1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        Button button = findViewById(R.id.button);

        // Cuando se pulse el botón, se cambiará de actividad.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos el objeto de la clase Objeto en la Pantalla 1.
                Objeto objeto = new Objeto("objeto1", 1);
                // Creamos el Intent para cambiar de actividad y le añadimos nuestro objeto.

                Intent intent = new Intent(Pantalla1Activity.this, Pantalla2Activity.class);
                intent.putExtra("MiObjeto", objeto);
                startActivity(intent);
            }
        });

    }
}
