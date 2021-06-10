package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	// Atributo de conex�o
	public static Connection conexao = null;
	
	// Atributos para efetuar a conex�o
	private static final String base = "escola";
	private static final String usuario = "root";
	private static final String senha = "apex";
	private static final String timeZone = "?useTimezone=true&serverTimezone=UTC";
	
	
	// Iniciar conex�o
	public static void iniciarConexao() {
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" +base+timeZone, usuario, senha);
			//System.out.println("Conexao ok! ");
		}catch (Exception erro) {
			System.out.println("Falha ao conectar " + erro.getMessage());
		}
		
	}

	// Finilizar conex�o
	public static void finalizarConexao() {
		try {
			conexao.close();
		}catch(Exception erro) {
			System.out.println("Falha ao finalizar a conex�o");
		}
	}
}


