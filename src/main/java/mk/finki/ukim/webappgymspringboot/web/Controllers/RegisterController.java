package mk.finki.ukim.webappgymspringboot.web.Controllers;

import mk.finki.ukim.webappgymspringboot.Model.Exceptions.InvalidArgumentsException;
import mk.finki.ukim.webappgymspringboot.Model.Exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.webappgymspringboot.Repository.UserRepository;
import mk.finki.ukim.webappgymspringboot.Service.AuthenticationService;
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

    private final AuthenticationService authenticationService;

    public RegisterController( AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;

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
        try {
            this.authenticationService.register(username, password, repeatedPassword, name, surname);
            return "redirect:/logIn";
        }
        catch (InvalidArgumentsException | PasswordsDoNotMatchException exc)
        {
            return "redirect:/register?error=" + exc.getMessage();
        }
    }
}
