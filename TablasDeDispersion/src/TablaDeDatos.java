import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaDeDatos {
    private DefaultTableModel modelo;
    private JTable tabla;
    private JTextField[] camposTexto;
    private int filaActual = 0; // Variable para realizar seguimiento de las filas ingresadas
    private JPanel panel;
    
    public TablaDeDatos() {
        // Crear una ventana principal
        JFrame frame = new JFrame("Tabla de Datos");
        panel = new JPanel(new GridLayout(7, 2)); // Usar la variable miembro panel

        camposTexto = new JTextField[6]; // Inicializamos el arreglo de campos de texto.

        String[] columnas = {"DNI", "Apellidos", "Nombres", "Email", "Celular", "Dirección"};
        modelo = new DefaultTableModel(columnas, 0); // Crear un modelo de tabla con nombres de columnas
        tabla = new JTable(modelo); // Crear la tabla

        for (int i = 0; i < camposTexto.length; i++) {
            panel.add(new JLabel(columnas[i] + ":")); // Crear etiquetas para los campos
            camposTexto[i] = new JTextField(); // Crear campos de texto
            panel.add(camposTexto[i]); // Agregar campos de texto al panel
        }

        JButton botonGuardar = new JButton("Guardar"); // Crear un botón "Guardar"
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filaActual < 10) {
                    Object[] fila = new Object[columnas.length]; // Crear un arreglo para almacenar los datos de la fila
                    for (int i = 0; i < columnas.length; i++) {
                        fila[i] = camposTexto[i].getText(); // Obtener datos de los campos de texto
                        camposTexto[i].setText(""); // Borrar los campos de texto
                    }
                    modelo.addRow(fila); // Agregar la fila al modelo de tabla
                    filaActual++; // Incrementar el contador de filas ingresadas
                } else {
                    JOptionPane.showMessageDialog(null, "La tabla está llena."); // Mostrar un mensaje si la tabla está llena
                }
            }
        });

        panel.add(botonGuardar); // Agregar el botón "Guardar" al panel
        // (El código que falta para mostrar la ventana se omite en esta respuesta)
    


        frame.add(panel, BorderLayout.NORTH); // Agregar el panel en la parte superior de la ventana.
        frame.add(new JScrollPane(tabla), BorderLayout.CENTER); // Agregar la tabla en el centro de la ventana dentro de un JScrollPane.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar el comportamiento de cierre de la ventana al hacer clic en la "X" de la ventana.
        frame.pack(); // Ajustar el tamaño de la ventana automáticamente para que se ajuste a su contenido.
        frame.setVisible(true); // Hacer visible la ventana.

    }
    
    public int getFilaActual() {
        return filaActual; // Método para obtener el número actual de filas ingresadas en la tabla.
    }

    public JTable getTabla() {
        return tabla; // Método para obtener la instancia de la tabla.
    }

    public JPanel getPanel() {
        return panel; // Método para obtener la instancia del panel.
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TablaDeDatos(); // Método principal para iniciar la aplicación y crear una instancia de TablaDeDatos.
            }
        });
    }
}
