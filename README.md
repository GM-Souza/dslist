# Sobre o Projeto

  Este é um projeto realizado para estudo, através de um mini curso de 5 dias, apresentado por [Nélio Alves](https://www.instagram.com/devsuperior.ig/).

 - O foco foi a criação de uma API Rest para listagem de jogos.

 - Cada jogo (Game) é composto por suas categorias e caracteristicas: (Nome, Nota de aprovação, Gênero, Plataforma, entre outros).

 - Os jogos são armazenados e enumerados em uma lista (Game List) no Banco de dados.
     - O mapeamento foi realizado através de JPA e Hibernate.
     - O Banco escolhido foi o H2.
     - os dados para compor os jogos foram isenridos através do arquivo import.sql

- A parte interessante do projeto, é a possibilidade de alterar a posição de um jogo, de acordo com a preferência do úsuario. Exemplo:
    Mover um jogo da posição 3 para 1. E com essa movimentação, atualizar a lista para se adaptar a nova formação.


# Objetivo

  O objetivo do projeto foi estudar a criação de uma API com framework Spring Boot, utilizando JPA para mapeamento, H2 para armazenamento de dados e Postman para requisições.
  
  Além disso, foi possivel aprender sobre a delegação correta de Classes e pacotes (controllers, service, entities, repositories, DTOs) para estruturar projetos robustos.
  
