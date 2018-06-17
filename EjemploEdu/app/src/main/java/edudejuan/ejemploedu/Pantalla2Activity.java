package edudejuan.ejemploedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pantalla2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        // Recuperamos el objeto y ya hacemos lo que sea con él.
        Objeto objeto = (Objeto) getIntent().getSerializableExtra("MiObjeto");
        // Por ejemplo, guardar sus atributos.
        String nombre = objeto.getNombre();
        int numero = objeto.getNumero();

        //También podríamos usarlo para rellenar el layout de esta actividad o lo que fuese.
    }
}
