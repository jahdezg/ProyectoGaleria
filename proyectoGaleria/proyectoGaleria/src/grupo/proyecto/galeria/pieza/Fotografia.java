package grupo.proyecto.galeria.pieza;

public class Fotografia {

	private String resolucion;
	private String fotografo;

	public Fotografia(String resolucion, String fotografo) {

		this.resolucion = resolucion;
		this.fotografo = fotografo;
	}

	public String getResolucion() {
		return resolucion;
	}

	public String getFotografo() {
		return fotografo;
	}
}