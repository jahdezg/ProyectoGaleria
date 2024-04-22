package grupo.proyecto.galeria.controladorPiezas;

import java.util.Date;

import grupo.proyecto.galeria.persona.Comprador;
import grupo.proyecto.galeria.pieza.Pieza;

public class Compra 
{

	private Pieza pieza;
	private Comprador comprador;
	private double monto;
	private Date fechaCompra;

	public Compra(Pieza pieza, Comprador comprador, double monto, Date fechaCompra) 
	{
		this.pieza = pieza;
		this.comprador = comprador;
		this.monto = monto;
		this.fechaCompra = fechaCompra;
	}

	public Pieza getPieza() 
	{
		return pieza;
	}

	public Comprador getComprador() 
	{
		return comprador;
	}

	public double getMonto() 
	{
		return monto;
	}

	public Date getFechaCompra() 
	{
        return fechaCompra;
    }

// metodo para validar
public boolean validarCompra() 
	{
        // Implementar la lógica de validación
        return true; // O false si la compra no es válida
	}
 
}
