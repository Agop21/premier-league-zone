package org.pl.premierzone.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data")
public class PlayerDataController {

    private final PlayerService playerService;

    @Autowired
    public PlayerDataController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String showPlayersByNation(
            @RequestParam String nation,
            Model model
    ) {
        model.addAttribute("selectedNation", nation);
        model.addAttribute("players", playerService.getPlayersByNation(nation));
        return "data";
    }
}
