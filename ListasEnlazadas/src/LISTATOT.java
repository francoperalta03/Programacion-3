import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

// La declaración de clase indica que cualquier tipo que se utilice como T
// debe ser capaz de compararse a sí mismo con otros objetos del mismo tipo
// para poder utilizar métodos de comparación como compareTo.
public class LISTATOT<T extends Comparable<T>>  {
    private LinkedList<T> lista; // Lista que almacena elementos de tipo T

    public LISTATOT() {
        lista = new LinkedList<>(); // Inicializar la lista vacía
    }

    //------------------------ LENA DE NUMEROS ALEATORIOS----------------------------
    public void llenarAleatoriamente() {
        // Crear un objeto Random para generar números aleatorios
        Random random = new Random();
        
        // Crear un conjunto para almacenar números únicos
        Set<Integer> numerosUnicos = new HashSet<>();

        // Usar un bucle while para generar valores únicos hasta que tengamos 10 de ellos
        while (numerosUnicos.size() < 10) {
            // Generar un número aleatorio entre 1 y 100 (inclusive)
            int valorAleatorio = random.nextInt(100) + 1;
            
            // Agregar el valor aleatorio al conjunto, automáticamente se eliminarán duplicados
            numerosUnicos.add(valorAleatorio);
        }

        // Agregar los 10 valores únicos al final de la lista original
        lista.addAll((Collection<T>) numerosUnicos);
    }

//------------------------------------------------METODOS-------------------------------------
    // Método para mostrar los elementos de la lista
    public void mostrarElementos() {
        System.out.println("Elementos de la lista:");
        for (T elemento : lista) {
            System.out.print(elemento + " "); // Imprimir cada elemento de la lista
        }
        System.out.println(); // Imprimir un salto de línea para separar la lista de la siguiente salida
    }

    // Método privado para buscar un elemento en la lista
    private void buscarElemento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el elemento a localizar: ");
        int elementoLocalizar = scanner.nextInt();
        boolean encontrado = false;

        for (T item : lista) {
            // Verificar si el elemento actual es un entero y si es igual al elemento a localizar
            if (item instanceof Integer && ((Integer) item).intValue() == elementoLocalizar) {
                System.out.println("Elemento encontrado: " + item); // Mostrar el elemento encontrado
                encontrado = true;
                break; // Salir del bucle una vez que se encuentre el elemento
            }
        }

        if (!encontrado) {
            System.out.println("Elemento no encontrado en la lista.");
        }
    }

 // Método para insertar un elemento en la lista sin que se repita
    private void insertarElemento() {
        Scanner scanner = new Scanner(System.in);

        // Bucle que se ejecuta continuamente hasta que se inserta un elemento único
        while (true) {
            System.out.print("Ingrese el elemento a insertar: ");
            try {
                Integer elementoInsertar = Integer.valueOf(scanner.next()); // Convertir la entrada a Integer

                // Verificar si el elemento ya está en la lista
                if (!lista.contains(elementoInsertar)) {
                    lista.add((T) elementoInsertar); // Convertir elementoInsertar a tipo T y agregarlo a la lista
                    System.out.println("Elemento insertado correctamente.");
                    break; // Salir del bucle si el elemento se inserta correctamente
                } else {
                    System.out.println("El elemento ya está en la lista.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
    }

    // Método para eliminar un elemento de la lista
    public void eliminar() {
        Scanner scanner = new Scanner(System.in);

        // Verificar si la lista está vacía
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.print("Ingrese el elemento a eliminar: ");
        try {
            int elementoEliminar = Integer.parseInt(scanner.next());

            int index = -1;
            // Buscar el índice del elemento en la lista
            for (int i = 0; i < lista.size(); i++) {
                T elementoLista = lista.get(i);
                if (elementoLista.equals(elementoEliminar)) {
                    index = i;
                    break;
                }
            }

            // Verificar si se encontró el elemento en la lista
            if (index != -1) {
                lista.remove(index);
                System.out.println("Elemento eliminado correctamente.");
            } else {
                System.out.println("El elemento no se encuentra en la lista.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido.");
        }
    }

    // Método para ordenar los elementos en la lista (Método de ordenamiento de burbuja)
    public void ordenar() {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Comparar dos elementos adyacentes y realizar un intercambio si es necesario
                if (((Comparable<T>) lista.get(j)).compareTo(lista.get(j + 1)) > 0) {
                    T temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }


 // Método para dividir la lista en sublistas de tamaño especificado
    public List<LISTATOT<T>> dividir(int tamañoSublista) {
        List<LISTATOT<T>> subListas = new ArrayList<>();
        int inicio = 0;

        // Dividir la lista en sublistas de tamaño especificado
        while (inicio < lista.size()) {
            int fin = Math.min(inicio + tamañoSublista, lista.size()); // Determinar el índice de fin de la sublista
            LISTATOT<T> subLista = new LISTATOT<>(); // Crear una nueva sublista
            subLista.lista.addAll(this.lista.subList(inicio, fin)); // Agregar elementos a la sublista desde la lista principal
            subListas.add(subLista); // Agregar la sublista a la lista de subListas
            inicio = fin; // Actualizar el índice de inicio para la próxima sublista
        }

        return subListas; // Devolver la lista de sublistas
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return lista.isEmpty(); // Devuelve verdadero si la lista está vacía, de lo contrario, falso
    }

    //----------------------------MENU DE TRABAJO --------------------------------------
 // Menú de Trabajo de LISTATOT
    public void menuTrabajo() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        T elementoLocalizar = null; // Variable para almacenar el elemento a localizar

        while (true) {
            // Mostrar el menú de opciones
            System.out.println("Menú de Trabajo para LISTATOT:");
            System.out.println("1. Localizar un elemento");
            System.out.println("2. Insertar un elemento");
            System.out.println("3. Eliminar un elemento");
            System.out.println("4. Ordenar la lista");
            System.out.println("5. Dividir en sublistas");
            System.out.println("6. Comprobar si la lista está vacía");
            System.out.println("7. Mostrar elementos de la lista");
            System.out.println("0. Salir");

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    buscarElemento(); // Llamar al método para buscar un elemento
                    System.out.println();
                    break;

                case 2:
                    insertarElemento(); // Llamar al método para insertar un elemento
                    System.out.println();
                    break;

                case 3:
                    eliminar(); // Llamar al método para eliminar un elemento
                    System.out.println();
                    break;

                case 4:
                    ordenar(); // Llamar al método para ordenar la lista
                    System.out.println("Lista ordenada de menor a mayor correctamente.");
                    System.out.println("lista ordenada: " + lista);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Ingrese el tamaño de las sublistas: ");
                    int tamañoSublista = scanner.nextInt();

                    List<LISTATOT<T>> sublistas = dividir(tamañoSublista); // Dividir la lista en sublistas

                    System.out.println("Sublistas creadas correctamente:");
                    for (int i = 0; i < sublistas.size(); i++) {
                        System.out.println("Sublista " + (i + 1) + ":");
                        sublistas.get(i).mostrarElementos(); // Mostrar elementos de las sublistas
                    }
                    break;

                case 6:
                    boolean vacia = estaVacia(); // Verificar si la lista está vacía
                    if (vacia) {
                        System.out.println("La lista está vacía.");
                        System.out.println();
                    } else {
                        System.out.println("La lista no está vacía.");
                        System.out.println();
                    }
                    break;

                case 7:
                    mostrarElementos(); // Llamar al método para mostrar elementos
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Saliendo del Menú de Trabajo.");
                    return; // Salir del bucle y del menú si se ingresa 0 (Salir)

            }
        }
    }
}