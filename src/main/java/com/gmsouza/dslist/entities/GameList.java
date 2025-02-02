package com.gmsouza.dslist.entities;

// Importações necessárias para o mapeamento JPA e manipulação de objetos no banco de dados
import jakarta.persistence.*;

import java.util.Objects;

// @Entity indica que a classe GameList será mapeada para uma tabela no banco de dados.
@Entity
@Table(name = "tb_game_list")  // Define o nome da tabela no banco de dados como "tb_game_list"
public class GameList {

    // Atributo id, que é a chave primária da tabela
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // O id será gerado automaticamente pelo banco com auto incremento
    private Long id;

    // Atributo name, que representa o nome da lista de jogos
    private String name;

    // Construtor sem parâmetros necessário para o JPA
    public GameList(){
    }

    // Construtor com parâmetros que inicializa os atributos id e name da classe GameList
    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Métodos Getters e Setters para acessar e modificar os valores dos atributos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Sobrescrita do metodo equals para comparar dois objetos GameList
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;  // Verifica se o objeto é da mesma classe
        GameList gameList = (GameList) o;
        return Objects.equals(id, gameList.id);  // Compara os objetos pelo id
    }

    // Sobrescrita do metodo hashCode para gerar o código hash baseado no id
    @Override
    public int hashCode() {
        return Objects.hashCode(id);  // Gera o hashCode baseado no id
    }
}