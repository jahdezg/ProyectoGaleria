package grupo.proyecto.galeria.interfazPropietario;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class PanelFondo extends JPanel {
    private BufferedImage imagen;

    public PanelFondo(String urlImagen) {
        try {
            imagen = ImageIO.read(new File(urlImagen));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
    @Override
    public Dimension getPreferredSize() {
        if (imagen != null) {
            return new Dimension(imagen.getWidth(), imagen.getHeight());
        } else {
            return super.getPreferredSize();
        }
    }
}