// Importar modolo React
import React from 'react';

// Classe
class Propriedades extends React.Component{

  // Construtor
  constructor (props){
    super(props);
  }

  // Render
  render (){
    return (
      <div>
        <h1>Nome: {this.props.nome}</h1>
        <h1>Idade:  {this.props.idade}</h1>
      </div>
    )
  }  

}

// Exportar
export default Propriedades;