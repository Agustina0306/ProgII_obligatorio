import entities.Artista;
import entities.Cancion;
import entities.DataLoader;
import entities.Top50;
import exceptions.DatoNoEXiste;
import tad.LinkedList.DatoInvalido;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

public class Spotify<T>  {

    public static void top10DiaPais(String pais, String fecha, DataLoader data) throws DatoInvalido, DatoNoEXiste {
        if (pais==null | fecha==null | data==null){
            throw new DatoInvalido();
        }
        if (!data.getTopEntries().contains(pais + "|"+ fecha + "|" + "1")){
            throw new DatoNoEXiste();
        }
        int i=10;
        while(i>0){
            i--;
            String j= String.valueOf(i);
            String key = pais + "|"+ fecha + "|" + j;
            MyList<Artista> artistas = data.getTopEntries().getValue(key).getCancion().getArtista();
            String titulo= data.getTopEntries().getValue(key).getCancion().getTitulo();
            String nombresArtistas= null;
            for (int k = 0; k < artistas.size(); k++) {
                nombresArtistas +=artistas.getPosition(k);
                nombresArtistas+= " | ";
            }

            System.out.println("Nombre Cancion: "+ titulo + "Artista: "+ nombresArtistas + "Posicion: "+ j );
        }

    }


}
