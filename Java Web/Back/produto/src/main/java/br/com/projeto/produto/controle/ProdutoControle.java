package br.com.projeto.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.produto.modelo.ProdutoModelo;
import br.com.projeto.produto.repositorio.ProdutoRepositorio;

@CrossOrigin(origins = "*")
@RestController
public class ProdutoControle {
	
	@Autowired
	private ProdutoRepositorio acao;

	@GetMapping(value="")
	public String principal() {
		return "Hello Word!";
	}
	@GetMapping(value="/nome/{variavel}")
	public String nome(@PathVariable String variavel) {
		return "Olá "+variavel;
	}
	
	@PostMapping(value="/api")
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo pm) {
		return acao.save(pm);
	}
	
	@GetMapping(value="/api")
	public List<ProdutoModelo> selecionar() {
		return acao.findAll();	
	}
	
	@GetMapping(value="/api/{codigo}")
	public @ResponseBody ProdutoModelo pesquisar(@PathVariable int codigo) {
		return acao.findByCodigo(codigo);
	}
	
	@PutMapping(value="/api")
	public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo pm) {
		return acao.save(pm);
	}
	
	@DeleteMapping(value="/api/{codigo}")
	public void remover(@PathVariable int codigo) {
		
		ProdutoModelo pm = acao.findByCodigo(codigo);
		acao.delete(pm);
		
	}
	
	
}
