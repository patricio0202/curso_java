package br.com.motos.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.motos.api.modelo.ImagemModelo;
import br.com.motos.api.repositorio.ImagemRepositorio;

/**
 * ImagemControle
 */
@RestController
public class ImagemControle {

  @Autowired
  private ImagemRepositorio acao;

  @GetMapping(value="/api/imagens")
  public List<ImagemModelo> selecionar(){
    return acao.findAll();
  }
}