// Importar modolo React
import React from 'react';

// Importar CSS
import './Estilos.css'; 

// Classe
class Agenda extends React.Component{

  // Render
  render (){
    return (
      <div>
        {/* Formulario */}
        <form>
            <input type = 'text' placeholder='Nome' className ='form-control'/>
            <input type = 'text' placeholder='E-mail' className ='form-control'/>
            <input type = 'text' placeholder='Cidade' className ='form-control'/>
            <input typo = 'button' value = 'Cadastrar' className = 'btn btn-primary'/>
        </form>

        {/* Tabela */}
        <table className = 'table table-striped'>
           <thead>
              <tr>
                <th>#</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Cidade</th>
              </tr>
            </thead>

              <tbody>
                <tr>
                  <td>1</td>
                  <td>Lucas</td>
                  <td>lucas.silva@gmail.com</td>
                  <td>Blumenau</td>
                </tr>
              </tbody>

        </table>

      </div>
    )
  }  

}

// Exportar
export default Agenda;