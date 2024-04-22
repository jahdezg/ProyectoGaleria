package grupo.proyecto.galeria.persona;

import grupo.proyecto.galeria.controladorPiezas.Compra;
import grupo.proyecto.galeria.pieza.Pieza;

public class Administrador extends Persona {

	public static final String ADMINISTRADOR = "Administrador";

	private String nombre;
	private int id;

	public Administrador(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
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

	public boolean verificarComprador(Comprador comprador, int oferta) {

		return false;
	}

	public void verificarLimiteCompra(Comprador comprador) {

	}

	public void aumentarLimiteCompra(Comprador comprador, double nuevoLimite) {

	}

	public void registrarCompra(Comprador comprador, Compra compra) {

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
