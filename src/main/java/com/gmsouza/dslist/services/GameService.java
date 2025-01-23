package com.gmsouza.dslist.services;

import com.gmsouza.dslist.dto.GameDTO;
import com.gmsouza.dslist.dto.GameMinDTO;
import com.gmsouza.dslist.entities.Game;
import com.gmsouza.dslist.projections.GameMinProjection;
import com.gmsouza.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//A classe de Service devolve um DTO (Data Transfer Objects)
@Service
public class GameService{

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(@PathVariable Long listId) {
        Game result = gameRepository.findById(listId).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();

        //Operação para transformar todos Objetos Game em GameMin
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(GameMinDTO::new).toList();
    }
}