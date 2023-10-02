/**
 * Clase Nodo que representa un nodo genérico para una estructura de datos enlazada.
 * @param <T> El tipo de dato genérico que se almacena en el nodo.
 */
public class Nodo<T> {
    T dato;            // El dato almacenado en el nodo
    Nodo<T> siguiente; // Referencia al siguiente nodo en la estructura

    /**
     * Constructor que crea un nodo con el dato proporcionado.
     * @param dato El dato a almacenar en el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;     // Inicializa el dato con el valor proporcionado
        this.siguiente = null; // Inicializa la referencia al siguiente nodo como nula
    }
}

