package exemplo01;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		// Vetor
		ArrayList<String> cursos = new ArrayList <String>();
		
		cursos.add("Lógica e Algoritomos");
		cursos.add("Banco de dados");
		cursos.add("Java Fundamentos");
		cursos.add("Java Web");
		
		// Remover curso
		cursos.remove(1);
		
		// Alterar cursos
		cursos.set(2, "java - Spring");
		
		// Quantidade de cursos
		System.out.println("Quantidade de cursos cadastrados " + cursos.size());
		
		// Listar
		for (String elemento : cursos) {
			System.out.println(elemento);
		}
	}

}
