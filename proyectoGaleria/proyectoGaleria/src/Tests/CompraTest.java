package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo.proyecto.galeria.inventarioPiezas.Pieza;
import grupo.proyecto.galeria.persona.Autor;
import grupo.proyecto.galeria.persona.Comprador;

class CompraTest 
{
	Comprador comprador;
	Pieza pieza;
	
	class pieza extends Pieza
	{
	
	public pieza(int id, String titulo, int anioDeCreacion, String lugarDeCreacion, String tipo, Autor autor,
				boolean valorFijo, boolean piezaBloqueada, String fechaCompra, double valor) 
	{
			super(id, titulo, anioDeCreacion, lugarDeCreacion, tipo, autor, valorFijo, piezaBloqueada, fechaCompra, valor);
	}
	
	}

	@BeforeEach
	void setUp() throws Exception 
	{
        comprador = new Comprador("Comprador", "Jaime", "jaime", "lol", true, 15000);
        pieza = new pieza(0, null, 0, null, null, null, false, false, null, 0);
    }
	
	
	@Test
	void realizarOfertaTest() 
	{
		comprador.realizarOferta(null, null, null, null, null, null);
	}

}
