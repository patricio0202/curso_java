package exercicio060708;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 24, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(24, 76, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(24, 135, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(24, 195, 46, 14);
		contentPane.add(lblData);
		
		txtNome = new JTextField();
		txtNome.setBounds(61, 21, 167, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(61, 73, 167, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(61, 132, 167, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtData = new JTextField();
		txtData.setBounds(61, 192, 167, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = txtEmail.getText();
				
				char[] caracteres = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','-','_','.','@',0,1,2,3,4,5,6,7,8,9};                                                            
	
		
				
				for (int i = 0; i < email.length(); i++) {
					char letra = email.charAt(i);
					
					boolean existe = false;
					
					for(int i2=0; i2<caracteres.length; i2++) {
						
						existe = false;
						
						if(caracteres[i2] == letra) {
							existe = true;
							break;
						}
						
						if(existe == false) {
							JOptionPane.showMessageDialog(null, "E-mail inválido");
							break;
						}
						
					}
					
				}
				
			}
		});
		btnEnviar.setBounds(315, 101, 89, 23);
		contentPane.add(btnEnviar);
	}

}
