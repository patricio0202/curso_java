package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.UsuarioControle;
import modelo.UsuarioModelo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField pswSenha;
	private JLabel lblImagem;

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\16Escola\\Imagens\\iconfinder_6771602_book shelf_books_education_learning_school_icon_256px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(290, 93, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(290, 124, 46, 14);
		contentPane.add(lblSenha);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(336, 90, 221, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(335, 121, 222, 20);
		contentPane.add(pswSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Tentativa
				try {
				
					//Capturar e-mail e senha
					String email = txtEmail.getText();
					String senha = String.valueOf(pswSenha.getPassword());	
					
					// Autenticar
					boolean autenticar = UsuarioControle.autenticar(email, senha);
					
					// Condicional
					if (autenticar == false) {
						JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos");
					}else {
						
						// Obter dados do usuário
						UsuarioModelo um = UsuarioControle.obterUsuario(email, senha);
					
						//Fechar oJframe
						dispose();
						
						//Exlibir o Jframe
						switch(um.getTipo()) {
						
							case 1:
								Administrador ad = new Administrador(um);
								ad.setVisible(true);
							break;
						
							case 2:
								Professor p = new Professor(um);
								p.setVisible(true);
							break;
						
							case 3:
								Aluno al = new Aluno(um);
								al.setVisible(true);
							break;
						}
						
					}
				}catch (Exception erro) {}
				
			}
		});
		btnEntrar.setBounds(404, 172, 89, 23);
		contentPane.add(btnEntrar);
		
		lblImagem = new JLabel("New label");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\16Escola\\Imagens\\iconfinder_6771602_book shelf_books_education_learning_school_icon_256px.png"));
		lblImagem.setBounds(24, 11, 256, 240);
		contentPane.add(lblImagem);
	}
}
