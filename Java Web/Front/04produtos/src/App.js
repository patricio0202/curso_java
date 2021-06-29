  // Importar módulo react
  import React from 'react';

  // Importar CSS
  import './estilos.css';

  // Classe
  export default class App extends React.Component{

  // Construtor
  constructor(props){
    super(props);

    this.state ={
      cadastro : true,
      codigo : '',
      nome : '',
      valor : '',
      vetor : [],
      statusAlerta : '',
      textoAlerta : ''
    }
  }

  // Antes de executar o Render
  componentDidMount(){
    this.listar();
  }

  // Ao digitar
  aoDigitar = (e) => {
    var nomeCampo = e.target.name;
    var valorCampo = e.target.value;

    this.setState({[nomeCampo] : valorCampo});
  }

  // Cadstrar
  cadastrar = () => {

    if (this.state.nome === ''){
      this.setState({
        statusAlerta : 'Falha',
        textoAlerta :  'O campo nome precisa ser preenchido'
      })
    }else if (this.state.valor === ''){
      this.setState({
        statusAlerta : 'Falha',
        textoAlerta :  'O campo valor precisa ser preenchido'
      })
    }else{

      var obj = {
        "nome" : this.state.nome,
        "valor" : this.state.valor
      }
        fetch ('http://localhost:8080/api',{
          method: 'POST',
          headers:{
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
          },
          body: JSON.stringify(obj)
        })
        .then(retorno => retorno.json())
        .then(retorno => {

          // Fazer uma copia do state vetor
          var copiaVetor = [...this.state.vetor];

          // Adicionar um nome elemento
          copiaVetor.push(retorno);

          // Sobrepor o state vetor
          this.setState({vetor : copiaVetor})

          // Limpar campos
          this.limparCampos();

          // Alterar status e mensagem
          this.setState({
            statusAlerta : 'ok',
            textoAlerta :  'Cadastro realizado com sucesso'

          })

        })
    }
  }

  // Limar campos
  limparCampos = () => {
    this.setState({
      codigo : '',
      nome : '',
      valor : ''
    })
  }

  // Listar

  listar = () =>{
    fetch('http://localhost:8080/api')
    .then(retorno => retorno.json())
    .then(retorno => {
      this.setState({vetor : retorno})
    })
  }

  // Função selecionar
  selecionar = (e) => {

    // Indice
    var indice = e.target.value;

    // Extrair linha do state vetor
    var obj = this.state.vetor[indice]

    // Extrair os dados do vetor
    this.setState ({
      codigo : obj.codigo,
      nome : obj.nome,
      valor : obj.valor
    })
    }


  // Render
  render(){
    return(
      <div>

        {/* Formulario */}
        <form>

          <div
          
          className={
            this.state.statusAlerta === 'Falha' ? 'alert alert-danger' :
            this.state.statusAlerta === 'ok' ? 'alert alert-success' :
            ''
          }

          >
            
            {this.state.textoAlerta}
          
          </div>

          <input type='text' value={this.state.nome} placeholder='Nome do produto' name='nome' onChange={this.aoDigitar} className='form-control'/>
          <input type='text' value={this.state.valor} placeholder='Valor do produto' name='valor' onChange={this.aoDigitar} className='form-control'/>

          {
            this.state.cadastro == true ?
              <input type='button' value='Cadastrar' className='btn btn-primary' onClick={this.cadastrar}/>
            :
            <div>
              <input type='button' value='Editar' className='btn btn-warning'/>  
              <input type='button' value='Remover' className='btn btn-danger'/>
              <input type='button' value='Cancelar' className='btn btn-secondary'/>
            </div>
          }
        </form>

        {/* Table */}
        <table className='table table-striped'>
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Valor</th>
              <th>Selecionar</th>
            </tr>
          </thead>

          <tbody>
            {this.state.vetor.map((produto, indice) => {
              return (
                <tr>
                  <td>{produto.codigo}</td>
                  <td>{produto.nome}</td>
                  <td>{produto.valor}</td>
                  <td><button className= 'btn btn-success' value={indice} onClick={this.selecionar}> Selecionar</button></td>
                </tr>
              )
            })}
          </tbody>

        </table>

      </div>
    );
  }

}