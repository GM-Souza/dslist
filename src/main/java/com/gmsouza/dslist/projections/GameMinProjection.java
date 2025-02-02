package com.gmsouza.dslist.projections;

// Interface GameMinProjection que define um contrato para a projeção de dados de jogos com informações mínimas
public interface GameMinProjection {

    // Metodo para obter o id do jogo
    Long getId();

    // Metodo para obter o título do jogo
    String getTitle();

    // Metodo para obter o ano de lançamento do jogo
    Integer getYear();

    // Metodo para obter a URL da imagem do jogo
    String getImgUrl();

    // Metodo para obter a descrição curta do jogo
    String getShortDescription();

    // Metodo para obter a posição do jogo em uma lista (caso aplicável)
    Integer getPosition();
}