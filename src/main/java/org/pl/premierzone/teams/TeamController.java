package org.pl.premierzone.teams;

import org.pl.premierzone.player.Player;
import org.springframework.ui.Model;
import org.pl.premierzone.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final PlayerService playerService;

    @Autowired
    public TeamController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String showTeamsPage(Model model) {
        List<String> teams = playerService.getAllTeams(); // You'll write this method next
        model.addAttribute("teams", teams);
        return "teams"; // This renders templates/teams.html
    }

    @GetMapping("/{teamName}")
    public String getPlayersByTeam(@PathVariable String teamName, Model model) {
        List<Player> players = playerService.getPlayersByTeam(teamName);
        model.addAttribute("players", players);
        model.addAttribute("teamName", teamName);
        return "teamPlayers"; // New page to show players in a team
    }
}

