package mk.finki.ukim.webappgymspringboot.web.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.webappgymspringboot.Model.ShoppingCart;
import mk.finki.ukim.webappgymspringboot.Service.AuthenticationService;
import mk.finki.ukim.webappgymspringboot.Service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController
{

    private final ShoppingCartService shoppingCartService;
    private final AuthenticationService authenticationService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, AuthenticationService authenticationService) {
        this.shoppingCartService = shoppingCartService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    private String getShopppingCartPage(@RequestParam(required = false) String error, Model model, HttpServletRequest req)
    {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        ShoppingCart shoppingCart = this.shoppingCartService.getActiveShoppingCart(username);
        model.addAttribute("products",this.shoppingCartService.listAllProductsInShoppingCart(shoppingCart.getId()));
        model.addAttribute("bodyContent","shopping-cart");
        return "master-template";
    }

    //Shopping cart addproduct
}
