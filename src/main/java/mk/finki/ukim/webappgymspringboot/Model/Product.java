package mk.finki.ukim.webappgymspringboot.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private double price;

    public Product( String name, double price,int quantity) {
        this.name = name;
        this.price = price;
        this.quantity=quantity;
    }

    public Product()
    {

    }
}
