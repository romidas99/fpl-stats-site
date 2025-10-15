package com.pl.premier_zone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PlayerRepository extends JpaRepository<Player, String> { //Player is entity type and String is the primary id type
    void deleteByName(String playerName);
    Optional<Player> findByName(String name);
    List<Player> findByTeam(String team);
    List<Player> findByNameContainingIgnoreCase(String name);
    List<Player> findByPosContainingIgnoreCase(String pos);
    List<Player> findByNationContainingIgnoreCase(String nation);
    List<Player> findByTeamAndPos(String team, String pos);
}





