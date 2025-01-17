import entities.Artista;
import entities.Cancion;
import entities.DataLoader;
import entities.Top50;
import exceptions.DatoNoEXiste;
import exceptions.DatoInvalido;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;
import tad.heap.MyHeap;
import tad.heap.MyHeapImpl;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Spotify implements SpotifyIntf{

    @Override
    public void top10DiaPais(String pais, String fecha, DataLoader data) throws DatoInvalido, DatoNoEXiste {
        System.out.println("Procesando...");
        if (pais.isEmpty() || fecha.isEmpty()){
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
    @Override
    public void Top5canciones (String fecha, DataLoader data) throws DatoInvalido, DatoNoEXiste {
        System.out.println("Procesando...");
        if (fecha.isEmpty()){
            throw new DatoInvalido();
        }

        LocalDate date = null;
        try {
            date = LocalDate.parse(fecha);
        } catch (DateTimeParseException e){
            System.out.println("El formato de la fecha no es el correcto");
            e.getMessage();
            return;
        }

        if (!data.getTop50Fecha().contains(date)){
            throw new DatoNoEXiste();
        }

        MyHeap<Top50> cancionesFecha = data.getTop50Fecha().getValue(date).clone();
        for (int i = 0; i < 5 ; i++) {
            Top50 temp = cancionesFecha.delete();
            System.out.println(temp.getCancion().getTitulo());
        }

    }
    @Override
    public void Top7ArtistasEnRango (String fechaInicio, String fechaFin, DataLoader data) throws DatoInvalido {
        System.out.println("Procesando...");

        if (fechaInicio.isEmpty() || fechaFin.isEmpty()){
            throw new DatoInvalido();
        }

        LocalDate inicio;
        LocalDate fin;

        try{
            inicio = LocalDate.parse(fechaInicio);
            fin = LocalDate.parse(fechaFin);
        } catch (DateTimeParseException e){
            System.out.println("El formato de la fecha no es el correcto");
            return;
        }

        if (fin.isBefore(inicio)) {
            throw new DatoInvalido();
        }

        MyHeap<Artista> artistasExitosos = new MyHeapImpl<>(false);
        LocalDate currentDate = inicio;

        while (!currentDate.isAfter(fin)){
            MyHeap<Top50> cancionesFecha = data.getTop50Fecha().getValue(currentDate).clone();

            if (cancionesFecha != null){
                while (cancionesFecha.size() != 0){
                    Top50 tempVar = cancionesFecha.delete();
                    Cancion tempCancion = tempVar.getCancion();
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
            }
            currentDate = currentDate.plusDays(1);
        }
        System.out.println(artistasExitosos.size());
        if (artistasExitosos.size() == 0){
            System.out.println("No hay datos para el rango de fechas indicado");
        }

        for (int i = 0; i < 7; i++) {
            Artista temp = artistasExitosos.delete();
            System.out.println(temp.getNombre());
        }
    }

    @Override
    public void cantArtistaTop50 (String date, String pais, String artista, DataLoader data) throws DatoInvalido, DatoNoEXiste {
        System.out.println("Procesando...");
        if (date.isEmpty() || pais.isEmpty() || artista.isEmpty()){
            throw new DatoInvalido();
        }

        if (!data.getArtistHash().contains(artista)){
            throw new DatoNoEXiste();
        }

        int cantidad = 0;

        for (int i = 1; i <= 50; i++) {
            String k = String.valueOf(i);

            String key = pais + "|" + date + "|" + k;
            MyList<Artista> artistas;

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
        System.out.println("El artista " + artista + " aparece " + cantStr + " veces ");
    }

    @Override
    public void cancionesTempo (double tempoMax, double tempoMin, String fechaIni, String fechaFin, DataLoader data) throws DatoInvalido {
        System.out.println("Procesando...");

        if (tempoMax <= 0 || tempoMin <= 0 || fechaFin.isEmpty()|| fechaIni.isEmpty()) {
            throw new DatoInvalido();
        }

        LocalDate inicio = null;
        LocalDate fin = null;
        LocalDate currentDate = null;
        int cantCanciones = 0;

        try{
            inicio = LocalDate.parse(fechaIni);
            fin = LocalDate.parse(fechaFin);
            currentDate = inicio;
        } catch (DateTimeParseException e){
            System.out.println("El formato de la fecha no es el correcto");
            return;
        }


        if (fin.isBefore(inicio) || tempoMin > tempoMax) {
            throw new DatoInvalido();
        }


        while (!currentDate.isAfter(fin)) {

            MyHeap<Top50> cancionesFecha = data.getTop50Fecha().getValue(currentDate).clone();

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
