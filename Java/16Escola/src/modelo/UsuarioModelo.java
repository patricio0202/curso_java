package modelo;

public class UsuarioModelo {
	
	// Atributos
	private int codigo, numero, tipo;
	private String nome, senha, email, bairro, rua, complemento, telefone;
	
	// Construtor
	public UsuarioModelo(int codigo, String nome, String senha, String email, String bairro, String rua, int numero, String complemento, String telefone, int tipo) {
		this.codigo= codigo;
		this.nome= nome;
		this.senha = senha;
		this.email = email;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.tipo = tipo;
	}
		
	// Construtor - cadastrar novo usuário
	public UsuarioModelo(String nome, String senha, String email, String bairro, String rua, int numero, String complemento, String telefone, int tipo) {
		this.nome= nome;
		this.senha = senha;
		this.email = email;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.tipo = tipo;
		}
	
	// Construtor
	public UsuarioModelo (int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
		
	
	// Get e Set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String toString () {
		return nome;
	}

}
