package edu.cafes;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.Serializable;
//solo sirve para modelar (MODELO)

public class Cafe implements Serializable {
    private String nombre;
    private String descripcion;
    private float precio;
    private int fotoID;

    public Cafe(String nombre, String descripcion, float precio, int fotoID) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fotoID = fotoID;
    }

    /**
     * Constructor para obtener un objeto Cafe a partir de un cursor
     */
    public Cafe(Cursor cursor) {
        nombre = cursor.getString(cursor.getColumnIndex("nombre"));
        descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));
        precio = cursor.getFloat(cursor.getColumnIndex("precio"));
        fotoID = cursor.getInt(cursor.getColumnIndex("foto_id"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getFotoID() {
        return fotoID;
    }

    public void setFotoID(int fotoID) {
        this.fotoID = fotoID;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("precio", precio);
        values.put("foto_id", fotoID);

        return values;
    }

    public static Cursor obtenerCafes(SQLiteHelper sqLiteHelper) {
        return sqLiteHelper.getReadableDatabase().query(
                "cafe",
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public static long insertarCafe(SQLiteHelper sqLiteHelper, Cafe cafe) {
        return sqLiteHelper.getWritableDatabase().insert(
                "pedido",
                null,
                cafe.toContentValues()
        );
    }
}
