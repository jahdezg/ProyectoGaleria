package grupo.proyecto.galeria.interfazPropietario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

public class InterfazPropietario extends JFrame{
	

    public InterfazPropietario() {
        setTitle("Menú del Propietario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        PanelFondo panelimagen = new PanelFondo("./data/imagenes/fondo1.JPG");
        panelimagen.setLayout(new BorderLayout());
        
        OpcionesBotones opcionesBotones = new OpcionesBotones(this);
        JPanel panelOpciones = opcionesBotones.crearPanelOpciones();

        //JPanel mainPanel = new JPanel(new BorderLayout());
        //mainPanel.add(panelOpciones, BorderLayout.CENTER);

        //add(mainPanel);
        panelimagen.add(panelOpciones, BorderLayout.CENTER);

        // Establece el panel personalizado como el panel principal del JFrame
        setContentPane(panelimagen);


        setVisible(true);
    }

    public static void main(String[] args) {
    	 SwingUtilities.invokeLater(() -> new InterfazPropietario());
    }
}
