import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Tabla tabla;  // Declaración de una variable miembro de la clase "tabla" de tipo Tabla

    public MainFrame() {
        setTitle("Tabla Hash con Swing");  // Establece el título de la ventana
        setSize(400, 300);  // Establece el tamaño de la ventana
        setLocationRelativeTo(null);  // Coloca la ventana en el centro de la pantalla

        tabla = null;  // Inicializa la variable "tabla" como nula

        JPanel panel = new JPanel();  // Crea un panel
        panel.setLayout(new GridLayout(0, 1));  // Establece el diseño del panel como una cuadrícula de una columna

        JButton createTableButton = new JButton("Crear Tabla");  // Crea un botón con etiqueta "Crear Tabla"
        JButton insertButton = new JButton("Insertar Elemento");  // Crea un botón con etiqueta "Insertar Elemento"
        JButton deleteButton = new JButton("Eliminar Elemento");  // Crea un botón con etiqueta "Eliminar Elemento"
        JButton searchButton = new JButton("Buscar Elemento");  // Crea un botón con etiqueta "Buscar Elemento"
        JButton printButton = new JButton("Imprimir Tabla");  // Crea un botón con etiqueta "Imprimir Tabla"

        // Agrega un ActionListener al botón "createTableButton"
        createTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla == null) {  // Comprueba si la tabla ya ha sido creada
                    int sizeT1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la tabla (potencia de 10): "));
                    while (!esPotenciaDeDiez(sizeT1)) {
                        sizeT1 = Integer.parseInt(JOptionPane.showInputDialog("Debe ser una potencia de 10. Volver a ingresar: "));
                    }
                    tabla = new Tabla(sizeT1);  // Crea una nueva tabla con el tamaño especificado
                } else {
                    JOptionPane.showMessageDialog(null, "Tabla ya creada.");  // Muestra un mensaje si la tabla ya ha sido creada
                }
            }
        });

        // Agrega un ActionListener al botón "insertButton"
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla != null) {  // Comprueba si la tabla ha sido creada
                    String nombre = JOptionPane.showInputDialog("Nombre: ");  // Solicita al usuario el nombre
                    String apellido = JOptionPane.showInputDialog("Apellido: ");  // Solicita al usuario el apellido
                    int dni = Integer.parseInt(JOptionPane.showInputDialog("DNI: "));  // Solicita al usuario el DNI
                    Elemento elemento = new Elemento(nombre, apellido, dni);  // Crea un nuevo elemento con los datos ingresados
                    tabla.insertar(elemento, tabla.hash(elemento));  // Inserta el elemento en la tabla
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede insertar un elemento en una tabla no creada.");  // Muestra un mensaje si la tabla no ha sido creada
                }
            }
        });

        // Agrega un ActionListener al botón "deleteButton"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla != null) {  // Comprueba si la tabla ha sido creada
                    int dniAEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del elemento a eliminar: "));
                    if (tabla.eliminar(dniAEliminar)) {  // Intenta eliminar el elemento con el DNI especificado
                        JOptionPane.showMessageDialog(null, "Elemento eliminado.");  // Muestra un mensaje si el elemento ha sido eliminado
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe el elemento a eliminar.");  // Muestra un mensaje si el elemento no existe
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar un elemento de una tabla no creada.");  // Muestra un mensaje si la tabla no ha sido creada
                }
            }
        });

        // Agrega un ActionListener al botón "searchButton"
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla != null) {  // Comprueba si la tabla ha sido creada
                    int dniABuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del elemento a buscar: "));
                    int posicionABuscar = tabla.buscar(dniABuscar);  // Busca el elemento con el DNI especificado
                    if (posicionABuscar != -1) {
                        JOptionPane.showMessageDialog(null, "Posición: " + posicionABuscar);  // Muestra la posición si el elemento ha sido encontrado
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el elemento.");  // Muestra un mensaje si el elemento no ha sido encontrado
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede buscar un elemento en una tabla no creada.");  // Muestra un mensaje si la tabla no ha sido creada
                }
            }
        });

        // Agrega un ActionListener al botón "printButton"
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla != null) {  // Comprueba si la tabla ha sido creada
                    JOptionPane.showMessageDialog(null, tabla.toString());  // Muestra la representación de la tabla
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede imprimir una tabla que no está creada.");  // Muestra un mensaje si la tabla no ha sido creada
                }
            }
        });

        panel.add(createTableButton);  // Agrega el botón "createTableButton" al panel
        panel.add(insertButton);  // Agrega el botón "insertButton" al panel
        panel.add(deleteButton);  // Agrega el botón "deleteButton" al panel
        panel.add(searchButton);  // Agrega el botón "searchButton" al panel
        panel.add(printButton);  // Agrega el botón "printButton" al panel

        add(panel);  // Agrega el panel a la ventana

    }

    public boolean esPotenciaDeDiez(int numero) {
        double logBaseDiez = Math.log10(numero);  // Calcula el logaritmo en base 10 del número
        return logBaseDiez == (int) logBaseDiez;  // Comprueba si el logaritmo es un número entero (potencia de 10)
    }
}


