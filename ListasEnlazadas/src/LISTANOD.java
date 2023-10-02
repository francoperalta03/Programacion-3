// Importaciones necesarias
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Definición de la clase LISTANOD con un tipo genérico T que debe ser Comparable
public class LISTANOD<T extends Comparable<T>> {
    // ATRIBUTOS
    private Nodo<T> primero; // Primer nodo de la lista
    private Nodo<T> ultimo;  // Último nodo de la lista
    private int tamaño;      // Tamaño de la lista
    private Random rand = new Random(); // Generador de números aleatorios

    // Constructor
    public LISTANOD() {
        primero = null;
        ultimo = null;
        tamaño = 0;

        //-----------------------------METODOS PARA LA LISTA ALEATORIO ---------------------------------
        // Llenar la lista con 10 elementos enteros diferentes aleatorios
        for (int i = 0; i < 10; i++) {
            insertarAleatorio(); // Llama al método para insertar un elemento aleatorio
        }
    }

    // Método para generar un elemento aleatorio de tipo T (Comparable)
    public T generarElementoAleatorio1() {
        return (T) Integer.valueOf(rand.nextInt(100)); // Números enteros aleatorios entre 0 y 99
    }

    // Método para llenar la lista con elementos de una lista dada
    public void llenarConLista(List<T> elementos) {
        for (T elemento : elementos) {
            insertarAlFinal(elemento); // Llama al método para insertar un elemento al final de la lista
        }
    }

 // Método para verificar si la lista contiene un elemento dado
    public boolean contiene(T elemento) {
        Nodo<T> actual = primero; // Comenzamos desde el primer nodo
        while (actual != null) { // Mientras no lleguemos al final de la lista
            if (actual.getContenido().compareTo(elemento) == 0) { // Comparamos el contenido del nodo con el elemento dado
                return true; // Si encontramos el elemento, retornamos true
            }
            actual = actual.getSiguiente(); // Avanzamos al siguiente nodo
        }
        return false; // Si llegamos al final sin encontrar el elemento, retornamos false
    }

    // Método para verificar si la lista está vacía
    public boolean esVacia() {
        return primero == null; // La lista está vacía si el primer nodo es null
    }

    // Método para insertar un elemento aleatorio al final de la lista
    public void insertarAleatorio() {
        Integer elemento;
        do {
            elemento = (Integer) generarElementoAleatorio1(); // Genera un elemento aleatorio
        } while (contiene((T) elemento)); // Verifica si la lista ya contiene ese elemento

        insertarAlFinal((T) elemento); // Llama al método para insertar el elemento al final
    }

    
    // ----------------------------------- METODOS PRIMITIVOS ------------------------------------------

 // Método para insertar un elemento al principio de la lista
    public void insertarAlPrincipio(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento); // Crea un nuevo nodo con el elemento dado
        if (esVacia()) { // Si la lista está vacía
            primero = nuevoNodo; // Establece el nuevo nodo como el primero y el último
            ultimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primero); // Establece el siguiente del nuevo nodo como el antiguo primer nodo
            primero = nuevoNodo; // Actualiza el primer nodo de la lista
        }
        tamaño++; // Incrementa el tamaño de la lista
    }

    // Método para insertar un elemento al final de la lista
    public void insertarAlFinal(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento); // Crea un nuevo nodo con el elemento dado
        if (esVacia()) { // Si la lista está vacía
            primero = nuevoNodo; // Establece el nuevo nodo como el primero y el último
            ultimo = nuevoNodo;
        } else {
            Nodo<T> temp = ultimo; // Guarda una referencia al último nodo actual
            temp.setSiguiente(nuevoNodo); // Establece el siguiente del último nodo actual como el nuevo nodo
            ultimo = nuevoNodo; // Actualiza el último nodo de la lista
        }
        tamaño++; // Incrementa el tamaño de la lista
    }
    
    
    
     // Localiza la posición de un elemento en la lista y muestra todas las posiciones si el elemento está repetido.
    public void localizar(T elemento) {
        int posicion = 1; // Inicializa la posición en 1
        Nodo<T> current = primero; // Comienza desde el primer nodo
        boolean encontrado = false;

        try {
            if (!esVacia()) { // Si la lista no está vacía
                while (current != null) {
                    if (elemento.compareTo(current.getContenido()) == 0) { // Compara el elemento actual con el elemento dado
                        System.out.println("El elemento " + elemento + " se encuentra en la posición " + posicion);
                        encontrado = true;
                    }
                    current = current.getSiguiente(); // Avanza al siguiente nodo
                    posicion++; // Incrementa la posición
                }

                if (!encontrado) {
                    System.out.println("El elemento " + elemento + " no se encontró en la lista.");
                }

                System.out.println();
            } else {
                throw new Exception("La lista está vacía. No se pueden localizar elementos.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Manejo de excepciones
        }
    }

    
     // Elimina todos los elementos iguales al valor especificado de la lista.
    
    public void eliminar(int elementoEliminar) {
        if (esVacia()) {
            System.out.println("La lista está vacía. No se puede eliminar ningún elemento.");
            return;
        }

        Nodo<T> actual = primero;
        Nodo<T> anterior = null;
        int elementosEliminados = 0;

        while (actual != null) {
            if (actual.getContenido().equals(elementoEliminar)) {
                if (anterior == null) {
                    // Si el elemento a eliminar está en el primer nodo
                    primero = actual.getSiguiente();
                    actual = primero; // Avanza al siguiente nodo
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    actual = actual.getSiguiente(); // Avanza al siguiente nodo
                }
                tamaño--;
                elementosEliminados++;
            } else {
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }

        if (elementosEliminados > 0) {
            System.out.println("Se eliminaron " + elementosEliminados + " elementos iguales a " + elementoEliminar + " de la lista.");
        } else {
            System.out.println("No se encontraron elementos iguales a " + elementoEliminar + " en la lista.");
        }
    }



 // Método para insertar un elemento en una posición específica de la lista
    public void insertarEnPosicion(int posicion, T elemento) {
        if (posicion < 1 || posicion > tamaño + 1) { // Verifica si la posición es válida
            System.out.println("Posición inválida para insertar el elemento.");
            return;
        }

        Nodo<T> nuevoNodo = new Nodo<>(elemento); // Crea un nuevo nodo con el elemento dado

        if (posicion == 1) { // Si la posición es 1, inserta al principio de la lista
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
            tamaño++;
            System.out.println("Elemento " + elemento + " insertado en la posición " + posicion);
            return;
        }

        Nodo<T> anterior = primero;
        for (int i = 1; i < posicion - 1; i++) {
            anterior = anterior.getSiguiente(); // Avanza hasta el nodo anterior a la posición deseada
        }

        nuevoNodo.setSiguiente(anterior.getSiguiente()); // Establece el siguiente del nuevo nodo al siguiente del nodo anterior
        anterior.setSiguiente(nuevoNodo); // Establece el siguiente del nodo anterior al nuevo nodo
        tamaño++;
        System.out.println("Elemento " + elemento + " insertado en la posición " + posicion);
    }

    // Método para ordenar la lista en orden ascendente
    public void ordenar() {
        if (esVacia()) {
            System.out.println("La lista está vacía. No se puede ordenar.");
            return;
        }

        boolean intercambioRealizado;
        do {
            intercambioRealizado = false;
            Nodo<T> actual = primero;
            Nodo<T> anterior = null;

            while (actual != null && actual.getSiguiente() != null) {
                if (actual.getContenido().compareTo(actual.getSiguiente().getContenido()) > 0) { // Compara elementos adyacentes
                    Nodo<T> siguiente = actual.getSiguiente();
                    actual.setSiguiente(siguiente.getSiguiente());
                    siguiente.setSiguiente(actual);

                    if (anterior == null) {
                        primero = siguiente; // Si el intercambio involucra el primer nodo, actualiza el primero
                    } else {
                        anterior.setSiguiente(siguiente); // Actualiza el siguiente del nodo anterior al siguiente nodo
                    }

                    intercambioRealizado = true;
                }

                anterior = actual;
                actual = actual.getSiguiente();
            }
        } while (intercambioRealizado); // Repite el proceso hasta que no se realicen más intercambios
    }


 // Método para dividir la lista en dos sublistas en una posición dada
    public List<LISTANOD<T>> dividir(int posicion) {
        if (posicion < 1 || posicion > tamaño) { // Verifica si la posición es válida
            System.out.println("Posición inválida para dividir la lista.");
            return null; // Retorna null si la posición es inválida
        }

        int posicionActual = 1; // Inicializa una variable para rastrear la posición actual
        Nodo<T> actual = primero; // Comienza desde el primer nodo
        Nodo<T> anterior = null; // Inicializa el nodo anterior como null

        // Avanzar hasta la posición deseada
        while (posicionActual < posicion) {
            anterior = actual; // Avanza al siguiente nodo y actualiza el nodo anterior
            actual = actual.getSiguiente();
            posicionActual++; // Incrementa la posición actual
        }

        // Crear una copia de la primera lista desde el inicio hasta la posición especificada
        LISTANOD<T> primeraCopia = new LISTANOD<>();
        Nodo<T> copiaActual = primeraCopia.primero = copiarNodos(primero, actual); // Copia los nodos de la primera parte
        primeraCopia.ultimo = actual; // Establece el último nodo de la primera copia
        primeraCopia.tamaño = posicion - 1; // Actualiza el tamaño de la primera copia

        // Crear una copia de la segunda lista desde la posición especificada hasta el final
        LISTANOD<T> segundaCopia = new LISTANOD<>();
        copiaActual = segundaCopia.primero = copiarNodos(actual, null); // Copia los nodos de la segunda parte
        segundaCopia.ultimo = ultimo; // Establece el último nodo de la segunda copia
        segundaCopia.tamaño = tamaño - (posicion - 1); // Actualiza el tamaño de la segunda copia

        // Crear una lista que contenga las dos copias de las sublistas
        List<LISTANOD<T>> listas = new ArrayList<>();
        listas.add(primeraCopia); // Agrega la primera copia a la lista
        listas.add(segundaCopia); // Agrega la segunda copia a la lista

        return listas; // Retorna una lista con las dos sublistas
    }

    // Método auxiliar para copiar los nodos de una lista a otra
    private Nodo<T> copiarNodos(Nodo<T> inicio, Nodo<T> fin) {
        Nodo<T> copiaInicio = null;
        Nodo<T> copiaActual = null;
        Nodo<T> actual = inicio;

        while (actual != fin) {
            Nodo<T> copia = new Nodo<>(actual.getContenido()); // Crea una copia del nodo actual
            if (copiaInicio == null) {
                copiaInicio = copia; // Establece el inicio de la copia si es el primer nodo
                copiaActual = copiaInicio;
            } else {
                copiaActual.setSiguiente(copia); // Establece el siguiente de la copia anterior al nodo actual
                copiaActual = copia;
            }
            actual = actual.getSiguiente(); // Avanza al siguiente nodo en la lista original
        }

        return copiaInicio; // Retorna el inicio de la copia de la lista
    }

    // Método para mostrar todos los elementos de la lista
    public void mostrarElementos() {
        System.out.println("Elementos de la lista:");
        mostrarLista(primero); // Llama al método auxiliar para mostrar la lista desde el primer nodo
    }

    // Método auxiliar para mostrar los elementos de la lista a partir de un nodo dado
    private void mostrarLista(Nodo<T> nodo) {
        Nodo<T> actual = nodo;
        while (actual != null) {
            System.out.print(actual.getContenido() + " "); // Imprime el contenido del nodo
            actual = actual.getSiguiente(); // Avanza al siguiente nodo en la lista
        }
        System.out.println(); // Imprime una nueva línea al final
    }


    // ---------------------------------------------- MENU DE TRABAJO - NODOS -----------------------------------------------------
   
 // Método para iniciar un menú interactivo para trabajar con la lista
    public void menuTrabajo() {
        Scanner scanner = new Scanner(System.in); //se encarga de crear una instancia de la clase Scanner que se utilizará para leer la entrada del usuario desde la consola
        int opcion;

        do {
            System.out.println("Menú de Trabajo para LISTANOD:");
            System.out.println("1. Localizar un elemento");
            System.out.println("2. Insertar un elemento al principio");
            System.out.println("3. Insertar un elemento por POSICIÓN de nodo");
            System.out.println("4. Ordenar la lista");
            System.out.println("5. Dividir en sublistas");
            System.out.println("6. Comprobar si la lista está vacía");
            System.out.println("7. Mostrar elementos de la lista");
            System.out.println("8. Eliminar un elemento");
            System.out.println("0. Salir");

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt(); // Lee la opción ingresada por el usuario

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento que desea localizar: ");
                    Integer elementoLocalizar = scanner.nextInt(); // Asumiendo que se busca un Integer
                    localizar((T) elementoLocalizar); // Llama al método para localizar el elemento
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a insertar al principio: ");
                    Integer elementoInsertarPrincipio = scanner.nextInt(); // Asumiendo que se inserta un Integer
                    insertarAlPrincipio((T) elementoInsertarPrincipio); // Llama al método para insertar al principio
                    System.out.println();
                    System.out.println("Elemento insertado al principio correctamente!!");
                    System.out.println();
                    break;
               
                case 3:
                	 System.out.print("Ingrese la posición donde desea insertar el elemento: ");
                     int posicionInsertar = scanner.nextInt();
                     System.out.print("Ingrese el elemento a insertar: ");
                     Integer elementoInsertar = scanner.nextInt(); // Asumiendo que se inserta un Integer
                     insertarEnPosicion(posicionInsertar, (T) elementoInsertar); // Llama al método para insertar en una posición
                     System.out.println();
                   
                    break;
                case 4:
                    ordenar(); // Llama al método para ordenar la lista
                    System.out.println("Lista ordenada.");
                    System.out.println();
                    mostrarElementos(); // Muestra la lista ordenada
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Ingrese la posición en la cual desea dividir la lista: ");
                    int posicionDividir = scanner.nextInt();
                    List<LISTANOD<T>> listasDivididas = dividir(posicionDividir); // Llama al método para dividir la lista
                    if (listasDivididas != null) {
                        System.out.println("Primera lista (desde el inicio hasta la posición " + posicionDividir + "):");
                        listasDivididas.get(0).mostrarElementos(); // Muestra la primera sublista
                        System.out.println();
                        System.out.println("Segunda lista (desde la posición " + posicionDividir + " hasta el final):");
                        listasDivididas.get(1).mostrarElementos(); // Muestra la segunda sublista
                        System.out.println();
                    }
                    break;
                case 6:
                    if (esVacia()) {
                        System.out.println("La lista está vacía.");
                        System.out.println();
                    } else {
                        System.out.println("La lista no está vacía.");
                        System.out.println();
                    }
                    break;
                case 7:
                    mostrarElementos(); // Muestra todos los elementos de la lista
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Ingrese el elemento a eliminar (entero): ");
                    int elementoEliminar = scanner.nextInt(); // Lee un entero
                    System.out.println();
                    eliminar(elementoEliminar); // Llama al método para eliminar un elemento
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Saliendo del Menú de Trabajo.");
                    return; // Salir del menú
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0); // Continúa el bucle mientras la opción no sea 0

        scanner.close(); // Cierra el scanner al final del menú
    }
}