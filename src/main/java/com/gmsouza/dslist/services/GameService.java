package com.gmsouza.dslist.services;

import com.gmsouza.dslist.dto.GameMinDTO;
import com.gmsouza.dslist.entities.Game;
import com.gmsouza.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//A classe de Service devolve um DTO (Data Transfer Objects)
public class GameService{

    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll(){

        //var result = gameRepository.findAll();
        List<Game> result = gameRepository.findAll();

        //Operação para transformar todos Objetos Game em GameMin
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
