package productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import productservice.models.Product;
import productservice.services.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product detail(@PathVariable Long id) throws InterruptedException {
        return productService.findById(id);
    }

    @PostMapping("/")
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        Product productRepo = productService.findById(id);

        if (productRepo != null) {
            productRepo.setName(product.getName());
            productRepo.setPrice(product.getPrice());
        }

        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
