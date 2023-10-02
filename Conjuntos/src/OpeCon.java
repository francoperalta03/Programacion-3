import java.util.Scanner;

public class OpeCon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear instancias de Conjunto
        Conjunto C1 = new Conjunto(10); //MAXIMO DEL CONJUNTO 1= 10 ELEMENTOS
        Conjunto C2 = new Conjunto(8);//MAXIMO CONJUNTO 2= 8 ELEMENTOS
        
        int opcion;
        
        do {
            // Mostrar menú
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println();
            System.out.println();
            System.out.println("MENU CONJUNTO 1");
            System.out.println();
            System.out.println("1. Añadir elemento a C1");
            System.out.println("2. Eliminar elemento de C1");
            System.out.println("3. Verificar si C1 está vacío");
            System.out.println("4. Obtener número de elementos en C1");
            System.out.println("5. Mostrar elementos de C1");
            System.out.println("6. Verificar si un elemento existe en C1");
            System.out.println();
            System.out.println("MENU CONJUNTO 2");
            System.out.println();
            System.out.println("7. Añadir elemento a C2");
            System.out.println("8. Eliminar elemento de C2");
            System.out.println("9. Verificar si C2 está vacío");
            System.out.println("10. Obtener número de elementos en C2");
            System.out.println("11. Mostrar elementos de C2");
            System.out.println("12. Verificar si un elemento existe en C2");
            System.out.println("13. Comparar dato con conjuntos");
            System.out.println("14. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
            // Caso 1: Añadir un elemento a C1
            case 1:
                System.out.print("Ingrese elemento a añadir a C1: ");
                int elementoAñadirC1 = scanner.nextInt();
                C1.añadir(elementoAñadirC1);
                break;

            // Caso 2: Eliminar un elemento de C1
            case 2:
                System.out.print("Ingrese elemento a eliminar de C1: ");
                int elementoEliminarC1 = scanner.nextInt();
                C1.eliminar(elementoEliminarC1);
                break;

            // Caso 3: Verificar si C1 está vacío
            case 3:
                if (C1.esVacio()) {
                    System.out.println("C1 está vacío");
                } else {
                    System.out.println("C1 no está vacío");
                }
                break;

            // Caso 4: Obtener el número de elementos en C1
            case 4:
                System.out.println("Número de elementos en C1: " + C1.numeroElementos());
                break;

            // Caso 5: Mostrar elementos en C1
            case 5:
                System.out.print("Elementos en C1: ");
                C1.mostrarElementos();
                break;

            // Caso 6: Verificar si un elemento existe en C1
            case 6:
                System.out.print("Ingrese elemento a verificar en C1: ");
                int elementoVerificarC1 = scanner.nextInt();
                if (C1.existe(elementoVerificarC1)) {
                    System.out.println("El elemento " + elementoVerificarC1 + " existe en C1");
                } else {
                    System.out.println("El elemento " + elementoVerificarC1 + " no existe en C1");
                }
                break;
                
                case 7:
                    System.out.print("Ingrese elemento a añadir a C2: ");
                    int elementoAñadirC2 = scanner.nextInt();
                    C2.añadir(elementoAñadirC2);
                    break;
                case 8:
                    System.out.print("Ingrese elemento a eliminar de C2: ");
                    int elementoEliminarC2 = scanner.nextInt();
                    C2.eliminar(elementoEliminarC2);
                    break;
                case 9:
                    if (C2.esVacio()) {
                        System.out.println("C2 está vacío");
                    } else {
                        System.out.println("C2 no está vacío");
                    }
                    break;
                case 10:
                    System.out.println("Número de elementos en C2: " + C2.numeroElementos());
                    break;
                case 11:
                    System.out.print("Elementos en C2: ");
                    C2.mostrarElementos();
                    break;
                case 12:
                    System.out.print("Ingrese elemento a verificar en C2: ");
                    int elementoVerificarC2 = scanner.nextInt();
                    if (C2.existe(elementoVerificarC2)) {
                        System.out.println("El elemento " + elementoVerificarC2 + " existe en C2");
                    } else {
                        System.out.println("El elemento " + elementoVerificarC2 + " no existe en C2");
                    }
                    break;
                    // Caso 13: Comparar un dato con ambos conjuntos
                case 13:
                    System.out.print("Ingrese un dato para comparar con los conjuntos: ");
                    int datoComparar = scanner.nextInt();

                    boolean existeEnC1 = C1.existe(datoComparar);
                    boolean existeEnC2 = C2.existe(datoComparar);

                    if (existeEnC1 && existeEnC2) {
                        System.out.println("El dato " + datoComparar + " existe en ambos conjuntos.");
                    } else if (existeEnC1) {
                        System.out.println("El dato " + datoComparar + " existe en C1 pero no en C2.");
                    } else if (existeEnC2) {
                        System.out.println("El dato " + datoComparar + " existe en C2 pero no en C1.");
                    } else {
                        System.out.println("El dato " + datoComparar + " no existe en ninguno de los conjuntos.");
                    }
                    break;

                // Caso 14: Salir del programa
                case 14:
                    System.out.println("Saliendo del programa.");
                    break;

                // Default: Opción no válida
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            } while (opcion != 14);
        
        scanner.close();
    }
}

