package grupo.proyecto.galeria.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuComprador {
    public static final String PIEZAS_FILE_PATH = "piezas.txt";
    private static final String PIEZAS_COMPRADOR_FILE_PATH = "piezas_comprador.txt";

    public static void definirMetodoPago(String nombreComprador, String metodoPago) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreComprador + "_piezas.txt", true))) {
            bw.write(nombreComprador + ":" + metodoPago);
            bw.newLine();
            System.out.println("Método de pago registrado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al almacenar el método de pago: " + e.getMessage());
        }
    }

    static void menuComprador(Scanner scanner, String nombreComprador) {
        int opcion;
        do {
            System.out.println("\nMenú de comprador - " + nombreComprador);
            System.out.println("1. Comprar piezas");
            System.out.println("2. Definir método de pago");
            System.out.println("3. Participar en subasta");
            System.out.println("4. Ver solicitudes o compras pendientes");
            System.out.println("5. Ver historial de todas las piezas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    comprarPiezas(scanner, nombreComprador);
                    break;
                case 2:
                    definirMetodoPago(scanner, nombreComprador);
                    break;
                case 3:
                    System.out.println("Opción en desarrollo.");
                    break;
                case 4:
                    verPendientes(nombreComprador);
                    break;
                case 5:
                    verHistorial();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 6);
    }

    public static void verHistorial() {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar el historial de piezas: " + e.getMessage());
        }
    }

    public static void comprarPiezas(Scanner scanner, String nombreComprador) {
        System.out.println("Lista de piezas disponibles para comprar:");
        mostrarPiezasNoVendidas();

        System.out.print("Ingrese el nombre de la pieza que desea comprar: ");
        String nombrePieza = scanner.nextLine();

        if (comprarPieza(nombrePieza, nombreComprador)) {
            System.out.println("La pieza se compró con éxito.");
        } else {
            System.out.println("No se encontró ninguna pieza con el nombre especificado o la pieza ya está vendida.");
        }
    }

    public static void mostrarPiezasNoVendidas() {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 7 && partes[5].equalsIgnoreCase("false")) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Autor: " + partes[1]);
                    System.out.println("Año de creación: " + partes[3]);
                    System.out.println("Tipo: " + partes[4]);
                    System.out.println("Vendida: No");
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas disponibles: " + e.getMessage());
        }
    }

    public static void definirMetodoPago(Scanner scanner, String nombreComprador) {
        System.out.println("Seleccione el método de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Transferencia");
        System.out.print("Seleccione una opción: ");
        int opcionMetodoPago = scanner.nextInt();
        scanner.nextLine();
        String metodoPago;
        switch (opcionMetodoPago) {
            case 1:
                metodoPago = "Efectivo";
                break;
            case 2:
                metodoPago = "Tarjeta";
                break;
            case 3:
                metodoPago = "Transferencia";
                break;
            default:
                System.out.println("Opción inválida. Se seleccionará el método de pago por defecto: Efectivo.");
                metodoPago = "Efectivo";
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreComprador + "_piezas.txt", true))) {
            bw.write(nombreComprador + ":" + metodoPago);
            bw.newLine();
            System.out.println("Método de pago registrado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al almacenar el método de pago: " + e.getMessage());
        }
    }

    public static void verPendientes(String nombreComprador) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreComprador + "_piezas.txt"))) {
            String linea;
            boolean tienePendientes = false;

            System.out.println("Piezas pendientes para " + nombreComprador + ":");

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 2 && partes[0].equalsIgnoreCase(nombreComprador)) {
                    System.out.println("Nombre de la pieza: " + partes[1]);
                    tienePendientes = true;
                }
            }

            if (!tienePendientes) {
                System.out.println("No hay piezas pendientes para " + nombreComprador);
            }
        } catch (IOException e) {
            System.err.println("Error al leer las solicitudes pendientes: " + e.getMessage());
        }
    }

    public static boolean comprarPieza(String nombrePieza, String nombreComprador) {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            StringBuilder piezasActualizadas = new StringBuilder();
            boolean piezaEncontrada = false;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 7 && partes[0].equalsIgnoreCase(nombrePieza) && partes[5].equalsIgnoreCase("false")) {
                    piezaEncontrada = true;
                    piezasActualizadas.append(partes[0]).append(":").append(partes[1]).append(":").append(partes[2]).append(":").append(partes[3]).append(":").append(partes[4]).append(":true:").append(partes[6]).append(":").append(partes[7]).append(":").append(partes[8]).append(":").append(partes[9]).append(":").append(partes[10]).append(":").append(partes[11]).append("\n");

                    try (FileWriter fw = new FileWriter(nombreComprador + "_piezas.txt", true)) {
                        fw.write(nombreComprador + ":" + nombrePieza + "\n");
                    } catch (IOException e) {
                        System.err.println("Error al almacenar la información de la pieza comprada: " + e.getMessage());
                    }
                } else {
                    piezasActualizadas.append(linea).append("\n");
                }
            }

            if (!piezaEncontrada) {
                return false;
            }

            FileWriter writer = new FileWriter(PIEZAS_FILE_PATH);
            writer.write(piezasActualizadas.toString());
            writer.close();

            return true;
        } catch (IOException e) {
            System.err.println("Error al comprar pieza: " + e.getMessage());
            return false;
        }
    }
}
