package exercicio05;

import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {
		
		int ano1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o primeiro ano"));
		int ano2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o segundo ano"));
		int contador = 0;
		
		
		while (ano1 <= ano2) {
			if (ano1 % 4 == 0) {
				contador++;
			
			}
			
			
			ano1++;
		}
		
		JOptionPane.showMessageDialog(null, contador +" Anos bissextos");
		
		
	}

}
