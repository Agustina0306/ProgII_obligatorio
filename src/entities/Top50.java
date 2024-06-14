package entities;

import java.time.LocalDate;

public class Top50 implements Comparable<Top50>{

    private String pais;

    private LocalDate fecha;

    private int posicion;

    private Cancion cancion;

    private int counter;

    public Top50(String pais, LocalDate fecha, Cancion cancion, int posicion) {
        this.pais = pais;
        this.fecha = fecha;
        this.cancion = cancion;
        this.posicion = posicion;
        this.counter = 0;
    }

    public String getPais() {
        return pais;
    }

    public LocalDate getFecha() {
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

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setCounter() {
        this.counter++;
    }

    @Override
    public int compareTo(Top50 o) {
        if (this.counter > o.counter){
            return 1;
        } else if (this.counter < o.counter) {
            return -1;
        } else {
            return 0;
        }
    }
}
