import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grafo {
	    // Atributos e inicialización DE LAS MATRICES
	    private String[] nodos;                // Arreglo de nodos
	    private int[][] matrizAdyacencia;      // Matriz de adyacencia
	    public List<String> relaciones;        // Lista de relaciones
	    private String[][] matrizIncidencia;   // Matriz de incidencia

	    // Método constructor
	    public Grafo(int numNodos) {
	        nodos = new String[numNodos];        // Inicializa el arreglo de nodos con el número de nodos especificado
	        matrizAdyacencia = new int[numNodos][numNodos];  // Inicializa la matriz de adyacencia con el número de nodos
	        relaciones = new ArrayList<>();       // Inicializa la lista de relaciones
	        matrizIncidencia = new String[numNodos][0];  // Inicializa la matriz de incidencia con 0 columnas
	    }

	    // Método getter para obtener los nodos, utilizado en la clase principal (Main)
	    public String[] getNodos() {
	        return nodos;
	    }

	    // Método para ingresar un nodo al grafo
	    public void ingresarNodo(int indice, String nodo) {
	        nodos[indice] = nodo;  // Establece el nodo en la posición especificada del arreglo
	    }

	    // Método para ingresar una dirección o relación entre nodos
	    public void ingresarDireccion(String desdeNodo, String haciaNodo, String relacion) {
	        int desdeNodoIndex = Arrays.asList(nodos).indexOf(desdeNodo); // Obtiene el índice del nodo de origen
	        int haciaNodoIndex = Arrays.asList(nodos).indexOf(haciaNodo); // Obtiene el índice del nodo de destino

	        if (desdeNodoIndex != -1 && haciaNodoIndex != -1) {
	            // Verifica si la relación ya existe en la lista de relaciones
	            if (relaciones.contains(relacion)) {
	                System.out.println("Relación duplicada: " + relacion); // Muestra un mensaje de error si la relación ya existe
	                return; // No agrega la relación si ya existe
	            }
	            
	            // Verifica si existe una relación con el mismo orden de nodos
	            if (matrizAdyacencia[desdeNodoIndex][haciaNodoIndex] == 1 || matrizAdyacencia[haciaNodoIndex][desdeNodoIndex] == 1) {
	                System.out.println("Ya existe una relación entre " + desdeNodo + " y " + haciaNodo); // Muestra un mensaje de error si la relación ya existe con el mismo orden de nodos
	                return; // No agrega la relación si ya existe
	            }

	            matrizAdyacencia[desdeNodoIndex][haciaNodoIndex] = 1; // Establece la relación en la matriz de adyacencia
	            relaciones.add(relacion); // Agrega la relación a la lista de relaciones

	            // Ajusta la matriz de incidencia para tener tantas columnas como relaciones
	            matrizIncidencia = ajustarMatrizIncidencia();

	            int relacionIndex = relaciones.indexOf(relacion); // Obtiene el índice de la relación
	            matrizIncidencia[desdeNodoIndex][relacionIndex] = '+' + haciaNodo; // Establece el valor en la matriz de incidencia
	            matrizIncidencia[haciaNodoIndex][relacionIndex] = '-' + desdeNodo; // Establece el valor en la matriz de incidencia
	        } else {
	            System.out.println("Nodo no encontrado: " + desdeNodo + " o " + haciaNodo); // Muestra un mensaje de error si no se encuentran los nodos
	        }
	    }
	



	 // Ajusta la matriz de incidencia con las relaciones
	    private String[][] ajustarMatrizIncidencia() {
	        String[][] nuevaMatrizIncidencia = new String[nodos.length][relaciones.size()]; // Crea una nueva matriz de incidencia con el tamaño correcto
	        for (int i = 0; i < nodos.length; i++) { // Itera sobre los nodos
	            for (int j = 0; j < relaciones.size(); j++) { // Itera sobre las relaciones
	                if (j < matrizIncidencia[0].length) { // Comprueba si ya existe una columna para esta relación
	                    nuevaMatrizIncidencia[i][j] = matrizIncidencia[i][j]; // Copia el valor de la matriz de incidencia existente
	                } else {
	                    nuevaMatrizIncidencia[i][j] = "0"; // Si no existe una columna, se establece en "0"
	                }
	            }
	        }
	        return nuevaMatrizIncidencia; // Devuelve la matriz de incidencia ajustada
	    }

	    // Crea e imprime la matriz de adyacencia
	    public void imprimirMatrizAdyacencia() {
	        System.out.println("MATRIZ ADYACENCIA");
	        System.out.print("\t");
	        for (String nodo : nodos) { // Imprime los nodos como encabezados de columna
	            System.out.print(nodo + "\t");
	        }
	        System.out.println();

	        for (int i = 0; i < nodos.length; i++) {
	            System.out.print(nodos[i] + "\t"); // Imprime el nombre del nodo
	            for (int j = 0; j < nodos.length; j++) {
	                System.out.print(matrizAdyacencia[i][j] + "\t"); // Imprime los valores de la matriz de adyacencia
	            }
	            System.out.println();
	        }
	    }

	    // Crea e imprime la matriz de incidencia
	    public void imprimirMatrizIncidencia() {
	        System.out.println("MATRIZ DE INCIDENCIA");

	        // Imprimir las relaciones como encabezados de columna
	        System.out.print("\t");
	        for (String relacion : relaciones) {
	            System.out.print(relacion + "\t");
	        }
	        System.out.println();

	        for (int i = 0; i < nodos.length; i++) {
	            System.out.print(nodos[i] + "\t"); // Imprime el nombre del nodo
	            for (int j = 0; j < relaciones.size(); j++) {
	                String relacion = matrizIncidencia[i][j];
	                System.out.print((relacion != null) ? relacion : "0"); // Imprime los valores de la matriz de incidencia, reemplazando null con "0"
	                System.out.print("\t");
	            }
	            System.out.println();
	        }
	    }
}
