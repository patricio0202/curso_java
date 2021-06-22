// Importar modolo React
import React from 'react';

// Classe
class Texto extends React.Component{

  // Construtor
  constructor(props){
    super(props);

    this.state = {texto : ''}
  }

  // Função ao digitar
  aoDigitar = (elemento) => {
    this.setState({texto : elemento.target.value});
  }

  // Render
  render (){
    return (
      <div>
        {/* <h1>{this.state.texto}</h1> */}
        <h1>{this.state.texto == '' ? 'Não foi digitado nada' : this.state.texto}</h1>
        <hr/>
        <input type = 'text' onChange = {this.aoDigitar} />
      </div>
    )
  }  

}

// Exportar
export default Texto;