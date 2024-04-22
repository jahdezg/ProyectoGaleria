package grupo.proyecto.galeria.consola;

import java.io.*;
import java.util.*;

public class ConsolaAdministradorPiezas {
    private static final String ARCHIVO_PIEZAS = "piezas.txt";
    private static List<Pieza> piezasRegistradas = new ArrayList<>();

    public static void main(String[] args) {
        cargarPiezas();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu del Administrador:");
            System.out.println("1. Registrar nueva pieza");
            System.out.println("2. Eliminar pieza");
            System.out.println("3. Mostrar piezas registradas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarPieza();
                        return;
                    case 2:
                        eliminarPieza();
                        return;
                    case 3:
                        mostrarPiezas();
                        return;
                    case 4:
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor seleccione una opción válida.");
                }
            } else {
                scanner.nextLine(); 
                System.out.println("Opción inválida. Por favor seleccione una opción válida.");
                opcion = 0; 
            }
        } while (opcion != 4);

        scanner.close();
    }


    public static void registrarPieza() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la pieza:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el año de creación de la pieza:");
        int añoCreacion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el tipo de pieza:");
        String tipo = scanner.nextLine();

        System.out.println("¿La pieza se vendió? (Sí/No):");
        boolean vendida = scanner.nextLine().equalsIgnoreCase("Sí");

        Pieza nuevaPieza = new Pieza(nombre, añoCreacion, tipo, vendida);

        piezasRegistradas.add(nuevaPieza);

        guardarPiezas();

        System.out.println("La pieza se ha registrado correctamente.");
        
        scanner.close();
    }

    public static void eliminarPieza() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Piezas registradas:");
        for (int i = 0; i < piezasRegistradas.size(); i++) {
            System.out.println((i + 1) + ". " + piezasRegistradas.get(i));
        }

        System.out.println("Ingrese el número de la pieza que desea eliminar:");
        int numeroPieza = scanner.nextInt();
        scanner.nextLine();

        if (numeroPieza >= 1 && numeroPieza <= piezasRegistradas.size()) {
            piezasRegistradas.remove(numeroPieza - 1);

            guardarPiezas();

            System.out.println("La pieza se ha eliminado correctamente.");
        } else {
            System.out.println("Número de pieza inválido. No se ha eliminado ninguna pieza.");
        }
        scanner.close();
    }

    public static void mostrarPiezas() {
        System.out.println("Piezas registradas:");
        for (int i = 0; i < piezasRegistradas.size(); i++) {
            System.out.println((i + 1) + ". " + piezasRegistradas.get(i));
        }
    }

    private static void guardarPiezas() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_PIEZAS))) {
            for (Pieza pieza : piezasRegistradas) {
                writer.println(pieza.getNombre() + "," + pieza.getAñoCreacion() + "," + pieza.getTipo() + "," + pieza.isVendida());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarPiezas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_PIEZAS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int añoCreacion = Integer.parseInt(partes[1]);
                String tipo = partes[2];
                boolean vendida = Boolean.parseBoolean(partes[3]);
                piezasRegistradas.add(new Pieza(nombre, añoCreacion, tipo, vendida));
            }
        } catch (IOException e) {
        }
    }
}

class Pieza {
    private String nombre;
    private int añoCreacion;
    private String tipo;
    private boolean vendida;

    public Pieza(String nombre, int añoCreacion, String tipo, boolean vendida) {
        this.nombre = nombre;
        this.añoCreacion = añoCreacion;
        this.tipo = tipo;
        this.vendida = vendida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAñoCreacion() {
        return añoCreacion;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isVendida() {
        return vendida;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Año de creación: " + añoCreacion + ", Tipo: " + tipo + ", Vendida: " + (vendida ? "Sí" : "No");
    }
}
