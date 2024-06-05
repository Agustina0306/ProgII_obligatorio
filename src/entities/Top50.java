package entities;

import java.time.LocalDate;

public class Top50 {

    private String pais;

    private String fecha;

    private int posicion;

    private Cancion cancion;

    public Top50(String pais, String fecha, Cancion cancion, int posicion) {
        this.pais = pais;
        this.fecha = fecha;
        this.cancion = cancion;
        this.posicion = posicion;
    }

    public String getPais() {
        return pais;
    }

    public String getFecha() {
        return fecha;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
