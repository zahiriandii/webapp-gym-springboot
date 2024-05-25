package mk.finki.ukim.webappgymspringboot.Model;



import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.webappgymspringboot.Model.Enumerations.ShoppingCartStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity

public class ShoppingCart
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreated;
    @ManyToMany
    private List<Product> products = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;

    public ShoppingCart(User user) {
        this.user = user;
        this.dateCreated = LocalDateTime.now();
        this.status = ShoppingCartStatus.CREATED;
    }
    public ShoppingCart()
    {

    }
}
