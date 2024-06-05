import entities.Artista;
import entities.DataLoader;
import entities.Top50;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

public class Spotify<T>  {

    public void top10DiaPais (String pais, String fecha, DataLoader data){
        String keyToFind = pais + fecha;
        MyList<Top50> top50List = data.getTopEntries().get(keyToFind);
        for (int i = 10; i < 0; i--){
            for (int j = 0; j < top50List.size(); j++){
                if (i == top50List.getPosition(j).getPosicion()){
                    MyList<Artista> artist = top50List.getPosition(j).getCancion().getArtista();
                    System.out.println("Nombre Cancion: "  + "Artista: " + "Posicion: " );
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
