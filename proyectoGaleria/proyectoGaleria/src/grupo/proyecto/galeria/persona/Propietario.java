package grupo.proyecto.galeria.persona;

import java.util.ArrayList;
import java.util.List;

import grupo.proyecto.galeria.inventarioPiezas.Pieza;

public class Propietario extends Persona 
{

	  public static final String PROPIETARIO = "Propietario";
	  private List<Pieza> piezas;
	  private List<Pieza> historialPiezas;
	  private int id;
	  private String nombre;
	  
	  public Propietario(int id, String nombre) 
	  {
		  this.id = id;
		  this.nombre = nombre;
		  piezas = new ArrayList<Pieza>();
		  historialPiezas = new ArrayList<Pieza>();
	  }

	  public List<Pieza> consultarEstadoPiezas() {
	    return piezas;
	  }

	  public List<Pieza> consultarHistorialPiezas() {
	    return historialPiezas;
	  }

	  public String getTipoDePersona() {
	    return null;
	  }

	  public int getId() {
	    return  id;
	  }

	@Override
	public void administrarInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
}
