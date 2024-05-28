package mk.finki.ukim.webappgymspringboot.Service.Implementation;

import mk.finki.ukim.webappgymspringboot.Model.Enumerations.ShoppingCartStatus;
import mk.finki.ukim.webappgymspringboot.Model.Exceptions.UserNotFoundException;
import mk.finki.ukim.webappgymspringboot.Model.Product;
import mk.finki.ukim.webappgymspringboot.Model.ShoppingCart;
import mk.finki.ukim.webappgymspringboot.Model.User;
import mk.finki.ukim.webappgymspringboot.Repository.ProductRepository;
import mk.finki.ukim.webappgymspringboot.Repository.ShoppingCartRepository;
import mk.finki.ukim.webappgymspringboot.Repository.UserRepository;
import mk.finki.ukim.webappgymspringboot.Service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        Optional<ShoppingCart> shoppingCart = this.shoppingCartRepository.findById(cartId);

        return shoppingCart.get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {

        return this.shoppingCartRepository.findByUserUsernameAndStatus(username, ShoppingCartStatus.CREATED)
                .orElseGet(()->{
                    User user = this.userRepository.findByUsername(username)
                            .orElseThrow(()->new UserNotFoundException(username));
                    ShoppingCart shoppingCart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(shoppingCart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        Product product = this.productRepository.findById(productId).get();
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);

        List<Product> productsInShoppingCart = shoppingCart.getProducts().stream()
                .filter(i->i.getId().equals(productId)).collect(Collectors.toList());
        shoppingCart.getProducts().add(product);

        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to) {
        return this.shoppingCartRepository.findByDateCreatedBetween(from,to);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return this.shoppingCartRepository.findAll();
    }

    @Override
    public Long countSuccessfulOrders(String username) {
        return null;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) {
        return this.shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCart deleteProductById(Long id,String username) {
        Product product = this.productRepository.findById(id).get();
        ShoppingCart cart = this.getActiveShoppingCart(username);

        cart.getProducts().remove(product);
        return this.shoppingCartRepository.save(cart);
    }
}
