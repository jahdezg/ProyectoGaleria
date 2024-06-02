package grupo.proyecto.galeria.interfazAdmin;

import grupo.proyecto.galeria.consola.MenuRoles;
import javax.swing.*;
import java.awt.*;

public class OpcionesBotones {
    private JFrame frame;
    private MenuRoles menuRoles;

    public OpcionesBotones(JFrame frame) {
        this.frame = frame;
        this.menuRoles = new MenuRoles();
    }

    public JPanel crearPanelOpciones() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton registrarPiezaButton = new JButton("Registrar una pieza nueva");
        JButton eliminarPiezaButton = new JButton("Eliminar una pieza");
        JButton mostrarVendidasButton = new JButton("Mostrar piezas vendidas");
        JButton mostrarNoVendidasButton = new JButton("Mostrar piezas no vendidas");
        JButton buscarPorAutorButton = new JButton("Buscar piezas por autor");
        JButton salirButton = new JButton("Salir");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(registrarPiezaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(eliminarPiezaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(mostrarVendidasButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(mostrarNoVendidasButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(buscarPorAutorButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(salirButton, gbc);

        registrarPiezaButton.addActionListener(e -> mostrarPantallaRegistroPieza());
        eliminarPiezaButton.addActionListener(e -> mostrarPantallaEliminarPieza());
        mostrarVendidasButton.addActionListener(e -> mostrarPantallaMostrarVendidas());
        mostrarNoVendidasButton.addActionListener(e -> mostrarPantallaMostrarNoVendidas());
        buscarPorAutorButton.addActionListener(e -> mostrarPantallaBuscarPiezasAutor());

        return panel;
    }

    private void mostrarPantallaRegistroPieza() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new BotonPiezaNueva(frame, menuRoles).crearPanelRegistro());
        frame.revalidate();
        frame.repaint();
    }

    private void mostrarPantallaEliminarPieza() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new BotonEliminarPieza(frame, menuRoles).crearPanelEliminar());
        frame.revalidate();
        frame.repaint();
    }

    private void mostrarPantallaMostrarVendidas() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new BotonMostrarVendidas(frame, menuRoles).crearPanelMostrarVendidas());
        frame.revalidate();
        frame.repaint();
    }

    private void mostrarPantallaMostrarNoVendidas() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new BotonNoVendidas(frame, menuRoles).crearPanelMostrarNoVendidas());
        frame.revalidate();
        frame.repaint();
    }

    private void mostrarPantallaBuscarPiezasAutor() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new BotonPiezasAutor(frame, menuRoles).crearPanelBuscarAutor());
        frame.revalidate();
        frame.repaint();
    }
}
