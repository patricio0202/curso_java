package Ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Formulario extends JFrame {
	
	ArrayList<Pessoa> vetor = new ArrayList<Pessoa>();

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtCidade;
	private JTable tblPessoas;

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
		setBackground(Color.CYAN);
		setForeground(new Color(255, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(36, 28, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdade.setBounds(36, 73, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(36, 119, 46, 14);
		contentPane.add(lblCidade);
		
		txtNome = new JTextField();
		txtNome.setBounds(92, 25, 278, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(92, 70, 278, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(92, 116, 278, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		DefaultTableModel dtm = new DefaultTableModel ();
		tblPessoas = new JTable(dtm);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obter dados
				String nome = txtNome.getText();
				int idade = Integer.parseInt(txtIdade.getText());
				String cidade = txtCidade.getText();
				
				//Criar objeto
				Pessoa p = new Pessoa();
				p.setNome(nome);
				p.setIdade(idade);
				p.setCidade(cidade);
				
				// ArrayList
				vetor.add(p);
				
				// Limpar defaultTableModel
				dtm.setRowCount(0);
				
				// Cadastrar dados no defaultTableModel
				for (int i = 0; i < vetor.size(); i++) {
					dtm.addRow(new Object[] {
							vetor.get(i).getNome(),
							vetor.get(i).getIdade(),
							vetor.get(i).getCidade()
					});
				}
				
				// Atualizar DefaoultTableModel
				tblPessoas.setModel(dtm);
				
				// exibir contagens de cadastros (TESTE)
				System.out.println(vetor.size());
				
				
				// Limpar os campos
				txtNome.setText("");
				txtIdade.setText("");
				txtCidade.setText("");
			}
		});
		btnCadastrar.setBounds(171, 159, 89, 23);
		contentPane.add(btnCadastrar);
		
		dtm.addColumn("Nome");
		dtm.addColumn("Idade");
		dtm.addColumn("Cidade");
		
		JScrollPane scrlTabela = new JScrollPane();
		scrlTabela.setBounds(27, 203, 372, 165);
		contentPane.add(scrlTabela);
		

		scrlTabela.setViewportView(tblPessoas);
	}
}
