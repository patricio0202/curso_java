package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
	
	// Atributo conex�o
	public static Connection conexao = null;	
	
	// Atributos para inicar conex�o
	private static final String base = "Empresa";
	private static final String usuario = "root";
	private static final String senha = "apex";
	private static final String timeZone = "?useTimezone=true&serverTimezone=UTC";
	
	// Iniciar conex�o
	public static void iniciarConexao() {
		try {
			conexao = DriverManager.getConnection ("jdbc:mysql://localhost/" +base+timeZone, usuario, senha);
		}catch(Exception erro){
			System.out.println("Falha ao conectar " + erro.getMessage());
		}
	}

}
