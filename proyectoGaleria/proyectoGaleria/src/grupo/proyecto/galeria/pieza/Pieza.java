package grupo.proyecto.galeria.pieza;

import java.util.*;


import grupo.proyecto.galeria.persona.Autor;

public abstract class Pieza {
	protected int id;
	protected String titulo;
	protected int anioDeCreacion;
	protected String lugarDeCreacion;
	protected String tipo;
	protected Autor autor;
	protected boolean exhibido;
	protected boolean consignacion;
	protected boolean valorFijo;
	protected boolean piezaBloqueada;
	protected Date fechaCompra;

	public Pieza(int id, String titulo, int anioDeCreacion, String lugarDeCreacion, String tipo, Autor autor,
			boolean exhibido, boolean consignacion, boolean valorFijo, boolean piezaBloqueada, Date fechaCompra) {
		this.id = id;
		this.titulo = titulo;
		this.anioDeCreacion = anioDeCreacion;
		this.lugarDeCreacion = lugarDeCreacion;
		this.tipo = tipo;
		this.autor = autor;
		this.exhibido = exhibido;
		this.consignacion = consignacion;
		this.valorFijo = valorFijo;
		this.piezaBloqueada = piezaBloqueada;
		this.fechaCompra = fechaCompra;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAnioDeCreacion() {
		return anioDeCreacion;
	}

	public String getLugarDeCreacion() {
		return lugarDeCreacion;
	}

	public String getTipo() {
		return tipo;
	}

	public Autor getAutor() {
		return autor;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}
}
