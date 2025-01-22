package com.gmsouza.dslist.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

/*Quando há uma relação de MUITOS para MUITOS, a Chave Primaria da terceira tabela relacional,
é a composição das duas chaves estrangeiras.

Como esta aplicação segue o Modelo de Objetos, faz-se necessario a criação desta classe auxilar,
para unificar as duas "Chaves Estrangeiras" (GAME, GameList) em um unico Objeto, para servir de Primary Key.
*/


//@Embeddable = "Encapsulando" DOIS atributos em apenas UMA classe
@Embeddable
public class BelonginPK {

    //Criação das duas chaves estrageiras
    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name="list_id")
    private GameList list;

    public BelonginPK(){

    }

    public BelonginPK(GameList list, Game game) {
        this.list = list;
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BelonginPK that = (BelonginPK) o;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}
