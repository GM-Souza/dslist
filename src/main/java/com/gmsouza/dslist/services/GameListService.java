package com.gmsouza.dslist.services;

import com.gmsouza.dslist.dto.GameListDTO;
import com.gmsouza.dslist.entities.GameList;
import com.gmsouza.dslist.repositories.GameListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//A classe de Service devolve um DTO (Data Transfer Objects)
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;


    public List<GameListDTO> findAll(){

        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
