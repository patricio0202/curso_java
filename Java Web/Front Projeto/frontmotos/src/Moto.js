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
      codigo : '',
      marca : '',
      modelo : '',
      ano : '',
      cilindrada : '',
      vetor: []
    }
  }

  componentDidMount(){
    this.listar();
  }


  //Listar
  listar = () => {
    fetch ('http://localhost:8081/api')
    .then(retorno => retorno.json())
    .then(retorno =>{
      this.setState ({vetor : retorno})
    })
  }

  

  // Render 
  render (){
    return(
      <div>
        
        <form>

          <input type='text' value={this.state.marca} placeholder='Marca da moto' name='marca' className='form-control'/>
          <input type='text' value={this.state.modelo} placeholder='Modelo da moto' name='modelo' className='form-control'/>
          <input type='text' value={this.state.ano} placeholder='Ano da moto' name='ano' className='form-control'/>
          <input type='text' value={this.state.cinlindrada} placeholder='Cilindrada da moto' name='cilindrada' className='form-control'/>
        
          <div>

            <input type='button' value='Cadastrar' className='btn btn-primary'/>
            <input type='button' value='Editar' className='btn btn-warning'/>
            <input type='button' value='Remover' className='btn btn-danger'/>
            <input type='button' value='Cancelar' className='btn btn-secondary'/>

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
                </tr>
              );
            })}
          </tbody>

        </table>

      </div>
    )
  
  }
}