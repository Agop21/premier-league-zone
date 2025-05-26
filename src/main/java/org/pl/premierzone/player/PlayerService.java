package org.pl.premierzone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByTeam(String teamName) {
        return playerRepository.findByTeam(teamName);
    }

    public List<Player> getPlayerByName(String playerName) {
        return playerRepository.findByNameContainingIgnoreCase(playerName);
    }

    public List<Player> getPlayersByPos(String position) {
        return playerRepository.findByPositionContainingIgnoreCase(position);
    }

    public List<Player> getPlayersByNation(String nation) {
        return playerRepository.findByNationContainingIgnoreCase(nation);
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position) {
        return playerRepository.findByTeamAndPosition(team, position);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        return playerRepository.findById(id).map(player -> {
            player.setName(updatedPlayer.getName());
            player.setTeam(updatedPlayer.getTeam());
            player.setPosition(updatedPlayer.getPosition());
            player.setNation(updatedPlayer.getNation());
            player.setAge(updatedPlayer.getAge());
            player.setMp(updatedPlayer.getMp());
            player.setStarts(updatedPlayer.getStarts());
            player.setMin(updatedPlayer.getMin());
            player.setGoals(updatedPlayer.getGoals());
            player.setAssists(updatedPlayer.getAssists());
            player.setPenaltyKicks(updatedPlayer.getPenaltyKicks());
            player.setYellowCards(updatedPlayer.getYellowCards());
            player.setRedCards(updatedPlayer.getRedCards());
            player.setXg(updatedPlayer.getXg());
            player.setXag(updatedPlayer.getXag());
            return playerRepository.save(player);
        }).orElse(null);
    }

    @Transactional
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
