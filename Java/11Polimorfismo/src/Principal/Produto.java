package Principal;

public class Produto {
	
	// Imposto Municipal
	public void im(double valor) {
		System.out.println("Imposto Municipal - Padr?o RS$ " + (valor * 0.02));
	}
	
	// Imposto Estadual
	
	public void ie(double valor) {
		System.out.println("Imposto Estadual - Padr?o RS$ " + (valor * 0.04));
	}
	// Imposto Federal
		public void ifd(double valor) {
			System.out.println("Imposto Federal - Padr?o RS$ " + (valor * 0.05));
		}
}
