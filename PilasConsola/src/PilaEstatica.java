import java.util.Random;

public class PilaEstatica {
    private int[] pila;           // Un arreglo de enteros para almacenar los elementos de la pila.
    private int tamano;           // El tamaño actual de la pila.
    private int tope;             // El índice del elemento en la cima de la pila.
    private int capacidadMaxima;  // La capacidad máxima de la pila.

    // Constructor de la clase PilaEstatica
    public PilaEstatica(int capacidadMaxima) {
        this.tamano = 0;
        this.pila = new int[capacidadMaxima]; // Inicializa el arreglo con la capacidad máxima.
        this.tope = -1; // Inicializa el tope en -1 para indicar que la pila está vacía.
        this.capacidadMaxima = capacidadMaxima;
    }

    // Método para llenar la pila con elementos aleatorios iniciales
    public void llenarAleatoriosIniciales(int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int elementoAleatorio = random.nextInt(100); // Generar elemento aleatorio
            apilarElemento(elementoAleatorio); // Apilar el elemento en la pila
        }
    }

    // Método privado para apilar un elemento en la pila
    private void apilarElemento1(int elementoAleatorio) {
        if (!pilaLLena()) { // Verifica si la pila no está llena
            pila[++tope] = elementoAleatorio; // Añade el elemento a la pila e incrementa el tope.
            tamano++; // Aumenta el tamaño de la pila.
        }
    }

    // Método para verificar si la pila está llena
    public boolean pilaLLena() {
        return tope == capacidadMaxima - 1; // Comprueba si el tope es igual a la capacidad máxima menos 1.
    }



 // Método para verificar si la pila está vacía
    public boolean pilaVacia() {
        return tope == -1; // Devuelve true si el tope es igual a -1 (indicando que la pila está vacía)
    }

    // Método para apilar un elemento en la pila
    public void apilarElemento(int elemento) {
        if (!pilaLLena()) { // Verifica si la pila no está llena
            if (!buscarElemento(elemento)) { // Verifica si el elemento no está en la pila
                pila[++tope] = elemento; // Añade el elemento a la pila e incrementa el tope.
                System.out.println("Elemento " + elemento + " apilado con éxito.");
            } else {
                System.out.println("El elemento " + elemento + " ya está en la Pila Estática.");
            }
        } else {
            System.out.println("La Pila Estática está llena. No se puede apilar más elementos.");
        }
    }

    // Método para desapilar (eliminar) un elemento de la pila
    public void desapilarElemento() {
        if (!pilaVacia()) { // Verifica si la pila no está vacía
            int elemento = pila[tope--]; // Obtiene el elemento en el tope y decrementa el tope
            System.out.println("Elemento " + elemento + " desapilado con éxito.");
        } else {
            System.out.println("La pila está vacía. No se puede desapilar.");
        }
    }



 // Método para obtener el elemento en el tope de la pila sin desapilarlo
    public int topePila() {
        if (pilaVacia()) { // Verifica si la pila está vacía
            System.out.println("La pila está vacía. No hay tope.");
            return -1; // Valor por defecto si la pila está vacía
        } else {
            return pila[tope]; // Devuelve el elemento en el tope de la pila sin desapilarlo
        }
    }

    // Método para buscar un elemento en la pila
    public boolean buscarElemento(int elemento) {
        for (int i = 0; i <= tope; i++) {
            if (pila[i] == elemento) {
                return true; // Elemento encontrado en la pila
            }
        }
        return false; // Elemento no encontrado en la pila
    }

    // Método para mostrar todos los elementos de la pila
    public void mostrarElementos() {
        if (pilaVacia()) { // Verifica si la pila está vacía
            System.out.println("La Pila Estática está vacía.");
        } else {
            System.out.println("Elementos de la Pila Estática: (DE ABAJO PARA ARRIBA)");
            for (int i = 0; i <= tope; i++) {
                System.out.println(pila[i]); // Muestra cada elemento de la pila de abajo hacia arriba
            }
        }
    }
}


