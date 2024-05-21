package mk.finki.ukim.webappgymspringboot.Service;

import mk.finki.ukim.webappgymspringboot.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService
{
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> save(String name, Double price,
                           Integer quantity);

    void deleteById(Long id);

    Optional<Product> edit(Long id, String name, Double price,
                           Integer quantity);

}
