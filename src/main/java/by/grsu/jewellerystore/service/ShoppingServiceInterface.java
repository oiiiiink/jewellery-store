package by.grsu.jewellerystore.service;

import by.grsu.jewellerystore.model.Product;
import by.grsu.jewellerystore.model.User;

import java.util.List;

public interface ShoppingServiceInterface {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Product getProductById(Long id);

    User orderAnItem(Long productId, String customerName, String address, String phoneNumber);

}
