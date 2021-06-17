package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Administrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 80, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 83, 355, 103);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar Jframe
				dispose();
				
				// Abrir Jframe Usuarios
				Usuarios u= new Usuarios();
				u.setVisible(true);
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnCadastrar);
		
		JButton btnAcessarEstoque = new JButton("Estoque");
		btnAcessarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar Jframe
				dispose();
				
				// Abrir Jframe estoque
				Estoque es = new Estoque();
				es.setVisible(true);
				
			}
		});
		btnAcessarEstoque.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnAcessarEstoque);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar Jframe
				dispose();
				
				// Voltar jframe login
				Login l = new Login();
				l.setVisible(true);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnSair);
	}
}
