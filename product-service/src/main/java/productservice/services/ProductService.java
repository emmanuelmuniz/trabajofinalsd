package productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productservice.models.Product;
import productservice.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public Product save (Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void deleteById (Long id) {
        productRepository.deleteById(id);
    }
}
