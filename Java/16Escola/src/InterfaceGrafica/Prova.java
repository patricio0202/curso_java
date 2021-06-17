package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.ProvaControle;
import modelo.UsuarioModelo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prova extends JFrame {

	private JPanel contentPane;
	private JTextField txtProva;

	/**
	 * Create the frame.
	 */
	public Prova(UsuarioModelo um) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProva = new JLabel("Prova");
		lblProva.setBounds(48, 115, 46, 14);
		contentPane.add(lblProva);
		
		txtProva = new JTextField();
		txtProva.setBounds(104, 112, 251, 20);
		contentPane.add(txtProva);
		txtProva.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obter dados
				String nomeProva = txtProva.getText();
				int codigoProfessor = um.getCodigo();
				
				// Cadastrar no banco de dados
				boolean status = ProvaControle.cadastrar(codigoProfessor, nomeProva);
				
				// Mensagem
				JOptionPane.showMessageDialog(null, status == true ? "Prova cadastrada" : "Falha ao cadastrar");
				
				// Limpar campo
				txtProva.setText("");
				
				// Cursos no campo
				txtProva.requestFocus();
				
				
				
			}
		});
		btnCadastrar.setBounds(48, 177, 107, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar oJframe
				dispose();
				
				// Exlibir o Jframe professor
				Professor p = new Professor(um);
				p.setVisible(true);
				
			}
		});
		btnCancelar.setBounds(251, 177, 107, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\16Escola\\Imagens\\prova.png"));
		lblNewLabel.setBounds(175, 24, 64, 64);
		contentPane.add(lblNewLabel);
	}

}
