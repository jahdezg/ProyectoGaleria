package grupo.proyecto.galeria.interfazPropietario;

import javax.swing.*;
import java.awt.*;

public class BotonComprarPieza extends JFrame {

    private JFrame parentFrame;

    public BotonComprarPieza(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        setTitle("Comprar Piezas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        
        JLabel label = new JLabel("Desarrollo", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> volverAlMenu());
        panel.add(volverButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void volverAlMenu() {
        parentFrame.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        JFrame parentFrame = new JFrame();
        new BotonComprarPieza(parentFrame);
    }
}

