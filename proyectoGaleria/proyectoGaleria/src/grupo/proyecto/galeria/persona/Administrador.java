package grupo.proyecto.galeria.persona;

import java.util.List;

import grupo.proyecto.galeria.Compra;
import grupo.proyecto.galeria.inventarioPiezas.Pieza;

public class Administrador extends Persona {


	private String nombre;
	private static String tipo = "Administrador";
	private static String username;
	private static String contrasenia;

	public Administrador(String tipo, String nombre, String username, String contrasenia) 
	{
		super(tipo, nombre, username, contrasenia);
	}
	
	public void venderPieza(Comprador comprador, Pieza pieza)
	{
		
	}

	public void registrarNuevaPieza() {

	}

	public void registrarNuevaVenta() {

	}

	public void registrarDevolucion() {

	}

	public boolean marcarPiezaBloqueada(Pieza pieza) {

		return false;
	}

	public boolean verificarCompra(Comprador comprador, double oferta, List<Persona> usuarios, Pieza pieza) 
	{
		if ((usuarios.contains(comprador) == true) && (oferta >= pieza.getValor()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void verificarLimiteCompra(Comprador comprador) {

	}

	public void aumentarLimiteCompra(Comprador comprador, double nuevoLimite) {

	}

	public void registrarCompra(Compra compra, List<Compra> compras) 
	{
		compras.add(compra);
	}

	public void administrarInventario() 
	{

	}

	public void actualizarInventario() 
	{
	
	}

	@Override
	public String getNombre() 
	{
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String getTipo() 
	{
		// TODO Auto-generated method stub
		return tipo;
	}

	@Override
	public String getUsername() 
	{
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public String getContrasenia() 
	{
		// TODO Auto-generated method stub
		return contrasenia;
	}
}
