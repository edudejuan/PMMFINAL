package edu.cafes;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.Serializable;

public class Pedido implements Serializable {
    private String cafeNombre;
    private String direccion;
    private float precio;

    public Pedido(String cafeNombre, String direccion, float precio) {
        this.cafeNombre = cafeNombre;
        this.direccion = direccion;
        this.precio = precio;
    }

    public Pedido(Cursor cursor) {
        cafeNombre = cursor.getString(cursor.getColumnIndex("cafe_nombre"));
        direccion = cursor.getString(cursor.getColumnIndex("direccion"));
        precio = cursor.getFloat(cursor.getColumnIndex("precio"));
    }

    public String getCafeNombre() {
        return cafeNombre;
    }

    public void setCafeNombre(String cafeNombre) {
        this.cafeNombre = cafeNombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put("direccion", direccion);
        values.put("precio", precio);
        values.put("cafe_nombre", cafeNombre);

        return values;
    }

    public static Cursor obtenerPedidos(SQLiteHelper sqLiteHelper) {
        return sqLiteHelper.getReadableDatabase().query(
                "pedido",
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public static long insertarPedido(SQLiteHelper sqLiteHelper, Pedido pedido) {
        return sqLiteHelper.getWritableDatabase().insert(
                "pedido",
                null,
                pedido.toContentValues()
        );
    }
}
