package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JButton btnSair;
	private JLabel txtTipoUsuario;
	private JTextField txtTipo;
	private JPasswordField pswSenhaUsuario;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Usuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoUsuario = new JLabel("Codigo");
		lblCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoUsuario.setBounds(185, 86, 46, 14);
		contentPane.add(lblCodigoUsuario);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(146, 111, 123, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(185, 142, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\17Empresa\\Imagens\\iconfinder_285645_user_icon_64px.png"));
		lblNewLabel.setBounds(167, 11, 64, 64);
		contentPane.add(lblNewLabel);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar Jframe
				dispose();
				
				// Voltar Jframe adminstrador
				Administrador a = new Administrador();
				a.setVisible(true);
				
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSair.setBounds(336, 11, 89, 23);
		contentPane.add(btnSair);
		
		txtTipoUsuario = new JLabel("Tipo");
		txtTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTipoUsuario.setBounds(185, 198, 46, 14);
		contentPane.add(txtTipoUsuario);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(146, 223, 123, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		pswSenhaUsuario = new JPasswordField();
		pswSenhaUsuario.setBounds(146, 161, 123, 20);
		contentPane.add(pswSenhaUsuario);
	}

}
