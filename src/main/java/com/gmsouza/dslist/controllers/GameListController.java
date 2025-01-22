package com.gmsouza.dslist.controllers;

//Classe responsavel por implementar a API

import com.gmsouza.dslist.dto.GameListDTO;
import com.gmsouza.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

        @Autowired
        private GameListService gameListService;

        @GetMapping
        public List<GameListDTO> findAll(){
            List<GameListDTO> result = gameListService.findAll();
            return result;
        }
}
