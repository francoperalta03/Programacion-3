import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//Clase COLALKL que representa una cola genérica implementada con una LinkedList.
public class COLALKL<T> {
 private List<T> elementos; // Lista para almacenar los elementos de la cola

 // Constructor que inicializa la cola como una LinkedList vacía.
 public COLALKL() {
     elementos = new LinkedList<>();
 }

 // Agrega un elemento aleatorio (número entre 0 y 99) a la cola.
 public void agregarElementoAleatorio() {
     Random random = new Random();
     T elementoAleatorio = (T) Integer.valueOf(random.nextInt(100)); // Genera números aleatorios entre 0 y 99
     agregar(elementoAleatorio);
 }

 // Agrega un elemento a la cola.
 public void agregar(T elemento) {
     elementos.add(elemento);
 }

 // Desencola un elemento de la cola.
 // Devuelve el elemento desencolado o null si la cola está vacía.
 public T desencolar() {
     if (!isEmpty()) {
         return ((LinkedList<T>) elementos).poll(); // Utiliza el método poll() para desencolar
     } else {
         return null; // Devuelve null si la cola está vacía
     }
 }



 // Muestra los elementos de la cola.
 public void mostrarElementos() {
     System.out.print("Cola: ");
     for (T elemento : elementos) {
         System.out.print(elemento + " ");
     }
     System.out.println();
 }

 // Verifica si la cola contiene un elemento específico.
 public boolean contiene(T elemento) {
     return elementos.contains(elemento);
 }

 // Busca un elemento específico en la cola.
 public boolean buscar(T elemento) {
     return elementos.contains(elemento);
 }

 // Vacía la cola, eliminando todos los elementos.
 public void vaciar() {
     elementos.clear();
 }

 // Obtiene el número de elementos en la cola.
 public int size() {
     return elementos.size();
 }

 // Verifica si la cola está vacía.
 public boolean isEmpty() {
     return elementos.isEmpty();
 }
}

