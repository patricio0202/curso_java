package exemplo03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

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
		
		JRadioButton rdbtnjava = new JRadioButton("Java");
		rdbtnjava.setBounds(126, 22, 55, 23);
		rdbtnjava.setActionCommand("Java");
		contentPane.add(rdbtnjava);
		
		JRadioButton rdbtnCSharp = new JRadioButton("C#");
		rdbtnCSharp.setBounds(244, 22, 109, 23);
		rdbtnCSharp.setActionCommand("C#");
		contentPane.add(rdbtnCSharp);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnjava);
		grupo.add(rdbtnCSharp);
		
		JButton btnTeste = new JButton("Teste");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, grupo.getSelection().getActionCommand());
			}
		});
		btnTeste.setBounds(167, 74, 89, 23);
		contentPane.add(btnTeste);
	}
}
