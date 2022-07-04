package itemsservice.controllers;

import itemsservice.models.Item;
import itemsservice.models.Product;
import itemsservice.service.ItemServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("serviceFeign")
    private ItemServiceFeign itemServiceFeign;

    @GetMapping("/")
    public List<Item> List() {
        return itemServiceFeign.findAll();
    }

    @GetMapping("/{id}/amount/{amount}")
    public Item detail(@PathVariable Long id, @PathVariable Integer amount) {
        return itemServiceFeign.findById(id, amount);
    }

    @PostMapping("/")
    public Product create(@RequestBody Product product) {
        return itemServiceFeign.save(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        return itemServiceFeign.update(product, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        itemServiceFeign.delete(id);
    }
}