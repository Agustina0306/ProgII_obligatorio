package entities;

import java.time.LocalDate;

public class Top50 {

    private String pais;

    private LocalDate fecha;

    private Cancion cancion;

    public Top50(String pais, LocalDate fecha, Cancion cancion) {
        this.pais = pais;
        this.fecha = fecha;
        this.cancion = cancion;
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

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }
}
