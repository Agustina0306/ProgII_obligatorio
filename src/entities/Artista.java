package entities;

import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

public class Artista implements Comparable<Artista> {

    private String nombre;
    private MyList<Cancion> cancionesArtista;

    private int artistaCounter;

    public Artista(String nombre) {
        this.nombre = nombre;
        cancionesArtista = new MyLinkedListIml<>();
        this.artistaCounter = 0;
    }

    public String getNombre() {
        return nombre;
    }
    public MyList<Cancion> getCancionesArtista() {
        return cancionesArtista;
    }

    public void setArtistaCounter() {
        this.artistaCounter++;
    }

    @Override
    public int compareTo(Artista o) {
        if (this.artistaCounter > o.artistaCounter){
            return 1;
        } else if (this.artistaCounter < o.artistaCounter) {
            return -1;
        } else {
            return 0;
        }
    }
}
