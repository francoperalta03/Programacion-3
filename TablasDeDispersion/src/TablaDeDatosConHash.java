
import javax.swing.table.DefaultTableModel;


public class TablaDeDatosConHash {
    private DefaultTableModel modelo;

    public TablaDeDatosConHash(DefaultTableModel modelo) {
        this.modelo = modelo;
        // Agregar las columnas adicionales entre "DNI" y "Apellidos"
        this.modelo.addColumn("AritmeticaModular");
        this.modelo.addColumn("Plegamiento");
        this.modelo.addColumn("MitadCuadrado");
        this.modelo.addColumn("Multiplicacion");
    }

    public void cargarTablaHash() {
        int rowCount = modelo.getRowCount();
        for (int i = 0; i < rowCount; i++) {
        	//convierto el dni en valor entero
            int dni = Integer.parseInt(modelo.getValueAt(i, 0).toString());
            String hashAritmeticaModular = Main.aritmeticaModular(dni, dni);
            String hashPlegamiento = Main.plegamiento(dni, dni);
            long dniLong = Long.parseLong(modelo.getValueAt(i, 0).toString());
            String hashMitadCuadrado = Main.mitadCuadrado(dniLong, dni);
            String hashMultiplicacion = Main.metodoDeLaMultiplicacion(dniLong, dni);

            // Inserta los valores calculados de hash como Strings en las columnas adecuadas del modelo.
            modelo.setValueAt(hashAritmeticaModular, i, 1); // Cambia 1 a la columna correcta para "AritmeticaModular"
            modelo.setValueAt(hashPlegamiento, i, 2); // Cambia 2 a la columna correcta para "Plegamiento"
            modelo.setValueAt(hashMitadCuadrado, i, 3); // Cambia 3 a la columna correcta para "MitadCuadrado"
            modelo.setValueAt(hashMultiplicacion, i, 4); // Cambia 4 a la columna correcta para "Multiplicacion"
        }
    }

    
}
