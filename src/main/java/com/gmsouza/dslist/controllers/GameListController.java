package com.gmsouza.dslist.controllers;

import com.gmsouza.dslist.dto.GameListDTO;
import com.gmsouza.dslist.dto.GameMinDTO;
import com.gmsouza.dslist.dto.ReplacementDTO;
import com.gmsouza.dslist.services.GameListService;
import com.gmsouza.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")

//Classe responsável por implementar a API
public class GameListController {

        @Autowired
        private GameListService gameListService;

        @Autowired
        private GameService gameService;

        @GetMapping
        public List<GameListDTO> findAll(){
            List<GameListDTO> result = gameListService.findAll();
            return result;
        }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}

