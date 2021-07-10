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

    // Editar
    editar = () => {

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
          "codigo" : this.state.codigo,
          "nome" : this.state.nome,
          "valor" : this.state.valor
        }
          fetch ('http://localhost:8080/api',{
            method: 'PUT',
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

            // Verificar a picosão do vetor que será editado
            var indiceEditar = copiaVetor.findIndex((objeto) => {
              return objeto.codigo === this.state.codigo;
            });
  
            // Alterar elemento
            copiaVetor[indiceEditar] = obj;
  
            // Sobrepor o state vetor
            this.setState({vetor : copiaVetor})
  
            // Limpar campos
            this.limparCampos();
  
            // Alterar status e mensagem
            this.setState({
              statusAlerta : 'ok',
              textoAlerta :  'Alteração realizado com sucesso'
  
            })

            this.setState({cadastro : true})
  
          })
      }
    }

    // Remover
    remover = (e) =>{

      // Fetch
      fetch ('http://localhost:8080/api/' + this.state.codigo, {
            method: 'DELETE',
            headers:{
              'Accept' : 'application/json',
              'Content-Type' : 'application/json'
            },
          })
          .then(() => {
  
            // Fazer uma copia do state vetor
            var copiaVetor = [...this.state.vetor];

            // Verificar a picosão do vetor que será removido
            var indiceRemover = copiaVetor.findIndex((objeto) => {
              return objeto.codigo === this.state.codigo;
            });
  
            // Remover elemento
            copiaVetor.splice(indiceRemover, 1);
  
            // Sobrepor o state vetor
            this.setState({vetor : copiaVetor})
  
            // Limpar campos
            this.limparCampos();
  
            // Alterar status e mensagem
            this.setState({
              statusAlerta : 'ok',
              textoAlerta :  'Produto deletado com sucesso'
  
            })

            this.setState({cadastro : true})
  
          })

    }

    // Calcelar
    cancelar = () => {

      // Limpar campos
      this.limparCampos();

      // Exibir botão de cadastro
      this.setState({cadastro : true})

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
    });

    this.setState({cadastro : false});
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
              <input type='button' value='Editar' className='btn btn-warning' onClick={this.editar}/>  
              <input type='button' value='Remover' className='btn btn-danger' onClick={this.remover}/>
              <input type='button' value='Cancelar' className='btn btn-secondary' onClick={this.cancelar}/>
            </div>
          }
        </form>

        {/* Table */}
        <table  >
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