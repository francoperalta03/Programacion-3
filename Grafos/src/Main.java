//CONSIGNA
	/*
	 * CREACION DE GRAFO, CON NODOS, DIRECCION Y RELACIONES
	 * CREAR LA MATRIZ DE INCIDENCIA Y ADYACENCIA 
	 */

//INTEGRANTES: PERALTA, SOSA Y SANABRIA

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = null;

        while (true) {
            try {
                System.out.println("Menú:");
                System.out.println("1. Crear grafo");
                System.out.println("2. Ingresar nodo");
                System.out.println("3. Ingresar dirección");
                System.out.println("4. Imprimir matriz de adyacencia");
                System.out.println("5. Imprimir matriz de incidencia");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();  // Lee la opción seleccionada
                scanner.nextLine();  // Consume el salto de línea

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el número de nodos: ");
                        int numNodos = scanner.nextInt();  // Lee el número de nodos
                        grafo = new Grafo(numNodos);  // Crea un nuevo grafo con el número de nodos especificado
                        break;

                    case 2:
                        if (grafo == null) {
                            System.out.println("Primero debe crear el grafo.");
                            break;
                        }

                        // Verificar si ya se ingresaron todos los nodos
                        if (Arrays.asList(grafo.getNodos()).contains(null)) {
                            System.out.print("Ingrese nodo: ");
                            String nodo = scanner.next();  // Lee el nombre del nodo
                            int nodoIndex = Arrays.asList(grafo.getNodos()).indexOf(null);  // Encuentra el índice del primer nodo vacío
                            grafo.ingresarNodo(nodoIndex, nodo);  // Ingresa el nodo en el índice encontrado
                        } else {
                            System.out.println("Ya se han ingresado todos los nodos.");
                        }
                        break;

                    case 3:
                        if (grafo == null) {
                            System.out.println("Primero debe crear el grafo.");
                            break;
                        }
                        System.out.print("Desde nodo: ");
                        String desdeNodo = scanner.next();  // Lee el nodo de origen
                        System.out.print("Hacia nodo: ");
                        String haciaNodo = scanner.next();  // Lee el nodo de destino
                        scanner.nextLine();  // Agrega esta línea para consumir el salto de línea
                        System.out.print("Nombre de la relación: ");
                        String relacion = scanner.next();  // Lee el nombre de la relación
                        grafo.ingresarDireccion(desdeNodo, haciaNodo, relacion);  // Ingresa la dirección o relación
                        break;

                    case 4:
                        if (grafo == null) {
                            System.out.println("Primero debe crear el grafo.");
                            break;
                        }
                        grafo.imprimirMatrizAdyacencia();  // Imprime la matriz de adyacencia
                        break;
                    case 5:
                        if (grafo == null) {
                            System.out.println("Primero debe crear el grafo.");
                            break;
                        }
                        grafo.imprimirMatrizIncidencia();  // Imprime la matriz de incidencia
                        break;
                    case 6:
                        System.out.println("Saliendo del programa.");
                        scanner.close();
                        System.exit(0);  // Sale del programa
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
                scanner.nextLine();  // Limpiar el búfer de entrada en caso de entrada no válida
            }
        }
    }
}

