package mk.finki.ukim.webappgymspringboot.Service;

import mk.finki.ukim.webappgymspringboot.Model.Product;
import mk.finki.ukim.webappgymspringboot.Model.ShoppingCart;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    List<Product> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addProductToShoppingCart(String username, Long productId);

    List<ShoppingCart> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to);

    List<ShoppingCart> findAll();

    Long countSuccessfulOrders(String username);

    ShoppingCart save(ShoppingCart shoppingCart);

    Optional<ShoppingCart> findById(Long id);

}
