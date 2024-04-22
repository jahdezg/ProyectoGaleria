package grupo.proyecto.galeria.pieza;

public class Impresion {
	private int tamanioDeEdicion;
	private String tecnicaDeImpresion;

	public Impresion(int tamanioDeEdicion, String tecnicaDeImpresion) {
		this.tamanioDeEdicion = tamanioDeEdicion;
		this.tecnicaDeImpresion = tecnicaDeImpresion;
	}

	public int getTamanioDeEdicion() {
		return tamanioDeEdicion;
	}

	public String getTecnicaDeImpresion() {
		return tecnicaDeImpresion;
	}
}
