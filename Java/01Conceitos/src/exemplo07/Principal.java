package exemplo07;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		// Variavel
		String cidade = JOptionPane.showInputDialog("Informe uma cidade");
		
		// Switch
		switch (cidade) {
			case "Blumenau":
			System.out.println("Cidade da Oktoberfest");
			break;
			
			case "Florianopolis":
			System.out.println("Capital de Santa Catarina");
			break;
			
			default:
			System.out.println("Cidade não encontrada");
		}

	}

}
