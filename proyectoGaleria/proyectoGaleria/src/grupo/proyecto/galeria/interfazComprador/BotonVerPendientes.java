package grupo.proyecto.galeria.interfazComprador;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BotonVerPendientes extends JPanel {
    private String nombreComprador;

    public BotonVerPendientes(String nombreComprador) {
        this.nombreComprador = nombreComprador;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Piezas Pendientes:");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        DefaultListModel<String> pendientesModel = obtenerPendientes();
        JList<String> pendientesList = new JList<>(pendientesModel);
        JScrollPane scrollPane = new JScrollPane(pendientesList);
        add(scrollPane, BorderLayout.CENTER);

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> volverAOpciones());
        add(volverButton, BorderLayout.SOUTH);
    }

    private DefaultListModel<String> obtenerPendientes() {
        DefaultListModel<String> pendientesModel = new DefaultListModel<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreComprador + "_piezas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                pendientesModel.addElement(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las piezas pendientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return pendientesModel;
    }

    private void volverAOpciones() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().removeAll();
        parentFrame.add(new OpcionesBotones(nombreComprador, new Scanner(System.in)));
        parentFrame.revalidate();
        parentFrame.repaint();
    }
}


