package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.UsuarioModelo;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrador extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Administrador(UsuarioModelo um) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBoasVindas = new JLabel("Boa noite "+ um.getNome());
		lblBoasVindas.setBounds(10, 11, 157, 14);
		contentPane.add(lblBoasVindas);
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 61, 431, 163);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnCadastrar = new JButton("Cadastrar Usuarios");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar oJframe
				dispose();
				
				// Exlibir o Jframe usuarios
				Usuarios u = new Usuarios(um);
				u.setVisible(true);
				
			}
		});
		btnCadastrar.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\16Escola\\Imagens\\usuario.png"));
		panel.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar oJframe
				dispose();
				
				// Exlibir o Jframe Administrador
				Login l = new Login();
				l.setVisible(true);
				
			}
		});
		btnSair.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\16Escola\\Imagens\\sair2.png"));
		panel.add(btnSair);
	}
}
