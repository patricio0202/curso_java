package exemplo06;

public class Principal {
	
		public static void main(String[] args) {
			
			// M�dia
			double media = 7;
			
			// Condicional simples
			/*if(media >= 7) {
				System.out.println("Aprovado");
			}else {
				System.out.println("Reprovado");
			}*/
			
			// Condicional composta
			if (media >= 7) {
				System.out.println("Aprovado");
			}else if (media >= 5){
				System.out.println("Em exame");
			}else {
				System.out.println("Reprovado");
			}
			
		}

}
