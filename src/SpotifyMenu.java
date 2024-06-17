
import java.util.InputMismatchException;
import java.util.Scanner;
import entities.DataLoader;
import exceptions.DatoNoEXiste;
import exceptions.DatoInvalido;

public class SpotifyMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws DatoInvalido, DatoNoEXiste {

        Spotify spotify = new Spotify();

        System.out.println("Ingrese el filePath del dataSet: ");
        String path = scanner.nextLine();
        DataLoader data = new DataLoader();
        boolean cargaDatos = data.loadData(path);

        while (!cargaDatos){
            System.out.println("No se pudo encontrar el filePath ingresado, ingreselo nuevamente: ");
            path = scanner.nextLine();
            data = new DataLoader();
            cargaDatos = data.loadData(path);
        }

        System.out.println("\n");

        int option = -1;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Top 10 canciones en un país en un día dado");
            System.out.println("2. Top 5 canciones en más top 50 en un día dado");
            System.out.println("3. Top 7 artistas en un rango de fechas");
            System.out.println("4. Cantidad de veces que aparece un artista en una fecha dada");
            System.out.println("5. Cantidad de canciones con un tempo en un rango específico de fechas");
            System.out.println("0. Salir");

            try{
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                case 1:
                    System.out.println("Ingrese el país:");
                    String pais = scanner.nextLine();
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    String fecha = scanner.nextLine();
                    spotify.top10DiaPais(pais, fecha, data);
                    break;
                case 2:
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    String date = scanner.nextLine();
                    spotify.Top5canciones(date, data);
                    break;
                case 3:
                    System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                    String startDate3 = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                    String endDate3 = scanner.nextLine();
                    spotify.Top7ArtistasEnRango(startDate3, endDate3, data);
                    break;
                case 4:
                    System.out.println("Ingrese el artista:");
                    String artist = scanner.nextLine();
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    String date4 = scanner.nextLine();
                    System.out.println("Ingrese un pais: ");
                    String pais4 = scanner.nextLine();
                    spotify.cantArtistaTop50(date4,  pais4, artist, data);
                    break;
                case 5:
                    System.out.println("Ingrese el tempo mínimo:");
                    double minTempo = scanner.nextDouble();
                    System.out.println("Ingrese el tempo máximo:");
                    double maxTempo = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                    String startDate5 = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
                    String endDate5 = scanner.nextLine();
                    spotify.cancionesTempo(maxTempo, minTempo, startDate5, endDate5, data);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
                }
            } catch (InputMismatchException e){
                System.out.println("Entrada no valida. Por favor ingrese uno de los numeros indicados en las opciones \n");
                scanner.nextLine();
            }

        } while (option != 0);

        scanner.close();

    }
}
