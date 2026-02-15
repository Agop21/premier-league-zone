package org.pl.premierzone.nations;

import org.pl.premierzone.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nations")
public class NationController {

    private final PlayerService playerService;

    @Autowired
    public NationController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String showNations(Model model) {
        model.addAttribute("nations", playerService.getAllNations());
        return "nations";
    }

    @GetMapping("/{nation}")
    public String showPlayersByNation(@PathVariable String nation, Model model) {
        model.addAttribute("nation", nation);
        model.addAttribute("players", playerService.getPlayersByNation(nation));
        return "players-by-nation";
    }
}
