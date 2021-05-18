package exemplo04;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		// Exibir uma mensagem
		//JOptionPane.showMessageDialog(null, "Hello word!");
		
		// Obter um dado
		//String texto = JOptionPane.showInputDialog("Informe algo");
		
		// Caixa de confirmação
		int opcao = JOptionPane.showConfirmDialog (null, "Gostando de java?");
		JOptionPane.showConfirmDialog (null, "O número da opção é " + opcao);
		
	}

}
