package by.grsu.jewellerystore.service;

import by.grsu.jewellerystore.model.Product;

import java.util.List;

public interface ShoppingServiceInterface {

    List<Product> getAllProducts();

    Product getProductById(Long id);

}
