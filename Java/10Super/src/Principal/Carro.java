package Principal;

public class Carro extends Veiculo{
	
	// Atributos
	private int portas;
	private boolean tetoSolar;
	
	// Construtor
	public Carro (String fabricante, String modelo, double valor, int portas, boolean tetoSolar) {
		super(fabricante, modelo, valor);
		this.portas = portas;
		this.tetoSolar = tetoSolar;
	}

}
