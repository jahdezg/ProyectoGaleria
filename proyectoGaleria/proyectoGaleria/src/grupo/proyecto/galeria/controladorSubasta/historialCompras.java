package grupo.proyecto.galeria.controladorSubasta;

import java.util.HashMap;
import java.util.Map;

import grupo.proyecto.galeria.inventarioPiezas.Pieza;
import grupo.proyecto.galeria.persona.Comprador;

public class historialCompras {
	private Map<Pieza, Map<Comprador, Double>> ofertasRealizadas;

	public historialCompras() {
		this.ofertasRealizadas = new HashMap<>();
	}

	// puede servir para registrar una oferta
	public void registrarOferta(Pieza pieza, Comprador comprador, double monto) {
		// Si la pieza no está en el historial, la agregamos con un nuevo mapa de
		// ofertas
		ofertasRealizadas.putIfAbsent(pieza, new HashMap<>());
		// Obtenemos el mapa de ofertas para la pieza y registramos la oferta del
		// comprador con el monto
		ofertasRealizadas.get(pieza).put(comprador, monto);
	}

	// Métodos para obtener información del historial
	public Map<Comprador, Double> obtenerOfertasPorPieza(Pieza pieza) {
		// Obtenemos el mapa de ofertas para la pieza específica
		return ofertasRealizadas.getOrDefault(pieza, new HashMap<>());
	}

	public Map<Pieza, Map<Comprador, Double>> obtenerTodasLasOfertas() {
		return ofertasRealizadas;
	}
}
