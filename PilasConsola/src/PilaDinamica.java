//Importaciones Necesarias
import java.util.LinkedList;
import java.util.Random;

public class PilaDinamica {
    private LinkedList<Integer> pila; // Usamos LinkedList para almacenar los elementos de la pila, y decimos que deben de ser tipo INT
    private String nombrePila;
    private int capacidadMaxima; // Capacidad máxima de la pila 
    private int tamano; // Tamaño actual de la pila

    // Constructor de la clase PilaDinamica
    public PilaDinamica(String nombrePila, int tamanoInicial) {
        this.nombrePila = nombrePila;
        this.pila = new LinkedList<>();
        this.capacidadMaxima = 100; // Capacidad máxima fija en 100
        this.tamano = 0;
        
        // Llenar la pila con valores aleatorios iniciales si el tamaño inicial es válido
        if (tamanoInicial >= 0 && tamanoInicial <= capacidadMaxima) {
            Random random = new Random();
            for (int i = 0; i < tamanoInicial; i++) {
                int elementoAleatorio = random.nextInt(100); // Generar elemento aleatorio
                pila.push(elementoAleatorio); // Agregar elemento a la pila
                tamano++;
            }
        } else {
            System.out.println("Tamaño inicial no válido. Debe ser menor o igual a 100.");
        }
    }

    // Método para verificar si la pila está llena
    public boolean pilaLLena() {
        return tamano == capacidadMaxima;
    }

    // Método para apilar un elemento en la pila
    public void apilarElemento(int elemento) {
        if (!pilaLLena()) {
            if (!pila.contains(elemento)) { // Verificar si el elemento no está en la pila
                pila.push(elemento);
                tamano++;
                System.out.println("Elemento " + elemento + " apilado en la Pila Dinámica (" + nombrePila + ") con éxito.");
            } else {
                System.out.println("El elemento " + elemento + " ya está en la Pila Dinámica (" + nombrePila + "). No se puede repetir.");
            }
        } else {
            System.out.println("La Pila Dinámica (" + nombrePila + ") está llena. No se puede apilar más elementos.");
        }
    }

 // Método para desapilar (eliminar) un elemento de la pila
    public void desapilarElemento() {
        if (!pila.isEmpty()) { // Verifica si la pila no está vacía
            int elemento = pila.pop(); // Elimina el elemento en la cima de la pila y lo almacena en la variable 'elemento'
            tamano--; // Reduce el tamaño de la pila en 1
            System.out.println("Elemento " + elemento + " desapilado de la Pila Dinámica (" + nombrePila + ") con éxito.");
        } else {
            System.out.println("La Pila Dinámica (" + nombrePila + ") está vacía. No se puede desapilar.");
        }
    }


 // Método para obtener el elemento en el tope de la pila sin desapilarlo
    public int topePila() {
        if (!pila.isEmpty()) { // Verifica si la pila no está vacía
            return pila.peek(); // Devuelve el elemento en la cima de la pila sin eliminarlo
        } else {
            System.out.println("La Pila Dinámica (" + nombrePila + ") está vacía. No hay tope.");
            return -1; // Valor por defecto si la pila está vacía
        }
    }

 // Método para verificar si la pila está vacía
    public boolean pilaVacia() {
        return pila.isEmpty(); // Devuelve true si la pila está vacía, de lo contrario, devuelve false
    }


 // Método para mostrar todos los elementos de la pila
    public void mostrarElementos() {
        if (pila.isEmpty()) { // Verifica si la pila está vacía
            System.out.println("La Pila Dinámica está vacía.");
        } else {
            System.out.println("Elementos de la Pila Dinámica: ");
            for (int elemento : pila) {
                System.out.println(elemento); // Muestra cada elemento de la pila en una nueva línea
            }
        }
    }


 // Método para buscar un elemento en la pila
    public boolean buscarElemento(int elemento) {
        return pila.contains(elemento); // Utiliza el método 'contains' de la lista enlazada para verificar si el elemento está presente en la pila
    }
}
