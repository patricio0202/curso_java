package exercicio02;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe um n�mero"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe outro n�mero"));
		int resultado = 0;
		int opcao = 0;
		String menu = "1) somar \n2) subtra��o \n3) multiplica��o \n4) divis�o";
		
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		if (opcao == 1) {
			resultado = (n1 + n2);
		}else if (opcao == 2){
			resultado = (n1 - n2);
		}else if (opcao == 3) {
			resultado = (n1 * n2);
		}else {
			resultado = (n1 / n2);
		}
		
		JOptionPane.showMessageDialog(null, resultado);
	}

}
