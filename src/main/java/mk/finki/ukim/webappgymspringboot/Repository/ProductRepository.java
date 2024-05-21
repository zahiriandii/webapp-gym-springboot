package mk.finki.ukim.webappgymspringboot.Repository;

import mk.finki.ukim.webappgymspringboot.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByNameLike(String name);
}
