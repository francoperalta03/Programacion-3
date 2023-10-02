public class Conjunto {
    // Atributos
    private int[] conjunto; // Un arreglo para almacenar los elementos del conjunto
    private int tamaño;     // El tamaño máximo del conjunto
    private int contador;   // La cantidad actual de elementos en el conjunto

    // Constructor
    public Conjunto(int N) {
        // El constructor recibe el tamaño máximo del conjunto como parámetro
        if (N <= 0) {
            System.out.println("(" + N + ") NO VALIDO");
        } else {
            conjunto = new int[N]; // Se crea un arreglo con el tamaño especificado
            tamaño = N;
            contador = 0; // El contador se inicializa a 0 ya que el conjunto está vacío
            System.out.println("CONJUNTO CREADO");
        }
    }

    // Método para añadir un elemento al conjunto
    public void añadir(int PE) { //PE= POSIBLE ELEMENTO
        if (contador == tamaño) {
            System.out.println("CONJUNTO LLENO");
            return;
        }

        for (int i = 0; i < contador; i++) {
            if (conjunto[i] == PE) {
                System.out.println("EL ELEMENTO (" + PE + ") YA EXISTE");
                return;
            }
        }

        conjunto[contador] = PE; // Se añade el elemento al conjunto
        contador++; // Se incrementa el contador de elementos
        System.out.println("ELEMENTO AÑADIDO");
    }


    // Eliminar un elemento del conjunto
    public void eliminar(int PE) {
        // Verificar si el conjunto está vacío
        if (contador == 0) {
            System.out.println("CONJUNTO VACÍO");
            return;
        }

        int indice = -1;
        // Buscar el índice del elemento a eliminar
        for (int i = 0; i < contador; i++) {
            if (conjunto[i] == PE) {
                indice = i;
                break;
            }
        }

        // Si el índice sigue siendo -1, significa que el elemento no existe en el conjunto
        if (indice == -1) {
            System.out.println("EL ELEMENTO (" + PE + ") NO EXISTE");
        } else {
            // Mover el último elemento del conjunto al lugar del elemento eliminado
            conjunto[indice] = conjunto[contador - 1];
            contador--;
            System.out.println("ELEMENTO ELIMINADO");
        }
    }


    // Verificar si el conjunto está vacío
    public boolean esVacio() {
        return contador == 0;
    }

    // Obtener el número de elementos en el conjunto
    public int numeroElementos() {
        return contador;
    }

    // Mostrar todos los elementos del conjunto
    public void mostrarElementos() {
        if (contador == 0) {
            System.out.println("CONJUNTO VACÍO");
            return;
        }

        System.out.print("ELEMENTOS: ");
        for (int i = 0; i < contador; i++) {
            System.out.print(conjunto[i] + " ");
        }
        System.out.println();
    }

    // Verificar si un elemento existe en el conjunto
    public boolean existe(int PE) {
        for (int i = 0; i < contador; i++) {
            if (conjunto[i] == PE) {
                return true;
            }
        }
        return false;
    }
}
