package itemsservice.clients;

import itemsservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "products-service", url="products-service:8080/")
public interface ProductClient {

    @GetMapping("/")
    public List<Product> products();

    @GetMapping("/{id}")
    public Product detail(@PathVariable Long id);

    @PostMapping("/create")
    public Product create(@RequestBody Product product);

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id);

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id);

}
