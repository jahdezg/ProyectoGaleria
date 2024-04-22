package grupo.proyecto.galeria.inventarioPiezas;

public class Video {
	private String formato;
	private int duracion;

	public Video(String formato, int duracion) {
		this.formato = formato;
		this.duracion = duracion;
	}

	public String getFormato() {
		return formato;
	}

	public int getDuracion() {
		return duracion;
	}

}
