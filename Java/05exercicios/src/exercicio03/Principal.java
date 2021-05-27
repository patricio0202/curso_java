package exercicio03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
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
		setBounds(100, 100, 450, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnBitcoin = new JRadioButton("Real p/ Bitcoin");
		rdbtnBitcoin.setHorizontalAlignment(SwingConstants.TRAILING);
		rdbtnBitcoin.setBounds(0, 22, 109, 23);
		rdbtnBitcoin.setActionCommand("Bitcoin");
		contentPane.add(rdbtnBitcoin);
		
		JRadioButton rdbtnLitecoin = new JRadioButton("Real p/ Litecoin");
		rdbtnLitecoin.setBounds(111, 22, 109, 23);
		rdbtnLitecoin.setActionCommand("Litecoin");
		contentPane.add(rdbtnLitecoin);
		
		JRadioButton rdbtnDoge = new JRadioButton("Real  p/ Doge");
		rdbtnDoge.setBounds(224, 22, 109, 23);
		rdbtnDoge.setActionCommand("Doge");
		contentPane.add(rdbtnDoge);
		
		JRadioButton rdbtnXRP = new JRadioButton("Real p/ XRP");
		rdbtnXRP.setBounds(335, 22, 109, 23);
		rdbtnXRP.setActionCommand("XRD");
		contentPane.add(rdbtnXRP);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnBitcoin);
		grupo.add(rdbtnLitecoin);
		grupo.add(rdbtnDoge);
		grupo.add(rdbtnXRP);
		
		
		txtValor = new JTextField();
		txtValor.setBounds(171, 78, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double valor = Double.parseDouble (txtValor.getText());
				double resultado = 0;
				
				if (grupo.getSelection().getActionCommand().equals("Bitcoin")) {
					resultado = (valor * 207470);
				}else if (grupo.getSelection().getActionCommand().equals("Litecoin")) {
					resultado = (valor * 1046);
				}else if (grupo.getSelection().getActionCommand().equals("Doge")) {
					resultado = (valor * 2.34);
				}else
					resultado = (valor * 4.94);
				
				JOptionPane.showMessageDialog(null, resultado);
			}
			
		});
		btnEnviar.setBounds(171, 145, 89, 23);
		contentPane.add(btnEnviar);
				
				
					
				
				
			
		

	}
}
