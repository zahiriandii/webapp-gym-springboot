package mk.finki.ukim.webappgymspringboot.Repository;

import mk.finki.ukim.webappgymspringboot.Model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder,Long> {

}
