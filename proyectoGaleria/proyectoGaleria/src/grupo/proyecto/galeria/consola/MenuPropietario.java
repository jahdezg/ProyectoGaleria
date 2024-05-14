package grupo.proyecto.galeria.consola;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuPropietario {
    private static final String USUARIOS_FILE_PATH = "usuarios.txt";
    private static final String VENTA_PROPIETARIO_FILE_PATH = "venta_propietario.txt";
    private static final String PIEZAS_FILE_PATH = "piezas.txt";
    private static final String METODO_PAGO_COMPRADOR_FILE_PATH = "metodo_pago_comprador.txt";

    static void menuPropietario(Scanner scanner, String nombrePropietario) {
        int opcion;
        do {
            System.out.println("\nMenú de propietario - " + nombrePropietario);
            System.out.println("1. Mirar historial de piezas a su nombre");
            System.out.println("2. Participar en subasta (Opción en desarrollo)");
            System.out.println("3. Comprar pieza");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mirarHistorialPiezas(scanner, nombrePropietario);
                    break;
                case 2:
                    System.out.println("Opción en desarrollo.");
                    break;
                case 3:
                    comprarPieza(scanner, nombrePropietario);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }

    private static void mirarHistorialPiezas(Scanner scanner, String nombrePropietario) {
        System.out.print("¿Puede confirmarme su nombre? (Sí/No): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("Si")) {
            System.out.print("Por favor, escriba su nombre de propietario: ");
            String nombreConfirmado = scanner.nextLine();
            
            try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(":");
                    if (partes.length >= 3 && partes[2].equalsIgnoreCase(nombreConfirmado)) {
                        System.out.println("Nombre: " + partes[0]);
                        System.out.println("Autor: " + partes[1]);
                        System.out.println("Año de creación: " + partes[3]);
                        System.out.println("Tipo: " + partes[4]);
                        System.out.println("Vendida: " + (partes[5].equalsIgnoreCase("true") ? "Sí" : "No"));
                        System.out.println();
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al mostrar historial de piezas: " + e.getMessage());
            }
        } else {
            System.out.println("Confirmación de nombre no recibida. No se puede mostrar el historial de piezas.");
        }
    }

    private static void comprarPieza(Scanner scanner, String nombrePropietario) {
        System.out.println("Lista de piezas disponibles para comprar:");
        mostrarPiezasNoVendidas(nombrePropietario);

        System.out.print("Ingrese el nombre de la pieza que desea comprar: ");
        String nombrePieza = scanner.nextLine();

        if (comprarPieza(nombrePieza, nombrePropietario)) {
            definirMetodoPago(scanner, nombrePieza);
            System.out.println("La pieza se compró con éxito.");
        } else {
            System.out.println("No se encontró ninguna pieza con el nombre especificado o la pieza ya está vendida.");
        }
    }

    private static void mostrarPiezasNoVendidas(String nombrePropietario) {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 7 && partes[2].equalsIgnoreCase(nombrePropietario) && partes[5].equalsIgnoreCase("false")) {
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

    private static boolean comprarPieza(String nombrePieza, String nombrePropietario) {
        if (!existePropietario(nombrePropietario)) {
            System.out.println("El propietario no está registrado en el sistema.");
            return false;
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH));
            String ventaPropietario = "";
            String nuevaLinea = "";
            boolean piezaEncontrada = false;

            while ((nuevaLinea = br.readLine()) != null) {
                String[] partes = nuevaLinea.split(":");
                if (partes.length >= 7 && partes[0].equalsIgnoreCase(nombrePieza) && partes[5].equalsIgnoreCase("false")) {
                    piezaEncontrada = true;
                    ventaPropietario = nombrePieza + ":" + nombrePropietario;
                    break;
                }
            }

            if (!piezaEncontrada) {
                return false;
            }

            br.close();
            br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH));

            StringBuilder piezasActualizadas = new StringBuilder();
            while ((nuevaLinea = br.readLine()) != null) {
                String[] partes = nuevaLinea.split(":");
                if (partes.length >= 7 && partes[0].equalsIgnoreCase(nombrePieza)) {
                    piezasActualizadas.append(partes[0]).append(":").append(partes[1]).append(":").append(partes[2]).append(":").append(partes[3]).append(":").append(partes[4]).append(":true:").append(partes[6]).append(":").append(partes[7]).append(":").append(partes[8]).append(":").append(partes[9]).append(":").append(partes[10]).append(":").append(partes[11]).append("\n");
                } else {
                    piezasActualizadas.append(nuevaLinea).append("\n");
                }
            }

            FileWriter writer = new FileWriter(PIEZAS_FILE_PATH);
            writer.write(piezasActualizadas.toString());
            writer.close();

            FileWriter ventaPropietarioWriter = new FileWriter(VENTA_PROPIETARIO_FILE_PATH, true);
            ventaPropietarioWriter.write(ventaPropietario + "\n");
            ventaPropietarioWriter.close();

            return true;
        } catch (IOException e) {
            System.err.println("Error al comprar pieza: " + e.getMessage());
            return false;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar BufferedReader: " + e.getMessage());
            }
        }
    }

    private static void definirMetodoPago(Scanner scanner, String nombrePieza) {
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

        try (FileWriter fw = new FileWriter(METODO_PAGO_COMPRADOR_FILE_PATH, true)) {
            fw.write(nombrePieza + ":" + metodoPago + "\n");
        } catch (IOException e) {
            System.err.println("Error al almacenar el método de pago: " + e.getMessage());
        }
    }

    private static boolean existePropietario(String nombrePropietario) {
        try (BufferedReader br = new BufferedReader(new FileReader(USUARIOS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 3 && partes[0].equalsIgnoreCase(nombrePropietario) && partes[2].equalsIgnoreCase("Propietario")) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al verificar propietario: " + e.getMessage());
        }
        return false;
    }
}
