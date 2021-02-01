package springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping()
    public String home(Model model){
        return "redirect:clients";
    }
}
