package com.existmaster.spring.repository;

import com.existmaster.spring.model.Ladder;
import com.existmaster.spring.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by existmaster on 2015. 8. 12..
 */
public interface LadderRepository extends JpaRepository<Ladder, Integer> {


//    String FIND_BY_PLAYER_ID_QUERY = "SELECT l FROM Ladder l WHERE l.player_id = :playerid";
//
//    @Query(FIND_BY_PLAYER_ID_QUERY)
//    List<Ladder> selectByPlayerId(@Param("playerid") int p);

}
