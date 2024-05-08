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
	        int opcion2;
	        int opcion3;
	        boolean verificado;
	        
	        do
	        {
	        	System.out.println("Elija que desea hacer:");
	            System.out.println("1. Modificar usuarios");
	            System.out.println("2. Ingresar como usuario");
	            System.out.println("3. Salir");
	            System.out.println("Seleccione una opción: ");
	            opcion = scanner.nextInt();
	            switch(opcion)
	            {
	            	case 1:
	            		System.out.println("Creador de Usuarios:");
	    	            System.out.println("1. Registrar Usuario");
	    	            System.out.println("2. Eliminar Usuario");
	    	            System.out.println("3. Mostrar Usuarios registrados");
	    	            System.out.println("Seleccione una opción: ");
	    	            opcion2 = scanner.nextInt();
	    	            switch(opcion2) 
	    	                {
	    	                    case 1:
	    	                        registrarUsuario();
	    	                        break;
	    	                    case 2:
	    	                        eliminarPersona();
	    	                        break;
	    	                    case 3:
	    	                        mostrarPersonas();
	    	                        break;
	    		            }
	            		break;
	            	case 2:
	            		System.out.println("Elija que tipo usuario es: ");
	    	            System.out.println("1. Comprador");
	    	            System.out.println("2. Propietario");
	    	            System.out.println("3. Cajero");
	    	            System.out.println("4. Administrador");
	    	            System.out.println("5. Operador");
	    	            System.out.println("6. Empleado");
	    	            System.out.print("Seleccione una opción: ");
	    	            opcion3 = scanner.nextInt();
	    	            switch (opcion3) 
	    	                {
	    	                    case 1:
	    	                        verificado = login(personasRegistradas);
	    	                        if (verificado) {System.out.println("El usuario existe");}
	    	                        else {System.out.println("Usuario no encontrado");}
	    	                        break;
	    	                    case 2:
	    	                        verificado = login(personasRegistradas);
	    	                        break;
	    	                    case 3:
	    	                        verificado = login(personasRegistradas);
	    	                        break;
	    	                    case 4:
	    	                        verificado = login(personasRegistradas);
	    	                        break;
	    	                    case 5:
	    	                        verificado = login(personasRegistradas);
	    	                        break;
	    	                    case 6:
	    	                        verificado = login(personasRegistradas);
	    	                        break;
	    	                }
	            		break;
	            	case 3:
	            		System.out.println("Ha elegido SALIR");
	            }
	        } while (opcion != 3);
	        scanner.close();
	    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	    
	    
	    
	    public static boolean login(List<Persona> personasRegistradas)
	    {
	    	int i = 0;
	    	boolean verificado = false;
	    	List<String> listaUsuarios = new ArrayList<String>();
	    	List<String> listaContrasenias = new ArrayList<String>();
	    	for (Persona persona : personasRegistradas)
	    	{
	    		listaUsuarios.add(persona.getUsername());
	    		listaContrasenias.add(persona.getContrasenia());
	    	}
	    	Scanner scn = new Scanner(System.in);
	    	while((i<3) || (verificado == false))
	    	{
	    	System.out.println("Ingrese su usuario: ");
	    	String usuario = scn.nextLine();
	    	System.out.println("Ingrese su contraseña: ");
	    	String contrasenia = scn.nextLine();
	    	if((listaUsuarios.contains(usuario)) && (listaContrasenias.contains(contrasenia))) {verificado = true;}
	    	i++;
	    	}
	    	scn.close();
	    	return verificado;
	    }
	    
	    public static void registrarUsuario() 
	    {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Ingrese el tipo de Usuario: ");
	        String tipo = scanner.nextLine();
	        System.out.println("Ingrese el Nombre del usuario: ");
	        String nombre = scanner.nextLine();
	        System.out.println("Ingrese el Username deseado: ");
	        String username = scanner.nextLine();
	        System.out.println("Ingrese la contraseña deseada: ");
	        String contrasenia = scanner.nextLine();

	        Persona nuevaPersona = new persona(tipo, nombre, username, contrasenia);

	        personasRegistradas.add(nuevaPersona);

	        guardarPersona();

	        System.out.println("La pieza se ha registrado correctamente.");
	        

	    }
	    
	    public static void eliminarPersona() 
	    {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Piezas registradas:");
	        for (int i = 0; i < personasRegistradas.size(); i++) 
	        {
	            System.out.println((i + 1) + ". " + personasRegistradas.get(i));
	        }

	        System.out.println("Ingrese el número de la pieza que desea eliminar:");
	        int numeroPersona = scanner.nextInt();
	        scanner.nextLine();

	        if (numeroPersona >= 1 && numeroPersona <= personasRegistradas.size()) 
	        {
	            personasRegistradas.remove(numeroPersona - 1);

	            guardarPersona();

	            System.out.println("La pieza se ha eliminado correctamente.");
	        } 
	        else 
	        {
	            System.out.println("Número de pieza inválido. No se ha eliminado ninguna pieza.");
	        }

	    }
	    
	    public static void mostrarPersonas() 
	    {
	        System.out.println("Usuarios registrados:");
	        for (int i = 0; i < personasRegistradas.size(); i++) 
	        {
	            System.out.println((i + 1) + ". " + personasRegistradas.get(i));
	        }
	    }
	    
	    private static void guardarPersona() 
	    {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_USUARIOS))) 
	        {
	            for (Persona usuario : personasRegistradas) 
	            {
	                writer.println(usuario.getTipo() + "," + usuario.getNombre() + "," + usuario.getUsername() + "," + usuario.getContrasenia());
	            }
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	    }
	    
	    private static void cargarUsuarios() 
	    {
	        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) 
	        {
	            String linea;
	            while ((linea = reader.readLine()) != null) 
	            {
	                String[] partes = linea.split(",");
	                String tipo = partes[0];
	                String nombre = partes[1];
	                String username = partes[2];
	                String contrasenia = partes[3];
	                personasRegistradas.add(new persona(tipo, nombre, username, contrasenia));
	            }
	        } 
	        catch (IOException e) 
	        {}
	    }
	    
	    static class persona extends Persona
	    {
	    	public persona(String tipo, String nombre, String username, String contrasenia) 
	    	{
	    		super(tipo, nombre, username, contrasenia);
	    	}

	    	@Override
	    	public String getTipo() 
	    	{
	    		return tipo;
	    	}

	    	@Override
	    	public String getNombre() 
	    	{
	    		return nombre;
	    	}

	    	@Override
	    	public String getUsername() 
	    	{
	    		return username;
	    	}

	    	@Override
	    	public String getContrasenia() 
	    	{
	    		return contrasenia;
	    	}
	    }
	
}
