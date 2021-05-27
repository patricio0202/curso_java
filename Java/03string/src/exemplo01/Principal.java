package exemplo01;

public class Principal {

	public static void main(String[] args) {
		
		// Variavel
		String texto = "Quarta aula de java Fundamentos";
		
		// Quantidade de caracteres
		System.out.println(texto.length());
		
		// Obter caracter
		for (int i=0; i < texto.length(); i++) {
			System.out.println("O "+(i+1)+ " caracter � "+ texto.charAt(i));
		}
		
		// Letras mai�sculas e min�culas
		System.out.println(texto.toLowerCase());
		System.out.println(texto.toUpperCase());
		
		// Cortar caracteres
		System.out.println(texto.substring(15));
		System.out.println(texto.substring(15, 19));
		
		// Remover espa�os no come�o e no final doa variavel
		String nome = "   Luciano";
		System.out.println(nome.trim());
		
		// Verificar exist�ncia de um caractere
		String email = "Ralf.lima@gmail.com";
		System.out.println(email.indexOf("@"));

		// C�digo ASCII
		char letra = 'L';
		System.out.println((int) letra);
		
		// Vetor de texto
		String cursos = "HTML;JavaScript;Java;MySQL;";
		
		String[] vetor = cursos.split(";");
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor [i]);
		}
		
		
		
		
	}

}
