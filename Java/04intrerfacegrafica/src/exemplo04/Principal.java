 package exemplo04;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
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
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\Apex03\\Desktop\\Patricio\\Java\\04intrerfacegrafica\\Imagens\\iconfinder_boy_628296.png"));
		lblImagem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblImagem.setBounds(149, 0, 128, 128);
		contentPane.add(lblImagem);
		
		JCheckBox cbkFrontEnd = new JCheckBox("Front-End");
		cbkFrontEnd.setBounds(6, 147, 97, 23);
		contentPane.add(cbkFrontEnd);
		
		JCheckBox ckbDevJava = new JCheckBox("Dev-Java");
		ckbDevJava.setBounds(169, 147, 97, 23);
		contentPane.add(ckbDevJava);
		
		JCheckBox ckbDevCSharp = new JCheckBox("Dev-C#");
		ckbDevCSharp.setBounds(331, 147, 97, 23);
		contentPane.add(ckbDevCSharp);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Mensagem
				String mensagem = "Você selecionou:\n";
				
				// Verificar se ouve seleção
				boolean  checar = false;
				
				// Validar CheckBoxes
				if (cbkFrontEnd.isSelected()) {
					mensagem += "Front-End\n";
					checar = true;
				}
				
				if (ckbDevJava.isSelected()) {
					mensagem += "Dev. Java\n";
					checar = true;
				}
				
				if (ckbDevCSharp.isSelected()) {
					mensagem += "Dev. C#\n";
					checar = true;
				}
				
				// Exibit mensagem
				JOptionPane.showMessageDialog(null, checar == true ? mensagem : "Selecionar um cargo");
				
			}
		});
		btnEnviar.setBounds(163, 190, 89, 23);
		contentPane.add(btnEnviar);
	}
}
