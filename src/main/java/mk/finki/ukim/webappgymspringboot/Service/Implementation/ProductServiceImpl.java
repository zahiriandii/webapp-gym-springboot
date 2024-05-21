package mk.finki.ukim.webappgymspringboot.Service.Implementation;

import mk.finki.ukim.webappgymspringboot.Model.Product;
import mk.finki.ukim.webappgymspringboot.Repository.ProductRepository;
import mk.finki.ukim.webappgymspringboot.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.ofNullable(productRepository.findByNameLike(name));
    }

    @Override
    public Optional<Product> save(String name, Double price, Integer quantity) {
        Product product = new Product(name,price,quantity);
        return Optional.of(productRepository.save(product));
    }

    @Override
    public void deleteById(Long id) {
        Product product = this.findById(id).get();
        productRepository.delete(product);

    }

    @Override
    public Optional<Product> edit(Long id, String name, Double price, Integer quantity) {
        Product product = this.productRepository.findById(id).get();
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);

        return Optional.of(productRepository.save(product));
    }
}
