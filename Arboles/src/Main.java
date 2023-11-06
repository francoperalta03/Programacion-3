//PRODUCTO SOFTWARE: ARBOL BINARIO
//Integrantes: SOSA, PERALTA Y SANABRIA
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = null;
    

 
        
        while (true) {
        	System.out.println();
        	System.out.println("--------------------------------------------");
            System.out.println("                  MENU");
            System.out.println("--------------------------------------------");
            System.out.println("1. Crear arbol");
            System.out.println("2. Destruir arbol por completo");
            System.out.println();
            System.out.println("               BUSQUEDA");
            System.out.println("3. Encontrar el padre de un nodo");
            System.out.println("4. Encontrar el hijo de la izquierda de un nodo");
            System.out.println("5. Encontrar el hijo de la derecha de un nodo");
            System.out.println("6. Mostrar la raiz del arbol");
            System.out.println();
            System.out.println("               INSERTAR ");
            System.out.println("7. Insertar hijo a la izquierda de un nodo");
            System.out.println("8. Insertar hijo a la derecha de un nodo");
            System.out.println();
            System.out.println("               ELIMINAR ");
            System.out.println("9. Podar hijo de la izquierda de un nodo");
            System.out.println("10. Podar hijo de la derecha de un nodo");
            System.out.println();
            System.out.println("               IMPRIMIR ");
            System.out.println("11. Imprimir árbol de manera tabulada");
            System.out.println("12. Imprimir el arbol INORDEN ");
            System.out.println("13. Imprimir el arbol POSTORDEN");
            System.out.println("14. Salir");
            System.out.print("Ingrese una opción: ");
            
            int opcion = scanner.nextInt();
            
            
          

            switch (opcion) {
                case 1:
                  	System.out.println();
                	System.out.println("RESPUESTA: ");
                    arbol = new ArbolBinario();
                    System.out.println("Arbol creado");
                    break;
                case 2:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    if (arbol != null) {
                        arbol.destruir();
                        arbol = null;
                        System.out.println("El árbol ha sido destruido.");
                    } else {
                        System.out.println("No hay un árbol para destruir.");
                    }
                    break;
                case 3:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    buscarPadre(arbol, scanner);
                    break;
                case 4:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    encontrarHijoIzquierdo(arbol, scanner);
                    break;
                case 5:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    encontrarHijoDerecho(arbol, scanner);
                    break;
                case 6:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    mostrarRaiz(arbol);
                    break;
                case 7:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    insertarHijoIzquierdo(arbol, scanner);
                    break;
                case 8:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    insertarHijoDerecho(arbol, scanner);
                    break;
                case 9:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    podarHijoIzquierdo(arbol, scanner);
                    break;
                case 10:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    podarHijoDerecho(arbol, scanner);
                    break;

                case 11:
                	System.out.println();
                	System.out.println("RESPUESTA: ");
                    System.out.println("Árbol:");
                    imprimirArbol(arbol.raiz(), 0);
                    break;

                 
                case 12:
                    System.out.println();
                    System.out.println("RESPUESTA: ");
                    if (arbol != null) {
                        arbol.imprimirInOrden();
                    } else {
                        System.out.println("No hay un árbol creado.");
                    }
                    break;

                case 13:
                    System.out.println();
                    System.out.println("RESPUESTA: ");
                    if (arbol != null) {
                        arbol.imprimirPostOrden();
                    } else {
                        System.out.println("No hay un árbol creado.");
                    }
                    break;


                    case 14:
                        System.out.println("FIN DEL PROGRAMA.");
                        return;
                    default:
                        System.out.println("RESPUESTA: ");
                        System.out.println("OPCIÓN INVÁLIDA.");
                        break;
                }

            }
        }
    
    
    //metodos para el menu
    private static void buscarPadre(ArbolBinario arbol, Scanner scanner) {
        if (arbol != null) {  // Comprueba si el árbol está creado
            System.out.print("Ingrese el contenido del nodo para buscar al padre: ");
            int contenidoNodoABuscarPadre = scanner.nextInt();  // Pide al usuario el contenido del nodo a buscar
            Nodo nodoABuscarPadre = arbol.obtenerNodoPorContenido(contenidoNodoABuscarPadre);  // Obtiene el nodo con el contenido especificado
            Nodo padre = arbol.padre(nodoABuscarPadre);  // Llama al método para encontrar el padre del nodo
            if (padre != null) {
                System.out.println("El padre de " + nodoABuscarPadre + " es " + padre);  // Si se encontró un padre, muestra el resultado
            } else {
                System.out.println("El nodo no tiene padre.");  // Si no se encontró un padre, muestra un mensaje de que el nodo no tiene padre
            }
        } else {
            System.out.println("No hay un árbol creado.");  // Si el árbol no está creado, muestra un mensaje de error
        }
    }


    private static void encontrarHijoIzquierdo(ArbolBinario arbol, Scanner scanner) {
        if (arbol != null) {  // Comprueba si el árbol está creado
            System.out.print("Ingrese el contenido del nodo para buscar al hijo de la izquierda: ");
            int contenidoNodoABuscarIzquierda = scanner.nextInt();  // Pide al usuario el contenido del nodo a buscar
            Nodo padreDelIzquierdo = arbol.obtenerNodoPorContenido(contenidoNodoABuscarIzquierda);  // Obtiene el nodo con el contenido especificado
            Nodo izquierdo = arbol.hijoIzquierdo(padreDelIzquierdo);  // Llama al método para encontrar el hijo izquierdo del nodo
            if (izquierdo != null) {
                System.out.println("El hijo izquierdo del nodo " + padreDelIzquierdo + " es " + izquierdo);  // Si se encontró un hijo izquierdo, muestra el resultado
            } else {
                System.out.println("El nodo no tiene hijo izquierdo.");  // Si no se encontró un hijo izquierdo, muestra un mensaje de que el nodo no tiene uno
            }
        } else {
            System.out.println("No hay un árbol creado.");  // Si el árbol no está creado, muestra un mensaje de error
        }
    }

    private static void encontrarHijoDerecho(ArbolBinario arbol, Scanner scanner) {
        if (arbol != null) {  // Comprueba si el árbol está creado
            System.out.print("Ingrese el contenido del nodo para buscar al hijo de la derecha: ");
            int contenidoNodoABuscarDerecha = scanner.nextInt();  // Pide al usuario el contenido del nodo a buscar
            Nodo padreDelDerecho = arbol.obtenerNodoPorContenido(contenidoNodoABuscarDerecha);  // Obtiene el nodo con el contenido especificado
            Nodo derecho = arbol.hijoDerecho(padreDelDerecho);  // Llama al método para encontrar el hijo derecho del nodo
            if (derecho != null) {
                System.out.println("El hijo derecho del nodo " + padreDelDerecho + " es " + derecho);  // Si se encontró un hijo derecho, muestra el resultado
            } else {
                System.out.println("El nodo no tiene hijo derecho.");  // Si no se encontró un hijo derecho, muestra un mensaje de que el nodo no tiene uno
            }
        } else {
            System.out.println("No hay un árbol creado.");  // Si el árbol no está creado, muestra un mensaje de error
        }
    }


    private static void mostrarRaiz(ArbolBinario arbol) {
        if (arbol != null) {  // Comprueba si el árbol está creado
            Nodo raiz = arbol.raiz();  // Obtiene el nodo raíz del árbol
            if (raiz != null) {
                System.out.println("La raíz del árbol es: " + raiz);  // Si se encontró un nodo raíz, muestra el resultado
            } else {
                System.out.println("El árbol está vacío.");  // Si el árbol no tiene un nodo raíz, muestra un mensaje de que el árbol está vacío
            }
        } else {
            System.out.println("No hay un árbol creado.");  // Si el árbol no está creado, muestra un mensaje de error
        }
    }


    private static void insertarHijoIzquierdo(ArbolBinario arbol, Scanner scanner) {
        if (arbol != null) {  // Comprueba si el árbol está creado
            if (arbol.raiz() == null) {  // Si el árbol está vacío (sin raíz)
                System.out.print("Ingrese el valor del primer nodo: ");
                int valorNodoAIzquierda = scanner.nextInt();
                Nodo nodoAIzquierda = new Nodo(valorNodoAIzquierda);
                arbol.insertarHijoIzquierdo(null, nodoAIzquierda);
                System.out.println("Primer nodo insertado. El nodo " + nodoAIzquierda + " es la raíz.");
            } else {
                System.out.print("Ingrese el contenido del nodo padre para agregar hijo a la izquierda: ");
                int contenidoPadreParaInsertarIzquierda = scanner.nextInt();
                Nodo padreParaInsertarIzquierda = arbol.obtenerNodoPorContenido(contenidoPadreParaInsertarIzquierda);
                if (padreParaInsertarIzquierda != null) {  // Comprueba si el padre existe
                    System.out.print("Ingrese el valor del nodo para agregar a la izquierda: ");
                    int valorNodoAIzquierda = scanner.nextInt();
                    Nodo nodoAIzquierda = new Nodo(valorNodoAIzquierda);
                    arbol.insertarHijoIzquierdo(padreParaInsertarIzquierda, nodoAIzquierda);
                    System.out.println("Nodo " + nodoAIzquierda + " insertado como hijo izquierdo de " + padreParaInsertarIzquierda);
                } else {
                    System.out.println("El padre no existe, no se puede insertar.");  // Mensaje de error si el padre no existe
                }
            }
        } else {
            System.out.println("No hay un árbol creado.");  // Mensaje de error si el árbol no está creado
        }
    }


    private static void insertarHijoDerecho(ArbolBinario arbol, Scanner scanner) {
        if (arbol != null) {  // Comprueba si el árbol está creado
            System.out.print("Ingrese el contenido del nodo padre para agregar hijo a la derecha: ");
            int contenidoPadreParaInsertarDerecha = scanner.nextInt();
            Nodo padreParaInsertarDerecha = arbol.obtenerNodoPorContenido(contenidoPadreParaInsertarDerecha);
            if (padreParaInsertarDerecha != null) {  // Comprueba si el padre existe
                System.out.print("Ingrese el valor del nodo para agregar a la derecha: ");
                int valorNodoADerecha = scanner.nextInt();
                Nodo nodoADerecha = new Nodo(valorNodoADerecha);

                if (padreParaInsertarDerecha.hijoIzquierdo() != null) {
                    arbol.insertarHijoDerecho(padreParaInsertarDerecha, nodoADerecha);
                    System.out.println("Nodo " + nodoADerecha + " insertado como hijo derecho de " + padreParaInsertarDerecha);
                } else {
                    System.out.println("No se puede insertar el hijo derecho. El nodo padre no tiene un hijo izquierdo.");
                }
            } else {
                System.out.println("El padre no existe, no se puede insertar.");  // Mensaje de error si el padre no existe
            }
        } else {
            System.out.println("No hay un árbol creado.");  // Mensaje de error si el árbol no está creado
        }
    }



    private static void podarHijoIzquierdo(ArbolBinario arbol, Scanner scanner) {
        if (arbol != null) {  // Comprueba si el árbol está creado
            System.out.print("Ingrese el contenido del nodo padre para podar hijo izquierdo: ");
            int contenidoPadreParaPodarIzquierda = scanner.nextInt();
            Nodo padreParaPodarIzquierda = arbol.obtenerNodoPorContenido(contenidoPadreParaPodarIzquierda);
            arbol.podarHijoIzquierdo(padreParaPodarIzquierda);  // Llama al método de la clase ArbolBinario para podar el hijo izquierdo
            System.out.println("Rama izquierda podada.");
        } else {
            System.out.println("No hay un árbol creado.");  // Mensaje de error si el árbol no está creado
        }
    }


    private static void podarHijoDerecho(ArbolBinario arbol, Scanner scanner) {
        if (arbol != null) {  // Comprueba si el árbol está creado
            System.out.print("Ingrese el contenido del nodo padre para podar hijo derecho: ");
            int contenidoPadreParaPodarDerecha = scanner.nextInt();
            Nodo padreParaPodarDerecha = arbol.obtenerNodoPorContenido(contenidoPadreParaPodarDerecha);
            arbol.podarHijoDerecho(padreParaPodarDerecha);  // Llama al método de la clase ArbolBinario para podar el hijo derecho
            System.out.println("Rama derecha podada.");
        } else {
            System.out.println("No hay un árbol creado.");  // Mensaje de error si el árbol no está creado
        }
    }

    private static void imprimirArbol(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirArbol(nodo.hijoIzquierdo(), nivel + 1); // Recorre el subárbol izquierdo primero
            for (int i = 0; i < nivel; i++) {
                System.out.print("   "); // Imprime espacios en blanco para la indentación
            }
            System.out.println(nodo.contenido()); // Imprime el contenido del nodo
            imprimirArbol(nodo.hijoDerecho(), nivel + 1); // Luego, recorre el subárbol derecho
        }
    }

    
}