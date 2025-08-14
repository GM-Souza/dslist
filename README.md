# dslist – API de Listagem de Jogos

## Sobre o Projeto
Este projeto foi desenvolvido durante um mini curso de 5 dias ministrado por **Nélio Alves**. O objetivo principal foi a criação de uma **API REST** para gerenciamento de uma lista de jogos — com foco em organização, manipulação e persistência de dados no backend.

Cada jogo (Game) é composto por atributos como nome, nota de aprovação, gênero, plataforma, entre outros. Os jogos são armazenados em uma lista (Game List) no banco de dados, permitindo, por exemplo, movimentar um jogo da posição 3 para a posição 1, reorganizando toda a lista de acordo com a preferência do usuário.

# Tecnologias utilizadas
- **Java 100 %** como linguagem de programação
- **Spring Boot** para desenvolvimento da API REST
- **Spring Data JPA / Hibernate** para mapeamento objeto-relacional
- **H2** como banco de dados em memória
- **import.sql** para popular os dados iniciais de jogos

# Objetivo do projeto
- Estudar a criação e estruturação de uma API com **Spring Boot**  
- Aprender a utilizar **JPA (Hibernate)** para persistência de entidades  
- Conhecer a aplicação de um banco em memória (**H2**) para ambientes de testes  
- Organizar a aplicação em camadas: controllers, services, entities, repositories e DTOs  
- Implementar a funcionalidade de reordenação dinâmica de elementos em uma lista
