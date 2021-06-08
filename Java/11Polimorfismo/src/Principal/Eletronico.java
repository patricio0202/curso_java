package Principal;

public class Eletronico extends Produto{
	
	// Imposto Federal
	public void ifd(double valor) {
		System.out.println("Imposto Federeal - Eletrônicos RS$ " + (valor * 0.1));
	}

}
