package exercicio03;

import javax.swing.JOptionPane;



public class Principal {

	public static void main(String[] args) {
		
		int peso = Integer.parseInt (JOptionPane.showInputDialog("Informe o peso"));
		double altura = Double.parseDouble (JOptionPane.showInputDialog("Informe a altura"));
		double total = 0;
		
		total = (peso / (altura * altura));
		
		if (total < 15) {
			JOptionPane.showMessageDialog(null, "Muito abaixo do peso");
		}else if (total < 17.5) {
			JOptionPane.showMessageDialog(null, "Abaixo do peso");
		}else if (total < 25) {
			JOptionPane.showMessageDialog(null, "Peso normal");
		}else if (total < 30) {
			JOptionPane.showMessageDialog(null, "Acima do peso");
		}else if (total < 35) {
			JOptionPane.showMessageDialog(null, "Obesidade 1");
		}else if (total < 40) {
			JOptionPane.showMessageDialog(null, "Obesidade 2");
		}else {
			JOptionPane.showMessageDialog(null, "Obesidade 3");
		}

	}

}
