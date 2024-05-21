package mk.finki.ukim.webappgymspringboot.web.Controllers;

import mk.finki.ukim.webappgymspringboot.Model.Product;
import mk.finki.ukim.webappgymspringboot.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController
{

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProductPage (@RequestParam(required = false) String error , Model model)
    {
        if (error!=null && error.isEmpty())
        {
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        List<Product> products = this.productService.findAll();
        model.addAttribute("products",products);
        model.addAttribute("bodyContent","products");
        return "master-template";
    }
}