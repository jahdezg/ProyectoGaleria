package grupo.proyecto.galeria.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRoles {
    private static final String PIEZAS_FILE_PATH = "piezas.txt";

    static void menuAdmin(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú de administrador");
            System.out.println("1. Registrar una pieza nueva");
            System.out.println("2. Eliminar una pieza");
            System.out.println("3. Mostrar piezas vendidas");
            System.out.println("4. Mostrar piezas no vendidas");
            System.out.println("5. Buscar piezas por autor");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarPiezaNueva(scanner);
                    break;
                case 2:
                    eliminarPieza(scanner);
                    break;
                case 3:
                    mostrarPiezasVendidas();
                    break;
                case 4:
                    mostrarPiezasNoVendidas2();
                    break;
                case 5:
                    buscarPiezasPorAutor(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 6);
    }

    static void menuAutor(Scanner scanner, String usuario) {
        int opcion;
        do {
            System.out.println("\nMenú de autor");
            System.out.println("1. Revisar piezas registradas a su nombre");
            System.out.println("2. Revisar estado de subasta (Opción en desarrollo)");
            System.out.println("3. Comprar piezas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    revisarPiezasAutor(scanner);
                    break;
                case 2:
                    System.out.println("Opción en desarrollo.");
                    break;
                case 3:
                    comprarPiezas(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }

    static void menuOperador(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú de operador");
            System.out.println("1. Manejar subasta (Opción en desarrollo)");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Opción en desarrollo.");
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 2);
    }

    public static void registrarPiezaNueva(Scanner scanner) {
        System.out.println("Ingrese el nombre de la pieza:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el nombre del autor:");
        String autor = scanner.nextLine();

        System.out.println("Ingrese el nombre del propietario:");
        String propietario = scanner.nextLine();

        System.out.println("Ingrese el año de creación de la pieza:");
        int añoCreacion = scanner.nextInt();
        scanner.nextLine();

        String tipo;
        do {
            System.out.println("Ingrese el tipo de pieza (Escultura, Fotografia, Impresion, Pintura o Video):");
            tipo = scanner.nextLine().trim().toLowerCase();
        } while (!tipoValido(tipo));

        System.out.println("¿La pieza se vendió? (Si/No):");
        boolean vendida = scanner.nextLine().equalsIgnoreCase("Si");

        double precioVenta = 0.0;
        String fechaCompra = "";
        String horaCompra = "";

        if (vendida) {
            System.out.println("Ingrese el precio por el cual se vendió la pieza:");
            precioVenta = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Ingrese la fecha de compra (Formato: dd/mm/yyyy):");
            fechaCompra = scanner.nextLine();

            System.out.println("Ingrese la hora de compra (Formato: HH:MM):");
            horaCompra = scanner.nextLine();
        } else {
            precioVenta = 0.0;
        }

        System.out.println("Ingrese el método de pago (Fijo/Subasta/Ninguno (si no se vendió)):");
        String metodoPago = scanner.nextLine().trim().toLowerCase();

        double precio = 0.0;
        double precioMinimo = 0.0;
        if (metodoPago.equals("fijo")) {
            if (!vendida) {
                System.out.println("Ingrese el precio:");
                precio = scanner.nextDouble();
                scanner.nextLine();
            }
        } else if (metodoPago.equals("subasta")) {
            System.out.println("Ingrese el precio mínimo:");
            precioMinimo = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Ingrese el precio inicial:");
            double precioInicial = scanner.nextDouble();
            scanner.nextLine();
            precioVenta = precioInicial;
        }

        System.out.println("Ingrese la historia del autor:");
        String historiaAutor = scanner.nextLine();

        guardarPieza(nombre, autor, propietario, añoCreacion, tipo, vendida, metodoPago, precio, precioMinimo, precioVenta, fechaCompra, horaCompra, historiaAutor);

        System.out.println("Pieza registrada exitosamente.");
    }

    public static boolean tipoValido(String tipo) {
        String[] tiposValidos = {"escultura", "fotografia", "impresion", "pintura", "video"};
        for (String tipoValido : tiposValidos) {
            if (tipoValido.equals(tipo)) {
                return true;
            }
        }
        System.out.println("Tipo de pieza inválido. Por favor, ingrese un tipo válido.");
        return false;
    }
    
    public static void guardarPieza(String nombre, String autor, String propietario, int añoCreacion, String tipo, boolean vendida, String metodoPago, double precio, double precioMinimo, double precioVenta, String fechaCompra, String horaCompra, String historiaAutor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PIEZAS_FILE_PATH, true))) {
            if (vendida) {
                bw.write(nombre + ":" + autor + ":" + propietario + ":" + añoCreacion + ":" + tipo + ":" + vendida + ":" + metodoPago + ":" + precio + ":" + precioMinimo + ":" + String.format("%.2f", precioVenta) + ":" + fechaCompra + ":" + horaCompra + ":" + historiaAutor);
            } else {
                if (metodoPago.equals("subasta")) {
                    bw.write(nombre + ":" + autor + ":" + propietario + ":" + añoCreacion + ":" + tipo + ":" + vendida + ":" + metodoPago + ":" + precio + ":" + precioMinimo + ":0.0:" + fechaCompra + ":" + horaCompra + ":" + historiaAutor);
                } else {
                    bw.write(nombre + ":" + autor + ":" + propietario + ":" + añoCreacion + ":" + tipo + ":" + vendida + ":" + metodoPago + ":" + precio + ":0.0:0.0:" + fechaCompra + ":" + horaCompra + ":" + historiaAutor);
                }
            }
            bw.newLine();
            bw.flush();
            System.out.println("Pieza guardada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar pieza: " + e.getMessage());
        }
    }



    public static List<String> mostrarPiezasVendidas() {
        List<String> piezas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 6 && partes[5].equalsIgnoreCase("true")) {
                    piezas.add("Nombre: " + partes[0] +
                               ", Autor: " + partes[1] +
                               ", Propietario: " + partes[2] +
                               ", Año de creación: " + partes[3] +
                               ", Tipo: " + partes[4] +
                               ", Precio de venta: " + partes[9] +
                               ", Fecha de venta: " + partes[10] +
                               ", Hora de venta: " + partes[11]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas vendidas: " + e.getMessage());
        }
        return piezas;
    }  

    private static void eliminarPieza(Scanner scanner) {
        System.out.println("Lista de piezas disponibles:");
        mostrarPiezasConID();

        System.out.print("Ingrese el número de la pieza que desea eliminar: ");
        int numeroPiezaEliminar = scanner.nextInt();
        scanner.nextLine(); 

        eliminarPiezaPorID(numeroPiezaEliminar);
    }

    public static List<String> mostrarPiezasConID() {
        List<String> piezas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            int contador = 1;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 6) {
                    piezas.add(contador + ". " + partes[0] + " - " + partes[1] + " - " + partes[2] + " - " + partes[3] + " - " + partes[4] + " - " + (partes[5].equalsIgnoreCase("true") ? "Sí" : "No"));
                    contador++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas: " + e.getMessage());
        }
        return piezas;
    }

    public static void eliminarPiezaPorID(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH));
            BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt")); 
            
            String linea;
            int contador = 1;
            boolean eliminada = false;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 7) {
                    if (contador != id) {
                        bw.write(linea); 
                        bw.newLine();
                    } else {
                        eliminada = true;
                    }
                    contador++;
                }
            }
            
            br.close();
            bw.close();
            
            if (eliminada) {
                File tempFile = new File("temp.txt");
                File originalFile = new File(PIEZAS_FILE_PATH);
                originalFile.delete();
                tempFile.renameTo(originalFile);
                
                System.out.println("Pieza eliminada exitosamente.");
            } else {
                System.out.println("No se encontró ninguna pieza con el número especificado.");
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar pieza: " + e.getMessage());
        }
    }
    
    public static List<String> mostrarPiezasNoVendidas2() {
        List<String> piezas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 6 && partes[5].equalsIgnoreCase("false")) {
                    piezas.add("Nombre: " + partes[0] +
                               ", Autor: " + partes[1] +
                               ", Propietario: " + partes[2] +
                               ", Año de creación: " + partes[3] +
                               ", Tipo: " + partes[4] +
                               ", Precio: " + partes[7] +
                               ", Precio mínimo: " + partes[8]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas no vendidas: " + e.getMessage());
        }
        return piezas;
    }

    private static void revisarPiezasAutor(Scanner scanner) {
        System.out.print("Ingrese su nombre como autor: ");
        String nombreAutor = scanner.nextLine();

        System.out.println("Piezas registradas a nombre de " + nombreAutor + ":");

        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 3 && partes[1].equalsIgnoreCase(nombreAutor)) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Propietario: " + partes[2]);
                    System.out.println("Año de creación: " + partes[3]);
                    System.out.println("Tipo: " + partes[4]);
                    System.out.println("Vendida: " + (partes[5].equalsIgnoreCase("true") ? "Sí" : "No"));
                    System.out.println(); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al revisar piezas del autor: " + e.getMessage());
        }
    }

    private static void comprarPiezas(Scanner scanner) {
        System.out.println("Lista de piezas disponibles para comprar:");
        mostrarPiezasNoVendidas();

        System.out.print("Ingrese el nombre de la pieza que desea comprar: ");
        String nombrePieza = scanner.nextLine();

        if (comprarPieza(nombrePieza)) {
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
                if (partes.length == 6 && partes[5].equalsIgnoreCase("false")) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Autor: " + partes[1]);
                    System.out.println("Propietario: " + partes[2]); 
                    System.out.println("Año de creación: " + partes[3]);
                    System.out.println("Tipo: " + partes[4]);
                    System.out.println("Vendida: " + (partes[5].equalsIgnoreCase("true") ? "Sí" : "No"));
                    System.out.println(); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas: " + e.getMessage());
        }
    }
    
    public static List<String> buscarPiezasPorAutor(String nombreAutor) {
        List<String> piezas = new ArrayList<>();
        nombreAutor = nombreAutor.trim().toLowerCase(); // Normaliza el nombre del autor
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 14 && partes[1].trim().toLowerCase().equals(nombreAutor)) { // Normaliza la comparación
                    StringBuilder piezaInfo = new StringBuilder();
                    piezaInfo.append("Nombre de la pieza: ").append(partes[0])
                             .append(", Historia del autor: ").append(partes[13])
                             .append(", Propietario: ").append(partes[2])
                             .append(", Año de creación: ").append(partes[3])
                             .append(", Tipo: ").append(partes[4])
                             .append(", Vendida: ").append(partes[5].equalsIgnoreCase("true") ? "Sí" : "No");
                    if (partes[5].equalsIgnoreCase("true")) {
                        piezaInfo.append(", Método de pago: ").append(partes[6])
                                 .append(", Precio de venta: ").append(partes[9])
                                 .append(", Fecha de venta: ").append(partes[10])
                                 .append(", Hora de venta: ").append(partes[11]);
                    } else {
                        if (partes[6].equals("fijo")) {
                            piezaInfo.append(", Precio: ").append(partes[7]);
                        } else if (partes[6].equals("subasta")) {
                            piezaInfo.append(", Precio mínimo: ").append(partes[8])
                                     .append(", Precio inicial: ").append(partes[9]);
                        }
                    }
                    piezas.add(piezaInfo.toString());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar piezas por autor: " + e.getMessage());
        }
        return piezas;
    }

    public static void buscarPiezasPorAutor(Scanner scanner) {
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();

        List<String> piezas = buscarPiezasPorAutor(nombreAutor);
        if (piezas.isEmpty()) {
            System.out.println("No se encontraron piezas para el autor: " + nombreAutor);
        } else {
            System.out.println("Piezas realizadas por " + nombreAutor + ":");
            for (String pieza : piezas) {
                System.out.println(pieza);
                System.out.println();
            }
        }
    }
    


    public static boolean comprarPieza(String nombrePieza) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH));
            BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt")); 
            
            String linea;
            boolean piezaEncontrada = false;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 6 && partes[0].equalsIgnoreCase(nombrePieza) && partes[5].equalsIgnoreCase("false")) {
                    bw.write(partes[0] + ":" + partes[1] + ":" + partes[2] + ":" + partes[3] + ":true");
                    bw.newLine();
                    piezaEncontrada = true;
                } else {
                    bw.write(linea);
                    bw.newLine();
                }
            }
            
            br.close();
            bw.close();
            
            if (piezaEncontrada) {
                File tempFile = new File("temp.txt");
                File originalFile = new File(PIEZAS_FILE_PATH);
                originalFile.delete();
                tempFile.renameTo(originalFile);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.err.println("Error al comprar pieza: " + e.getMessage());
            return false;
        }
    }

}
