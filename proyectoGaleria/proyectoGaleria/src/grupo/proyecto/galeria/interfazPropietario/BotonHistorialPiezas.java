package grupo.proyecto.galeria.interfazPropietario;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BotonHistorialPiezas extends JFrame {

    private static final String PIEZAS_FILE_PATH = "piezas.txt";
    private JFrame parentFrame;

    public BotonHistorialPiezas(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        setTitle("Historial de Piezas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        
        JList<String> piezasList = new JList<>(cargarPiezas());
        piezasList.setFont(new Font("monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(piezasList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> volverAlMenu());
        panel.add(volverButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private String[] cargarPiezas() {
        List<String> piezas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 13) {
                    piezas.add(String.format("Nombre: %s, Autor: %s, Propietario: %s, Año: %s, Tipo: %s, Vendida: %s, Método de Pago: %s, Precio: %s, Precio Mínimo: %s, Precio Venta: %s, Fecha Compra: %s, Hora Compra: %s, Historia Autor: %s",
                            partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6], partes[7], partes[8], partes[9], partes[10], partes[11], partes[12]));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las piezas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return piezas.toArray(new String[0]);
    }

    private void volverAlMenu() {
        parentFrame.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        JFrame parentFrame = new JFrame();
        new BotonHistorialPiezas(parentFrame);
    }
}


