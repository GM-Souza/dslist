package com.gmsouza.dslist.dto;

// Importação da entidade GameList que será usada para popular o DTO
import com.gmsouza.dslist.entities.GameList;

public class GameListDTO {

    // Atributos que representam os dados de uma lista de jogos que serão transferidos via API
    private Long id;
    private String name;

    // Construtor que recebe uma entidade GameList e popula o DTO com os dados dessa entidade
    public GameListDTO(GameList entity) {
        id = entity.getId();   // Copia o id da entidade GameList para o DTO
        name = entity.getName(); // Copia o nome da entidade GameList para o DTO
    }

    // Metodo getter para acessar o id da lista de jogos
    public Long getId() {
        return id;
    }

    // Metodo getter para acessar o nome da lista de jogos
    public String getName() {
        return name;
    }
}