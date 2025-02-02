package com.gmsouza.dslist.dto;

// A classe ReplacementDTO é um Data Transfer Object (DTO) que representa as informações necessárias
// para realizar a movimentação de um item (no caso, um jogo) dentro de uma lista de jogos.
public class ReplacementDTO {

    // Atributos para armazenar os índices de origem e destino para a movimentação
    private Integer sourceIndex;        // Índice do jogo na lista de origem
    private Integer destinationIndex;   // Índice do jogo na lista de destino

    // Metodo getter para acessar o índice de origem
    public Integer getSourceIndex() {
        return sourceIndex;
    }

    // Metodo setter para definir o índice de origem
    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    // Metodo getter para acessar o índice de destino
    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    // Metodo setter para definir o índice de destino
    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }
}