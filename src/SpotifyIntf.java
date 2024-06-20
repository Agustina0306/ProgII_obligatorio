import entities.DataLoader;
import exceptions.DatoNoEXiste;
import exceptions.DatoInvalido;

public interface SpotifyIntf {

    public void top10DiaPais(String pais, String fecha, DataLoader data) throws DatoNoEXiste, DatoInvalido;

    public void Top5canciones (String fecha, DataLoader data) throws DatoInvalido, DatoNoEXiste;

    public void Top7ArtistasEnRango (String fechaInicio, String fechaFin, DataLoader data) throws DatoInvalido;

    public void cantArtistaTop50 (String date, String pais, String artista, DataLoader data) throws DatoInvalido, DatoNoEXiste;

    public void cancionesTempo (double tempoMax, double tempoMin, String fechaIni, String fechaFin, DataLoader data) throws DatoInvalido;

}
