package grupo.proyecto.galeria.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioTipo {
    private static final String USUARIOS_FILE_PATH = "usuarios.txt";
    private static HashMap<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        cargarUsuarios();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Bienvenido");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar usuario (Opción para registrar Propietario o Comprador)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        iniciarSesion(scanner);
                        break;
                    case 2:
                        registrarUsuarioConsola(scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);
        scanner.close();
    }

    public static void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(USUARIOS_FILE_PATH))) {
            String linea;
            int lineaNumero = 1;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(":");
                if (partes.length == 3) {
                    usuarios.put(partes[0], partes[1] + ":" + partes[2]);
                } else {
                    System.err.println("Formato de línea incorrecto en la línea " + lineaNumero + ": " + linea);
                }
                lineaNumero++;
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    public static void guardarUsuario(String usuario, String contrasena, String rol) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USUARIOS_FILE_PATH, true))) {
            bw.write(usuario + ":" + contrasena + ":" + rol);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar usuario: " + e.getMessage());
        }
    }

    public static boolean iniciarSesion(String usuario, String contrasena) {
        if (usuarios.containsKey(usuario)) {
            String[] datosUsuario = usuarios.get(usuario).split(":");
            String contraseñaAlmacenada = datosUsuario[0];
            return contraseñaAlmacenada.equals(contrasena);
        } else {
            return false;
        }
    }

    public static String obtenerRol(String usuario) {
        if (usuarios.containsKey(usuario)) {
            String[] datosUsuario = usuarios.get(usuario).split(":");
            return datosUsuario[1];
        }
        return null;
    }

    public static void registrarUsuario(String usuario, String contrasena, String rol) {
        usuarios.put(usuario, contrasena + ":" + rol);
        guardarUsuario(usuario, contrasena, rol);
        crearArchivoUsuario(usuario);
    }

    public static void crearArchivoUsuario(String usuario) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(usuario + ".txt"))) {
            bw.write("Registro para " + usuario);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al crear archivo para el usuario: " + e.getMessage());
        }
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (iniciarSesion(usuario, contrasena)) {
            String rol = obtenerRol(usuario);
            System.out.println("Inicio de sesión exitoso como " + usuario);
            switch (rol) {
                case "Administrador":
                    MenuRoles.menuAdmin(scanner);
                    break;
                case "Autor":
                    MenuRoles.menuAutor(scanner, usuario);
                    break;
                case "Oper":
                    MenuRoles.menuOperador(scanner);
                    break;
                case "Propietario":
                    mostrarMenuPorRol(rol, scanner, usuario);
                    break;
                case "Comprador":
                    mostrarMenuPorRol(rol, scanner, usuario);
                    break;
                case "Cajero":
                    MenuCajero.menuCajero(scanner);
                    break;
                default:
                    System.out.println("Rol desconocido. Por favor, contacte al administrador.");
            }
        } else {
            System.out.println("Contraseña incorrecta. Por favor, inténtelo de nuevo.");
        }
    }

    private static void registrarUsuarioConsola(Scanner scanner) {
        System.out.print("Ingrese el usuario a registrar: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.println("Seleccione su rol:");
        System.out.println("1. Comprador");
        System.out.println("2. Propietario");
        System.out.print("Seleccione una opción: ");
        int opcionRol = scanner.nextInt();
        scanner.nextLine();
        String rol;
        switch (opcionRol) {
            case 1:
                rol = "Comprador";
                break;
            case 2:
                rol = "Propietario";
                break;
            default:
                System.out.println("Opción inválida. Se asignará el rol por defecto: Comprador.");
                rol = "Comprador";
        }

        registrarUsuario(usuario, contrasena, rol);
        System.out.println("Usuario registrado exitosamente como " + rol);
        mostrarMenuPorRol(rol, scanner, usuario);
    }

    private static void mostrarMenuPorRol(String rol, Scanner scanner, String nombrePropietario) {
        if (rol.equals("Comprador")) {
            MenuComprador.menuComprador(scanner, nombrePropietario);
        } else if (rol.equals("Propietario")) {
            MenuPropietario.menuPropietario(scanner, nombrePropietario);
        }
    }
}