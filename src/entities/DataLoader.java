package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import tad.Hash2.MyClosedHash;
import tad.Hash2.MyHash;
import java.time.format.DateTimeFormatter;

public class DataLoader {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private MyHash<String, Top50> topEntriesHash = new MyClosedHash<>();
    private MyHash<String, Cancion> songHash = new MyClosedHash<>();
    private MyHash<String, Artista> artistHash = new MyClosedHash<>();

    public void loadData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int datosNumero = 0;

            System.out.println("Cargando datos, por favor espere...");

            br.readLine(); // descarto la primera linea

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",\"");

                for (int i = 0; i < values.length; i++) {
                    // Eliminar comillas adicionales
                    values[i] = values[i].replace("\"", "");
                }

                String spotifyId = values[0];
                String songTitle = values[1];
                String[] artistNames;
                int position;
                String country;
                LocalDate date;
                double tempo;

                // TENGO QUE HACERLO ASI PORQUE TENGO ALGUNAS CANCIONES COMO DEAR MY FRIEND, QUE AFECTA LA COMA DEL NOMBRE
                if (values[2] == "" && values[1] != "") {
                    artistNames = values[3].split(", ");
                    position = Integer.parseInt(values[4]);
                    country = values[7];
                    date = LocalDate.parse(values[8], formatter);
                    tempo = Double.parseDouble(values[values.length - 2]);
                } else {
                    artistNames = values[2].split(", ");
                    position = Integer.parseInt(values[3]);
                    country = values[6];
                    date = LocalDate.parse(values[7], formatter);
                    tempo = Double.parseDouble(values[values.length - 2]);
                }

                // Instancio una cancion nueva y al mismo tiempo la agrego en el Hash de cancion
                Cancion song = songHash.insertIfAbsent(spotifyId, () -> new Cancion (songTitle, spotifyId, tempo));

                // Crear o recuperar los artistas y asociarlos con la canción
                for (String artistName : artistNames) {
                    Artista artist = artistHash.insertIfAbsent(artistName, () -> new Artista(artistName));
                    song.getArtista().add(artist);
                    artist.getCancionesArtista().add(song);
                }

                // Crear y agregar la entrada Top50
                String topEntryKey = country + date;
                Top50 topEntry = new Top50(country,date,song,position);
                topEntriesHash.insert(topEntryKey,topEntry);
            }
            System.out.println("Datos cargados exitosamente.");
        } catch (IOException e) {  // Excepcion de java que salta cuando no se puede leer correctamente el archivo
            e.printStackTrace();
        }
    }

    public MyHash<String, Top50> getTopEntries() {
        return topEntriesHash;
    }

    public MyHash<String, Cancion> getSongHash() {
        return songHash;
    }

    public MyHash<String, Artista> getArtistHash() {
        return artistHash;
    }
}
