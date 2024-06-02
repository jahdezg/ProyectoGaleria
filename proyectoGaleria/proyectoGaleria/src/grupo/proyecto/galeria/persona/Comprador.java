package grupo.proyecto.galeria.persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import grupo.proyecto.galeria.Compra;
import grupo.proyecto.galeria.galeria;
import grupo.proyecto.galeria.inventarioPiezas.Pieza;

public class Comprador extends Persona 
{
	public static final String tipo = "Comprador";
	private String nombre;
	private String username;
	private String contrasenia;
	private boolean verificado = false;
	private List<Compra> compras;
	private double limiteCompra;

	public Comprador(String tipo, String nombre, String username, String contrasenia, boolean verificado, double limiteCompra) 
	{
		super(tipo, nombre, username, contrasenia);
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
			Comprador comprador = new Comprador(getTipo(), getNombre(), getUsername(), getContrasenia(), getVerificado(), getLimiteCompra());
			boolean verificar = administrador.verificarCompra(comprador, monto, usuarios, pieza);
			if (verificar == true)
			{				
				Compra compra = new Compra(pieza, comprador, monto, fechaCompra);
				administrador.registrarCompra(compra, compras);
			}
		}
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