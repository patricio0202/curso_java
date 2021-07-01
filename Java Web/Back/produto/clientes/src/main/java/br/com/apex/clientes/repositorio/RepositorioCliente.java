package br.com.apex.clientes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.apex.clientes.modelo.ClienteModelo;

/*
  Repository - Ações base de banco de dados (SELECT, INSERT, UPDATE E DELETE)
  CrudRepository - Além de funçoes CRUD, podemos trabalhar com AND, OR, LIKE, BETWEEN, IN e WHERE
  JpaRepository - Trablha com todas as funções do repository e CrudRepository, além de paginação
*/

@Repository
public interface RepositorioCliente extends CrudRepository <ClienteModelo, Integer>{

  // Cadastrar
  <Cli extends ClienteModelo> Cli save(ClienteModelo cm);
  
  // Listar
  List<ClienteModelo> findAll();

  // Ordenar listagem (ASC = crescente ou DESC = decrescente)
  List<ClienteModelo> findByOrderByNomeAsc();

  // Operadores lógicos (E - AND, OU - OR)
  ClienteModelo findByNomeAndCidade(String nome, String cidade);

  // Contém determinado termo (LIKE)
  List<ClienteModelo> findByNomeContains(String termo);
}