package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField pswSenha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(77, 92, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(77, 135, 46, 14);
		contentPane.add(lblSenha);
		
		txtNome = new JTextField();
		txtNome.setBounds(145, 89, 182, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar Jframe
				dispose();
				
				// Abrir tabela administrador
				Funcionario f = new Funcionario();
				f.setVisible(true);
				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEntrar.setBounds(169, 193, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\17Empresa\\Imagens\\iconfinder_416376_envelope_files_folder_interface_office_icon_64px.png"));
		lblNewLabel.setBounds(181, 11, 64, 64);
		contentPane.add(lblNewLabel);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(145, 135, 182, 20);
		contentPane.add(pswSenha);
	}
}
