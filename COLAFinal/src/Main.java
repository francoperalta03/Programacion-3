import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        COLALKL<Integer> lista = new COLALKL<>(); // Crear una cola con una lista enlazada
        COLAND<Integer> cola = new COLAND<>();    // Crear una cola con nodos

        // Generar y agregar 10 números aleatorios a la lista y la cola
        generarNumerosAleatorios(lista, cola, 10);

        // -------------------------------------------------MENU PRINCIPAL -------------------------------------------------------
        while (true) {
            System.out.println("\nMenu Principal: Elegir con la opcion que desea trabajar");
            System.out.println("1. cola con LinkedList"); // Opción para trabajar con la cola basada en LinkedList
            System.out.println("2. Cola por nodos");      // Opción para trabajar con la cola basada en nodos
            System.out.println("3. Salir");               // Opción para salir del programa
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ListaMenu(lista, cola);  // Acceder al menú para la cola basada en LinkedList
                    break;
                case 2:
                    ColaMenu(cola);          // Acceder al menú para la cola basada en nodos
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);         // Salir del programa
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void generarNumerosAleatorios(COLALKL<Integer> lista, COLAND<Integer> cola, int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = random.nextInt(100); // Genera números aleatorios entre 0 y 99
            lista.agregar(numeroAleatorio); // Agrega el número aleatorio a la cola basada en LinkedList
            cola.encolar(numeroAleatorio); // Agrega el número aleatorio a la cola basada en nodos
        }
    }

    //----------------------------------------------MENU DE COLALKL.------------------------------------------------------------------
    public static void ListaMenu(COLALKL<Integer> lista, COLAND<Integer> cola) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu de Lista:");
            System.out.println("1. Encolar elemento"); // Opción para agregar un elemento a la cola basada en LinkedList
            System.out.println("2. Mostrar elementos"); // Opción para mostrar los elementos de la cola basada en LinkedList
            System.out.println("3. Mostrar tamaño de la cola por LinkedList"); // Opción para mostrar el tamaño de la cola basada en LinkedList
            System.out.println("4. Buscar elemento"); // Opción para buscar un elemento en la cola basada en LinkedList
            System.out.println("5. Desencolar elemento"); // Opción para desencolar un elemento de la cola basada en LinkedList
            System.out.println("6. Vaciar cola"); // Opción para vaciar la cola basada en LinkedList
            System.out.println("7. Volver al menú principal"); // Opción para volver al menú principal
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un elemento para agregar: ");
                    int elementoLista = scanner.nextInt();
                    if (!lista.contiene(elementoLista)) {
                        lista.agregar(elementoLista);
                        System.out.println("Elemento agregado correctamente a la lista.");
                    } else {
                        System.out.println("El elemento ya existe en la lista. Por favor, ingrese otro elemento.");
                    }
                    break;
                case 2:
                    lista.mostrarElementos(); // Muestra los elementos de la cola basada en LinkedList
                    break;
                case 3:
                    System.out.println("Tamaño de la lista: " + lista.size() + " elementos enteros");
                    break;
                case 4:
                    System.out.print("Ingrese un elemento para buscar: ");
                    int elementoBuscado = scanner.nextInt();
                    if (lista.buscar(elementoBuscado)) {
                        System.out.println("Elemento encontrado en la lista.");
                    } else {
                        System.out.println("Elemento no encontrado en la lista.");
                    }
                    break;
                case 5:
                    Integer elementoDesencolado = lista.desencolar();
                    if (elementoDesencolado != null) {
                        System.out.println("Elemento desencolado de la cola: " + elementoDesencolado);
                    } else {
                        System.out.println("La cola está vacía. No se pueden desencolar elementos.");
                    }
                    break;
                case 6:
                    lista.vaciar(); // Vacía la cola basada en LinkedList
                    System.out.println("Lista vaciada.");
                    break;
                case 7:
                    return; // Regresar al menú principal
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }


    //----------------------------------------------------MEUNU DE COLALAND --------------------------------------------
    public static void ColaMenu(COLAND<Integer> COLAND) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu de Cola:");
            System.out.println("1. Encolar elemento"); // Opción para encolar un elemento en la cola
            System.out.println("2. Desencolar elemento"); // Opción para desencolar un elemento de la cola
            System.out.println("3. Mostrar tamaño de la cola"); // Opción para mostrar el tamaño de la cola
            System.out.println("4. Mostrar elementos de la cola"); // Opción para mostrar los elementos de la cola
            System.out.println("5. Vaciar cola"); // Opción para vaciar la cola
            System.out.println("6. Volver al menú principal"); // Opción para volver al menú principal
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un elemento para encolar: ");
                    int elementoCola = scanner.nextInt();
                    if (!COLAND.contiene(elementoCola)) {
                        COLAND.encolar(elementoCola); // Encola un elemento en la cola basada en nodos
                        System.out.println("Elemento encolado correctamente en la cola.");
                    } else {
                        System.out.println("El elemento ya existe en la cola. Por favor, ingrese otro elemento.");
                    }
                    break;
                case 2:
                    Integer elementoDesencolar = COLAND.desencolar();
                    if (elementoDesencolar != null) {
                        System.out.println("Elemento desencolado: " + elementoDesencolar);
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;
                case 3:
                    System.out.println("Tamaño de la cola: " + COLAND.size() + " elementos enteros");
                    break;
                case 4:
                    COLAND.mostrarElementos(); // Muestra los elementos de la cola basada en nodos
                    break;
                case 5:
                    COLAND.vaciar(); // Vacia la cola basada en nodos
                    System.out.println("Cola vaciada.");
                    break;
                case 6:
                    return; // Regresar al menú principal
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}