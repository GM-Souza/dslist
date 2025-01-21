package com.gmsouza.dslist.repositories;

import com.gmsouza.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
