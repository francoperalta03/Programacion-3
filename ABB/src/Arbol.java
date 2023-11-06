public class Arbol {
    private Nodo raiz;

    // Constructor de la clase Arbol que crea un árbol con un nodo raíz que contiene un dato inicial.
    public Arbol(int dato) {
        raiz = new Nodo(dato);
    }

 // Método privado para agregar un nodo al árbol de manera recursiva.
    private Nodo agregarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            System.out.println("Agregando " + dato + " al árbol.");
            return new Nodo(dato);
        }

        if (dato < nodo.dato) {
            nodo.izquierda = agregarRecursivo(nodo.izquierda, dato);
        } else if (dato > nodo.dato) {
            nodo.derecha = agregarRecursivo(nodo.derecha, dato);
        } else {
            System.out.println(dato + " ya existe en el árbol. No se permiten duplicados.");
        }
        
        return nodo;
    }

    // Método público para agregar un nodo al árbol.
    public void agregar(int dato) {
        raiz = agregarRecursivo(raiz, dato);
        
    }



    // Método privado para recorrer el árbol en orden (inorden) de manera recursiva.
    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierda);
            System.out.print(nodo.dato + ", ");
            inordenRecursivo(nodo.derecha);
        }
    }

    // Método privado para recorrer el árbol en preorden de manera recursiva.
    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + ", ");
            preordenRecursivo(nodo.izquierda);
            preordenRecursivo(nodo.derecha);
        }
    }

    // Método privado para recorrer el árbol en postorden de manera recursiva.
    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierda);
            postordenRecursivo(nodo.derecha);
            System.out.print(nodo.dato + ", ");
        }
    }

    // Método privado para buscar un dato en el árbol de manera recursiva.
    private Nodo buscar(Nodo nodo, int busqueda) {
        if (nodo == null) {
            return null;
        }
        if (nodo.dato == busqueda) {
            return nodo;
        }
        if (busqueda < nodo.dato) {
            return buscar(nodo.izquierda, busqueda);
        } else {
            return buscar(nodo.derecha, busqueda);
        }
    }

  

    // Método público para imprimir el árbol en orden (inorden).
    public void inorden() {
        System.out.print("Imprimiendo árbol inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    // Método público para imprimir el árbol en preorden.
    public void preorden() {
        System.out.print("Imprimiendo árbol preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    // Método público para imprimir el árbol en postorden.
    public void postorden() {
        System.out.print("Imprimiendo árbol postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }

    // Método público para buscar un dato en el árbol.
    public Nodo buscar(int busqueda) {
        return buscar(raiz, busqueda);
    }
    
    // Método público para eliminar un nodo del árbol.
    public void eliminar(int dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    //metodo privado eliminar recursivo
    private Nodo eliminarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            return nodo;
        }

        if (dato < nodo.dato) {
            nodo.izquierda = eliminarRecursivo(nodo.izquierda, dato);
        } else if (dato > nodo.dato) {
            nodo.derecha = eliminarRecursivo(nodo.derecha, dato);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (nodo.izquierda == null && nodo.derecha == null) {
                return null;
            } else if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }

            // Nodo con dos hijos, obtener el sucesor inorden
            nodo.dato = encontrarMinimoValor(nodo.derecha);

            // Eliminar el sucesor inorden
            nodo.derecha = eliminarRecursivo(nodo.derecha, nodo.dato);
        }

        return nodo;
    }


    // Método privado para encontrar el valor mínimo en un subárbol.
    private int encontrarMinimoValor(Nodo nodo) {
        int minValor = nodo.dato;
        while (nodo.izquierda != null) {
            minValor = nodo.izquierda.dato;
            nodo = nodo.izquierda;
        }
        return minValor;
    }
}
