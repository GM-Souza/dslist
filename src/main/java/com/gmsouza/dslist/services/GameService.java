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

// A classe de Service devolve um DTO (Data Transfer Objects),
// que serve como uma abstração de dados para o transporte entre a camada de dados e a camada de apresentação.
@Service
public class GameService {

    // Injeção do repositório GameRepository para realizar operações de acesso a dados no banco.
    @Autowired
    private GameRepository gameRepository;

    // Metodo para buscar um jogo específico pelo seu ID.
    // A anotação @Transactional(readOnly = true) indica que esse metodo não irá modificar os dados e só realizará leitura.
    @Transactional(readOnly = true)
    public GameDTO findById(@PathVariable Long listId) {
        // Busca o jogo no banco com o ID fornecido e converte o objeto Game para o DTO GameDTO.
        Game result = gameRepository.findById(listId).get();
        return new GameDTO(result);
    }

    // Metodo para retornar todos os jogos da base de dados.
    // A anotação @Transactional(readOnly = true) melhora o desempenho para consultas.
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        // Busca todos os jogos da tabela "tb_game" e mapeia cada jogo para um GameMinDTO.
        List<Game> result = gameRepository.findAll();

        // A operação abaixo transforma cada objeto Game em GameMinDTO,
        // que é uma versão simplificada do Game (contendo apenas as informações essenciais).
        return result.stream().map(GameMinDTO::new).toList();
    }

    // Metodo para buscar os jogos que pertencem a uma lista específica, identificada pelo listId.
    // Também utiliza a anotação @Transactional(readOnly = true) para otimizar a leitura.
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {

        // Busca os jogos relacionados à lista através de uma projeção (GameMinProjection) que otimiza a consulta.
        List<GameMinProjection> games = gameRepository.searchByList(listId);

        // A operação abaixo transforma a lista de projeções (GameMinProjection) em uma lista de GameMinDTO.
        return games.stream().map(GameMinDTO::new).toList();
    }
}