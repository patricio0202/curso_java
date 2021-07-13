// Importar modelo react
import React from 'react';

// Importar estilos CSS
import './estilos.css';

// Classe 
export default class Moto extends React.Component{
  
  // Construtor
  constructor (propos){
    super (propos);

    this.state ={
      cadastro : true,
      codigo : '',
      marca : '',
      modelo : '',
      ano : '',
      cilindrada : '',
      vetor: [],
      statusAlerta : '',
      textoAlerta : ''
    }
  }

  componentDidMount(){
    this.listar();
  }

  // Ao digitar
  aoDigitar = (e) => {
    var campoNome = e.target.name;
    var campoValor = e.target.value;
    this.setState({[campoNome] : campoValor});
  }

  // Cadastrar
  cadastrar = () => {
    if (this.state.marca === ''){
    this.setState({
      statusAlerta : 'Falha',
      textoAlerta : 'Campo marca precisa ser preenchido'
    })
  }else if (this.state.modelo === ''){
    this.setState({
    statusAlerta : 'Falha',
    textoAlerta : 'Campo modelo precisa ser preenchido'
    })
  }else if(this.state.ano === ''){
    this.setState({
      statusAlerta : 'Falha',
      textoAlerta : 'Campo ano precisa ser preenchido'
    })
  }else if (this.state.cilindrada === ''){
    this.setState({
      statusAlerta : 'Falha',
      textoAlerta : 'Campo cilindrada precisa ser preenchido'
    })
  } else{
    var obj = {
      "marca" : this.state.marca,
      "modelo" : this.state.modelo,
      "ano" : this.state.ano,
      "cilindrada" : this.state.cilindrada
    } 
      fetch ('http://localhost:8081/api',{
        method : 'POST',
        headers:{
          'Accept' : 'application/json',
          'content-type' : 'application/json'
        },
        body : JSON.stringify(obj)
      })
      .then(retorno => retorno.json())
      .then(retorno => {
        
        // Fazer copiar do state vetor
        var copiaVetor = [... this.state.vetor];

        // Adicionar um nome elemento
        copiaVetor.push(retorno);

        // Sobrepor state vetor
        this.setState ({vetor : copiaVetor})

        // Limpar campos
        this.limparCampos();

        // Alterar status e mensagem
        this.setState ({
          statusAlerta : 'ok',
          textoAlerta : 'Cadastro efetuado com sucesso'
        })
        

      })
  }

  }

  // Editar
  editar = () => {
    if (this.state.marca === ''){
      this.setState({
        statusAlerta : 'Falha',
        textoAlerta : 'Campo marca precisa ser preenchido'
      })
    }else if (this.state.modelo === ''){
      this.setState({
      statusAlerta : 'Falha',
      textoAlerta : 'Campo modelo precisa ser preenchido'
      })
    }else if(this.state.ano === ''){
      this.setState({
        statusAlerta : 'Falha',
        textoAlerta : 'Campo ano precisa ser preenchido'
      })
    }else if (this.state.cilindrada === ''){
      this.setState({
        statusAlerta : 'Falha',
        textoAlerta : 'Campo cilindrada precisa ser preenchido'
      })
   }else{

    var obj = {
      "codigo" : this.state.codigo,
      "marca" : this.state.marca,
      "modelo" : this.state.modelo,
      "ano" : this.state.ano,
      "cilindrada" : this.state.cilindrada
    } 
    fetch ('http://localhost:8081/api',{
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

        this.setState({cadastro : true});

      })
  }

  }

  //Listar
  listar = () => {
    fetch ('http://localhost:8081/api')
    .then(retorno => retorno.json())
    .then(retorno =>{
      this.setState ({vetor : retorno})
    })
  }

  // Limpar campos
  limparCampos = () => {
    this.setState({
      codigo : '',
      marca : '',
      modelo : '',
      ano : '',
      cilindrada : ''
    })
  }

  // Função selecionar
  selecionar = (e) => {

    // Indice
    var indice = e.target.value;

    // Extrair linha do state vetor
    var obj = this.state.vetor[indice]



    // Extrair dados do vetor
    this.setState({
      codigo : obj.codigo,
      marca : obj.marca,
      modelo : obj.modelo,
      ano : obj.ano,
      cilindrada : obj.cilindrada

    });

    this.setState({cadastro : false});
  }

   //Remover
   remover = (e) => {

     fetch ('http://localhost:8081/api/' + this.state.codigo, {
       method : 'DELETE',
       headers:{
         'Accept' : 'application/json',
         'Content-Type' : 'application/json'
       },
     })
       .then(() =>{

        // Fazer copia do vetor
         var copiaVetor = [...this.state.vetor];

         // verificar a posição do vetor que sera removido
         var indiceRemover = copiaVetor.findIndex((objeto) => {
           return objeto.codigo === this.state.codigo;
        })

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

          this.setState({cadastro : true});
          
       })
      
   }

   // Cancelar
   cancelar = () => {
     
    // Limpar campos
    this.limparCampos();

    // Exibir botão de cadastro
    this.setState({cadastro : true});

   }


  // Render 
  render (){
    return(
      <div>
        
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

          <input type='text' value={this.state.marca} placeholder='Marca' name='marca' onChange={this.aoDigitar} className='form-control'/>
          <input type='text' value={this.state.modelo} placeholder='Modelo' name='modelo' onChange={this.aoDigitar} className='form-control'/>
          <input type='text' value={this.state.ano} placeholder='Ano' name='ano' onChange={this.aoDigitar} className='form-control'/>
          <input type='text' value={this.state.cilindrada} placeholder='Cilindrada' onChange={this.aoDigitar} name='cilindrada' className='form-control'/>
        
          <div>

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

          </div>

        </form>

        <table className='table table-striped'>
          <thead>
            <tr>
              <th>Código</th>
              <th>Marca</th>
              <th>Modelo</th>
              <th>Ano</th>
              <th>Cilindradas</th>
            </tr>
          </thead>

          <tbody>
            {this.state.vetor.map((moto, indice) => {
              return (
                <tr>
                  <td>{moto.codigo}</td>
                  <td>{moto.marca}</td>
                  <td>{moto.modelo}</td>
                  <td>{moto.ano}</td>
                  <td>{moto.cilindrada}</td>
                  <td><button className= 'btn btn-success' value={indice} onClick={this.selecionar}>selecionar</button></td>
                </tr>
              );
            })}
          </tbody>

        </table>

      </div>
    )
  
  }
}