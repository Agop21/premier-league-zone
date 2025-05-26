package org.pl.premierzone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);
    void deleteById(Long id);

    List<Player> findByTeam(String team);
    List<Player> findByPositionContainingIgnoreCase(String position);
    List<Player> findByNationContainingIgnoreCase(String nation);
    List<Player> findByTeamAndPosition(String team, String position);
    List<Player> findByNameContainingIgnoreCase(String name);
}
