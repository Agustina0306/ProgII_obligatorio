package entities;

import java.time.LocalDate;

public class Top50 {

    private String pais;

    private LocalDate fecha;

    private Cancion cancion;



    public String getPais() {
        return pais;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cancion getCancion() {
        return cancion;
    }
}
