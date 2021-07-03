package br.com.motos.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.motos.api.repositorio.MotoRepositorio;

@CrossOrigin
@RestController 
public class MotoControle {

  @Autowired
  private MotoRepositorio acao;

  @GetMapping(value="")
  public String principal() {
    return "Olá";
  }

  

}