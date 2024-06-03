package grupo.proyecto.galeria.interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoVentana extends JPanel
{
	//private JLabel lblLogo;
	private BufferedImage logoImagen;
	
	public LogoVentana()
	{
		//lblLogo = new JLabel("");
		//lblLogo.setPreferredSize(new Dimension (800,180));
		//add(lblLogo);
		
		//ImageIcon fotico = new ImageIcon("./data/imagenes/logoo.PNG");
		//lblLogo.setIcon(fotico);
		
		// Cargar la imagen desde el archivo
        try {
        	logoImagen = ImageIO.read(new File("./data/imagenes/logoo.PNG")); 
        } catch (IOException e) {
            e.printStackTrace();
        }

        setPreferredSize(new Dimension(800, 180));
		
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (logoImagen != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Escalar la imagen al tamaño del panel
            int width = getWidth();
            int height = getHeight();
            g2d.drawImage(logoImagen, 0, 0, width, height, this);
        }
    }
}
