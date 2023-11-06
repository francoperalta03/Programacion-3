import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Crear una ventana principal.
        JFrame frame = new JFrame("Tablas de Datos");
        JPanel panel = new JPanel(new BorderLayout());

        // Crear un modelo de tabla con nombres de columnas.
        DefaultTableModel modeloOriginal = new DefaultTableModel(
                new String[]{"DNI", "Apellidos", "Nombres", "Email", "Celular", "Dirección"}, 0);

        // Crear una tabla con el modelo de tabla.
        JTable tablaOriginal = new JTable(modeloOriginal);

        // Crear un array de campos de texto para ingresar datos.
        JTextField[] camposTexto = new JTextField[6];

        // Crear un panel para ingresar datos con una cuadrícula de 7 filas y 2 columnas.
        JPanel panelDatos = new JPanel(new GridLayout(7, 2));

        // Agregar etiquetas y campos de texto para cada columna en la tabla.
        for (int i = 0; i < camposTexto.length; i++) {
            panelDatos.add(new JLabel(tablaOriginal.getColumnName(i) + ":"));
            camposTexto[i] = new JTextField();
            panelDatos.add(camposTexto[i]);
        }

        // Crear un botón "Guardar" y agregar un ActionListener para guardar datos en la tabla.
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos de los campos de texto y agregarlos como una fila en la tabla.
                Object[] fila = new Object[6];
                for (int i = 0; i < camposTexto.length; i++) {
                    fila[i] = camposTexto[i].getText();
                    camposTexto[i].setText(""); // Limpiar los campos de texto.
                }
                modeloOriginal.addRow(fila); // Agregar la fila al modelo de tabla.
                // Mostrar un mensaje de confirmación.
                JOptionPane.showMessageDialog(frame, "Registro cargado correctamente", "Registro Cargado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Agregar el botón "Guardar" al panel de datos.
        panelDatos.add(botonGuardar);

        // Agregar el panel de datos en la parte superior del panel principal.
        panel.add(panelDatos, BorderLayout.NORTH);

        // Configurar el comportamiento de cierre de la ventana.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar el panel principal a la ventana.
        frame.add(panel);

        // Ajustar el tamaño de la ventana según su contenido.
        frame.pack();

        // Hacer visible la ventana.
        frame.setVisible(true);

        // Agregar datos de ejemplo a la tabla original.
        // (Esto se agrega a la tabla antes de que se muestre la ventana).
        Object[] fila1 = {"45201617", "Peralta", "Franco", "franco.peralta617@comunidad.ub.edu.ar", "11 2648 5657", "Corrientes 336, Martinez"};
        modeloOriginal.addRow(fila1);

        Object[] fila2 = {"44452040", "Sanabria", "Ramiro", "ramiro.sanabria@comunidad.ub.edu.ar", "11 3019 0902", "virrey olaguer y feliu 3340 CABA"};
        modeloOriginal.addRow(fila2);

        Object[] fila3 = {"45791627", "Sosa", "Tomas", "tomas.sosa@comunidad.ub.edu.ar", "11 2607 6097", "Carlos villate 2052, Olivos"};
        modeloOriginal.addRow(fila3);

        Object[] fila4 = {"22845117", "Peralta", "Faustino Jose", "fjperalta100@hotmail.com", "11 5174 9217", "Tomas Guido 180, Cañuelas"};
        modeloOriginal.addRow(fila4);

     // Crear un botón adicional para cargar más tablas (sin ActionListener).
        JButton botonCargarTablas = new JButton("Cargar Tablas");
        panelDatos.add(botonCargarTablas);
        
        botonCargarTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo modelo de tabla para la segunda tabla con nombres de columnas adicionales.
                DefaultTableModel modeloSegundaTabla = new DefaultTableModel(
                    new String[]{"DNI", "Aritmetica Modular", "Plegamiento", "Mitad Cuadrado", "Multiplicacion", "Apellidos", "Nombres", "Email", "Celular", "Dirección"}, 0);

                // Obtener el número de filas en el modeloOriginal.
                int rowCount = modeloOriginal.getRowCount();

                // Recorrer todas las filas de modeloOriginal.
                for (int i = 0; i < rowCount; i++) {
                    Object[] fila = new Object[10];

                    // Copiar el valor del DNI de modeloOriginal a fila[0].
                    fila[0] = modeloOriginal.getValueAt(i, 0);
                    
                    // Convertir el DNI en un valor entero.
                    int dni = Integer.parseInt(modeloOriginal.getValueAt(i, 0).toString());

                    // Calcular valores adicionales y asignarlos a las columnas correspondientes.
                    fila[1] = aritmeticaModular(dni, 10);
                    fila[2] = plegamiento(dni, 10);

                    long dniLong = Long.parseLong(modeloOriginal.getValueAt(i, 0).toString());
                    fila[3] = mitadCuadrado(dniLong, dni);
                    fila[4] = metodoDeLaMultiplicacion(dniLong, 10);

                    // Copiar los valores de las otras columnas de modeloOriginal a fila.
                    fila[5] = modeloOriginal.getValueAt(i, 1);
                    fila[6] = modeloOriginal.getValueAt(i, 2);
                    fila[7] = modeloOriginal.getValueAt(i, 3);
                    fila[8] = modeloOriginal.getValueAt(i, 4);
                    fila[9] = modeloOriginal.getValueAt(i, 5);

                    // Agregar la fila con datos calculados al modeloSegundaTabla.
                    modeloSegundaTabla.addRow(fila);
                }

                // Crear una nueva ventana para mostrar las dos tablas.
                JFrame frameTablas = new JFrame("Tablas de Datos");
                frameTablas.setLayout(new GridLayout(1, 2));

                // Crear las tablas con los modelos correspondientes y agregarlas a un panel.
                JTable tablaSegunda = new JTable(modeloSegundaTabla);
                JTable tablaOriginal = new JTable(modeloOriginal);
                JPanel panelTablas = new JPanel(new GridLayout(2, 1));

                panelTablas.add(new JScrollPane(tablaOriginal));
                panelTablas.add(new JScrollPane(tablaSegunda));

                // Agregar el panel de las tablas a la ventana.
                frameTablas.add(panelTablas);

                // Configurar el comportamiento de cierre de la ventana de tablas.
                frameTablas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Ajustar el tamaño de la ventana de tablas según su contenido.
                frameTablas.pack();

                // Hacer visible la ventana de tablas.
                frameTablas.setVisible(true);
            }
        });

    }
    
    //--------------------------metodos hash----------------------------

    public static String aritmeticaModular(int dni, int sizeTabla) {
        // Calcula la posición en la tabla mediante la operación de aritmética modular.
        int posicion = dni % sizeTabla;
        // Convierte el valor de posición (un entero) en una cadena de texto y lo retorna.
        return String.valueOf(posicion);
    }

    public static String plegamiento(int dni, int sizeTabla) {
        // Convierte el DNI y el tamaño de la tabla en cadenas de texto.
        String auxClave = String.valueOf(dni);
        String auxTamTab = String.valueOf(sizeTabla - 1);

        // Inicializa la variable para almacenar la posición en la tabla.
        int posicion = 0;

        // Inicializa una variable para construir partes de la clave.
        String parte = "";

        // Recorre cada dígito de la clave.
        for (int i = 0; i < auxClave.length(); i++) {
            parte += auxClave.charAt(i);

            // Cuando la longitud de la parte sea igual a la longitud del tamaño de la tabla - 1,
            // suma el valor de la parte a la posición y restablece la parte.
            if (parte.length() == auxTamTab.length()) {
                posicion += Integer.parseInt(parte);
                parte = "";
            } else if (i == auxClave.length() - 1) {
                // Cuando se alcance el último dígito de la clave, suma el valor de la parte a la posición.
                posicion += Integer.parseInt(parte);
            }
        }

        // Convierte la posición en la tabla (un número entero) en una cadena de texto y la retorna.
        return String.valueOf(posicion);
    }


    public static String mitadCuadrado(long dni, int sizeTabla) {
        // Calcula el cuadrado del DNI y lo convierte en una cadena de texto.
        String auxClave = String.valueOf(dni * dni);

        // Convierte el tamaño de la tabla - 1 en una cadena de texto.
        String auxTamTab = String.valueOf(sizeTabla - 1);

        // Calcula el índice de inicio en auxClave para tomar la "mitad cuadrada".
        int inicio = (auxClave.length() / 2) - 1;

        // Inicializa una cadena para almacenar la posición en la tabla.
        String posicion = "";

        // Recorre una parte de auxClave para obtener la posición.
        for (int i = inicio; i < inicio + auxTamTab.length(); i++) {
            posicion += auxClave.charAt(i);
        }

        // Retorna la posición calculada como una cadena de texto.
        return posicion;
    }


    public static String metodoDeLaMultiplicacion(long dni, int sizeTabla) {
        // Define un valor constante A.
        double A = 0.61680339887;
        
        // Calcula d = A * dni - parte entera de (A * dni).
        double d = A * dni - Math.floor(A * dni);

        // Calcula la posición en la tabla como sizeTabla * d y lo redondea hacia abajo.
        int posicion = (int) Math.floor(sizeTabla * d);

        // Convierte la posición en la tabla (un número entero) en una cadena de texto y la retorna.
        return String.valueOf(posicion);
    }
}

