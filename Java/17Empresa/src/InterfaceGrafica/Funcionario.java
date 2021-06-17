package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Funcionario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Funcionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Funcionario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 80, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 66, 388, 138);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar Jframe
				dispose();
				
				// Abrir Jframe estoque
				Estoque es = new Estoque();
				es.setVisible(true);
				
			}
		});
		btnAcessar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnAcessar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// fechar Jframe
				dispose();
				
				// Abrir Jframe cadastro estoque
				
				Cadastro c = new Cadastro();
				c.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// fechar Jframe
				dispose();
				
				// Abrir Jframe cadastro estoque
				
				Cadastro c = new Cadastro();
				c.setVisible(true);
				
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// fechar Jframe
				dispose();
				
				// Abrir Jframe cadastro estoque
				
				Cadastro c = new Cadastro();
				c.setVisible(true);
				
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSair.setBounds(335, 7, 89, 23);
		contentPane.add(btnSair);
	}

}
