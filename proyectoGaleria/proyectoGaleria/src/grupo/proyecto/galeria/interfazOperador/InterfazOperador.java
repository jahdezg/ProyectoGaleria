package grupo.proyecto.galeria.interfazOperador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class InterfazOperador extends JFrame {

    public InterfazOperador() {
        setTitle("Menú del Operador");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BotonesOperador opcionesOperador = new BotonesOperador(this);
        JPanel panelOpciones = opcionesOperador.crearPanelOpciones();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelOpciones, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new InterfazOperador();
    }
}

