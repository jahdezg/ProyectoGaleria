package grupo.proyecto.galeria.persona;

import java.util.ArrayList;
import java.util.List;

import grupo.proyecto.galeria.inventarioPiezas.Pieza;

public class Propietario extends Persona 
{

	  public static final String tipo = "Propietario";
	  private List<Pieza> piezas;
	  private List<Pieza> historialPiezas;
	  private String username;
	  private String nombre;
	  private String contrasenia;
	  
	  public Propietario(String tipo, String nombre, String username, String contrasenia) 
	  {
		  super(tipo, nombre, username, contrasenia);
		  piezas = new ArrayList<Pieza>();
		  historialPiezas = new ArrayList<Pieza>();
	  }

	  public List<Pieza> consultarEstadoPiezas() {
	    return piezas;
	  }

	  public List<Pieza> consultarHistorialPiezas() {
	    return historialPiezas;
	  }

	  @Override
		public String getNombre() 
		{
			return nombre;
		}

		@Override
		public String getTipo() 
		{
			return tipo;
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
