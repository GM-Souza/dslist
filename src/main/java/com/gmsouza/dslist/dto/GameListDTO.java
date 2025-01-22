/*As classes DTO criam uma padronização no projeto,
e evita loops por referências ciclicas.
*/

package com.gmsouza.dslist.dto;

import com.gmsouza.dslist.entities.Game;
import com.gmsouza.dslist.entities.GameList;
import org.springframework.beans.BeanUtils;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}