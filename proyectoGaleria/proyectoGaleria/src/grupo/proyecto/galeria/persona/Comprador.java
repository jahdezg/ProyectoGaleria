package grupo.proyecto.galeria.persona;
import java.util.ArrayList;
import java.util.List;
import grupo.proyecto.galeria.controladorPiezas.Compra;
import grupo.proyecto.galeria.pieza.Pieza;

public class Comprador extends Persona {
	public static final String COMPRADOR = "Comprador";
	private int id;
	private String nombre;
	private Boolean verificado;
	private List<Compra> compras;
	private Double limiteCompra;

	public Comprador(int id, String nombre, Boolean verificado, Double limiteCompra) 
	{
		this.id = id;
		this.nombre = nombre;
		this.verificado = verificado;
		compras = new ArrayList<Compra>();
		this.limiteCompra = limiteCompra;
	}

	public void realizarOferta(Pieza pieza, Double valor) 
	{
		return;
    }

	public String getTipoDePersona() 
	{
		return COMPRADOR;
    }
	
	public boolean getVerificado() 
	{
		return verificado;
	}
	
	public List<Compra> getCompras()
	{
		return compras;
	}
	
	public Double getLimiteCompra()
	{
		return limiteCompra;
	}

	public int getId() 
	{
		return id;
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
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
}