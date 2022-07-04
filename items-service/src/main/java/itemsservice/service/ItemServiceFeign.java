package itemsservice.service;

import itemsservice.clients.ProductClient;
import itemsservice.models.Item;
import itemsservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemServiceFeign {
    @Autowired
    private ProductClient clientFeign;

    public List<Item> findAll() {
        return clientFeign.products().stream()
                .map(p -> new Item(p, 1))
                .collect(Collectors.toList());
    }

    public Item findById(Long id, Integer amount) {
        return new Item(clientFeign.detail(id), amount);
    }

    public Product save(Product product) {
        return clientFeign.create(product);
    }

    public Product update(Product product, Long id) {
        return clientFeign.update(product, id);
    }

    public void delete(Long id) {
        clientFeign.delete(id);
    }
}
