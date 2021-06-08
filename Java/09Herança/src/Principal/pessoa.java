package Principal;

// No java n�o h� eran�a m�ltipla, sendo assim s� � possivel herdar uma classe
public class pessoa extends Cargo {
	
	// Atributos
	private String nome;
	private int idade;
	
	// Construtor
	public pessoa (String nome, String cargo, int idade, double salario) {
		this.nome = nome;
		this.cargo = cargo;
		this.idade = idade;
		this.salario = salario;
		
		listarPessoa();
		listarCargo();
	}
	
	// M�todo para listar dados
	private void listarPessoa() {
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + idade);
	}
	
	

}
