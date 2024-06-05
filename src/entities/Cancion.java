package entities;

import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

public class Cancion {

    private String titulo;

    private String idSong;

    private double tempo;

    private MyList<Artista> artista;

    public Cancion(String titulo, String idSong, double tempo) {
        this.titulo = titulo;
        this.idSong = idSong;
        this.tempo = tempo;
        this.artista = new MyLinkedListIml<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdSong() {
        return idSong;
    }

    public double getTempo() {
        return tempo;
    }

    public MyList<Artista> getArtista() {
        return artista;
    }
}
