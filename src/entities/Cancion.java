package entities;

public class Cancion {

    private String titulo;

    private String idSong;

    private double tempo;

    private int posicion;

    private Artista artista;

    public String getTitulo() {
        return titulo;
    }

    public String getIdSong() {
        return idSong;
    }

    public double getTempo() {
        return tempo;
    }

    public int getPosicion() {
        return posicion;
    }

    public Artista getArtista() {
        return artista;
    }
}
