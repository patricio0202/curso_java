package exemplo01;

public class Principal {

	public static void main(String[] args) {
		
		// Instanciar um objeto da classe carro
		Carro objeto = new Carro ();
		objeto.fabricante = " Hyundai";
		objeto.modelo = " HB20";
		objeto.ano = 2019;
		objeto.valor = 89000;
		objeto.mensagem();
		
	}
	
}
