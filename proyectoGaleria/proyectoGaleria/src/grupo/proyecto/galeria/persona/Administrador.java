package grupo.proyecto.galeria.persona;

import java.util.List;

import grupo.proyecto.galeria.Compra;
import grupo.proyecto.galeria.pieza.Pieza;

public class Administrador extends Persona {

	public static final String ADMINISTRADOR = "Administrador";

	private String nombre;
	private int id;

	public Administrador(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	public void venderPieza(Comprador comprador, Pieza pieza)
	{
		
	}

	@Override
	public String getTipoDePersona() {
		return ADMINISTRADOR;
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

	@Override
	public void administrarInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarInventario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
}
