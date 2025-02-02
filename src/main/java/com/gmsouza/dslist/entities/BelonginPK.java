package com.gmsouza.dslist.entities;

// Importações do JPA para definir a chave composta e os relacionamentos entre entidades
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

/*
Quando há uma relação de muitos para muitos entre duas entidades, a chave primária da tabela
intermediária (que mapeia a relação) é composta pelas duas chaves estrangeiras.

Como estamos utilizando o modelo de objetos (ORM), é necessário criar uma classe auxiliar que
unifique as duas chaves estrangeiras em um único objeto, para que ele possa atuar como chave primária
na tabela intermediária.
*/

// @Embeddable indica que esta classe será usada para embutir em outra classe (a chave composta)
@Embeddable
public class BelonginPK {

    // Definição da chave estrangeira que mapeia o relacionamento com a tabela de jogos (Game)
    @ManyToOne
    @JoinColumn(name="game_id")  // Define a coluna que será usada para armazenar a chave estrangeira para o jogo
    private Game game;

    // Definição da chave estrangeira que mapeia o relacionamento com a tabela de listas de jogos (GameList)
    @ManyToOne
    @JoinColumn(name="list_id")  // Define a coluna que será usada para armazenar a chave estrangeira para a lista
    private GameList list;

    // Construtor sem parâmetros necessário para a persistência e uso pelo JPA
    public BelonginPK(){
    }

    // Construtor que inicializa a chave composta com os valores de GameList e Game
    public BelonginPK(GameList list, Game game) {
        this.list = list;  // Inicializa a lista de jogos
        this.game = game;  // Inicializa o jogo
    }

    // Métodos getter e setter para acessar e modificar a chave estrangeira de Game
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    // Métodos getter e setter para acessar e modificar a chave estrangeira de GameList
    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    // Sobrescrição do metodo equals para comparar duas instâncias de BelonginPK
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;  // Verifica se o objeto é válido e da mesma classe
        BelonginPK that = (BelonginPK) o;
        // Verifica se os dois objetos têm os mesmos valores para Game e GameList
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    // Sobrescrição do metodo hashCode para gerar o código hash da chave composta
    @Override
    public int hashCode() {
        // Gera o hashCode usando os objetos de Game e GameList
        return Objects.hash(game, list);
    }
}