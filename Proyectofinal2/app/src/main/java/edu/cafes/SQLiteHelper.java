package edu.cafes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static SQLiteHelper sInstance;

    private SQLiteHelper(Context context) {
        super(context, "cafes.db", null, 4);
    }
//se asegura que solo haya un objeto de esta clase y siempre se abre y se cierra la misma instancia
    public static synchronized SQLiteHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SQLiteHelper(context.getApplicationContext());
        }
        return sInstance;
    }
//Se ejecuta cuando es necesario crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tabla cafe
        db.execSQL("CREATE TABLE cafe(" +
                "_id INTEGER PRIMARY KEY," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT NOT NULL," +
                "precio REAL NOT NULL," +
                "foto_id INTEGER," +
                "UNIQUE (nombre)" +
                ")"
        );
        // Tabla pedido
        db.execSQL("CREATE TABLE pedido(" +
                "_id INTEGER PRIMARY KEY," +
                "direccion TEXT NOT NULL," +
                "precio REAL NOT NULL," +
                "cafe_nombre TEXT NOT NULL," +
                "FOREIGN KEY (cafe_nombre) REFERENCES cafe(nombre)" +
                ")"
        );

        // Datos de los cafés
        Cafe cafe1 = new Cafe("Capuccino", "Con Espuma", 4.0f, R.drawable.capuccino);
        Cafe cafe2 = new Cafe("Americano", "Café hasta arriba", 5.0f, R.drawable.americano);
        Cafe cafe3 = new Cafe("Cortado", "Mitad leche mitad café", 6.0f, R.drawable.cortado);

        db.insert("cafe", null, cafe1.toContentValues());
        db.insert("cafe", null, cafe2.toContentValues());
        db.insert("cafe", null, cafe3.toContentValues());
    }
//Elimina las tablas y las vuelve a crear cada vez que se actualiza la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cafe");
        db.execSQL("DROP TABLE IF EXISTS pedido");

        onCreate(db);
    }
}
