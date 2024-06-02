package grupo.proyecto.galeria.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuCajero {
    private static final String PIEZAS_FILE_PATH = "piezas.txt";
    private static final String PIEZAS_COMPRADOR_FILE_PATH = "piezas_comprador.txt";
    private static final String VENTA_PROPIETARIO_FILE_PATH = "venta_propietario.txt";

    public static void menuCajero(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú de Cajero");
            System.out.println("1. Autorizar compras pendientes");
            System.out.println("2. Cambiar estado de piezas no vendidas a vendidas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    autorizarComprasPendientes(scanner);
                    break;
                case 2:
                    cambiarEstadoPiezasNoVendidas();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);
    }

    private static void autorizarComprasPendientes(Scanner scanner) {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_COMPRADOR_FILE_PATH))) {
            String linea;
            boolean tienePendientes = false;

            System.out.println("Solicitudes de compra pendientes:");

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 2) {
                    String nombrePieza = partes[0];
                    String nombreComprador = partes[1];
                    System.out.println("Nombre de la pieza: " + nombrePieza + ", Comprador: " + nombreComprador);
                    tienePendientes = true;
                }
            }

            if (!tienePendientes) {
                System.out.println("No hay solicitudes de compra pendientes.");
            } else {
                System.out.println("Ingrese el nombre de la pieza que desea autorizar (o '0' para salir): ");
                String nombrePiezaAutorizar = scanner.nextLine();
                if (!nombrePiezaAutorizar.equals("0")) {
                    autorizarCompra(nombrePiezaAutorizar);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer las solicitudes pendientes: " + e.getMessage());
        }
    }
    
    private static void autorizarCompra(String nombrePiezaAutorizar) {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            StringBuilder piezasActualizadas = new StringBuilder();
            boolean piezaEncontrada = false;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 7 && partes[0].equalsIgnoreCase(nombrePiezaAutorizar) && partes[5].equalsIgnoreCase("false")) {
                    piezaEncontrada = true;
                    piezasActualizadas.append(partes[0]).append(":").append(partes[1]).append(":").append(partes[2]).append(":").append(partes[3]).append(":").append(partes[4]).append(":true:").append(partes[6]).append(":").append(partes[7]).append(":").append(partes[8]).append(":").append(partes[9]).append(":").append(partes[10]).append(":").append(partes[11]).append("\n");
                } else {
                    piezasActualizadas.append(linea).append("\n");
                }
            }

            if (!piezaEncontrada) {
                System.out.println("La pieza especificada no existe o ya está vendida.");
                return;
            }

            FileWriter writer = new FileWriter(PIEZAS_FILE_PATH);
            writer.write(piezasActualizadas.toString());
            writer.close();

            System.out.println("La pieza '" + nombrePiezaAutorizar + "' ha sido autorizada y marcada como vendida.");
        } catch (IOException e) {
            System.err.println("Error al autorizar compra: " + e.getMessage());
        }
    }



    private static void cambiarEstadoPiezasNoVendidas() {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            StringBuilder piezasActualizadas = new StringBuilder();

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 7 && partes[5].equalsIgnoreCase("false")) {
                    piezasActualizadas.append(partes[0]).append(":").append(partes[1]).append(":").append(partes[2]).append(":").append(partes[3]).append(":").append(partes[4]).append(":true:").append(partes[6]).append(":").append(partes[7]).append(":").append(partes[8]).append(":").append(partes[9]).append(":").append(partes[10]).append(":").append(partes[11]).append("\n");
                } else {
                    piezasActualizadas.append(linea).append("\n");
                }
            }

            FileWriter writer = new FileWriter(PIEZAS_FILE_PATH);
            writer.write(piezasActualizadas.toString());
            writer.close();

            System.out.println("Se han marcado todas las piezas no vendidas como vendidas.");
        } catch (IOException e) {
            System.err.println("Error al cambiar estado de las piezas no vendidas: " + e.getMessage());
        }
    }
}