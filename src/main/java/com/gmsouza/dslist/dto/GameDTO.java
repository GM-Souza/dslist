package com.gmsouza.dslist.dto;

// Importação da classe BeanUtils do Spring para copiar propriedades entre objetos
import org.springframework.beans.BeanUtils;
import com.gmsouza.dslist.entities.Game;

// A classe GameDTO é um Data Transfer Object (DTO), que é usada para transferir dados entre camadas da aplicação.
// O DTO ajuda a evitar referências cíclicas e melhora a performance ao limitar as informações transferidas.
public class GameDTO {

    // Atributos que representam os dados do jogo que serão transferidos via API
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    // Construtor que recebe uma entidade Game e usa BeanUtils para copiar as propriedades da entidade para o DTO
    public GameDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }

    // Métodos getters e setters para acessar e modificar os valores dos atributos do DTO

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
}