import entities.Artista;
import entities.Cancion;
import entities.DataLoader;
import entities.Top50;
import exceptions.DatoNoEXiste;
import tad.LinkedList.DatoInvalido;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;
import tad.heap.MyHeap;
import tad.heap.MyHeapImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Spotify{

    public void top10DiaPais(String pais, String fecha, DataLoader data) throws DatoInvalido, DatoNoEXiste {
        System.out.println("Procesando...");
        if (pais==null || fecha==null || data==null){
            throw new DatoInvalido();
        }
        if (!data.getTopEntries().contains(pais + "|"+ fecha + "|" + "1")){
            throw new DatoNoEXiste();
        }
        int i=10;
        while(i!=0){

            String j= String.valueOf(i);
            String key = pais + "|" + fecha + "|" + j;
            MyList<Artista> artistas = data.getTopEntries().getValue(key).getCancion().getArtista();
            String titulo= data.getTopEntries().getValue(key).getCancion().getTitulo();
            StringBuilder nombresArtistas = new StringBuilder();

            for (int k = 0; k < artistas.size(); k++) {
                if (k > 0) {
                    nombresArtistas.append(" | ");
                }
                nombresArtistas.append(artistas.getPosition(k).getNombre());
            }

            System.out.println("Nombre Cancion: " + titulo + " Artista: "+ nombresArtistas + " Posicion: "+ j );
            i--;
        }

    }

    public void Top5canciones (String fecha, DataLoader data) throws DatoInvalido {
        System.out.println("Procesando...");
        if (fecha == null){
            throw new DatoInvalido();
        }
        LocalDate date = LocalDate.parse(fecha);
        MyHeap<Top50> cancionesFecha = data.getTop50Fecha().getValue(date);
        for (int i = 0; i < 5 ; i++) {
            System.out.println(cancionesFecha.delete().getCancion().getTitulo());
        }

    }

    public void Top7ArtistasEnRango (String fechaInicio, String fechaFin, DataLoader data) throws DatoInvalido {
        System.out.println("Procesando...");
        if (fechaInicio == null || fechaFin == null || data == null){
            throw new DatoInvalido();
        }

        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);
        LocalDate currentDate = inicio;

        if (fin.isBefore(inicio)) {
            throw new DatoInvalido();
        }

        MyHeap<Artista> artistasExitosos = new MyHeapImpl<>(false);

        while (!currentDate.isAfter(fin)){
            MyHeap<Top50> cancionesFecha = data.getTop50Fecha().getValue(currentDate);
            Cancion tempCancion = cancionesFecha.delete().getCancion();
            MyList<Artista> artistas = tempCancion.getArtista();

            for (int j = 0; j < artistas.size(); j++) {
                Artista tempArtista = artistas.getPosition(j);
                if (artistasExitosos.search(tempArtista) != null && artistasExitosos.search(tempArtista).equals(tempArtista)) {
                    artistasExitosos.search(tempArtista).setArtistaCounter();
                } else {
                    tempArtista.setArtistaCounter();
                    artistasExitosos.insert(tempArtista);
                }
            }

            currentDate = currentDate.plusDays(1);
        }
        System.out.println(artistasExitosos.size());
        for (int i = 0; i < 7; i++) {
            System.out.println(artistasExitosos.delete().getNombre());
        }
    }
    public void cantArtistaTop50 (String date, String pais, String artista, DataLoader data) throws DatoInvalido {
        System.out.println("Procesando...");
        if (date == null || pais == null){
            throw new DatoInvalido();
        }
        int cantidad = 0;

        for (int i = 0; i < data.getTopEntries().size(); i++) {
            String key = pais + "|" + date + "|" + "i";

            MyList<Artista> artistas =  new MyLinkedListIml<>();

            if (data.getTopEntries().getValue(key) != null) {
                artistas = data.getTopEntries().getValue(key).getCancion().getArtista();
                for (int j = 0; j < artistas.size() ; j++) {
                    if (artistas.getPosition(j).getNombre().equals(artista)){
                        cantidad++;
                    }
                }
            }
        }

        String cantStr = String.valueOf(cantidad);
        System.out.println("El artista " + artista + "aparece " + cantStr + "veces ");

    }

    public void cancionesTempo (double tempoMax, double tempoMin, String fechaIni, String fechaFin, DataLoader data) throws DatoInvalido {
        System.out.println("Procesando...");

        if (tempoMax == 0 || tempoMin == 0 || fechaFin == null || fechaIni == null) {
            throw new DatoInvalido();
        }

        LocalDate inicio = LocalDate.parse(fechaIni);
        LocalDate fin = LocalDate.parse(fechaFin);
        LocalDate currentDate = inicio;
        int cantCanciones = 0;

        if (fin.isBefore(inicio)) {
            throw new DatoInvalido();
        }


        while (!currentDate.isAfter(fin)) {

            MyHeap<Top50> cancionesFecha = data.getTop50Fecha().getValue(currentDate);
            System.out.println(cancionesFecha.size());

            for (int i = 0; i < cancionesFecha.size(); i++) {
                Cancion tempCancion = cancionesFecha.delete().getCancion();
                if (tempoMin <= tempCancion.getTempo() && tempCancion.getTempo() <= tempoMax) {
                    cantCanciones++;
            }

            }
            currentDate = currentDate.plusDays(1);
        }

        System.out.println("Hay " + cantCanciones + " canciones con un tempo en el intervalo indicado");
    }


}
