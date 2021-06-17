package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.ProvaControle;
import Controle.UsuarioControle;
import modelo.ProvaModelo;
import modelo.UsuarioModelo;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Notas extends JFrame {
	
	// Variaveis globais
	int codigoProva = 0;
	int codigoAluno = 0;
	int nota = 0;
	
	private JPanel contentPane;
	private JTextField txtNota;

	/**
	 * Create the frame.
	 */
	public Notas(UsuarioModelo um) {
		
		// Obter todas as provas atraves do codigo professor
		ArrayList<ProvaModelo> provas = ProvaControle.listarProvas(um.getCodigo());
		
		// DefaultComboBoxModel
		DefaultComboBoxModel<ProvaModelo> cbxmProvas = new DefaultComboBoxModel<ProvaModelo>();
		
		for (int i = 0; i < provas.size(); i++) {
			cbxmProvas.addElement (provas.get(i));
		}

		ArrayList<UsuarioModelo> alunos = UsuarioControle.listarAlunos();
		
		// DefaultComboBoxModel
		DefaultComboBoxModel<UsuarioModelo> cbxmAlunos = new DefaultComboBoxModel<UsuarioModelo>();
		
		for (int i = 0; i < alunos.size(); i++) {
			cbxmAlunos.addElement(alunos.get(i));
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbxProvas = new JComboBox();
		cbxProvas.setModel(cbxmProvas);
		cbxProvas.setBounds(26, 104, 377, 22);
		contentPane.add(cbxProvas);
		
		JComboBox cbxAlunos = new JComboBox();
		cbxAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Código da prova
				ProvaModelo pm = (ProvaModelo) cbxProvas.getSelectedItem();
				codigoProva = pm.getCodigoProva();
				
				//Código aluno
				UsuarioModelo usm = (UsuarioModelo) cbxAlunos.getSelectedItem();
				codigoAluno = usm.getCodigo();
				
				// Obter nota
				nota = ProvaControle.retornarNota(codigoProva, codigoAluno);
				
				// Exibir no txtNota
				txtNota.setText(nota == -1 ? "" : String.valueOf(nota));
			}
		});
		cbxAlunos.setModel(cbxmAlunos);
		cbxAlunos.setBounds(26, 162, 377, 22);
		contentPane.add(cbxAlunos);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\16Escola\\Imagens\\provas.png"));
		lblNewLabel.setBounds(178, 11, 64, 64);
		contentPane.add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar oJframe
				dispose();
				
				// Exlibir o Jframe professor
				Professor p = new Professor(um);
				p.setVisible(true);
				
			}
		});
		btnSair.setBounds(335, 11, 89, 23);
		contentPane.add(btnSair);
		
		txtNota = new JTextField();
		txtNota.setBounds(26, 218, 377, 20);
		contentPane.add(txtNota);
		txtNota.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// Efetuar cadastro ou altereção
				
				boolean status = false;
				
				if (nota == -1) {
					status = ProvaControle.cadastrarNota(codigoProva, codigoAluno, Integer.parseInt(txtNota.getText()));
					JOptionPane.showMessageDialog(null, status == true ? "Cadastro efetuado com sucesso" : "Falha ao cadastrar");
				}	else {
					status = ProvaControle.alterarNota(codigoProva, codigoAluno, Integer.parseInt(txtNota.getText()));
					JOptionPane.showMessageDialog(null, status == true ? "Edição efetuada" : "Falha ao editars");
				}
				
				// Reset dos campos
				cbxAlunos.setSelectedIndex(0);
				cbxProvas.setSelectedIndex(0);
				txtNota.setText("");
			}
		});
		btnCadastrar.setBounds(165, 282, 108, 23);
		contentPane.add(btnCadastrar);
	}
}
