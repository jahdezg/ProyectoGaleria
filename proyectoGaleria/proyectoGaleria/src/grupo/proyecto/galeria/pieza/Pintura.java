package grupo.proyecto.galeria.pieza;

public class Pintura {

	private String medioDePintura;
	private String materialDeMarco;

	public Pintura(String medioDePintura, String materialDeMarco) {
		this.medioDePintura = medioDePintura;
		this.materialDeMarco = materialDeMarco;
	}

	public String getMedioDePintura() {
		return medioDePintura;
	}

	public String getMaterialDeMarco() {
		return materialDeMarco;
	}
}
