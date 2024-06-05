import entities.Artista;
import entities.Cancion;
import entities.DataLoader;
import entities.Top50;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

public class Spotify<T>  {

    public static void top10DiaPais(String pais, String fecha, DataLoader data){
        String keyToFind = pais + fecha;
        MyList<Top50> top50List = data.getTopEntries().get(keyToFind);
        for (int i = 10; i < 0; i--){
            for (int j = 0; j < top50List.size(); j++){
                if (i == top50List.getPosition(j).getPosicion()){
                    MyList<Artista> artistas = top50List.getPosition(j).getCancion().getArtista();
                    String titulo= top50List.getPosition((j)).getCancion().getTitulo();

                    System.out.println("Nombre Cancion: "+ titulo + "Artista: "+ artistas + "Posicion: "+ j );
                }
            }
        }

    }

    public void printList (MyList<Artista> lista){
        for (int i = 0; i< lista.size(); i++){
            System.out.println(lista.getPosition(i));
        }
    }
}
