package mk.finki.ukim.webappgymspringboot.Repository;

import mk.finki.ukim.webappgymspringboot.Model.Enumerations.ShoppingCartStatus;
import mk.finki.ukim.webappgymspringboot.Model.Product;
import mk.finki.ukim.webappgymspringboot.Model.ShoppingCart;
import mk.finki.ukim.webappgymspringboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    Optional<ShoppingCart> findByUserAndStatus(User user,ShoppingCartStatus status);
    Optional<ShoppingCart> findByUserUsernameAndStatus(String user, ShoppingCartStatus status);

    List<ShoppingCart> findByDateCreatedBetween(LocalDateTime from, LocalDateTime to);
    void deleteProductById (Long id);
}
