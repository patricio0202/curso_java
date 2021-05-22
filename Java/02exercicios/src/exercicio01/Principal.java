package exercicio01;

import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {
		
		// Obter valor
		String nome = JOptionPane.showInputDialog("Informe o produto");
		String pagamento = JOptionPane.showInputDialog("Informe a forme de pagamento");
		double valor = Integer.parseInt (JOptionPane.showInputDialog ("Informe o valor do produto"));
		double resultado = 0;
		
		// Condicional
		if (valor > 500 && pagamento.equals ("avista")){
			resultado = (valor * 0.9);
			System.out.println(resultado+" "+nome);
		}else {
			System.out.println(nome+ " "+valor);
		}
		
	}

}
