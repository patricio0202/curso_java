
// JSON
var pessoas = []

// Vrificar se existe dados no localstorage
window.onload = function(){

  if (localStorage.getItem('dados') != null){
    pessoas = JSON.parse (localStorage.getItem ('dados'))
    listar()
  }
}
//Função de cadastro
function cadastrar(){

  // Obter objetos
  var nome = document.getElementById ('nome')
  var idade = document.getElementById ('idade')
  var alerta = document.getElementById ('alerta')

  // Remover as classes-alertdanger e alert-success
  alerta.classList.remove ('alert-danger')
  alerta.classList.remove ('alert-success')

  //Validar campos
  if (nome.value == ''){
    alerta.classList.add ('alert-danger')
    alerta.innerHTML = 'Favor informar um nome'
    return false
  }

  if (idade.value == ''){
    alerta.classList.add ('alert-danger')
    alerta.innerHTML = 'Informar uma idade'
    return false
  }

  // Adicionar a classe alert-success e o texto
  alerta.classList.add ('alert-success')
  alerta.innerHTML = 'Cadastro efetuado com sucesso!'

  //Cadastras no JSON
  pessoas.push ({'nome':nome.value, 'idade':idade.value})

  // console
  //console.table (pessoas)

  // Limpar os campos
  nome.value = ''
  idade.value = ''

  // Cursor no campo nome
  nome.focus()

  //Atualizar tabela
  listar()

  // Adicionar no localstorage
  adicionarLocalStorage()

}



// Função de listagem
function listar (){

  //Obter o elemento tabela
  var tabela = document.getElementById ('tabela')

  // Lmpar a tabela
  tabela.innerHTML = ''

  // laço
  for (var indice = 0; indice < pessoas.length; indice++){

    //Criar linha
    var linha = tabela.insertRow (-1)

    // Criar colunas
    var colunacodigo = linha.insertCell (0)
    var colunanome = linha.insertCell (1)
    var colunaidade = linha.insertCell (2)
    var colunaremover = linha.insertCell (3)

    //Valores
    colunacodigo.innerHTML = indice + 1
    colunanome.innerHTML = pessoas[indice].nome
    colunaidade.innerHTML = pessoas[indice].idade
    colunaremover.innerHTML = "<button class = ' btn btn-danger' onClick ='remover("+ indice +")' > remover </ button>"
  }
}

//Função remoção
function remover (posicao){
  
  //Remover JSON
  pessoas.splice (posicao, 1)

  //Remover os dados no localstorage
  localStorage.removeItem ('dados')

  //Enviar o JSON atualizado para localstorage
  localStorage.setItem ('dados', JSON.stringify(pessoas))

  // Atualizar a tabela
  listar ()
}  

// Adicionar ao localstorage
function adicionarLocalStorage (){
  localStorage.setItem ('dados', JSON.stringify(pessoas))
}