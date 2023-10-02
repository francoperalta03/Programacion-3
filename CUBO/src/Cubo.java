import java.util.Random;
import java.util.Scanner;

public class Cubo {
    // ATRIBUTOS
    private int[][][] datos; // Arreglo tridimensional para almacenar los datos del cubo.
    private int filas; // Número de filas del cubo.
    private int columnas; // Número de columnas del cubo.
    private int profundidad; // Número de capas de profundidad del cubo.

    // CONSTRUCTOR
    public Cubo(int filas, int columnas, int profundidad) {
        this.filas = filas;
        this.columnas = columnas;
        this.profundidad = profundidad;
        datos = new int[filas][columnas][profundidad]; // Inicializa el arreglo tridimensional con las dimensiones especificadas.

        // EXCEPCIÓN PARA VER Q EL NUMERO SEA MAYOR O IGUAL A 0
        if (filas <= 0 || columnas <= 0 || profundidad <= 0) {
            throw new IllegalArgumentException("Las dimensiones deben ser mayores que 0");
        }
    }

 // METODO PARA LLENAR EL CUBO ALEATORIAMENTE
    public void llenarCuboAleatoriamente() {
        // Crear una instancia de Random para generar números aleatorios
        Random rand = new Random();

        // Iterar a través de las filas del cubo
        for (int i = 0; i < filas; i++) {
            // Iterar a través de las columnas del cubo
            for (int j = 0; j < columnas; j++) {
                // Iterar a través de la profundidad del cubo
                for (int k = 0; k < profundidad; k++) {
                    // Generar un número aleatorio entre 0 y 9
                    int valorAleatorio = rand.nextInt(10);

                    // Asignar el valor aleatorio a la posición correspondiente del cubo
                    datos[i][j][k] = valorAleatorio;
                }
            }
        }
    }


 // Método para imprimir el cubo
    public void imprimirCubo() {
        // Iterar a través de los planos del cubo (profundidad)
        for (int k = 0; k < profundidad; k++) {
            System.out.println("Plano " + k + ":"); // Imprimir el número de plano
            // Iterar a través de las filas del cubo
            for (int i = 0; i < filas; i++) {
                // Iterar a través de las columnas del cubo
                for (int j = 0; j < columnas; j++) {
                    // Imprimir la posición y el valor del elemento en el plano actual
                    System.out.print("(" + i + "," + j + "," + k + "): " + datos[i][j][k] + " ");
                }
                System.out.println(); // Salto de línea para separar las filas
            }
            System.out.println(); // Salto de línea para separar los planos
        }
    }

	
 // Método para verificar si una posición en el cubo está vacía
    public boolean esPosicionVacia(int fila, int columna, int profundidad) {
        // Verificar si los índices de fila, columna y profundidad están dentro de los límites del cubo
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas && profundidad >= 0 && profundidad < this.profundidad) {
            // Comprobar si el valor en la posición especificada es igual a 0 (vacío)
            if (datos[fila][columna][profundidad] == 0) {
                System.out.println("La posición está vacía.");
                return true; // La posición está vacía, devuelve true
            } else {
                System.out.println("La posición no está vacía.");
                return false; // La posición no está vacía, devuelve false
            }
        } else {
            System.out.println("La posición está fuera de los límites del cubo.");
            return false; // La posición está fuera de los límites del cubo, devuelve false
        }
    }


 // 3. Método para anular (poner en 0) una posición en el cubo
    public void anularPosicion(int fila, int columna, int profundidad) {
        // Establece el valor en la posición dada como 0 (anulado)
        datos[fila][columna][profundidad] = 0;
        
        // Imprime un mensaje informando que la posición ha sido anulada
        System.out.println("Posición " + fila + ", " + columna + ", " + profundidad + " ha sido anulada.");
    }

    // 4. Método para cargar un valor en una posición del cubo
    public void cargarValor(int fila, int columna, int profundidad, int valor) {
        // Si el valor es 0, simplemente anula la posición en lugar de cargar el valor
        if (valor == 0) {
            anularPosicion(fila, columna, profundidad);
            return;
        }

        // Verifica si la posición está vacía antes de cargar el valor
        if (esPosicionVacia(fila, columna, profundidad)) {
            // Carga el valor en la posición especificada
            datos[fila][columna][profundidad] = valor;
            
            // Imprime un mensaje informando que el valor ha sido cargado en la posición
            System.out.println("El valor " + valor + " ha sido cargado en la posición: " + fila + ", " + columna + ", " + profundidad);
        } else {
            // Si la posición ya contiene un valor distinto de cero, muestra un mensaje indicando que la posición está ocupada
            // y sugiere utilizar la operación "Modificar" para cambiar el valor existente
            System.out.println("Posición ocupada. Utiliza la operación Modificar para cambiar el valor existente.");
        }
    }

		
 // 5. Método para modificar un valor en una posición del cubo
    public void modificarValor(int fila, int columna, int profundidad, int valor) {
        // Verifica si la posición no está vacía antes de modificar el valor
        if (!esPosicionVacia(fila, columna, profundidad)) {
            // Modifica el valor en la posición especificada
            datos[fila][columna][profundidad] = valor;
            
            // Imprime un mensaje informando que el valor en la posición ha sido modificado
            System.out.println("El valor en la posición " + fila + ", " + columna + ", " + profundidad + " ha sido modificado a: " + valor);
        } else {
            // Si la posición está vacía, muestra un mensaje indicando que se debe utilizar la operación "Cargar" en lugar de "Modificar"
            System.out.println("Posición vacía. Utiliza la operación Cargar para agregar un valor.");
        }
    }

    // 6. Método para mostrar por pantalla todas las posiciones que se encuentran anuladas
    public void mostrarPosicionesAnuladas() {
        System.out.println("Posiciones anuladas: ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < profundidad; k++) {
                    if (datos[i][j][k] == 0) {
                        // Imprime la posición que está anulada
                        System.out.println("(" + i + ", " + j + ", " + k + ")");
                    }
                }
            }
        }
    }

 // 7. Método para obtener el valor en una coordenada específica del cubo
    public int obtenerValorEnCoordenada() {
        Scanner scanner = new Scanner(System.in);

        int fila, columna, profundidad;
        do {
            // Solicita al usuario ingresar la fila, columna y profundidad
            System.out.print("Ingrese la fila: ");
            fila = scanner.nextInt();
            System.out.print("Ingrese la columna: ");
            columna = scanner.nextInt();
            System.out.print("Ingrese la profundidad: ");
            profundidad = scanner.nextInt();

            // Verifica si la coordenada ingresada es válida
            if (!esCoordenadaValida(fila, columna, profundidad)) {
                System.out.println("Coordenada no válida. Intente nuevamente.");
            }
        } while (!esCoordenadaValida(fila, columna, profundidad));

        // Obtiene el valor almacenado en la coordenada ingresada
        int valor = datos[fila][columna][profundidad];
        
        // Muestra el valor obtenido y lo retorna
        System.out.println("El valor en la coordenada (" + fila + "," + columna + "," + profundidad + ") es: " + valor);
        return valor;
    }


 // Método para verificar si una coordenada es válida dentro del cubo tridimensional
    public boolean esCoordenadaValida(int fila, int columna, int profundidad) {
        // Una coordenada es válida si todas sus componentes están dentro de los límites del cubo
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas && profundidad >= 0 && profundidad < this.profundidad;
    }

 // 8. Método para calcular la sumatoria por plano de profundidad
    public void sumatoria() {
        // Itera a través de cada plano de profundidad del cubo
        for (int profundidadActual = 0; profundidadActual < profundidad; profundidadActual++) {
            int sumatoria = 0; // Inicializa una variable para almacenar la sumatoria del plano actual
            
            // Itera a través de cada fila y columna en el plano de profundidad actual
            for (int fila = 0; fila < filas; fila++) {
                for (int columna = 0; columna < columnas; columna++) {
                    sumatoria += datos[fila][columna][profundidadActual]; // Suma el valor actual al acumulador
                }
            }
            
            // Imprime la sumatoria y el número del plano de profundidad actual
            System.out.println();
            System.out.println("SUMATORIA " + (profundidadActual + 1) + ": " + sumatoria);
            System.out.println();
        }
    }


 // Método para calcular la sumatoria total de todas las profundidades
    public void sumatoriaTotal() {
        int sumatoriaTotal = 0; // Inicializa una variable para almacenar la sumatoria total de todas las profundidades
        
        // Itera a través de cada plano de profundidad, fila y columna
        for (int profundidadActual = 0; profundidadActual < profundidad; profundidadActual++) {
            for (int fila = 0; fila < filas; fila++) {
                for (int columna = 0; columna < columnas; columna++) {
                    sumatoriaTotal += datos[fila][columna][profundidadActual]; // Suma el valor actual al acumulador
                }
            }
        }
        
        // Imprime la sumatoria total en la consola
        System.out.println("Sumatoria Total de todas las profundidades: " + sumatoriaTotal);
    }



}
		



