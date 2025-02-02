package com.gmsouza.dslist.entities;

// Importações necessárias para o mapeamento JPA e manipulação de objetos no banco de dados
import jakarta.persistence.*;

import java.util.Objects;

// @Entity indica que a classe Game será mapeada para uma tabela no banco de dados.
@Entity
@Table(name = "tb_game")  // Define o nome da tabela no banco de dados como "tb_game"
public class Game {

    // Atributo id, que é a chave primária da tabela
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // O id será gerado automaticamente pelo banco, com auto incremento
    private Long id;

    // Atributo título do jogo
    private String title;

    // Customizando o nome da variável, pois "year" é uma palavra reservada do banco de dados
    @Column(name = "game_year")  // O nome da coluna no banco será "game_year"
    private Integer year;

    // Atributos adicionais que descrevem o jogo
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    // Atributos de descrição do jogo, sendo definidos como tipos TEXT no banco
    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    // Construtor sem parâmetros necessário para o JPA
    public Game(){

    }

    // Construtor que inicializa todos os atributos da classe Game
    public Game(Long id, String title, String genre, Integer year, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    // Métodos Getters e Setters para acessar e modificar os valores dos atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    // Sobrescrita do metodo equals para comparar dois objetos Game
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;  // Verifica se o objeto é da mesma classe
        Game game = (Game) o;
        return Objects.equals(id, game.id);  // Compara os objetos pelo id
    }

    // Sobrescrita do metodo hashCode para gerar o código hash baseado no id
    @Override
    public int hashCode() {
        return Objects.hashCode(id);  // Gera o hashCode baseado no id
    }
}