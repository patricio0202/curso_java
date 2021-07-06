package br.com.motos.api.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.motos.api.modelo.MotoModelo;

/**
 * MotoRepositorio
 */


public interface MotoRepositorio extends CrudRepository<MotoModelo, Integer>{

  // Cadastrar ou Alterar
  <MotoModel extends MotoModelo> MotoModel save(MotoModelo mm);

  // listar
  List<MotoModelo> findAll();

  // Pesquisar
  MotoModelo findByCodigo (int codigo);

  // Deletar
  void delete(MotoModelo mm);
  
}

