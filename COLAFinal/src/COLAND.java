import java.util.Random;

public class COLAND<T> {
    private Nodo<T> frente;
    private Nodo<T> finalCola;
    private int tamaño;

    // Constructor de la clase COLAND
    public COLAND() {
        frente = null;          // Inicializa el frente de la cola como nulo
        finalCola = null;       // Inicializa el final de la cola como nulo
        tamaño = 0;             // Inicializa el tamaño de la cola como 0
    }
    
    // Método para encolar un elemento aleatorio en la cola
    public void encolarElementoAleatorio() {
        Random random = new Random();                                       // Crear una instancia de Random para generar números aleatorios
        T elementoAleatorio = (T) Integer.valueOf(random.nextInt(100));     // Genera números aleatorios entre 0 y 99 y los convierte al tipo T
        encolar(elementoAleatorio);                                        // Llama al método encolar para agregar el elemento aleatorio a la cola
    }

    // Método para encolar un elemento en la cola
    public void encolar(T elemento) {
        if (!contiene(elemento)) {       // Verifica si el elemento no existe en la cola
            Nodo<T> nuevoNodo = new Nodo<>(elemento);  // Crea un nuevo nodo con el elemento dado
            if (finalCola == null) {       // Si la cola está vacía
                frente = nuevoNodo;         // El nuevo nodo se convierte en el frente y el final de la cola
                finalCola = nuevoNodo;
            } else {
                finalCola.siguiente = nuevoNodo;  // Agrega el nuevo nodo al final de la cola
                finalCola = nuevoNodo;            // Actualiza el final de la cola
            }
            tamaño++;                       // Incrementa el tamaño de la cola
        }
    }

 // Método para desencolar un elemento de la cola
    public T desencolar() {
        if (!isEmpty()) {                    // Verifica si la cola no está vacía
            T elemento = frente.dato;        // Obtiene el elemento en el frente de la cola
            frente = frente.siguiente;       // Avanza el frente al siguiente nodo
            tamaño--;                         // Reduce el tamaño de la cola
            return elemento;                 // Retorna el elemento desencolado
        }
        return null;                         // Retorna nulo si la cola está vacía
    }

    // Método para obtener el tamaño actual de la cola
    public int size() {
        return tamaño;                      // Retorna el tamaño de la cola
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return tamaño == 0;                 // Retorna verdadero si el tamaño es 0, lo que indica que la cola está vacía
    }

    // Método para mostrar todos los elementos en la cola
    public void mostrarElementos() {
        Nodo<T> actual = frente;            // Inicializa un nodo actual en el frente de la cola
        System.out.print("Elementos de la cola: ");
        while (actual != null) {            // Recorre la cola desde el frente hasta el final
            System.out.print(actual.dato + " ");  // Imprime cada elemento en la cola
            actual = actual.siguiente;       // Avanza al siguiente nodo en la cola
        }
        System.out.println();                // Imprime un salto de línea al final
    }


 // Método para vaciar completamente la cola
    public void vaciar() {
        frente = null;          // Establece el frente como nulo, lo que vacía la cola
        finalCola = null;       // Establece el finalCola como nulo
        tamaño = 0;             // Restablece el tamaño de la cola a 0
    }

    // Método para verificar si la cola contiene un elemento específico
    public boolean contiene(T elemento) {
        Nodo<T> actual = frente;  // Inicializa un nodo actual en el frente de la cola
        while (actual != null) {  // Recorre la cola desde el frente hasta el final
            if (actual.dato.equals(elemento)) {  // Compara el elemento actual con el elemento proporcionado
                return true;       // Retorna verdadero si encuentra una coincidencia
            }
            actual = actual.siguiente;  // Avanza al siguiente nodo en la cola
        }
        return false;              // Retorna falso si no encuentra el elemento en la cola
    }
}




