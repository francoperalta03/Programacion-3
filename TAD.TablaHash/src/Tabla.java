public class Tabla {
    // ATRIBUTOS
    private Elemento tabla[];
    private int size;

    // CONSTRUCTOR
    public Tabla(int size) {
        this.size = size;  // Asigna el tamaño de la tabla
        this.tabla = new Elemento[size];  // Inicializa el array de elementos
        for (int i = 0; i < size; i++) {
            this.tabla[i] = null;  // Inicializa todas las posiciones de la tabla como nulas
        }
    }

    // HASH GENERADOR DE POSICION
    public int hash(Elemento e) {
        int clave = e.getDni();  // Obtiene el DNI como clave
        return clave % size;  // Calcula la posición usando el módulo
    }


    // METODOS
    public void insertar(Elemento e, int posicion) {
        // SI NO HAY NADA EN ESA POSICIÓN, AGREGAR EL ELEMENTO AHÍ
        if (tabla[posicion] == null) {
            tabla[posicion] = e;
        } else {
            // ENCONTRAR NUEVA POSICIÓN Y GUARDAR EN ESA POSICIÓN
            int nuevaPosicion = encontrarNuevaPosicion(posicion);
            if (nuevaPosicion != -1) {
                tabla[nuevaPosicion] = e;
            } else {
                // ASIGNAR EN LA POSICIÓN PASADA POR PARÁMETRO EL PUNTERO AL NUEVO ELEMENTO Y TRATARLO COMO NODO
                Elemento actual = tabla[posicion];
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(e);
            }
        }
    }
    public int encontrarNuevaPosicion(int posicion) {
        // RECORRER LA LISTA BUSCANDO POSICION VACIA
        for (int i = 0; i < size; i++) {
            int nuevaPosicion = (posicion + i) % size;
            if (tabla[nuevaPosicion] == null) {
                return nuevaPosicion;
            }
        }
        return -1; // DEVOLVER -1 SI NO ENCONTRO NINGUNA POSICION VACIA
    }

    public boolean eliminar(int clave) {
        try {
            if (clave < 0) {
                throw new Exception("EL DNI NO PUEDE SER NEGATIVO");
            }
            // ELEMENTO EN PRIMER NIVEL DE TABLA
            for (int i = 0; i < tabla.length; i++) {
                // TRACKERS
                Elemento actual = tabla[i];
                Elemento anterior = null;
                while (actual != null) {
                    if (actual.getDni() == clave) {
                        if (anterior != null) {
                            // ELIMINAR EL NODO
                            anterior.setSiguiente(actual.getSiguiente());
                        } else {
                            tabla[i] = actual.getSiguiente();
                        }
                        return true;
                    }
                    // ACTUALIZAR PARA SIGUIENTE VUELTA
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int buscar(int clave){
        try{
            if(clave < 0){
                throw new Exception("EL DNI NO PUEDE SER NEGATIVO");
            }
            // ELEMENTO EN PRIMER NIVEL DE TABLA
            for (int i = 0; i < tabla.length; i++) {
                Elemento actual = tabla[i];
                while (actual != null) {
                    if (actual.getDni() == clave) {
                        if(actual == tabla[i]){
                            System.out.println("EL ELEMENTO SE ENCUENTRA EN EL PRIMER NIVEL DE LA TABLA");
                        } else {
                            System.out.println("EL ELEMENTO SE ENCUENTRA EN UN NODO");
                        }
                        // DEVOLVER LA POSICION DONDE SE ENCUENTRA
                        return i;
                    }
                    actual = actual.getSiguiente();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    // TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ");
            if (tabla[i] != null) {
                sb.append(tabla[i].toString());  // Agrega la representación del elemento en esa posición
            } else {
                sb.append("VACÍO");
            }
            sb.append("\n");
        }
        return sb.toString();  // Devuelve la representación de la tabla en forma de cadena
    }
}