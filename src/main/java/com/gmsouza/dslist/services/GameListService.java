package com.gmsouza.dslist.services;

import com.gmsouza.dslist.dto.GameListDTO;
import com.gmsouza.dslist.entities.GameList;
import com.gmsouza.dslist.projections.GameMinProjection;
import com.gmsouza.dslist.repositories.GameListRepository;
import com.gmsouza.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//A classe de Service devolve um DTO (Data Transfer Objects)
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    // Metodo para retornar todas as listas de jogos.
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        // Recupera todas as listas de jogos do repositório.
        List<GameList> result = gameListRepository.findAll();

        // Converte a lista de entidades GameList para uma lista de GameListDTO e retorna.
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    // Função para reposicionar jogos dentro de uma lista, com base na origem e no destino.
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        // Recupera a lista de jogos da lista específica (ordenada por posição) usando o repositório.
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        // Remove o jogo da posição de origem.
        GameMinProjection obj = list.remove(sourceIndex);

        // Adiciona o jogo na nova posição de destino.
        list.add(destinationIndex, obj);

        // Define os índices mínimo e máximo para a iteração (do menor para o maior).
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        // Atualiza a posição dos jogos na tabela 'tb_belonging' com base nas novas posições.
        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}