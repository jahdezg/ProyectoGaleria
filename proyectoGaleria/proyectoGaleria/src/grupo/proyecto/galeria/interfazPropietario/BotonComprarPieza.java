package grupo.proyecto.galeria.interfazPropietario;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BotonComprarPieza extends JFrame {
	
	private static final String PIEZAS_FILE_PATH = "piezas.txt";
	
	private List<String> piezas;
    private int currentIndex;
    private JFrame parentFrame;
    
    private JPanel panelDatosObra;
    
    private JTextField txtNombreObra;
    private JTextField txtNombreArtista;
    private JTextField txtTipoObra;
    private JTextField txtAñoObra;
    private JTextField txtTipoVenta;
    private JTextField txtDescripcion;
    

    

    public BotonComprarPieza(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        setTitle("Comprar Piezas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        
     // Crear los campos de texto
        txtNombreObra = new JTextField();
        txtNombreArtista = new JTextField();
        txtTipoObra = new JTextField();
        txtAñoObra = new JTextField();
        txtTipoVenta = new JTextField();
        txtDescripcion = new JTextField();
        
        
     // Agregar los campos de texto al panel de datos de la obra
        panelDatosObra = new JPanel();
        panelDatosObra.setLayout(new GridLayout(6, 2));
        
        panelDatosObra.add(new JLabel("Nombre de la obra"));
        panelDatosObra.add(txtNombreObra);
        
        panelDatosObra.add(new JLabel("Nombre del artista"));
        panelDatosObra.add(txtNombreArtista);
        
        panelDatosObra.add(new JLabel("Tipo de la obra"));
        panelDatosObra.add(txtTipoObra);
        
        panelDatosObra.add(new JLabel("Año de la obra"));
        panelDatosObra.add(txtAñoObra);
        
        panelDatosObra.add(new JLabel("Venta"));
        panelDatosObra.add(txtTipoVenta);
        
        panelDatosObra.add(new JLabel("Descripción"));
        panelDatosObra.add(txtDescripcion);
        
        // Agregar el panel de datos de la obra al panel principal
        panel.add(panelDatosObra, BorderLayout.CENTER);
        
        // Cargar la información de las piezas
        cargarInformacion(PIEZAS_FILE_PATH);
        mostrarPiezaActual();
        
        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> volverAlMenu());
        panel.add(volverButton, BorderLayout.SOUTH);
        
        JButton siguienteButton = new JButton("Siguiente");
        siguienteButton.addActionListener(e -> mostrarSiguientePieza());
        
        JPanel panelBotones = new JPanel(new GridLayout(1, 2));
        panelBotones.add(siguienteButton);
        panelBotones.add(volverButton);
        
        panel.add(panelBotones, BorderLayout.SOUTH);


        add(panel);
        setVisible(true);
    }

    
    private void cargarInformacion(String filename) {
        piezas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                piezas.add(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las piezas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarPiezaActual() {
        if (piezas != null && currentIndex >= 0 && currentIndex < piezas.size()) {
            String[] partes = piezas.get(currentIndex).split(":");
            if (partes.length >= 13) {
            	txtNombreObra.setText(partes[0]);
                txtNombreArtista.setText(partes[1]);
                txtAñoObra.setText(partes[3]);
                txtTipoObra.setText(partes[4]);
                txtTipoVenta.setText(partes[6]);
                txtDescripcion.setText(partes[13]);
            }
        }
    }

    private void mostrarSiguientePieza() {
        currentIndex++;
        if (piezas != null && currentIndex >= 0 && currentIndex < piezas.size()) {
            mostrarPiezaActual();
        } else {
            JOptionPane.showMessageDialog(this, "No hay más piezas para mostrar.", "Fin de la lista", JOptionPane.INFORMATION_MESSAGE);
            currentIndex = piezas.size() - 1;
        }
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

