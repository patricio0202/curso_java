package exercicio04;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe um valor"));
		int opcao = 0;
		double total = 0;
		String menu = "1) Real p/ D�lar \n";
		       menu+= "2) Real p/ Libra \n";
		       menu+= "3) Real p/ Euro \n";
		       menu+= "4) D�lar p/ Real \n";
		       menu+= "5) D�lar p/ Libra \n";
		       menu+= "6) D�lar p/ Euro \n";
		       menu+= "7) Libra p/ Real \n";
		       menu+= "8) Libra p/ D�lar \n";
		       menu+= "9) Libra p/ Euro \n";
		       menu+= "10) Euro p/ Real";
		       menu+= "11) Euro p/ D�lar";
		       menu+= "12) Euro p/ Libra";
		       
		opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		if (opcao == 1) {
			total = (valor * 5.37);
		}else if (opcao == 2) {
			total = (valor * 7.60);
		}else if (opcao == 3) {
			total = (valor * 6.54);
		}else if (opcao == 4) {
			total = (valor / 5.37);
		}else if (opcao == 5) {
			total = (valor * 0.71);
		}else if (opcao == 6) {
			total = (valor * 0.82);
		}else if (opcao == 7) {
			total = (valor / 7.60);
		}else if (opcao == 8) {
			total = (valor / 0.71);
		}else if (opcao == 9) {
			total = (opcao * 1.16);
		}else if (opcao == 10) {
			total = (opcao / 6.54);
		}else if (opcao == 11) {
			total = (opcao / 0.82);
		}else {
			total = (valor / 1.16);
		}
		
		JOptionPane.showMessageDialog(null, total);
		
	}

}
