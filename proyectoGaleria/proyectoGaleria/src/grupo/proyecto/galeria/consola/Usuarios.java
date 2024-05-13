package grupo.proyecto.galeria.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Usuarios {
    private static final String USUARIOS_FILE_PATH = "usuarios.txt";
    private static final String PIEZAS_FILE_PATH = "piezas.txt";
    private static HashMap<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        cargarUsuarios(); 

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Bienvenido");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    iniciarSesion(scanner);
                    break;
                case 2:
                    registrarUsuario(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);
    }

    private static void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(USUARIOS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    usuarios.put(partes[0], partes[1]);
                } else {
                    System.err.println("Formato de línea incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private static void guardarUsuario(String usuario, String contrasena) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USUARIOS_FILE_PATH, true))) {
            bw.write(usuario + ":" + contrasena);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar usuario: " + e.getMessage());
        }
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasena)) {
            System.out.println("Inicio de sesión exitoso como " + usuario);
            if (usuario.equals("Admin")) { 
                menuAdmin(scanner);
            } 
            else if (usuario.equals("Autor")) {
                menuAutor(scanner, usuario);
            }
            else if (usuario.equals("Oper")) { 
                menuOperador(scanner);
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
        }
    }	


    private static void menuAdmin(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú de administrador");
            System.out.println("1. Registrar una pieza nueva");
            System.out.println("2. Eliminar una pieza");
            System.out.println("3. Mostrar las piezas");
            System.out.println("4. Salir");
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
                    mostrarPiezas();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }

    private static void registrarPiezaNueva(Scanner scanner) {
        System.out.println("Ingrese el nombre de la pieza:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese el nombre del autor:");
        String autor = scanner.nextLine();

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

        guardarPieza(nombre, autor, añoCreacion, tipo, vendida);
        System.out.println("Pieza registrada exitosamente.");
    }
    
    private static boolean tipoValido(String tipo) {
        String[] tiposValidos = {"escultura", "fotografía", "impresión", "pintura", "video"};
        for (String tipoValido : tiposValidos) {
            if (tipoValido.equals(tipo)) {
                return true;
            }
        }
        System.out.println("Tipo de pieza inválido. Por favor, ingrese un tipo válido.");
        return false;
    }

    private static void guardarPieza(String nombre, String autor, int añoCreacion, String tipo, Boolean vendida) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PIEZAS_FILE_PATH, true))) {
            bw.write(nombre + ":" + autor + ":" + añoCreacion + ":" + tipo + ":" + vendida) ;
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar pieza: " + e.getMessage());
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
            String linea;
            int contador = 1;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 4) {
                    System.out.println(contador + ". " + partes[0]); 
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
                if (partes.length == 4) {
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
                if (partes.length == 5) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Autor: " + partes[1]);
                    System.out.println("Año de creación: " + partes[2]);
                    System.out.println("Tipo: " + partes[3]);
                    System.out.println("Vendida: " + (partes[4].equalsIgnoreCase("true") ? "Sí" : "No"));
                    System.out.println(); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar piezas: " + e.getMessage());
        }
    }

    
    private static void menuAutor(Scanner scanner, String usuario) {
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

    private static void revisarPiezasAutor(Scanner scanner) {
        System.out.print("Ingrese su nombre como autor: ");
        String nombreAutor = scanner.nextLine();

        System.out.println("Piezas registradas a nombre de " + nombreAutor + ":");

        try (BufferedReader br = new BufferedReader(new FileReader(PIEZAS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 2 && partes[1].equalsIgnoreCase(nombreAutor)) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Año de creación: " + partes[2]);
                    System.out.println("Tipo: " + partes[3]);
                    System.out.println("Vendida: " + (partes[4].equalsIgnoreCase("true") ? "Sí" : "No"));
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
                if (partes.length == 5 && partes[4].equalsIgnoreCase("false")) {
                    System.out.println("Nombre: " + partes[0]);
                    System.out.println("Autor: " + partes[1]);
                    System.out.println("Año de creación: " + partes[2]);
                    System.out.println("Tipo: " + partes[3]);
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
                if (partes.length == 5 && partes[0].equalsIgnoreCase(nombrePieza) && partes[4].equalsIgnoreCase("false")) {
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
    
    private static void menuOperador(Scanner scanner) {
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


    private static void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese el usuario a registrar: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarios.containsKey(usuario)) {
            System.out.println("El usuario ya existe. Por favor, elija otro nombre de usuario.");
        } else {
            usuarios.put(usuario, contrasena);
            guardarUsuario(usuario, contrasena);
            System.out.println("Usuario registrado exitosamente.");
        }
    }
}

