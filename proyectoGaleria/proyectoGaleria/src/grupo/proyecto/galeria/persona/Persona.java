package grupo.proyecto.galeria.persona;

public abstract class Persona {

	public Persona() 
	{

	}

	public abstract String getTipoDePersona();

	public abstract void administrarInventario();

	public abstract void actualizarInventario();

	public abstract int getId();
	
	public abstract String getNombre();
}
