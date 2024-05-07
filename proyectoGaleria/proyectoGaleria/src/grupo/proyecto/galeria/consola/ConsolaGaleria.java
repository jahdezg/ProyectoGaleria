package grupo.proyecto.galeria.consola;


import java.io.*;
import java.util.*;
import grupo.proyecto.galeria.inventarioPiezas.Pieza;
import grupo.proyecto.galeria.persona.Autor;
import grupo.proyecto.galeria.persona.Persona;



public class ConsolaGaleria 
{
	
	

	
	    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
	    private static List<Persona> personasRegistradas = new ArrayList<>();

	    public static void main(String[] args) 
	    {
	        cargarUsuarios();

	        Scanner scanner = new Scanner(System.in);
	        int opcion;
	        do 
	        {
	        	System.out.println("Elija que tipo usuario es: ");
	            System.out.println("1. Comprador");
	            System.out.println("2. Propietario");
	            System.out.println("3. Cajero");
	            System.out.println("4. Administrador");
	            System.out.println("5. Operador");
	            System.out.println("6. Empleado");
	            System.out.println("7. Salir");
	            System.out.print("Seleccione una opción: ");
//	            System.out.println("Menu del Administrador:");
//	            System.out.println("1. Registrar nueva pieza");
//	            System.out.println("2. Eliminar pieza");
//	            System.out.println("3. Mostrar piezas registradas");
//	            System.out.println("4. Salir");
//	            System.out.print("Seleccione una opción: ");

	            if (scanner.hasNextInt()) 
	            {
	                opcion = scanner.nextInt();
	                scanner.nextLine();
	                	
	                switch (opcion) 
	                {
	                    case 1:
	                        registrarUsuario();
	                        return;
	                    case 2:
	                        eliminarPersona();
	                        return;
	                    case 3:
	                        mostrarPiezas();
	                        return;
	                    case 4:
	                        return;
	                    case 5:
	                    case 6:
	                    case 7:
	                    default:
	                        System.out.println("Opción inválida. Por favor seleccione una opción válida.");
	                }
	            } 
	            else 
	            {
	                scanner.nextLine(); 
	                System.out.println("Opción inválida. Por favor seleccione una opción válida.");
	                opcion = 0; 
	            }
	        } while (opcion != 4);

	        scanner.close();
	    }

	    public static void login()
	    {
	    	System.out.println("Ingrese su usuario: ");
	    	InputStream opcion = System.in;
	    	
	    	System.out.println("Ingrese su contraseña: ");
	    	
	    }

	    
	
}
