package mk.finki.ukim.webappgymspringboot.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class ProductOrder
{

    @Id
    private Long id;
    @ManyToOne
    private User user;
    private int quantity;
    @ManyToOne
    private Product product;
    private LocalDateTime dateCreated;

    public ProductOrder(Long id, User user, int quantity, Product product, LocalDateTime dateCreated) {
        this.id = id;
        this.user = user;
        this.quantity = quantity;
        this.product = product;
        this.dateCreated = dateCreated;
    }

    public ProductOrder()
    {

    }
}
