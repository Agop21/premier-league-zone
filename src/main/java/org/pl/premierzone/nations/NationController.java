package org.pl.premierzone.nations;

import org.pl.premierzone.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        List<NationOption> nationOptions = playerService.getAllNations().stream()
                .map(value -> {
                    String code = NationFlag.extractCode(value);
                    String flag = NationFlag.fromCode(code).getFlagIconClass();
                    return new NationOption(value, code, flag);
                })
                .toList();

        model.addAttribute("nations", nationOptions);
        return "nations";
    }

    public record NationOption(String name, String code, String flag) {
    }
}
