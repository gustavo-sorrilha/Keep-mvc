package br.com.fiap.keep.achievement;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("achievements")
public class AchievementController {

    @Autowired
    AchievementRepository repository;

    @Autowired
    MessageSource messageSource;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("achievements", repository.findAll());
        model.addAttribute("user", user.getAttribute("name"));
        model.addAttribute("avatar", user.getAttribute("avatar_url"));
        return "achievement/index";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        var achievement = repository.findById(id);

        if (achievement.isEmpty()){
            redirect.addFlashAttribute("message", "Erro ao apagar. Tarefa não encontrada");
            return "redirect:/achievements";
        }

        repository.deleteById(id);
        redirect.addFlashAttribute("message", messageSource.getMessage("achievement.delete", null, LocaleContextHolder.getLocale()));
        return "redirect:/achievements";
    }

    @GetMapping("new")
    public String form(br.com.fiap.keep.model.Achievement achievement){
        return "achievement/form";
    }

    @PostMapping
    public String create(@Valid br.com.fiap.keep.model.Achievement achievement, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()) return "achievement/form";

        repository.save(achievement);
        redirect.addFlashAttribute("message", "Tarefa cadastrada com sucesso");
        return "redirect:/achievements";
    }


}
