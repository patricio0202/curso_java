package exemplo04;

public class Cargo {
	
	// Atributo
	private String cargo;
	
	// Construtor #1
	public Cargo() {
		System.out.println("Construtor ok!");
	}
	
	// Construtor #2
	
	public Cargo (String cargo) {
		this.cargo = cargo;
		System.out.println(mensagem());
	}
	
	// Método de mensagem
	private String mensagem () {
		return "O cargo informado é " +cargo;
	}
	

}
