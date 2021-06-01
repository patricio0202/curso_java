package exemplo02;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		// ArrayList
		ArrayList<Pessoa> dados = new ArrayList<Pessoa>();
		
		// Objetos
		Pessoa p1 = new Pessoa ("Alice",   19);
		Pessoa p2 = new Pessoa ("Lucas",   32);
		Pessoa p3 = new Pessoa ("Rebeca",  21);
		Pessoa p4 = new Pessoa ("Júlio",   14);
		Pessoa p5 = new Pessoa ("Viviane", 37);
		
		// Cadastrar
		dados.add(p1);
		dados.add(p2);
		dados.add(p3);
		dados.add(p4);
		dados.add(p5);
		
		// Listar
		for (int i = 0; i < dados.size(); i++) {
			System.out.println(dados.get(i).getNome());
			System.out.println(dados.get(i).getIdade());
			System.out.println();
		}
		
	}

}
