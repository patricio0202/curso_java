
package br.com.motos.api.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.motos.api.modelo.ImagemModelo;

/**
 * ImagemRepositorio
 */
public interface ImagemRepositorio extends CrudRepository<ImagemModelo, Integer>{

  // Selecionar
  List <ImagemModelo> findAll();
}