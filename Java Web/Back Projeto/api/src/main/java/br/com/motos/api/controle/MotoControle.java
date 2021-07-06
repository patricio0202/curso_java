package br.com.motos.api.controle;

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

import br.com.motos.api.modelo.MotoModelo;
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
  @PostMapping(value="/api")
  public @ResponseBody MotoModelo cadastrar(@RequestBody MotoModelo mm){
    return acao.save(mm);
  }
  @GetMapping(value="/api")
  public List<MotoModelo> selecionar() {
    return acao.findAll();
  }
  @GetMapping(value="/api/{codigo}")
  public @ResponseBody MotoModelo pesquisar(@PathVariable int codigo){
    return acao.findByCodigo(codigo);
  }
  @PutMapping(value="/api")
  public @ResponseBody MotoModelo alterar(@RequestBody MotoModelo mm){
    return acao.save(mm);
  }

  @DeleteMapping(value="/api/{codigo}")
  public void remover (@PathVariable int codigo){

    MotoModelo mm = acao.findByCodigo(codigo);
    acao.delete(mm);
  }

}