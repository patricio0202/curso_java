package exemplo09;

public class Principal {

	public static void main(String[] args) {

		// Indice
		int indice = 1;
		
		// Laço
		while (indice < 11) {
			if (indice % 2 == 0) {
				System.out.println( indice + " é par");
			}else {
				System.out.println(indice + " é impar");
			}
			
			indice++;
		}

	}

}
