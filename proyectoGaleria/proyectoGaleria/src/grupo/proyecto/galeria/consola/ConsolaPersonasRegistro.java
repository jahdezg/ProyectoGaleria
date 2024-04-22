package grupo.proyecto.galeria.consola;

import java.io.*;
import java.util.*;

public class ConsolaPersonasRegistro {
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    private static List<Usuario> usuariosRegistrados = new ArrayList<>();

    public static void main(String[] args) {
        cargarUsuarios();

        Usuario usuario = roles();

        if (usuario != null) {
            System.out.println(usuario.getNombre().getValor() + " ha seleccionado el rol de " + usuario.getRol().getValor());
        }

        System.out.println("Usuarios registrados:");
        for (Usuario u : usuariosRegistrados) {
            System.out.println(u.getNombre().getValor() + " - " + u.getRol().getValor());
        }

        scanner.close();
    }

    private static Scanner scanner = new Scanner(System.in);

    public static Usuario roles() {
        Map<Integer, Rol> roles = new HashMap<>();
        roles.put(1, new Rol("Administrador"));
        roles.put(2, new Rol("Autor"));
        roles.put(3, new Rol("Cajero"));
        roles.put(4, new Rol("Comprador"));
        roles.put(5, new Rol("Empleado"));
        roles.put(6, new Rol("Operador"));
        roles.put(7, new Rol("Propietario"));

        System.out.println("Por favor ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Los roles disponibles son:");
        for (Map.Entry<Integer, Rol> entry : roles.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getValor());
        }

        System.out.println("Por favor ingrese el número correspondiente al rol:");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        if (roles.containsKey(opcion)) {
            Rol rolSeleccionado = roles.get(opcion);


            Usuario nuevoUsuario = new Usuario(new Nombre(nombre), rolSeleccionado);


            usuariosRegistrados.add(nuevoUsuario);


            guardarUsuarios();


            return nuevoUsuario;
        } else {
            System.out.println("Opción inválida. Por favor seleccione un número válido.");


            return null;
        }
    }

    private static void guardarUsuarios() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_USUARIOS))) {
            for (Usuario usuario : usuariosRegistrados) {
                writer.println(usuario.getNombre().getValor() + "," + usuario.getRol().getValor());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarUsuarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) { 
                    String nombre = partes[0];
                    String rol = partes[1];
                    usuariosRegistrados.add(new Usuario(new Nombre(nombre), new Rol(rol)));
                } else {
                    System.out.println("Menu: " + linea);
                }
            }
        } catch (IOException e) {
            
        }
    }
}

class Nombre {
    private String valor;

    public Nombre(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

class Rol {
    private String valor;

    public Rol(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

class Usuario {
    private Nombre nombre;
    private Rol rol;

    public Usuario(Nombre nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }
}
