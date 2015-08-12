package com.existmaster.spring.repository;

import com.existmaster.spring.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by existmaster on 2015. 8. 11..
 */
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
