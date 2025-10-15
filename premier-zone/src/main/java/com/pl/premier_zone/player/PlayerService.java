package com.pl.premier_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component //this class should be managed by the spring container
public class PlayerService { //creates an instance and spring will manage life cycle
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPLayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName){
        return playerRepository.findByTeam(teamName); //more efficiently does the filtering instead
        //of loading all the player into memory then using java server side to filter
//        return playerRepository.findAll().stream()
//                .filter(player -> teamName.equals(player.getTeam()))
//                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findByNameContainingIgnoreCase(searchText);
    }

    public List<Player> getPlayersByPos(String searchText){
        return playerRepository.findByPosContainingIgnoreCase(searchText);
    }

    public List<Player> getPlayersByNation(String searchText){
        return playerRepository.findByNationContainingIgnoreCase(searchText);
    }

    public List<Player> getPlayersByTeamAndPos(String teamName, String pos){
        return playerRepository.findByTeamAndPos(teamName, pos);
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());
        if (existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerToUpdate.setTeam(updatedPlayer.getTeam());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName){
        playerRepository.deleteByName(playerName);
    }
}
