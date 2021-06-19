// Após carregar tofo HTML e CSS
window.onload = function(){

    // Json local
    var pokemons = []

    // ONbert o elemnto lista
    var lista = document.getElementById("lista")

    // Obter o local onde serão criados os modair
    var modais = document.getElementById("modais")


    // Realizar uma consulta via API
    fetch("https://pokeapi.co/api/v2/pokemon?limit=151")
    .then(dados => dados.json())
    .then(dados => pokemons = dados.results)
    .then(pokemons => {
        for (var i = 0; i < pokemons.length; i++){

          // Card
          var linha =  '<div class = "col-xl-2 col-sm-6">'
                linha += '<div class = "card">' 
                  linha += '<img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/'+(i+1)+'.png">'
                  linha += '<p>'+ pokemons[i].name+'</p>'
                  linha += '<a href="#" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#modal'+i+'">informações</a>'
                linha += '</div>'
              linha += '</div>'

              lista.innerHTML += linha

          // Modal
          var modal = '<div class="modal fade" id="modal'+i+'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">'
                modal += '<div class="modal-dialog modal-xl">'
                  modal += '<div class="modal-content">'
                      modal += '<div class="modal-header">'
                        modal += '<h1>' +pokemons[i].name+'</h1>'
                        modal += '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>'
                    modal += '</div>'

                  modal += '<div class="modal-body">'
                    modal += '<div class="row">'
                      modal += '<div class="col-md-6">'
                      modal += '<img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/'+(i+1)+'.png">'
                  modal += '</div>'

                      modal += '<div class="col-md-6">'
                      modal += '<img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/'+(i+1)+'.png">'
                  modal += '</div>'
                modal += '</div>'
              modal += '</div>'
            modal += '</div>'
          modal += '</div>'

          modais.innerHTML += modal

        }
    })

}