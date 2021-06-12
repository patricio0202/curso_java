package Controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import bd.Conexao;
import modelo.UsuarioModelo;

public class UsuarioControle {
	
	// Aitenticar usuario
	public static boolean autenticar(String email, String senha) throws SQLException{
		
		// Variavel Boolean
		boolean existe = false;
		
		// SQL
		String sql = "SELECT COUNT(*) FROM usuarios WHERE emailUsuario = ? AND senhaUsuario = ?";
		
		// Acessar o banco de dados
		Conexao.iniciarConexao();
		
		//PreparedStatement
		PreparedStatement pstmt = null;
		
		// ResultSet
		ResultSet rs = null;
		
		// Tentativa
		try {
			pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				existe = rs.getInt(1) == 1 ? true : false;
			}
			
		}catch (Exception erro) {
			System.out.println("Falha ao autenticar" + erro.getMessage());
		}finally {
			rs.close();
			pstmt.close();
			Conexao.finalizarConexao();
		}
		
		// retorno
		return existe;
		
	}

	// Retornar um objeto usuário
	public static UsuarioModelo obterUsuario(String email, String senha) throws SQLException {
		
		// Variável usuario mdelo
		UsuarioModelo um = null;
		
		// SQL
		String sql = "SELECT * FROM usuarios WHERE emailUsuario = ? AND senhaUsuario = ?";
				
		// Acessar o banco de dados
		Conexao.iniciarConexao();
				
		//PreparedStatement
		PreparedStatement pstmt = null;
				
		// ResultSet
		ResultSet rs = null;
				
		// Tentativa
		try {
			pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
					
			rs = pstmt.executeQuery();
					
			while (rs.next()) {
				um = new UsuarioModelo (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
										rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}
					
		}catch (Exception erro) {
				System.out.println("Falha ao autenticar" + erro.getMessage());
		}finally {
			rs.close();
			pstmt.close();
			Conexao.finalizarConexao();
		}
		
		// Retorno
		return um;
		
	}

	// Cadastrar usuário
	public static boolean cadastrar(UsuarioModelo um) throws SQLException {
		
		// Variável
		boolean status = false;
		
		// SQL
		String sql = "INSERT INTO usuarios (nomeUsuario, senhaUsuario, EmailUsuario, bairroUsuario, ruaUsuario, numeroUsuario, complementoUsuario, telefoneUsuario, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
		// Acessar o banco de dados
		Conexao.iniciarConexao();
				
		//PreparedStatement
		PreparedStatement pstmt = null;
				
		// Tentativa
		try {
			pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setString(1, um.getNome());
			pstmt.setString(2, um.getSenha());
			pstmt.setString(3, um.getEmail());
			pstmt.setString(4, um.getBairro());
			pstmt.setString(5, um.getRua());
			pstmt.setInt(6, um.getNumero());
			pstmt.setString(7, um.getComplemento());
			pstmt.setString(8, um.getTelefone());
			pstmt.setInt(9, um.getTipo());
					
			pstmt.execute();
					
			status = true;
			
		}catch (Exception erro) {
				System.out.println("Falha ao cadastrar" + erro.getMessage());
		}finally {
			pstmt.close();
			Conexao.finalizarConexao();
		}
		
		// Retorno
		return status;
	}

}

