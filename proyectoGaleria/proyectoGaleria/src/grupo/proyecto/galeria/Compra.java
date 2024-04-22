package grupo.proyecto.galeria;

import java.util.Date;

import grupo.proyecto.galeria.inventarioPiezas.Pieza;
import grupo.proyecto.galeria.persona.Comprador;

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
 
}
