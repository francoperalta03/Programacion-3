import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arbol arbol = null;
        boolean creado = false;

        while (true) {
            System.out.println();
            System.out.println("---------------------------");
            System.out.println("MENÚ: ARBOL ABB");
            System.out.println("---------------------------");
            System.out.println("1. Crear Arbol");
            System.out.println("2. Agregar Hoja");
            System.out.println("3. Buscar elemento");
            System.out.println("4.Mostrar preorden");
            System.out.println("5. Mostrar inorden");
            System.out.println("6. Mostrar postorden");
            System.out.println("7. Eliminar elemento");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    if (!creado) {
                        System.out.print("Ingrese el valor de la raíz principal: ");
                        int numero = scanner.nextInt();
                        arbol = new Arbol(numero);
                        creado = true;
                        System.out.println("Arbol creado con exito!");
                    } else {
                        System.out.println("El árbol ya ha sido creado.");
                    }
                    break;
                case 2:
                    if (!creado) {
                        System.out.println("Primero crea el árbol.");
                    } else {
                        System.out.print("Ingrese el valor de la hoja a agregar: ");
                        int numero = scanner.nextInt();
                        arbol.agregar(numero);
                    }
                    break;
                case 3:
                    if (!creado) {
                        System.out.println("Primero crea el árbol.");
                    } else {
                        System.out.print("Ingresa un valor para buscar en el árbol: ");
                        int busqueda = scanner.nextInt();
                        Nodo nodo = arbol.buscar(busqueda);
                        if (nodo == null) {
                            System.out.println(busqueda + " no existe");
                        } else {
                            System.out.println(busqueda + " sí existe");
                        }
                    }
                    break;
                case 4:
                    if (!creado) {
                        System.out.println("Primero crea el árbol.");
                    } else {
                        System.out.println("Mostrando...");
                        arbol.preorden();
                    }
                    break;
                case 5:
                    if (!creado) {
                        System.out.println("Primero crea el árbol.");
                    } else {
                        System.out.println("Mostrando...");
                        arbol.inorden();
                    }
                    break;
                case 6:
                    if (!creado) {
                        System.out.println("Primero crea el árbol.");
                    } else {
                        System.out.println("Mostrando...");
                        arbol.postorden();
                    }
                    break;
                case 7:
                    if (!creado) {
                        System.out.println("Primero crea el árbol.");
                    } else {
                        System.out.print("Ingrese el valor del nodo a eliminar: ");
                        int valorAEliminar = scanner.nextInt();
                        Nodo nodoAEliminar = arbol.buscar(valorAEliminar);
                        
                        if (nodoAEliminar != null) {
                            arbol.eliminar(valorAEliminar);
                            System.out.println("Nodo eliminado.");
                        } else {
                            System.out.println("El nodo a eliminar no existe en el árbol. Por favor, ingrese un nodo válido.");
                        }
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
            scanner.nextLine(); // Consumir el salto de línea
        }
    }
}

