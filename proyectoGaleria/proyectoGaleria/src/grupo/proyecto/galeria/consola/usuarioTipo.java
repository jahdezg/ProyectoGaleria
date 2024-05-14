package grupo.proyecto.galeria.consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class usuarioTipo {
    private static final String USUARIOS_FILE_PATH = "usuarios.txt";
    private static HashMap<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        cargarUsuarios(); 

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Bienvenido");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar usuario (Opcion para registrar Propietario o Comprador)");
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
                        registrarUsuario(scanner);
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

    private static void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(USUARIOS_FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 3) {
                    usuarios.put(partes[0], partes[1] + ":" + partes[2]);
                } else {
                    System.err.println("Formato de línea incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }




    private static void guardarUsuario(String usuario, String contrasena, String rol) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USUARIOS_FILE_PATH, true))) {
            bw.write(usuario + ":" + contrasena + ":" + rol);
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

        if (usuarios.containsKey(usuario)) {
            String[] datosUsuario = usuarios.get(usuario).split(":");
            String contraseñaAlmacenada = datosUsuario[0];
            String rol = datosUsuario[1];
            if (contraseñaAlmacenada.equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso como " + usuario);
                if (rol.equals("Admin")) { 
                    MenuRoles.menuAdmin(scanner);
                } 
                else if (rol.equals("Autor")) {
                    MenuRoles.menuAutor(scanner, usuario);
                }
                else if (rol.equals("Oper")) { 
                    MenuRoles.menuOperador(scanner);
                }
                else if (rol.equals("Propietario")) {
                    mostrarMenuPorRol(rol, scanner, usuario);
                }
                else if (rol.equals("Comprador")) {
                    mostrarMenuPorRol(rol, scanner, usuario);
                }
                else if (rol.equals("Cajero")) {
                    MenuCajero.menuCajero(scanner);
                }
            } else {
                System.out.println("Contraseña incorrecta. Por favor, inténtelo de nuevo.");
            }
        } else {
            System.out.println("Usuario no encontrado. Por favor, regístrese primero.");
        }
    }




    private static void registrarUsuario(Scanner scanner) {
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

        usuarios.put(usuario, rol);
        guardarUsuario(usuario, contrasena, rol);
        System.out.println("Usuario registrado exitosamente como " + rol);
        mostrarMenuPorRol(rol, scanner, rol);
    }

    private static void mostrarMenuPorRol(String rol, Scanner scanner, String nombrePropietario) {
        if (rol.equals("Comprador")) {
            MenuComprador.menuComprador(scanner, nombrePropietario);
        } else if (rol.equals("Propietario")) {
        	MenuPropietario.menuPropietario(scanner, nombrePropietario);
        }
    }

}
