package mk.finki.ukim.webappgymspringboot.web.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.webappgymspringboot.Model.Exceptions.InvalidArgumentsException;
import mk.finki.ukim.webappgymspringboot.Model.Exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.webappgymspringboot.Model.User;
import mk.finki.ukim.webappgymspringboot.Service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logIn")
public class LogInController
{
    private final AuthenticationService authenticationService;

    public LogInController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String getLogInPage(Model model)
    {
        model.addAttribute("bodyContent","logIn");
        return "master-template";
    }

    @PostMapping
    public String logIn (HttpServletRequest req , Model model)
    {
        User user= null;
        try {
            user = this.authenticationService.login(req.getParameter("username"), req.getParameter("password"));
        }
        catch (InvalidArgumentsException | InvalidUserCredentialsException exc)
        {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exc.getMessage());
            model.addAttribute("bodyContent","logIn");
            return "master-template";
        }

        req.getSession().setAttribute("user",user);
        return "redirect:/products";
    }
}
