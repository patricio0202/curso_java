package exercicio01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textNota1;
	private JTextField textNota2;
	private JTextField textNota3;
	private JButton btnEnviar;

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
		setBounds(100, 100, 450, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNota1 = new JTextField();
		textNota1.setBounds(102, 31, 86, 20);
		contentPane.add(textNota1);
		textNota1.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(46, 31, 46, 20);
		contentPane.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(46, 83, 46, 14);
		contentPane.add(lblNota2);
		
		textNota2 = new JTextField();
		textNota2.setBounds(102, 80, 86, 20);
		contentPane.add(textNota2);
		textNota2.setColumns(10);
		
		JLabel lblNota3 = new JLabel("Nota 3");
		lblNota3.setBounds(46, 132, 46, 14);
		contentPane.add(lblNota3);
		
		textNota3 = new JTextField();
		textNota3.setBounds(102, 129, 86, 20);
		contentPane.add(textNota3);
		textNota3.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double nota1 = Double.parseDouble (textNota1.getText());
				double nota2 = Double.parseDouble (textNota2.getText());
				double nota3 = Double.parseDouble (textNota3.getText());
				double media = 0;
				
				media = (nota1 + nota2 + nota3)/3;
				
				if (media >= 7) {
					JOptionPane.showMessageDialog(null, "Aprovado com média " + media);
				}else {
					JOptionPane.showMessageDialog(null, "Reprovado com média " + media);
				}
			
			}
		});
		btnEnviar.setBounds(280, 79, 89, 23);
		contentPane.add(btnEnviar);
		
		
	}
}
