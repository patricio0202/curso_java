package ex3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JButton btnCadastrar;
	private JButton btnAlterar;
	private JButton btnRemover;
	private JButton btnCancelar;
	private JScrollPane barraRolagem;
	private JTable tabela;
	
	int indice = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		
		// ArrayLista
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		// DefaultTableModel
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Aluno");
		dtm.addColumn("Nota 1");
		dtm.addColumn("Nota 2");
		dtm.addColumn("M?dia");
		dtm.addColumn("Situa??o");
		
		barraRolagem = new JScrollPane();
		tabela = new JTable(dtm);
		
		JScrollPane barraRolagem = new JScrollPane();
		tabela = new JTable(dtm);
		tabela.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				 indice = tabela.getSelectedRow();
				 
				 // Exibir dados do formulario
				 txtNome.setText (alunos.get(indice).getAluno());
				 txtNota1.setText (String.valueOf(alunos.get(indice).getNota1()));
				 txtNota2.setText (String.valueOf(alunos.get(indice).getNota2()));
				 
				// Habilitar e desabilitar bot?es
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnRemover.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 396);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAluno = new JLabel("Aluno");
		lblAluno.setBounds(10, 23, 46, 14);
		contentPane.add(lblAluno);
		
		JLabel lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(10, 73, 46, 14);
		contentPane.add(lblNota2);
		
		txtNome = new JTextField();
		txtNome.setBounds(72, 20, 273, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(10, 48, 46, 14);
		contentPane.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(72, 45, 86, 20);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(72, 70, 86, 20);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// Obter os dados
				String nome = txtNome.getText();
				double nota1 = Double.parseDouble(txtNota1.getText());
				double nota2 = Double.parseDouble(txtNota2.getText());
				double media;
				String situacao;
				
				media = (nota1 + nota2)/2;
				
				if (media >= 7) {
					situacao = "Aprovado";
				}else {
					situacao = "Reprovado";
				}
				
				// Instanciar objeto da classe aluno
				Aluno a = new Aluno(nome, nota1, nota2, media, situacao);
				
				// Cadastrar no ArrayList
				alunos.add (a);
				
				// Limpar os campos
				txtNome.setText("");
				txtNota1.setText("");
				txtNota2.setText("");
				
				// Cursor no campo nome
				txtNome.requestFocus();
				
				// Atualizar DefaultTableModel e JTable
				dtm.setRowCount(0);
				for (int i = 0; i < alunos.size(); i++) {
					dtm.addRow (new Object [] {
						alunos.get(i).getAluno(),
						alunos.get(i).getNota1(),
						alunos.get(i).getNota2(),
						alunos.get(i).getMedia(),
						alunos.get(i).getSituacao()
						
					});
				}
				
				tabela.setModel(dtm);
				
			}
		});
		btnCadastrar.setBounds(20, 103, 89, 23);
		contentPane.add(btnCadastrar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
				
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obter os dados
				String nome = txtNome.getText();
				double nota1 = Double.parseDouble(txtNota1.getText());
				double nota2 = Double.parseDouble(txtNota2.getText());
				double media;
				String situacao;
				
				media = (nota1 + nota2)/2;
				
				if (media >= 7) {
					situacao = "Aprovado";
				}else {
					situacao = "Reprovado";
				}
				
				// Instanciar objeto da classe aluno
				Aluno a = new Aluno(nome, nota1, nota2, media, situacao);
				
				// Cadastrar no ArrayList
				alunos.set (indice, a);
				
				// Limpar os campos
				txtNome.setText("");
				txtNota1.setText("");
				txtNota2.setText("");
				
				// Cursor no campo nome
				txtNome.requestFocus();
				
				// Atualizar DefaultTableModel e JTable
				dtm.setRowCount(0);
				for (int i = 0; i < alunos.size(); i++) {
					dtm.addRow (new Object [] {
						alunos.get(i).getAluno(),
						alunos.get(i).getNota1(),
						alunos.get(i).getNota2(),
						alunos.get(i).getMedia(),
						alunos.get(i).getSituacao()
						
					});
				}
				
				tabela.setModel(dtm);
				
			}
		});
		btnAlterar.setBounds(119, 103, 89, 23);
		contentPane.add(btnAlterar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				// Remover do ArrayList
				alunos.remove(indice);
				
				// Limpar os campos
				txtNome.setText("");
				txtNota1.setText("");
				txtNota2.setText("");
				
				// Cursor no campo nome
				txtNome.requestFocus();
				
				// Atualizar DefaultTableModel e JTable
				dtm.setRowCount(0);
				for (int i = 0; i < alunos.size(); i++) {
					dtm.addRow (new Object [] {
						alunos.get(i).getAluno(),
						alunos.get(i).getNota1(),
						alunos.get(i).getNota2(),
						alunos.get(i).getMedia(),
						alunos.get(i).getSituacao()
						
					});
				}
				
				tabela.setModel(dtm);
				
				// Habilitar e Desabilitar bot?es
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnRemover.setEnabled(false);
				btnCancelar.setEnabled(false);
				
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(218, 103, 89, 23);
		contentPane.add(btnRemover);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				// Reset os campos
				txtNome.setText("");
				txtNota1.setText("");
				txtNota2.setText("");
				
				// Desabilitar bot?es
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnRemover.setEnabled(false);
				btnCancelar.setEnabled(false);
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(317, 103, 89, 23);
		contentPane.add(btnCancelar);
		

		barraRolagem.setBounds(30, 137, 376, 193);
		contentPane.add(barraRolagem);
		

		barraRolagem.setViewportView(tabela);
		
	}	
}