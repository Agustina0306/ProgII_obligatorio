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

    public void Top5canciones (String fecha, DataLoader data) throws DatoInvalido {
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

        if (fechaInicio == null || fechaFin == null || data == null){
            throw new DatoInvalido();
        }
        // VERIFICAR FECHA INICIO > FECHA FIN

        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);
        LocalDate currentDate = inicio;

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
        if (date == null || pais == null){
            throw new DatoInvalido();
        }
        int cantidad = 0;

        for (int i = 0; i < data.getTopEntries().size(); i++) {
            String key = pais + "|" + date + "|" + i;

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




}
