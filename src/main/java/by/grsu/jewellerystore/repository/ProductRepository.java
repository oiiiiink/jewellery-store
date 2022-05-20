package by.grsu.jewellerystore.repository;

import by.grsu.jewellerystore.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "select * from products", nativeQuery = true)
    List<Product> getAll();

    List<Product> getProductByProductType_Type(String productType_type);

}
