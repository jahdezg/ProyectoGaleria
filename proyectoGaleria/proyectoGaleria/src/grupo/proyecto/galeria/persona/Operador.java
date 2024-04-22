package grupo.proyecto.galeria.persona;

import grupo.proyecto.galeria.controladorSubasta.Subasta;

public class Operador extends Persona {
	private int id;
	private String nombre;

	public Operador(int id, String nombre)
	{
    this.id = id;
    this.nombre = nombre;
	}

	public void registrarOferta(Subasta subasta, Double oferta, Comprador comprador) {
		return;
	}

	public String getTipoDePersona() {
		return null;
	}

	public int getId() {
		return id;
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