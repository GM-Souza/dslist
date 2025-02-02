package com.gmsouza.dslist.controllers;

// Importação das dependências necessárias, como DTOs, serviços e anotações do Spring
import com.gmsouza.dslist.dto.GameListDTO;
import com.gmsouza.dslist.dto.GameMinDTO;
import com.gmsouza.dslist.dto.ReplacementDTO;
import com.gmsouza.dslist.services.GameListService;
import com.gmsouza.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A anotação @RestController define essa classe como um controlador REST, ou seja,
// ela é responsável por manipular as requisições HTTP e retornar respostas no formato JSON
@RestController
@RequestMapping(value = "/lists") // Define que todos os endpoints nesta classe começam com "/lists"
public class GameListController {

    // A anotação @Autowired injeta automaticamente as dependências de GameListService e GameService
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    // Metodo para listar todas as listas de jogos. A resposta será uma lista de GameListDTO
    @GetMapping
    public List<GameListDTO> findAll() {
        // Chama o serviço para buscar todas as listas de jogos e retorna a lista de GameListDTO
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    // Metodo para buscar os jogos de uma lista específica. O ID da lista é passado na URL
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        // Chama o serviço de GameService para buscar os jogos associados à lista com o ID fornecido
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    // Metodo para mover um jogo dentro da lista. A solicitação é feita com o ID da lista,
    // e os índices de origem e destino para o movimento do jogo dentro da lista
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        // Chama o serviço GameListService para mover o jogo na lista com base nos índices fornecidos
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}