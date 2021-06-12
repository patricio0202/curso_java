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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField pswSenha;
	private JTextField txtEmail;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtTelefone;

	/**
	 * Create the frame.
	 */
	public Usuarios(UsuarioModelo um) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\16Escola\\Imagens\\usuario.png"));
		lblImagem.setBounds(209, 21, 64, 64);
		contentPane.add(lblImagem);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 112, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 129, 228, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 160, 46, 14);
		contentPane.add(lblSenha);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(10, 175, 228, 20);
		contentPane.add(pswSenha);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(250, 112, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(250, 129, 254, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(250, 160, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(248, 175, 256, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 206, 46, 14);
		contentPane.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setBounds(10, 222, 228, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(250, 206, 46, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(250, 222, 254, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(10, 253, 82, 14);
		contentPane.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(10, 267, 228, 20);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(250, 253, 64, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(250, 267, 254, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JComboBox <String> cbxTipo = new JComboBox <String>();
		cbxTipo.addItem("Tipo de conta");
		cbxTipo.addItem("Administrador");
		cbxTipo.addItem("Professor");
		cbxTipo.addItem("Aluno");
		cbxTipo.setBounds(10, 298, 494, 22);
		contentPane.add(cbxTipo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Tentativa
				try {
				
					// Obter dados
					String nome = txtNome.getText();
					String email = txtEmail.getText();
					String senha = String.valueOf(pswSenha.getPassword());
					String bairro = txtBairro.getText();
					String rua = txtRua.getText();
					int numero = Integer.parseInt(txtNumero.getText());
					String complemento = txtComplemento.getText();
					String telefone = txtTelefone.getText();
					int tipo = cbxTipo.getSelectedIndex();			
					
					// Criar objeto do tipo UsuarioModelo
					UsuarioModelo um = new UsuarioModelo(nome, senha, email, bairro, rua, numero, complemento, telefone, tipo);
					
					// Cadastrar Usuario
					boolean status = UsuarioControle.cadastrar(um);
					
					// Mensagem
					JOptionPane.showMessageDialog (null, status == true ? "Cadastramento realizado com sucesso" : "Falha ao cadastrar");
				
					// Limpar campos
					txtNome.setText("");
					pswSenha.setText("");
					txtEmail.setText("");
					txtBairro.setText("");
					txtRua.setText("");
					txtNumero.setText("");
					txtComplemento.setText("");
					txtTelefone.setText("");
					cbxTipo.setSelectedIndex(0);
					
				
				}catch(Exception erro) {}
				
			}
				
		});
		btnCadastrar.setBounds(80, 344, 103, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar oJframe
				dispose();
				
				// Exlibir o Jframe Administrador
				Administrador a = new Administrador(um);
				a.setVisible(true);
				
			}
		});
		btnCancelar.setBounds(327, 344, 103, 23);
		contentPane.add(btnCancelar);
	}
}
