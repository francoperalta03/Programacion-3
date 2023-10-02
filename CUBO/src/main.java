import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario ingresar el número de filas, columnas y profundidad del cubo
        System.out.print("Ingrese el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = scanner.nextInt();
        System.out.print("Ingrese la profundidad: ");
        int profundidad = scanner.nextInt();

        // Crear un objeto Cubo utilizando los valores proporcionados por el usuario
        Cubo cubo = new Cubo(filas, columnas, profundidad);

        // Llenar el cubo con valores aleatorios entre 0 y 9
        cubo.llenarCuboAleatoriamente();

        // Imprimir el contenido actual del cubo
        cubo.imprimirCubo();

        int opcion;
        do {
            // Mostrar un menú interactivo para que el usuario elija una opción
            System.out.println("--- Menú del CUBO ---");
            System.out.println("1. Mostrar cubo");
            System.out.println("2. Verificar si la posición está vacía");
            System.out.println("3. Anular posición");
            System.out.println("4. Cargar valor al cubo");
            System.out.println("5. Modificar valores");
            System.out.println("6. Mostrar posiciones anuladas");
            System.out.println("7. Obtener valor en coordenada");
            System.out.println("8. Obtener sumatoria de los valores del cubo");
            System.out.println("9. Calcular Sumatoria Total de Profundidades");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

           //case para el menu

            switch (opcion) {
            case 1:
                // Opción 1: Mostrar el contenido actual del cubo
                cubo.imprimirCubo();
                break;
            case 2:
                // Opción 2: Verificar si la posición especificada está vacía
                System.out.print("Ingrese fila: ");
                int fila = scanner.nextInt();
                System.out.print("Ingrese columna: ");
                int columna = scanner.nextInt();
                System.out.print("Ingrese profundidad: ");
                int prof = scanner.nextInt();
                boolean vacia = cubo.esPosicionVacia(fila, columna, prof);
                // El resultado (si la posición está vacía o no) se almacena en 'vacia', pero falta una acción con ese resultado.
                break;
            case 3:
                // Opción 3: Anular (poner en 0) la posición especificada en el cubo
                System.out.print("Ingrese fila: ");
                int filaAnular = scanner.nextInt();
                System.out.print("Ingrese columna: ");
                int columnaAnular = scanner.nextInt();
                System.out.print("Ingrese profundidad: ");
                int profAnular = scanner.nextInt();
                cubo.anularPosicion(filaAnular, columnaAnular, profAnular);
                break;
            case 4:
                // Opción 4: Cargar un valor en la posición especificada del cubo
                System.out.print("Ingrese fila: ");
                int filaCargar = scanner.nextInt();
                System.out.print("Ingrese columna: ");
                int columnaCargar = scanner.nextInt();
                System.out.print("Ingrese profundidad: ");
                int profCargar = scanner.nextInt();
                System.out.print("Ingrese valor: ");
                int valor = scanner.nextInt();
                cubo.cargarValor(filaCargar, columnaCargar, profCargar, valor);
                break;
            case 5:
                // Opción 5: Modificar el valor en la posición especificada del cubo
                System.out.print("Ingrese fila: ");
                int filaModificar = scanner.nextInt();
                System.out.print("Ingrese columna: ");
                int columnaModificar = scanner.nextInt();
                System.out.print("Ingrese profundidad: ");
                int profModificar = scanner.nextInt();
                System.out.print("Ingrese nuevo valor: ");
                int valorModificar = scanner.nextInt();
                cubo.modificarValor(filaModificar, columnaModificar, profModificar, valorModificar);
                break;    
            case 6:
                // Opción 6: Mostrar las posiciones anuladas (con valor 0) en el cubo
                cubo.mostrarPosicionesAnuladas();
                break;
            case 7:
                // Opción 7: Obtener el valor en una coordenada especificada por el usuario
                cubo.obtenerValorEnCoordenada();
                break;
            case 8:
                // Opción 8: Calcular y mostrar la sumatoria de valores en cada profundidad
                cubo.sumatoria();
                break;
            case 9:
                // Opción 9: Calcular y mostrar la sumatoria total de todas las profundidades
                cubo.sumatoriaTotal();
                break;
            case 0:
                // Opción 0: Salir del programa
                System.out.println("Saliendo del programa.");
                break;
            default:
                // Opción por defecto: Mensaje de error para una opción no válida
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
        
    } while (opcion != 0);
}
}