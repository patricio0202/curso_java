package br.com.projeto.produto.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.produto.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer>{
	
	// Cadastrar e alterar
	ProdutoModelo save(ProdutoModelo pm);
	
	// Listar
	List<ProdutoModelo> findAll();
	
	// Pesquisa
	ProdutoModelo findByCodigo(int codigo);
	
	// Remover
	void delete(ProdutoModelo pm);
	
	

}
