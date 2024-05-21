package mk.finki.ukim.webappgymspringboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
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
