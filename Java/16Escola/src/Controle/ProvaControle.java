package Controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import bd.Conexao;
import modelo.ProvaModelo;

public class ProvaControle {

	// Cadastrar Prova
	public static boolean cadastrar(int codigoProfessor, String nomeProva) {
		// Variável boolean
		boolean status = false;
		
		// SQL
		String sql = "INSERT INTO provas (nomeProva, codigoProfessor) VALUES (?, ?)";
		
		// Abrir a conexão
		Conexao.iniciarConexao();
		
		// Tentativa
		try {
			
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setString(1, nomeProva);
			pstmt.setInt(2,codigoProfessor);
			pstmt.execute();
			pstmt.close();
			
			status = true;
			
		}catch (Exception erro) { 
			System.out.println("Falha ao cadastrar a prova" + erro.getMessage());
		}finally {
			Conexao.finalizarConexao();
		}
		
		// Retornar
		return status;
	}
	
	// Listar provas atraves do codigo professor
	public static ArrayList<ProvaModelo> listarProvas(int codigoProfessor){
		// ArrayList
		ArrayList<ProvaModelo> dados = new ArrayList<ProvaModelo>();
		
		// SQL
		String sql = "SELECT * FROM provas WHERE codigoProfessor = ?";
			
		// Inicar conexão
		Conexao.iniciarConexao();
		
		// Tentativa
		try {
			
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setInt(1, codigoProfessor);
			
			ProvaModelo cabecalho = new ProvaModelo(0, "Prova");
			dados.add(cabecalho);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProvaModelo pm = new ProvaModelo(rs.getInt(1), rs.getString(2));
				dados.add(pm);
			}
			
			rs.close();
			pstmt.close();
			
		}catch (Exception erro) {
			System.out.println("Falha ao listar as provas" + erro.getMessage());
		}finally {
			Conexao.finalizarConexao();
		}
		
		// Retorno
		return dados;
	}
	
	// Retornar a nota da prova
	public static int retornarNota(int codigoProva, int codigoAluno) {
		
		// Variavel nota
		int nota = -1;
		
		// SQL
		String sql = "SELECT notaAluno FROM provasRealizadas WHERE codigoAluno = ? AND codigoProva = ?";
		
		// Abrir conexão
		Conexao.iniciarConexao();
		
		// Tentativa
		try {
			
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setInt(1, codigoAluno);
			pstmt.setInt(2, codigoProva);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				nota= rs.getInt(1);
			}
			
			pstmt.close();
			rs.close();
			
		}catch (Exception erro) {
			System.out.println("Falha ao obter a nota" + erro.getMessage());
		}finally {
			Conexao.finalizarConexao();
		}
	
		
		// Retorno
		return nota;
		
	}
	
	// Cadastrar nota ou alterar nota
	public static boolean cadastrarNota(int codigoProva, int codigoAluno, int nota) {
	
		// Variavel
		boolean status = false; 
		
		// SQL
		String sql = "INSERT INTO provasRealizadas VALUES (?, ?, ?)";
		
		// Abrir conexao
		Conexao.iniciarConexao();
		
		// Tentativa
		try {
			
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setInt(1, codigoAluno);
			pstmt.setInt(2, codigoProva);
			pstmt.setInt(3, nota);
			pstmt.execute();
			
			status = true;
			
		}catch (Exception erro) {
			System.out.println("Falha ao cadastrar a nota" + erro.getMessage());
		}finally {
			Conexao.finalizarConexao();
		}
		
		// Retorno
		return status;
	}
	
	// Alterar nota
		public static boolean alterarNota(int codigoProva, int codigoAluno, int nota) {
		
			// Variavel
			boolean status = false; 
			
			// SQL
			String sql = "UPDATE provasRealizadas SET notaAluno = ? WHERE codigoAluno = ? AND CodigoProva = ?";
			
			// Abrir conexao
			Conexao.iniciarConexao();
			
			// Tentativa
			try {
				
				PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
				pstmt.setInt(1, nota);
				pstmt.setInt(2, codigoAluno);
				pstmt.setInt(3, codigoProva);
				pstmt.execute();
				
				status = true;
				
			}catch (Exception erro) {
				System.out.println("Falha ao alterar a nota" + erro.getMessage());
			}finally {
				Conexao.finalizarConexao();
			}
			
			// Retorno
			return status;
		}
		
		
		// Provas realizadas pelo aluno
		public static DefaultTableModel provasAluno (int codigo) {
		
			// DefaultTableModel
			DefaultTableModel dtm = new DefaultTableModel(); 
			dtm.addColumn("Prova");
			dtm.addColumn("Nota");
			
			// SQL
			String sql = "SELECT provas.nomeProva, provasRealizadas.notaAluno FROM provas INNER JOIN provasRealizadas ON provas.codigoProva = provasRealizadas.codigoProva WHERE provasRealizadas.codigoAluno = ?";
			
			// Iniciar conexão
			Conexao.iniciarConexao();
			
			// Tentativa
			try {
				PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
				pstmt.setInt(1, codigo);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					dtm.addRow(new Object[] {rs.getString(1), rs.getInt(2)});
				}
				
				pstmt.close();
				rs.close();
				
			}catch(Exception erro) {
				System.out.println("Falha ao puxar as notas" + erro.getMessage());
			}finally {
				Conexao.finalizarConexao();
			}
			
			return dtm;
			
			
			
		}
		
		
}
		








