import java.util.Objects;

//<T extends Comparable<T>> es para permitir la comparación de los elementos almacenados en los nodos dentro de la lista enlazada. Esta restricción se basa en la interfaz Comparable.
class Nodo<T extends Comparable<T>> {
    private T contenido; // Contiene el valor almacenado en el nodo de la lista
    private Nodo<T> siguiente; // Referencia al siguiente nodo en la lista

    // Constructor de la clase Nodo
    public Nodo(T contenido) {
        this.contenido = contenido;
        this.siguiente = null; // Inicializa la referencia al siguiente nodo como nula
    }

    // Método para obtener el contenido del nodo
    public T getContenido() {
        return contenido;
    }

    // Método para obtener el siguiente nodo en la lista
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    // Método para establecer el siguiente nodo en la lista
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    // Método equals para comparar nodos por su contenido
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return Objects.equals(contenido, nodo.contenido);
    }

    // Método hashCode para generar un código hash basado en el contenido
    @Override
    public int hashCode() {
        return Objects.hash(contenido);
    }
}
