package entities;

import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

public class Artista {

    private String nombre;
    private MyList<Cancion> cancionesArtista;

    public Artista(String nombre) {
        this.nombre = nombre;
        cancionesArtista = new MyLinkedListIml<>();
    }

    public String getNombre() {
        return nombre;
    }
    public MyList<Cancion> getCancionesArtista() {
        return cancionesArtista;
    }

}
