package exercicio05;

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
	private JTextField txtPalavra;

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
		setBounds(100, 100, 450, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPalavra = new JLabel("Palavra");
		lblPalavra.setBounds(181, 31, 46, 14);
		contentPane.add(lblPalavra);
		
		txtPalavra = new JTextField();
		txtPalavra.setBounds(72, 56, 260, 20);
		contentPane.add(txtPalavra);
		txtPalavra.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String palavra = txtPalavra.getText(); 
				String invertida = new StringBuffer(palavra).reverse().toString();
				
				palavra = palavra.replace(" ", "");
				invertida = invertida.replace(" ","");
				
				if (palavra.equals(invertida)) {
					JOptionPane.showMessageDialog(null, "É palindrome ");
				}else {
					JOptionPane.showMessageDialog(null, "Não é palindrome");
				}
				
				
				
			}
		});
		btnEnviar.setBounds(156, 105, 89, 23);
		contentPane.add(btnEnviar);
	}
}
