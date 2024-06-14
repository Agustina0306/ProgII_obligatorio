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

    public static void top10DiaPais(String pais, String fecha, DataLoader data) throws DatoInvalido, DatoNoEXiste {
        if (pais==null | fecha==null | data==null){
            throw new DatoInvalido();
        }
        if (!data.getTopEntries().contains(pais + "|"+ fecha + "|" + "1")){
            throw new DatoNoEXiste();
        }
        int i=10;
        while(i>0){

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

            System.out.println("Nombre Cancion: " + titulo + "Artista: "+ nombresArtistas + "Posicion: "+ j );
            i--;
        }

    }

    public static void Top5canciones (String fecha, DataLoader data) throws DatoInvalido {
        if (fecha == null){
            throw new DatoInvalido();
        }
        LocalDate date = LocalDate.parse(fecha);
        MyHeap<Top50> cancionesFecha = data.getTop50Fecha().getValue(date);
        for (int i = 0; i < 5 ; i++) {
            System.out.println(cancionesFecha.delete().getCancion().getTitulo());
        }

    }

    public static void Top7ArtistasEnRango (String fechaInicio, String fechaFin, DataLoader data){
        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);
        MyList<LocalDate> rangeDate = new MyLinkedListIml<>();
        LocalDate currentDate = inicio;

        MyHeap<Artista> artistasExitosos = new MyHeapImpl<>(false);

        while (!currentDate.isAfter(fin)){
            rangeDate.add(currentDate);
            currentDate.plusDays(1);
        }

        for (int i = 0; i < rangeDate.size(); i++) {
            MyHeap<Top50> cancionesFecha = data.getTop50Fecha().getValue(rangeDate.getPosition(i));
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
        }

        for (int i = 0; i < 7; i++) {
            System.out.println(artistasExitosos.delete().getNombre());
        }

    }


}
