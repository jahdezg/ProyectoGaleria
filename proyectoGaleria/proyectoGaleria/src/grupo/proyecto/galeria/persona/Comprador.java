package grupo.proyecto.galeria.persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import grupo.proyecto.galeria.Compra;
import grupo.proyecto.galeria.galeria;
import grupo.proyecto.galeria.inventarioPiezas.Pieza;

public class Comprador extends Persona {
	public static final String COMPRADOR = "Comprador";
	private int id;
	private String nombre;
	private Boolean verificado;
	private List<Compra> compras;
	private double limiteCompra;

	public Comprador(int id, String nombre, Boolean verificado, Double limiteCompra) 
	{
		this.id = id;
		this.nombre = nombre;
		this.verificado = verificado;
		compras = new ArrayList<Compra>();
		this.limiteCompra = limiteCompra;
	}

	public void realizarOferta(Pieza pieza, Double monto, Administrador administrador, galeria galeria,
			Date fechaCompra, List<Compra> compras) 
	{
		if ((pieza.getValorFijo() == true) && (pieza.piezaBloqueada == false))
		{
			pieza.piezaBloqueada = true;
			List<Persona> usuarios = galeria.getUsuarios();
			Comprador comprador = new Comprador(getId(), getNombre(), getVerificado(), getLimiteCompra());
			boolean verificar = administrador.verificarCompra(comprador, monto, usuarios, pieza);
			if (verificar == true)
			{				
				Compra compra = new Compra(pieza, comprador, monto, fechaCompra);
				administrador.registrarCompra(compra, compras);
			}
		}
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
	
	public double getLimiteCompra()
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