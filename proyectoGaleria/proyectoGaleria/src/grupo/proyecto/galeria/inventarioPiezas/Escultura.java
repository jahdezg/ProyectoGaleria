package grupo.proyecto.galeria.inventarioPiezas;

public class Escultura {
	private String dimensiones;
	private String materiales;
	private float peso;
	private boolean necesita_electricidad;
	private String otros_detalles_instalacion;

	public Escultura(String dimensiones, String materiales, float peso, boolean necesita_electricidad,
			String otros_detalles_instalacion) {
		this.dimensiones = dimensiones;
		this.materiales = materiales;
		this.peso = peso;
		this.necesita_electricidad = necesita_electricidad;
		this.otros_detalles_instalacion = otros_detalles_instalacion;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public String getMateriales() {
		return materiales;
	}

	public float getPeso() {
		return peso;
	}

	public boolean necesitaElectricidad() {
		return necesita_electricidad;
	}

	public String getOtrosDetallesInstalacion() {
		return otros_detalles_instalacion;
	}
}
