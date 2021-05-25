package exemplo02;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Principal {

	public static void main(String[] args) {
		
		// JFrame
		JFrame frame = new JFrame();
		frame.setSize(800, 500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JTextField
		JTextField campo = new JTextField();
		campo.setBounds(50, 50, 400, 20);
		
		// Ação de teclado
		campo.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (e.getExtendedKeyCode() != 8) {
		
				
					// Obter o termo digitado
					String valor = campo.getText();
				
					// Condicional
					if (valor.length () == 2 || valor.length() == 5) {
					campo.setText(valor+"/");
					
					}
				
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Adicionar o JFrame
		frame.add(campo);
		
		// Exibir o formulário
		frame.setVisible(true);

	}

}
