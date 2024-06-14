
import java.util.Scanner;
import entities.DataLoader;
import exceptions.DatoNoEXiste;
import tad.LinkedList.DatoInvalido;

public class SpotifyMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws DatoInvalido, DatoNoEXiste {

        System.out.println("Ingrese el filePath del dataSet: ");
        String path = scanner.nextLine();
        DataLoader data = new DataLoader();
        data.loadData(path);

        int option;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Top 10 canciones en un país en un día dado");
            System.out.println("2. Top 5 canciones en más top 50 en un día dado");
            System.out.println("3. Top 7 artistas en un rango de fechas");
            System.out.println("4. Cantidad de veces que aparece un artista en una fecha dada");
            System.out.println("5. Cantidad de canciones con un tempo en un rango específico de fechas");
            System.out.println("0. Salir");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el país:");
                    String pais = scanner.nextLine();
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    String fecha = scanner.nextLine();
                    Spotify.top10DiaPais(pais, fecha, data);
                    break;
                case 2:
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    String date = scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                    String startDate = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                    String endDate = scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Ingrese el artista:");
                    String artist = scanner.nextLine();
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    date = scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Ingrese el tempo mínimo:");
                    float minTempo = scanner.nextFloat();
                    System.out.println("Ingrese el tempo máximo:");
                    float maxTempo = scanner.nextFloat();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                    startDate = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                    endDate = scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (option != 0);

        scanner.close();
        //prueba
    }
}
