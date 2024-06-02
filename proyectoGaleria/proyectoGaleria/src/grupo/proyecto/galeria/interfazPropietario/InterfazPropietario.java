package grupo.proyecto.galeria.interfazPropietario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class InterfazPropietario extends JFrame{

    public InterfazPropietario() {
        setTitle("Menú del Propietario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        OpcionesBotones opcionesBotones = new OpcionesBotones(this);
        JPanel panelOpciones = opcionesBotones.crearPanelOpciones();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelOpciones, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new InterfazPropietario();
    }
}
