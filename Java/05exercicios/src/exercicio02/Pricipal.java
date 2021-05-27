package exercicio02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pricipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pricipal frame = new Pricipal();
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
	public Pricipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(49, 36, 46, 14);
		contentPane.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(49, 115, 46, 14);
		contentPane.add(lblAltura);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(105, 33, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(105, 112, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int peso = Integer.parseInt (txtPeso.getText());
				double altura = Double.parseDouble (txtAltura.getText());
				double total = 0;
				
				total = (peso / (altura * altura));
				
				if (total < 15) {
					JOptionPane.showMessageDialog(null, "Muito abaixo do peso");
				}else if (total < 17.5) {
					JOptionPane.showMessageDialog(null, "Abaixo do peso");
				}else if (total < 25) {
					JOptionPane.showMessageDialog(null, "Peso normal");
				}else if (total < 30) {
					JOptionPane.showMessageDialog(null, "Acima do peso");
				}else {
					JOptionPane.showMessageDialog(null, "Obesidade");
				}
			}
		});
		btnEnviar.setHorizontalAlignment(SwingConstants.LEADING);
		btnEnviar.setBounds(279, 73, 89, 23);
		contentPane.add(btnEnviar);
	}
}
