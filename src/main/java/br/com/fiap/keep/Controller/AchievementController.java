package br.com.fiap.keep.Controller;

import br.com.fiap.keep.model.Achievement;
import br.com.fiap.keep.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/achievement")
public class AchievementController {

    private final AchievementRepository achievementRepository;

    @Autowired
    public AchievementController(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @GetMapping
    public String index(Model model){
        List<Achievement> achievements = achievementRepository.findAll();
        model.addAttribute("achievements", achievements);
        return "achievement/index";
    }
}
