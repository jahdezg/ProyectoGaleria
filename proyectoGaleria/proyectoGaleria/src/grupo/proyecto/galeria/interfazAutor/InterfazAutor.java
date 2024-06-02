package grupo.proyecto.galeria.interfazAutor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class InterfazAutor extends JFrame {

    public InterfazAutor() {
        setTitle("Menu del Autor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        OpcionesBotonesAu opcionesBotonesAu = new OpcionesBotonesAu(this);
        JPanel panelOpciones = opcionesBotonesAu.crearPanelOpciones();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelOpciones, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new InterfazAutor();
    }
}
