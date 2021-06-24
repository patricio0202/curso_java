// Importar modolo React
import React from 'react';

// Importar CSS
import './Estilos.css'; 

// Classe
class Agenda extends React.Component{

  // Construtor
  constructor (propos){
    super(propos);

    this.state ={
      nome : '',
      email :'',
      cidade : '',
      vetor : []
    }
  }

  // Ao digitar
  aoDigitar = (elemento) => {

    var nome = elemento.target.name;
    var valor = elemento.target.value;

    this.setState({
      [nome] : valor}
    );

  }

  // Cadastrar
  cadastrar = () => {

    // Copia do vetor
    var copiaVetor = [...this.state.vetor];

    // Objeto
    var objeto = {
      'nome':this.state.nome,
      'email':this.state.email,
      'cidade':this.state.cidade
      }

      // Cadastrar no vetor copiado
      copiaVetor.push(objeto);

      // Sobrepor o vator (state)
      this.setState({vetor : copiaVetor});

      // Limpar campos
      this.setState({
        nome : '',
        email : '',
        cidade : ''
      }); 

  }

  // Remover
  remover = (elemento) => {

    // Obter o indice
    var indice = elemento.target.value
    
    // Cópia do vetor
    var copiaVetor = [...this.state.vetor];

    // Remover
    copiaVetor.splice(indice, 1);

    // Atualizar state
    this.setState({vetor : copiaVetor});

  }

  // Render
  render (){
    return (
      <div>
        {/* Formulario */}
        <form>
            <input type = 'text' value={this.state.nome} placeholder='Nome' className ='form-control' name="nome" onChange={this.aoDigitar}/>
            <input type = 'text' value={this.state.email} placeholder='E-mail' className ='form-control'name= "email" onChange={this.aoDigitar}/>
            <input type = 'text' value={this.state.cidade} placeholder='Cidade' className ='form-control'name= "cidade" onChange={this.aoDigitar}/>
            <input type = 'button' value='Cadastrar' className = 'btn btn-primary' onClick={this.cadastrar}/>
        </form>

        {/* Tabela */}
        <table className = 'table table-striped'>
           <thead>
              <tr>
                <th>#</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Cidade</th>
                <th>Remover</th>
              </tr>
            </thead>

              <tbody>
                {this.state.vetor.map((objeto, linha) => {
                  return (
                  <tr>
                    <td>{linha + 1}</td>
                    <td>{objeto.nome}</td>
                    <td>{objeto.email}</td>
                    <td>{objeto.cidade}</td>
                    <td><button className = 'btn btn-danger' value={linha} onClick={this.remover}>Remover</button></td>
                  </tr>
                  )
                })}
              </tbody>

        </table>

      </div>
    )
  }  

}

// Exportar
export default Agenda;