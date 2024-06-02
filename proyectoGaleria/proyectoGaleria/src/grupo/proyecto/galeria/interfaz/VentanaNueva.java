package grupo.proyecto.galeria.interfaz;

import grupo.proyecto.galeria.consola.UsuarioTipo;

import javax.swing.*;
import java.awt.*;

public class VentanaNueva extends JFrame {

    public VentanaNueva() {
        setTitle("Menu Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        UsuarioTipo.cargarUsuarios();

        JPanel mainPanel = new JPanel(new BorderLayout());

        BotonesOpciones botonesOpciones = new BotonesOpciones();
        mainPanel.add(botonesOpciones.getPanel(), BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaNueva();
    }
}

