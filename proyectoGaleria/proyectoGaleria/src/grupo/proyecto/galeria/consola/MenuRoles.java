package grupo.proyecto.galeria.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            System.out.println("5. Salir");
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
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
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

    private static void registrarPiezaNueva(Scanner scanner) {
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

        System.out.println("Ingrese el método de pago (Fijo/Subasta/Ninguno (si si se vendió)):");
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

        guardarPieza(nombre, autor, propietario, añoCreacion, tipo, vendida, metodoPago, precio, precioMinimo, precioVenta, fechaCompra, horaCompra);

        System.out.println("Pieza registrada exitosamente.");
    }


    
    private static boolean tipoValido(String tipo) {
        String[] tiposValidos = {"escultura", "fotografia", "impresion", "pintura", "video"};
        for (String tipoValido : tiposValidos) {
            if (tipoValido.equals(tipo)) {
                return true;
            }
        }
        System.out.println("Tipo de pieza inválido. Por favor, ingrese un tipo válido.");
        return false;
    }
    
    private static void guardarPieza(String nombre, String autor, String propietario, int añoCreacion, String tipo, boolean vendida, String metodoPago, double precio, double precioMinimo, double precioVenta, String fechaCompra, String horaCompra) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PIEZAS_FILE_PATH, true))) {
            if (vendida) {
                bw.write(nombre + ":" + autor + ":" + propietario + ":" + añoCreacion + ":" + tipo + ":" + vendida + ":" + metodoPago + ":" + precio + ":" + precioMinimo + ":" + String.format("%.2f", precioVenta) + ":" + fechaCompra + ":" + horaCompra);
            } else {
                if (metodoPago.equals("subasta")) {
                    bw.write(nombre + ":" + autor + ":" + propietario + ":" + añoCreacion + ":" + tipo + ":" + vendida + ":" + metodoPago + ":" + precio + ":" + precioMinimo + ":0.0:" + fechaCompra + ":" + horaCompra);
                } else {
                    bw.write(nombre + ":" + autor + ":" + propietario + ":" + añoCreacion + ":" + tipo + ":" + vendida + ":" + metodoPago + ":" + precio + ":0.0:0.0:" + fechaCompra + ":" + horaCompra);
                }
            }
            bw.newLine();
            bw.flush(); 
            System.out.println("Pieza guardada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar pieza: " + e.getMessage());
        }
    }



    private static void mostrarPiezasVendidas() {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 6 && partes[5].equalsIgnoreCase("true")) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Autor: " + partes[1]);
                    System.out.println("Propietario: " + partes[2]);
                    System.out.println("Año de creación: " + partes[3]);
                    System.out.println("Tipo: " + partes[4]);
                    System.out.println("Vendida: Sí");
                    System.out.println("Precio de venta: " + partes[9]);
                    System.out.println("Fecha de venta: " + partes[10]);
                    String horaVenta = partes[11] + ":" + partes[12];
                    System.out.println("Hora de venta: " + horaVenta);
                    System.out.println(); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas vendidas: " + e.getMessage());
        }
    }  


    private static void eliminarPieza(Scanner scanner) {
        System.out.println("Lista de piezas disponibles:");
        mostrarPiezasConID();

        System.out.print("Ingrese el número de la pieza que desea eliminar: ");
        int numeroPiezaEliminar = scanner.nextInt();
        scanner.nextLine(); 

        eliminarPiezaPorID(numeroPiezaEliminar);
    }


    private static void mostrarPiezasConID() {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            System.out.println("Lista de piezas:");
            String linea;
            int contador = 1;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 6) {
                    System.out.println(contador + ". " + partes[0]); 
                    System.out.println("   Autor: " + partes[1]);
                    System.out.println("   Propietario: " + partes[2]); 
                    System.out.println("   Año de creación: " + partes[3]);
                    System.out.println("   Tipo: " + partes[4]);
                    System.out.println("   Vendida: " + (partes[5].equalsIgnoreCase("true") ? "Sí" : "No"));
                    if (partes[5].equalsIgnoreCase("true")) {
                        System.out.println("   Precio de venta: " + partes[7]);
                    } else {
                        System.out.println("   Precio: " + partes[7]);
                        System.out.println("   Precio mínimo: " + partes[8]);
                    }
                    System.out.println(); 
                    contador++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas: " + e.getMessage());
        }
    }


    private static void eliminarPiezaPorID(int id) {
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


    private static void mostrarPiezas() {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            System.out.println("Lista de piezas:");
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 6) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Autor: " + partes[1]);
                    System.out.println("Propietario: " + partes[2]); 
                    System.out.println("Año de creación: " + partes[3]);
                    System.out.println("Tipo: " + partes[4]);
                    System.out.println("Vendida: " + (partes[5].equalsIgnoreCase("true") ? "Sí" : "No"));
                    if (partes[5].equalsIgnoreCase("true")) {
                        System.out.println("Precio de venta: " + partes[7]);
                    } else {
                        System.out.println("Precio: " + partes[7]);
                        System.out.println("Precio mínimo: " + partes[8]);
                    }
                    System.out.println(); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas: " + e.getMessage());
        }
    }
    
    private static void mostrarPiezasNoVendidas2() {
        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 6 && partes[5].equalsIgnoreCase("false")) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Autor: " + partes[1]);
                    System.out.println("Propietario: " + partes[2]);
                    System.out.println("Año de creación: " + partes[3]);
                    System.out.println("Tipo: " + partes[4]);
                    System.out.println("Vendida: No");

                    String metodoPago = partes[6];
                    System.out.println("Método de pago: " + metodoPago);

                    if (metodoPago.equalsIgnoreCase("subasta")) {
                        System.out.println("Precio inicial: " + partes[8]);
                        if (partes.length >= 10) {
                            System.out.println("Precio mínimo: " + partes[9]);
                        } else {
                            System.out.println("No se ha establecido un precio mínimo.");
                        }
                    } else if (metodoPago.equalsIgnoreCase("fijo")) {
                        System.out.println("Precio fijo: " + partes[7]);
                    }

                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas no vendidas: " + e.getMessage());
        }
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

    private static void mostrarPiezasNoVendidas() {
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

    private static boolean comprarPieza(String nombrePieza) {
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