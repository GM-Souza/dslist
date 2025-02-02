package com.gmsouza.dslist.dto;

// Importação da entidade Game e da projeção GameMinProjection
import com.gmsouza.dslist.entities.Game;
import com.gmsouza.dslist.projections.GameMinProjection;

// A classe GameMinDTO representa uma versão "resumida" de um objeto Game, contendo apenas as principais variáveis
// Isso ajuda a otimizar a transferência de dados, retornando somente as informações essenciais sobre o jogo.
public class GameMinDTO {

    // Atributos que representam uma versão resumida dos dados do jogo
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    // Construtor sem parâmetros (necessário para deserialização, por exemplo, ao receber uma requisição)
    public GameMinDTO(){

    }

    // Construtor que recebe uma entidade Game e copia seus dados para o DTO
    public GameMinDTO(Game entity) {
        this.id = entity.getId();              // Copia o id da entidade Game
        this.title = entity.getTitle();        // Copia o título da entidade Game
        this.year = entity.getYear();          // Copia o ano da entidade Game
        this.imgUrl = entity.getImgUrl();      // Copia a URL da imagem do jogo
        this.shortDescription = entity.getShortDescription();  // Copia a descrição curta do jogo
    }

    // Construtor que recebe uma projeção GameMinProjection e copia seus dados para o DTO
    public GameMinDTO(GameMinProjection projection) {
        this.id = projection.getId();          // Copia o id da projeção GameMinProjection
        this.title = projection.getTitle();    // Copia o título da projeção
        this.year = projection.getYear();      // Copia o ano da projeção
        this.imgUrl = projection.getImgUrl();  // Copia a URL da imagem da projeção
        this.shortDescription = projection.getShortDescription();  // Copia a descrição curta da projeção
    }

    // Métodos getters para acessar os dados do DTO
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