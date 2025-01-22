package com.gmsouza.dslist.dto;

import com.gmsouza.dslist.entities.Game;

//Versão "resumida" do Objeto game, contendo apenas as principais variaveis
public class GameMinDTO{
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){

    }

    //O parametro passado na Classe, faz o papel de copiar os dados de Game e passar para o DTO.
    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
