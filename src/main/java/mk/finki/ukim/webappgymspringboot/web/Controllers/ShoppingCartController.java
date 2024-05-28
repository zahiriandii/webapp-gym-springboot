package mk.finki.ukim.webappgymspringboot.web.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.webappgymspringboot.Model.Product;
import mk.finki.ukim.webappgymspringboot.Model.ShoppingCart;
import mk.finki.ukim.webappgymspringboot.Model.User;
import mk.finki.ukim.webappgymspringboot.Service.AuthenticationService;
import mk.finki.ukim.webappgymspringboot.Service.ProductService;
import mk.finki.ukim.webappgymspringboot.Service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController
{

    private final ShoppingCartService shoppingCartService;
    private final AuthenticationService authenticationService;
    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, AuthenticationService authenticationService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.authenticationService = authenticationService;
        this.productService = productService;
    }

    @GetMapping
    private String getShoppingCartPage(@RequestParam(required = false) String error, Model model, HttpServletRequest req)
    {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/logIn";
        }

        ShoppingCart shoppingCart = this.shoppingCartService.getActiveShoppingCart(user.getUsername());
        model.addAttribute("products",this.shoppingCartService.listAllProductsInShoppingCart(shoppingCart.getId()));
        model.addAttribute("bodyContent","shopping-cart");
        return "master-template";
    }

    //Shopping cart addproduct

    @PostMapping("/add-product/{id}")
    public String addProductToShoppingCart(@PathVariable Long id, HttpServletRequest req)
    {
        User username = (User) req.getSession().getAttribute("user");
        this.shoppingCartService.addProductToShoppingCart(username.getUsername(),id);
        return "redirect:/products";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductFromShoppingCart (@PathVariable Long id,HttpServletRequest req)
    {
        User username = (User) req.getSession().getAttribute("user");
        this.shoppingCartService.deleteProductById(id, username.getUsername());
        return "redirect:/shopping-cart";
    }
}
