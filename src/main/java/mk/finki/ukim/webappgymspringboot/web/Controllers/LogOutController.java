package mk.finki.ukim.webappgymspringboot.web.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logOut")
public class LogOutController
{

    @GetMapping
    public String logOutPage(HttpServletRequest req)
    {
        req.getSession().invalidate();
        return  "redirect:/logIn";
    }
}
