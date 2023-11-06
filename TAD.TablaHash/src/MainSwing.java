import javax.swing.JFrame;  // Importa la clase JFrame del paquete javax.swing

public class MainSwing {
    public static void main(String[] args) {
        JFrame frame = new MainFrame();  // Crea una instancia de la clase MainFrame y la asigna a una variable "frame"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Configura la acción de cierre de la ventana al cerrar la aplicación
        frame.setVisible(true);  // Hace visible la ventana en la pantalla
    }
}
