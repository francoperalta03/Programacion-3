import java.util.LinkedList;
import java.util.Queue;

class ArbolBinario {
    private Nodo raiz; // La raíz del árbol binario

    // Obtener la raíz del árbol
    public Nodo raiz() {
        return raiz;
    }

    // Destruir el árbol (haciendo que la raíz sea null)
    public void destruir() {
        raiz = null;
    }

    // Comprobar si el árbol está vacío
    public boolean esVacio() {
        return raiz == null;
    }

    // Encontrar el padre de un nodo en el árbol
    public Nodo padre(Nodo nodo) {
        return padre(raiz, nodo);
    }

    protected Nodo padre(Nodo subarbol, Nodo nodo) {
        if (subarbol == null || subarbol.esHoja()) {
            return null;
        }

        if ((subarbol.hijoIzquierdo() != null && subarbol.hijoIzquierdo().equals(nodo)) ||
            (subarbol.hijoDerecho() != null && subarbol.hijoDerecho().equals(nodo))) {
            return subarbol;
        }

        Nodo izquierdo = padre(subarbol.hijoIzquierdo(), nodo);
        if (izquierdo != null) {
            return izquierdo;
        }

        Nodo derecho = padre(subarbol.hijoDerecho(), nodo);
        return derecho;
    }

    // Obtener el hijo izquierdo de un nodo padre
    public Nodo hijoIzquierdo(Nodo padre) {
        return (padre != null) ? padre.hijoIzquierdo() : null;
    }

    // Obtener el hijo derecho de un nodo padre
    public Nodo hijoDerecho(Nodo padre) {
        return (padre != null) ? padre.hijoDerecho() : null;
    }

    // Insertar un nodo como hijo izquierdo de un nodo padre
    public void insertarHijoIzquierdo(Nodo padre, Nodo hijo) {
        if (padre == null) {
            if (raiz == null) {
                raiz = hijo; // Si no hay raíz, el hijo se convierte en la raíz.
            } else {
                System.out.println("La raíz ya tiene un hijo izquierdo.");
            }
        } else {
            padre.establecerHijoIzquierdo(hijo);
        }
    }

    // Insertar un nodo como hijo derecho de un nodo padre
    public void insertarHijoDerecho(Nodo padre, Nodo hijo) {
        if (padre != null) {
            if (padre.hijoIzquierdo() != null) {
                padre.establecerHijoDerecho(hijo);
            } else {
            	System.out.println();
            	System.out.println("RESPUESTA: ");
                System.out.println("No se puede insertar el hijo derecho. El nodo padre no tiene un hijo izquierdo.");
            }
        } else {
        	System.out.println();
        	System.out.println("RESPUESTA: ");
            System.out.println("No se puede insertar el hijo derecho. El nodo padre no existe.");
        }
    }

    // Podar el hijo izquierdo de un nodo padre
    public void podarHijoIzquierdo(Nodo padre) {
        if (padre != null) {
            padre.establecerHijoIzquierdo(null);
        }
    }

    // Podar el hijo derecho de un nodo padre
    public void podarHijoDerecho(Nodo padre) {
        if (padre != null) {
            padre.establecerHijoDerecho(null);
        }
    }

    // Obtener un nodo por su contenido (valor)
    public Nodo obtenerNodoPorContenido(int contenido) {
        return obtenerNodoPorContenido(raiz, contenido);
    }

    protected Nodo obtenerNodoPorContenido(Nodo subarbol, int contenido) {
        if (subarbol == null) {
            return null;
        }

        if (subarbol.contenido() == contenido) {
            return subarbol;
        }

        Nodo izquierdo = obtenerNodoPorContenido(subarbol.hijoIzquierdo(), contenido);
        if (izquierdo != null) {
            return izquierdo;
        }

        Nodo derecho = obtenerNodoPorContenido(subarbol.hijoDerecho(), contenido);
        return derecho;
    }

    // Representación en cadena del árbol
    @Override
    public String toString() {
        if (raiz != null) {
            StringBuilder sb = new StringBuilder();
            Queue<Nodo> queue = new LinkedList<>();
            queue.add(raiz);

            while (!queue.isEmpty()) {
                Nodo nodo = queue.poll();
                sb.append(nodo).append(" ");

                if (nodo.hijoIzquierdo() != null) {
                    queue.add(nodo.hijoIzquierdo());
                }
                if (nodo.hijoDerecho() != null) {
                    queue.add(nodo.hijoDerecho());
                }
            }

            return sb.toString();
        } else {
            return "Árbol vacío.";
        }
    }
 // Método para imprimir el árbol en inorden (izquierda - raíz - derecha)
    public void imprimirInOrden() {
        if (raiz != null) {
            System.out.print("In-Order (Izquierda - Raíz - Derecha): ");
            inordenRecursivo(raiz);
            System.out.println();
        } else {
            System.out.println("El árbol está vacío.");
        }
    }

    // Método auxiliar para imprimir en inorden de manera recursiva
    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.hijoIzquierdo());
            System.out.print(nodo.contenido() + " ");
            inordenRecursivo(nodo.hijoDerecho());
        }
    }

    // Método para imprimir el árbol en postorden (izquierda - derecha - raíz)
    public void imprimirPostOrden() {
        if (raiz != null) {
            System.out.print("Post-Order (Izquierda - Derecha - Raíz): ");
            postordenRecursivo(raiz);
            System.out.println();
        } else {
            System.out.println("El árbol está vacío.");
        }
    }

    // Método auxiliar para imprimir en postorden de manera recursiva
    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.hijoIzquierdo());
            postordenRecursivo(nodo.hijoDerecho());
            System.out.print(nodo.contenido() + " ");
        }
    }

}
