package mk.finki.ukim.webappgymspringboot.web.Controllers;

import mk.finki.ukim.webappgymspringboot.Repository.UserRepository;
import mk.finki.ukim.webappgymspringboot.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController
{

    private final UserService userService;

    public RegisterController( UserService userService) {
        this.userService = userService;

    }

    @GetMapping
    public String getRegisterPage(Model model)
    {
        model.addAttribute("bodyContent","register");
        return "master-template";
    }

    @PostMapping
    public String register (@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam String repeatedPassword,
                            @RequestParam String name ,
                            @RequestParam String surname)
    {
        this.userService.register(username,name,surname,password,repeatedPassword);
        return "redirect:/logIn";
    }
}
