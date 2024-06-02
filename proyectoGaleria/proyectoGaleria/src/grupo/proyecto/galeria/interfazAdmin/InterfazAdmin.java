package grupo.proyecto.galeria.interfazAdmin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class InterfazAdmin extends JFrame {

    public InterfazAdmin() {
        setTitle("Menu del Administrador");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        OpcionesBotones opcionesBotones = new OpcionesBotones(this);
        JPanel panelOpciones = opcionesBotones.crearPanelOpciones();

        JScrollPane scrollPane = new JScrollPane(panelOpciones);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new InterfazAdmin();
    }
}
