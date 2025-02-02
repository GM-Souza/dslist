package com.gmsouza.dslist.controllers;

// Importação das dependências necessárias, como DTOs, serviço e anotações do Spring
import com.gmsouza.dslist.dto.GameDTO;
import com.gmsouza.dslist.dto.GameMinDTO;
import com.gmsouza.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// A anotação @RestController define essa classe como um controlador REST, ou seja,
// ela é responsável por manipular as requisições HTTP e retornar respostas no formato JSON
@RestController
@RequestMapping(value = "/games")  // Mapeia as requisições para o endpoint "/games"
public class GameController {

    // A anotação @Autowired faz com que o Spring injete automaticamente a dependência de GameService
    @Autowired
    private GameService gameService;

    //Metodo para buscar um jogo pelo seu ID. A anotação @PathVariable pega o valor do "id" na URL

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        // Chama o serviço para buscar o jogo pelo ID e retorna um objeto GameDTO
        GameDTO result = gameService.findById(id);
        return result;
    }

    // Metodo para listar todos os jogos. A resposta será uma lista de objetos do tipo GameMinDTO
    @GetMapping
    public List<GameMinDTO> findAll() {
        // Chama o serviço para buscar todos os jogos e retorna a lista
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}