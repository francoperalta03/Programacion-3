import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario.
        boolean salir = false; // Variable que controla la salida del bucle principal.
        PilaEstatica pilaEstatica = null; // Inicializa una PilaEstatica como nula al principio.
        PilaDinamica pilaDinamica = null; // Inicializa una PilaDinamica como nula al principio.

        while (!salir) { // Inicia un bucle que permite al usuario interactuar con el menú principal.
            System.out.println("\nMenú:"); // Muestra el menú principal.
            System.out.println("1. Pila Estática");
            System.out.println("2. Pila Dinámica");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt(); // Lee la opción seleccionada por el usuario.

            //---------------------------------------------------------------------------------------CASE MENU PRINCIPAL -----------------------------------------------------------------------
            switch (opcion) { // Evalúa la opción seleccionada por el usuario.

            case 1: // Si el usuario selecciona la opción 1 (Pila Estática):
                if (pilaEstatica == null) { // Verifica si la Pila Estática ya ha sido creada.
                    System.out.println("Ingrese el nombre de la Pila Estática: ");
                    String nombrePilaEstatica = scanner.next(); // Lee el nombre de la Pila Estática.

                    int tamanoInicial;
                    while (true) {
                        System.out.print("Ingrese el tamaño inicial de la Pila Estática (menor o igual a 100): ");
                        tamanoInicial = scanner.nextInt();

                        // Validar que el tamaño inicial sea válido (entre 0 y 100).
                        if (tamanoInicial >= 0 && tamanoInicial <= 100) {
                            break; // Sale del bucle si el valor es válido.
                        } else {
                            System.out.println("Tamaño inicial no válido. Debe ser menor o igual a 100.");
                        }
                    }

                    // Crea una instancia de PilaEstatica con capacidad máxima de 100 y la llena con elementos aleatorios iniciales.
                    pilaEstatica = new PilaEstatica(100);
                    pilaEstatica.llenarAleatoriosIniciales(tamanoInicial);
                    System.out.println("Pila Estática (" + nombrePilaEstatica + ") creada");
                }

                // Llama a la función menuPila para permitir al usuario interactuar con la Pila Estática.
                menuPila(pilaEstatica, "Pila Estática", scanner);
                break;

            case 2: // Si el usuario selecciona la opción 2 (Pila Dinámica):
                if (pilaDinamica == null) { // Verifica si la Pila Dinámica ya ha sido creada.
                    System.out.print("Ingrese el nombre de la Pila Dinámica: ");
                    String nombrePilaDinamica = scanner.next(); // Lee el nombre de la Pila Dinámica.

                    int tamanoInicial;
                    while (true) {
                        System.out.print("Ingrese el tamaño inicial de la Pila Dinámica (menor o igual a 100): ");
                        tamanoInicial = scanner.nextInt();

                        // Validar que el tamaño inicial sea válido (entre 0 y 100).
                        if (tamanoInicial >= 0 && tamanoInicial <= 100) {
                            break; // Sale del bucle si el valor es válido.
                        } else {
                            System.out.println("Tamaño inicial no válido. Debe ser menor o igual a 100.");
                        }
                    }

                    // Crea una instancia de PilaDinamica con nombre y tamaño inicial especificados.
                    pilaDinamica = new PilaDinamica(nombrePilaDinamica, tamanoInicial);
                    System.out.println("Pila Dinámica (" + nombrePilaDinamica + ") creada.");
                }

                // Llama a la función menuPila para permitir al usuario interactuar con la Pila Dinámica.
                menuPila(pilaDinamica, "Pila Dinámica", scanner);
                break;

            case 3: // Si el usuario selecciona la opción 3 (Salir):
                salir = true; // Establece la variable "salir" en "true" para salir del bucle principal.
                System.out.println("Saliendo del programa.");
                break;

            default: // Si el usuario selecciona una opción no válida:
                System.out.println("Opción no válida. Intente de nuevo.");
                break;
            }
        }
    }



//  //---------------------------------------------------------------------------------------MENU PILA ESTATICA-----------------------------------------------------------------------
	private static void menuPila(PilaEstatica pila, String nombrePila, Scanner scanner) {
		boolean salirMenuPila = false; // Variable que controla la salida del menú de la pila.

		while (!salirMenuPila) { // Inicia un bucle que permite al usuario interactuar con el menú de la pila.
	        System.out.println("\nMenú de " + nombrePila + ":"); // Muestra el menú de la pila.
	        System.out.println("1. Apilar Elemento");
	        System.out.println("2. Desapilar Elemento");
	        System.out.println("3. Tope de " + nombrePila);
	        System.out.println("4. Mostrar Elementos de " + nombrePila);
	        System.out.println("5. Buscar Elemento en " + nombrePila);
	        System.out.println("6. Verificar si " + nombrePila + " está vacía");
	        System.out.println("7. Volver al Menú Principal");
	        System.out.print("Seleccione una opción: ");

		        int opcionMenuPila = scanner.nextInt(); // Lee la opción seleccionada por el usuario.
		
		        switch (opcionMenuPila) { // Evalúa la opción seleccionada por el usuario.

		            case 1: // Si el usuario selecciona la opción 1 (Apilar Elemento):
		                System.out.print("Ingrese el elemento a apilar: ");
		                int elementoApilar = scanner.nextInt(); // Lee el elemento a apilar.
		                pila.apilarElemento(elementoApilar); // Llama al método apilarElemento de la pila.
		                break;
		
		            case 2: // Si el usuario selecciona la opción 2 (Desapilar Elemento):
		                pila.desapilarElemento(); // Llama al método desapilarElemento de la pila.
		                break;
		
		            case 3: // Si el usuario selecciona la opción 3 (Tope de la pila):
		                int topePila = pila.topePila(); // Obtiene el tope de la pila sin desapilarlo.
		                System.out.println("Tope de " + nombrePila + ": " + topePila);
		                break;
		
		            case 4: // Si el usuario selecciona la opción 4 (Mostrar Elementos):
		                pila.mostrarElementos(); // Llama al método mostrarElementos de la pila.
		                break;
		
		            case 5: // Si el usuario selecciona la opción 5 (Buscar Elemento):
		                System.out.print("Ingrese el elemento a buscar: ");
		                int elementoBuscar = scanner.nextInt(); // Lee el elemento a buscar.
		                boolean encontrado = pila.buscarElemento(elementoBuscar); // Llama al método buscarElemento de la pila.
		                if (encontrado) {
		                    System.out.println("El elemento " + elementoBuscar + " se encuentra en " + nombrePila + ".");
		                } else {
		                    System.out.println("El elemento " + elementoBuscar + " no se encuentra en " + nombrePila + ".");
		                }
		                break;
		
		            case 6: // Si el usuario selecciona la opción 6 (Verificar si la pila está vacía):
		                if (pila.pilaVacia()) {
		                    System.out.println(nombrePila + " está vacía.");
		                } else {
		                    System.out.println(nombrePila + " no está vacía.");
		                }
		                break;
		
		            case 7: // Si el usuario selecciona la opción 7 (Volver al Menú Principal):
		                salirMenuPila = true; // Sale del bucle del menú de la pila.
		                break;
		
		            default: // Si el usuario selecciona una opción no válida:
		                System.out.println("Opción no válida. Intente de nuevo.");
		                break;
        }
    }
}

    
    //  //---------------------------------------------------------------------------------------CASE MENU DINAMICA---------------------------------------------------------------------

	private static void menuPila(PilaDinamica pila, String nombrePila, Scanner scanner) {
	    boolean salirMenuPila = false; // Variable que controla la salida del menú de la pila.

	    while (!salirMenuPila) { // Inicia un bucle que permite al usuario interactuar con el menú de la pila.
	        System.out.println("\nMenú de " + nombrePila + ":"); // Muestra el menú de la pila.
	        System.out.println("1. Apilar Elemento");
	        System.out.println("2. Desapilar Elemento");
	        System.out.println("3. Tope de " + nombrePila);
	        System.out.println("4. Mostrar Elementos de " + nombrePila);
	        System.out.println("5. Buscar Elemento en " + nombrePila);
	        System.out.println("6. Verificar si " + nombrePila + " está vacía");
	        System.out.println("7. Volver al Menú Principal");
	        System.out.print("Seleccione una opción: ");

	        int opcionMenuPila = scanner.nextInt(); // Lee la opción seleccionada por el usuario.

	        switch (opcionMenuPila) { // Evalúa la opción seleccionada por el usuario.

	            case 1: // Si el usuario selecciona la opción 1 (Apilar Elemento):
	                System.out.print("Ingrese el elemento a apilar: ");
	                int elementoApilar = scanner.nextInt(); // Lee el elemento a apilar.
	                pila.apilarElemento(elementoApilar); // Llama al método apilarElemento de la pila.
	                break;

	            case 2: // Si el usuario selecciona la opción 2 (Desapilar Elemento):
	                pila.desapilarElemento(); // Llama al método desapilarElemento de la pila.
	                break;

	            case 3: // Si el usuario selecciona la opción 3 (Tope de la pila):
	                int topePila = pila.topePila(); // Obtiene el tope de la pila sin desapilarlo.
	                System.out.println("Tope de " + nombrePila + ": " + topePila);
	                break;

	            case 4: // Si el usuario selecciona la opción 4 (Mostrar Elementos):
	                pila.mostrarElementos(); // Llama al método mostrarElementos de la pila.
	                break;

	            case 5: // Si el usuario selecciona la opción 5 (Buscar Elemento):
	                System.out.print("Ingrese el elemento a buscar: ");
	                int elementoBuscar = scanner.nextInt(); // Lee el elemento a buscar.
	                boolean encontrado = pila.buscarElemento(elementoBuscar); // Llama al método buscarElemento de la pila.
	                if (encontrado) {
	                    System.out.println("El elemento " + elementoBuscar + " se encuentra en " + nombrePila + ".");
	                } else {
	                    System.out.println("El elemento " + elementoBuscar + " no se encuentra en " + nombrePila + ".");
	                }
	                break;

	            case 6: // Si el usuario selecciona la opción 6 (Verificar si la pila está vacía):
	                if (pila.pilaVacia()) {
	                    System.out.println(nombrePila + " está vacía.");
	                } else {
	                    System.out.println(nombrePila + " no está vacía.");
	                }
	                break;

	            case 7: // Si el usuario selecciona la opción 7 (Volver al Menú Principal):
	                salirMenuPila = true; // Sale del bucle del menú de la pila.
	                break;

	            default: // Si el usuario selecciona una opción no válida:
	                System.out.println("Opción no válida. Intente de nuevo.");
	                break;
	        }
	    }
	}

}
