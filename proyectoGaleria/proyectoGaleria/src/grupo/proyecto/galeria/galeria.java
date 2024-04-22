package grupo.proyecto.galeria;

import java.util.ArrayList;
import java.util.List;

import grupo.proyecto.galeria.controladorSubasta.Subasta;
import grupo.proyecto.galeria.persona.Persona;
import grupo.proyecto.galeria.pieza.Pieza;

public class galeria {

	private String nombre;
	private String ubicacion;
	private List<Pieza> piezas;
	private List<Subasta> subastas;
	private List<Persona> usuarios;

	public galeria(String nombre, String ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.piezas = new ArrayList<>();
		this.subastas = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	}

	// sirve para agregar una pieza a la galería
	public void agregarPieza(Pieza pieza) 
	{
		piezas.add(pieza);
	}

	// sirve para iniciar una subasta en la galería
	public void iniciarSubasta() 
	{
		Subasta subasta = new Subasta();
		subasta.realizarSubasta(0, 0, 0, null);
		subastas.add(subasta);
	}

	public String getNombre() 
	{
		return nombre;
	}

	public String getUbicacion() 
	{
		return ubicacion;
	}

	public List<Pieza> getPiezas() 
	{
		return piezas;
	}

	public List<Subasta> getSubastas() 
	{
		return subastas;
	}
	
	public List<Persona> getUsuarios()
	{
		return usuarios;
	}
}
