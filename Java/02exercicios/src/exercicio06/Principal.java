package exercicio06;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int n = 0;
		int total = 0;
	
		do {
			n = Integer.parseInt (JOptionPane.showInputDialog("Informe um numero"));
			total = (total + n);
			
		}while (n != 0);
		
		JOptionPane.showMessageDialog(null, total);
	

	}

}
