package grupo.proyecto.galeria.persona;

public class Empleado extends Persona {

	public static final String EMPLEADO = "Empleado";
	private String nombre;
	private int id;

	public Empleado(String nombre, int id) 
	{
		this.nombre = nombre;
		this.id = id;
	}

	// Métodos
	@Override
	public String getTipoDePersona() 
	{
		return EMPLEADO;
	}

	public void venderPieza() 
	{
		return;
	}

	public void agregarPieza() 
	{
		return;
	}

	public void devolverAlPropietario() 
	{
	}

	@Override
	public void administrarInventario() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarInventario() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getId() 
	{
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

}
