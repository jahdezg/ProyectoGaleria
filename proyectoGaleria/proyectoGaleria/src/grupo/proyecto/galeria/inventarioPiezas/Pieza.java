package grupo.proyecto.galeria.inventarioPiezas;

import java.util.*;


import grupo.proyecto.galeria.persona.Autor;

public abstract class Pieza 
{
	protected double valor;
	protected int id;
	protected String titulo;
	protected int anioDeCreacion;
	protected String lugarDeCreacion;
	protected String tipo;
	protected Autor autor;
	protected boolean exhibido;
	protected boolean consignacion;
	protected boolean valorFijo;
	public boolean piezaBloqueada;
	protected Date fechaCompra;

	public Pieza(int id, String titulo, int anioDeCreacion, String lugarDeCreacion, String tipo, Autor autor,
			boolean exhibido, boolean consignacion, boolean valorFijo, boolean piezaBloqueada, Date fechaCompra,
			double valor) 
	{
		this.id = id;
		this.titulo = titulo;
		this.anioDeCreacion = anioDeCreacion;
		this.lugarDeCreacion = lugarDeCreacion;
		this.tipo = tipo;
		this.autor = autor;
		this.exhibido = exhibido;
		this.consignacion = consignacion;
		this.piezaBloqueada = piezaBloqueada;
		this.fechaCompra = fechaCompra;
		this.valorFijo = valorFijo;
		this.valor = valor;
	}

	public int getId() 
	{
		return id;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public int getAnioDeCreacion() 
	{
		return anioDeCreacion;
	}

	public String getLugarDeCreacion() 
	{
		return lugarDeCreacion;
	}

	public String getTipo() 
	{
		return tipo;
	}

	public Autor getAutor() 
	{
		return autor;
	}

	public Date getFechaCompra() 
	{
		return fechaCompra;
	}
	
	public boolean getValorFijo()
	{
		return valorFijo;
	}
	
	public boolean getPiezaBloqueada()
	{
		return piezaBloqueada;
	}

	public double getValor() 
	{
		return valor;
	}
}
