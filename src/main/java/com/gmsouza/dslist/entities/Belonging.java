package com.gmsouza.dslist.entities;

// Importação de anotações e classes do JPA para persistência de dados e criação de entidades no banco de dados
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity  // Define essa classe como uma entidade do JPA, que será mapeada para uma tabela no banco de dados
@Table(name = "tb_belonging")  // Define o nome da tabela no banco de dados como "tb_belonging"
public class Belonging {

    // Atributo id, que é uma chave composta (mapeada por um EmbeddedId) representando a relação entre Game e GameList
    @EmbeddedId
    private BelonginPK id = new BelonginPK();  // O objeto BelonginPK é responsável por armazenar a chave composta (Game + GameList)

    // Atributo para armazenar a posição do jogo na lista
    private Integer position;

    // Construtor sem parâmetros necessário para o JPA
    public Belonging(){
    }

    // Construtor que inicializa os valores de game, list e position
    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);   // Define o jogo (Game) associado a essa relação
        id.setList(list);    // Define a lista de jogos (GameList) associada a essa relação
        this.position = position;  // Define a posição do jogo na lista
    }

    // Getter para acessar a chave composta (id) da relação entre Game e GameList
    public BelonginPK getId() {
        return id;
    }

    // Setter para definir a chave composta (id) da relação
    public void setId(BelonginPK id) {
        this.id = id;
    }

    // Getter para acessar a posição do jogo na lista
    public Integer getPosition() {
        return position;
    }

    // Setter para definir a posição do jogo na lista
    public void setPosition(Integer position) {
        this.position = position;
    }

    // Metodo equals para comparar dois objetos Belonging com base na chave composta (id)
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;  // Verifica se o objeto é válido e se é da mesma classe
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);  // Compara os objetos usando a chave composta
    }

    // Metodo hashCode para gerar o código hash da entidade, com base na chave composta (id)
    @Override
    public int hashCode() {
        return Objects.hashCode(id);  // Gera o hashCode com base no id
    }
}