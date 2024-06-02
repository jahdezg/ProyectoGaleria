package grupo.proyecto.galeria.interfazComprador;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class InterfazComprador extends JFrame {
    public InterfazComprador(String nombreComprador, Scanner scanner) {
        setTitle("Menú del Comprador");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        OpcionesBotones opcionesBotones = new OpcionesBotones(nombreComprador, scanner);
        mainPanel.add(opcionesBotones, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreComprador = JOptionPane.showInputDialog("Ingrese su nombre de comprador:");
        new InterfazComprador(nombreComprador, scanner);
    }
}
