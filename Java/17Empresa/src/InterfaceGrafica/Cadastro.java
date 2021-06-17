package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeEstoque;
	private JTextField txtModelo;
	private JTextField txtAltura;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 64, 46, 14);
		contentPane.add(lblNome);
		
		txtNomeEstoque = new JTextField();
		txtNomeEstoque.setBounds(66, 62, 192, 20);
		contentPane.add(txtNomeEstoque);
		txtNomeEstoque.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModelo.setBounds(10, 128, 46, 14);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(66, 126, 192, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAltura.setBounds(10, 191, 46, 14);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(66, 189, 192, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar Jframe
				dispose();
				
				// Abrir Jframe Funcionario
				Funcionario f = new Funcionario();
				f.setVisible(true);
				
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSair.setBounds(269, 11, 89, 23);
		contentPane.add(btnSair);
	}

}
