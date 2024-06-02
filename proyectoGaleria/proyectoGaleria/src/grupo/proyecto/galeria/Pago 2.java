package grupo.proyecto.galeria;

public class Pago {

	private String metodoDePago;
	private boolean pagoRealizado;

	public Pago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
		this.pagoRealizado = false; // Inicialmente el pago no ha sido realizado
	}

	public void procesoPago() {
		// Realizar el proceso de pago
		// Por ejemplo, validar el método de pago, procesar la transacción, etc.
		pagoRealizado = true; // Marcar el pago como realizado
		System.out.println("Pago realizado con éxito.");
	}

	public String getMetodoDePago() {
		return metodoDePago;
	}

	public boolean isPagoRealizado() {
		return pagoRealizado;
	}
}
