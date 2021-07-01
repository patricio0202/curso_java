package br.com.apex.clientes.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apex.clientes.modelo.ClienteModelo;
import br.com.apex.clientes.repositorio.RepositorioCliente;

/**
 * ClienteControle
 */
@RestController
public class ClienteControle {

  @Autowired
  private RepositorioCliente acoes;

  @GetMapping(value="")
  public String helloWord(){
    return "Hello Word";
  }
  
  @PostMapping(value="/api")
  public @ResponseBody ClienteModelo cadastrar (@RequestBody ClienteModelo cm){
    return acoes.save(cm);
  }

  @GetMapping(value="/api")
  public List<ClienteModelo> listar(){
    return acoes.findAll();
  }

  @GetMapping(value="/api/nome")
  public List<ClienteModelo> ListarPorNomes(){
    return acoes.findByOrderByNomeAsc();
  }

  @GetMapping (value="/api/{nome}/{cidade}")
  public ClienteModelo operadorE(@PathVariable String nome, @PathVariable String cidade){
    return acoes.findByNomeAndCidade(nome, cidade);
  }

  @GetMapping(value="/api/contem/{termo}")
  public List<ClienteModelo> contem (@PathVariable String termo){
    return acoes.findByNomeContains(termo);
  }
}