package grupo.proyecto.galeria.persona;

import grupo.proyecto.galeria.Compra;
import grupo.proyecto.galeria.Pago;
import grupo.proyecto.galeria.pieza.Pieza;

public class Cajero extends Persona {

	public static final String CAJERO = "Cajero";

	private String nombre;
	private int id;

	public Cajero(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}

	@Override
	public String getTipoDePersona() {
		return CAJERO;
	}

	public void registroDePago(Compra compra, String metodoDePago, Pago pago, Comprador comprador,
			Propietario propietario, Pieza pieza) {

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
