// Importar módulo react
import React from 'react';

// Importar CSS
import './estilos.css';

// Importar imagens
import bitcoin from './imagens/bitcoin.png';
import xrp from './imagens/XRP.png';
import ethereum from './imagens/ethereum.png';
import litecoin from './imagens/Litecoin.png';

// Classe
export default class App extends React.Component{

  // Construtor
  constructor(propos){
    super(propos);

    this.state = {
      bitcoin : 0,
      ethereum : 0,
      litecoin : 0,
      XRP : 0
    }
  }

  

  // Antes de criar o componente
  componentDidMount (){

    // Bitcoin
    setInterval(() => {
      fetch('https://www.mercadobitcoin.net/api/BTC/ticker/')
      .then(dados => dados.json())
      .then(dados => this.setState ({bitcoin : dados.ticker.buy}))
    }, 5000);

        // Ethereum
    setInterval(() => {
      fetch('https://www.mercadobitcoin.net/api/ETH/ticker/')
      .then(dados => dados.json())
      .then(dados => this.setState ({ethereum : dados.ticker.buy}))
    }, 5000);

    setInterval(() => {
      fetch('https://www.mercadobitcoin.net/api/LTC/ticker/')
      .then(dados => dados.json())
      .then(dados => this.setState ({litecoin : dados.ticker.buy}))
    }, 5000);

    setInterval(() => {
      fetch('https://www.mercadobitcoin.net/api/XRP/ticker/')
      .then(dados => dados.json())
      .then(dados => this.setState ({XRP : dados.ticker.buy}))
    }, 5000);


  }

  // Render
  render(){
    return (
      <div className='container'>
        <div className='row'>

          <div className='col-xl-3 col-md-4 col-sm-6'>
            <div className='card'>
              <img src = {bitcoin}/>
              <p>Bitcoin</p>
              <p>R${Number (this.state.bitcoin).toFixed(2)}</p>
            </div>
          </div>

          <div className='col-xl-3 col-md-4 col-sm-6'>
            <div className='card'>
              <img src = {xrp}/>
              <p>XRP</p>
              <p>R${Number (this.state.XRP).toFixed(2)}</p>
            </div>
          </div>

          <div className='col-xl-3 col-md-4 col-sm-6'>
            <div className='card'>
              <img src = {ethereum}/>
              <p>Etherium</p>
              <p>R${Number (this.state.ethereum).toFixed(2)}</p>
            </div>
          </div>

          <div className='col-xl-3 col-md-4 col-sm-6'>
            <div className='card'>
              <img src = {litecoin}/>
              <p>Litecoin</p>
              <p>R${Number (this.state.litecoin).toFixed(2)}</p>
            </div>
          </div>

        </div>
      </div>
    );
  }

}