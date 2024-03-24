package br.com.fiap.keep.achievement;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("achievements")
public class AchievementController {

    @GetMapping
    public String index(Model model){
        model.addAttribute("goals", List.of(
                "Desenvolver Interface de Login",
                "Implementar CRUD de Usuários",
                "Configurar Autenticação JWT",
                "Criar Testes de Integração"
        ));
        return "task/index";
    }

}
