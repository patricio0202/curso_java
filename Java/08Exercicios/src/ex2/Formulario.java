package ex2;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Formulario extends JFrame {
	private JPanel contentPane;
	private JTextField txtTurma;
	private JTable tabela;
	
	//Indice
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
		
		DefaultTableModel dtm = new DefaultTableModel();
		
		JComboBox cbxCurso = new JComboBox();
		
		JButton btnAlterar = new JButton("Alterar");
		JButton btnCadastrar = new JButton("Cadastrar");
		JButton btnRemover = new JButton("Remover");
		JButton btnCancelar = new JButton("Cancelar");
		
		JTextField txtNome = new JTextField();
		
		btnAlterar.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				// Extrair nome do curso e valor (JComboBox)
				Cursos obj = (Cursos) cbxCurso.getSelectedItem();
				
				// Obter dados
				String nome = txtNome.getText();
				String curso = obj.getNome();
				double valor = obj.getValor();
				String turma = txtTurma.getText();
				
				// Instanciar objeto da classe aluno
				Aluno a = new Aluno(nome, curso, turma, valor);
				
				// Cadastrar no ArrayList
				alunos.set(indice, a);
				
				// Limpar os campos
				txtNome.setText("");
				cbxCurso.setSelectedIndex(0);
				txtTurma.setText("");
				
				// Cursor no campo nome
				txtNome.requestFocus();
				
				// Atualizar DefaultTableModel e JTable
				dtm.setRowCount(0);
				for (int i = 0; i < alunos.size(); i++) {
					dtm.addRow(new Object[] {
						alunos.get(i).getNome(),
						alunos.get(i).getCurso(),
						alunos.get(i).getValor(),
						alunos.get(i).getTurma()
					});
			    }
			
			tabela.setModel(dtm);
			
			btnCadastrar.setEnabled(true);
			btnAlterar.setEnabled(false);
			btnRemover.setEnabled(false);
			btnCancelar.setEnabled(false);
			
			}
		});
		
		btnRemover.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				// Remover do ArrayList
				alunos.remove(indice);
				
				// Limpar os campos
				txtNome.setText("");
				cbxCurso.setSelectedIndex(0);
				txtTurma.setText("");
				
				// Cursor no campo nome
				txtNome.requestFocus();
				
				// Atualizar DefaultTableModel e JTable
				dtm.setRowCount(0);
				for (int i = 0; i < alunos.size(); i++) {
					dtm.addRow(new Object[] {
						alunos.get(i).getNome(),
						alunos.get(i).getCurso(),
						alunos.get(i).getValor(),
						alunos.get(i).getTurma()
					});
			    }
			
			tabela.setModel(dtm);
			
			btnCadastrar.setEnabled(true);
			btnAlterar.setEnabled(false);
			btnRemover.setEnabled(false);
			btnCancelar.setEnabled(false);
			
			}
		});
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				// Reset dos campos
				txtNome.setText("");
				cbxCurso.setSelectedIndex(0);
				txtTurma.setText("");
				
				// Bot?es
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnRemover.setEnabled(false);
				btnCancelar.setEnabled(false);
			}
		});
		
		// Carregar cursos
		Cursos c1 = new Cursos ("Java", 5000);
		Cursos c2 = new Cursos ("C#", 4800);
		Cursos c3 = new Cursos ("Python", 3300);
		Cursos c4 = new Cursos ("Front-End", 4500);
		Cursos c5 = new Cursos ("PHP", 3500);
		
		// ArrayList
		ArrayList<Cursos> cursos = new ArrayList<Cursos>();
		cursos.add(c1);
		cursos.add(c2);
		cursos.add(c3);
		cursos.add(c4);
		cursos.add(c5);
		
		// Modelo ComboBox
		DefaultComboBoxModel<Cursos> dtc = new DefaultComboBoxModel<Cursos>();
		for (int i = 0; i < cursos.size(); i++) {
			dtc.addElement(cursos.get(i));
		}
		

		
		// DefaultTableModel
		dtm.addColumn("Nome");
		dtm.addColumn("Curso");
		dtm.addColumn("Valor");
		dtm.addColumn("Turma");
		
		JScrollPane barraRolagem = new JScrollPane();
		tabela = new JTable(dtm);
		tabela.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				 indice = tabela.getSelectedRow();
				
				// Exibir dados do formulario
				txtNome.setText(alunos.get(indice).getNome());
				txtTurma.setText(alunos.get(indice).getTurma());
				
				String cursoSelecionado = alunos.get(indice).getCurso();
				
				for (int i = 0; i < cursos.size(); i++) {
					if(cursoSelecionado.equals(cursos.get(i).getNome())) {
						cbxCurso.setSelectedIndex(i);
						break;
					}
				}
				
				// Habilitar e desabilitar bot?es
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnRemover.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		txtNome.setBounds(91, 31, 252, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(35, 34, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(35, 77, 46, 14);
		contentPane.add(lblCurso);
		
		JLabel lblTurma = new JLabel("Turma");
		lblTurma.setBounds(35, 120, 46, 14);
		contentPane.add(lblTurma);
		
		
		txtTurma = new JTextField();
		txtTurma.setBounds(91, 117, 252, 20);
		contentPane.add(txtTurma);
		txtTurma.setColumns(10);
		

		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(124, 160, 89, 23);
		contentPane.add(btnAlterar);
		
		
		cbxCurso.setBounds(91, 73, 252, 22);
		cbxCurso.setModel(dtc);
		contentPane.add(cbxCurso);
		

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				// Extrair nome do curso e valor (JComboBox)
				Cursos obj = (Cursos) cbxCurso.getSelectedItem();
				
				// Obter dados
				String nome = txtNome.getText();
				String curso = obj.getNome();
				double valor = obj.getValor();
				String turma = txtTurma.getText();
				
				// Instanciar objeto da classe aluno
				Aluno a = new Aluno(nome, curso, turma, valor);
				
				// Cadastrar no ArrayList
				alunos.add(a);
				
				// Limpar os campos
				txtNome.setText("");
				cbxCurso.setSelectedIndex(0);
				txtTurma.setText("");
				
				// Cursor no campo nome
				txtNome.requestFocus();
				
				// Atualizar DefaultTableModel e JTable
				dtm.setRowCount(0);
				for (int i = 0; i < alunos.size(); i++) {
					dtm.addRow(new Object[] {
						alunos.get(i).getNome(),
						alunos.get(i).getCurso(),
						alunos.get(i).getValor(),
						alunos.get(i).getTurma()
					});
			    }
			
			tabela.setModel(dtm);
				
			}
		});
		btnCadastrar.setBounds(25, 160, 89, 23);
		contentPane.add(btnCadastrar);
		

		btnRemover.setEnabled(false);
		btnRemover.setBounds(223, 160, 89, 23);
		contentPane.add(btnRemover);
		
		
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(324, 160, 89, 23);
		contentPane.add(btnCancelar);
		
		barraRolagem.setBounds(25, 204, 388, 170);
		contentPane.add(barraRolagem);
		
		barraRolagem.setViewportView(tabela);
	}
}