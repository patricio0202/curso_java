package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Notas extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Notas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbxProvas = new JComboBox();
		cbxProvas.setBounds(26, 104, 377, 22);
		contentPane.add(cbxProvas);
		
		JComboBox cbxTurmas = new JComboBox();
		cbxTurmas.setBounds(26, 180, 377, 22);
		contentPane.add(cbxTurmas);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\16Escola\\Imagens\\provas.png"));
		lblNewLabel.setBounds(178, 11, 64, 64);
		contentPane.add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Fechar oJframe
				dispose();
				
				// Exlibir o Jframe professor
				Professor p = new Professor();
				p.setVisible(true);
				
			}
		});
		btnSair.setBounds(335, 11, 89, 23);
		contentPane.add(btnSair);
	}

}
