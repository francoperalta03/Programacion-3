import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int opcion;
  
        // Iniciar un bucle que se ejecutará continuamente hasta que el usuario decida salir
        while (true) {
            // Mostrar el menú principal
            System.out.println("Menú Principal:");
            System.out.println("1. Trabajar con LISTATOT");
            System.out.println("2. Trabajar con LISTANOD");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            
            // Leer la opción ingresada por el usuario
            opcion = scanner.nextInt();

            // Utilizar una estructura switch para determinar la acción según la opción elegida
            switch (opcion) {
                case 1:
                    // Crear una instancia de LISTATOT para trabajar con enteros
                    LISTATOT<Integer> listaTotInstance = new LISTATOT<>();
                    // Llenar listaTotInstance con elementos aleatorios
                    listaTotInstance.llenarAleatoriamente();
                    // Llamar al método menuTrabajo de listaTotInstance para interactuar con la lista
                    listaTotInstance.menuTrabajo();
                    break;
                case 2:
                    // Crear una instancia de LISTANOD para trabajar con cadenas (strings)
                    LISTANOD<String> listaNodInstance = new LISTANOD<>();
                    // Llamar al método menuTrabajo de listaNodInstance para interactuar con la lista
                    listaNodInstance.menuTrabajo();
                    break;
                case 0:
                    // Mostrar un mensaje de salida y salir del programa
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    // Mostrar un mensaje de error si la opción no es válida
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
