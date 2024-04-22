package grupo.proyecto.galeria.controladorSubasta;
import java.util.ArrayList;
import java.util.List;

import grupo.proyecto.galeria.persona.Comprador;

public class Subasta 
{
	private int idSubasta;
	private double valorInicial;
	private double valorMinimo;
	private List<Comprador> participantesVerificados;
	
	public void realizarSubasta(int idSubasta, double valorInicial, double valorMinimo, List<Comprador> participantesVerificados) 
	{
		this.idSubasta = idSubasta;
		this.valorInicial = valorInicial;
		this.valorMinimo = valorMinimo;
		this.participantesVerificados = new ArrayList<>();
	}

	// Método para agregar un participante verificado
	public void agregarParticipante(Comprador comprador) {
		participantesVerificados.add(comprador);
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}
	
	public int getIdSubasta()
	{
		return idSubasta;
	}

	public List<Comprador> getParticipantesVerificados() {
		return participantesVerificados;
	}

	// Métodos de establecimiento (si llegan a ser necesarios)
	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public void setParticipantesVerificados(List<Comprador> participantesVerificados) {
		this.participantesVerificados = participantesVerificados;
	}

}
