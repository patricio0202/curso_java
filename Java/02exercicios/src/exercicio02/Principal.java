package exercicio02;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe um número"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe outro número"));
		int resultado = 0;
		int opcao = 0;
		String menu = "1) somar \n2) subtração \n3) multiplicação \n4) divisão";
		
		
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
