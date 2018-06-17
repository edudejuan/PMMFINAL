package edudejuan.ejemploedu;

import java.io.Serializable;

/**
 * Un objeto cualquiera, que implementa la interfaz Serializable.
 */
public class Objeto implements Serializable {
    private String nombre;
    private int numero;

    public Objeto(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
