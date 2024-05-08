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
	        ConsolaPersonasRegistro.cargarUsuarios();

	        Scanner scanner = new Scanner(System.in);
	        int opcion;
	        boolean verificado;
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

	                opcion = scanner.nextInt();
               	
	                switch (opcion) 
	                {
	                    case 1:
	                        System.out.println("Ha elegido Comprador");
	                        verificado = login();
	                        if(verificado)
	                        {}
	                        else
	                        {
	                        	System.out.println("Usuario y/o contraseña incorrectos");
	                        }
	                        break;
	                    case 2:
	                    	System.out.println("Ha elegido Propietario");
	                    	verificado = login();
	                        if(verificado)
	                        {}
	                        else
	                        {
	                        	System.out.println("Usuario y/o contraseña incorrectos");
	                        }
	                        break;
	                    case 3:
	                    	System.out.println("Ha elegido Cajero");
	                    	verificado = login();
	                        if(verificado)
	                        {}
	                        else
	                        {
	                        	System.out.println("Usuario y/o contraseña incorrectos");
	                        }
	                        break;
	                    case 4:
	                    	System.out.println("Ha elegido Administrador");
	                    	verificado = login();
	                        if(verificado)
	                        {}
	                        else
	                        {
	                        	System.out.println("Usuario y/o contraseña incorrectos");
	                        }
	                    	break;
	                    case 5:
	                    	System.out.println("Ha elegido Operador");
	                    	verificado = login();
	                        if(verificado)
	                        {}
	                        else
	                        {
	                        	System.out.println("Usuario y/o contraseña incorrectos");
	                        }
	                    	break;
	                    case 6:
	                    	System.out.println("Ha elegido Empleado");
	                    	verificado = login();
	                        if(verificado)
	                        {}
	                        else
	                        {
	                        	System.out.println("Usuario y/o contraseña incorrectos");
	                        }
	                    	break;
	                    case 7:
	                    	System.out.println("Ha elegido la opcion SALIR");
	                    	break;
	                    default:
	                        System.out.println("Opción inválida. Por favor seleccione una opción válida.");
	                }	             	            
	        } while (opcion != 7);

	        scanner.close();
	    }

	    public static boolean login()
	    {	
	    	int i = 0;
	    	String username;
	    	String contrasenia;
	    	List<String> listaUsuarios = new ArrayList<>();
	    	List<String> listaContrasenias = new ArrayList<>();
	    	for (Persona persona : personasRegistradas)
	    	{
	    		listaUsuarios.add(persona.getUsername());
	    		listaContrasenias.add(persona.getContrasenia());
	    		System.out.println(persona.getUsername());
	    		System.out.println(persona.getContrasenia());
	    	}
	    	boolean verificado = false;
	    	Scanner scanner = new Scanner(System.in);
	    	do 
	    	{
	    		System.out.println("Ingrese su usuario: ");
	    		username = scanner.nextLine();	    	
	    		System.out.println("Ingrese su contraseña: ");
	    		contrasenia = scanner.nextLine();
	    		if ((listaUsuarios.contains(username)) && (listaContrasenias.contains(contrasenia)))
	    		{
	    			verificado = true;
	    		}
	    		else
	    		{
	    			verificado = false;
	    			System.out.println("contraseña incorrecta, intente de nuevo");
	    			i++;
	    		}
	    	}while((verificado == false) || i < 3);
	    	scanner.close();
	    	return verificado;

	    }

	    
	
}
