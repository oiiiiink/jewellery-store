package by.grsu.jewellerystore.repository;

import by.grsu.jewellerystore.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
