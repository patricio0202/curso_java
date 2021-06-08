package Principal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import BD.Conexao;

public class Principal {

	public static void main(String[] args) {
		
		// Iniciar conex�o
		Conexao.iniciarConexao();
		
		// SQL 1
		String sql1 = "INSERT INTO usuarios VALUES (?, ?)";
		
		// SQL 2
		String sql2 = "SELECT * FROM usuarios";
		
		try {
			// PreparedStatemnet - Executa uma instru��o SQL com par�metros
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql1);
			pstmt.setString(1, "Lucas");
			pstmt.setInt(2, 22);
			pstmt.execute();
			

			// Statement - Executa uma instru�ao SQL sem par�metros
			Statement stmt = Conexao.conexao.createStatement();
			
			// ResultSet - armazena resultados vindos de uma consulta SQL
			ResultSet rs = stmt.executeQuery(sql2);
			
			// Listar
			while (rs.next()) {
				System.out.println(rs.getString(1) +  " - " + rs.getInt(2));
			}
			
		}catch(Exception erro){}
		
		// Finalizar conex�o
		Conexao.finalizarConexao();

	}

}
