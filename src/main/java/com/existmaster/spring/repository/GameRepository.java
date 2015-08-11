package com.existmaster.spring.repository;

import com.existmaster.spring.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by existmaster on 2015. 8. 11..
 */
public interface GameRepository extends JpaRepository<Game, Integer> {
}
