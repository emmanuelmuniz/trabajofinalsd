package productservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import productservice.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
