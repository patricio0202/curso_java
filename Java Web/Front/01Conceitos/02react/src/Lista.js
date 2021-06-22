// Incrementar
// Importar modolo React
import React from 'react';

// Classe
class Lista extends React.Component{

  // Render
  render (){

    var nomes = ['Alexandre', 'Maicon', 'Marcela', 'Rebeca'];

    return (
        <ul>
          {
              nomes.map((objeto, indice) => {
                return <li key={objeto}>{indice+1} - {objeto}</li>
              } )
          }
        </ul>
    )
  }  

}

// Exportar
export default Lista;