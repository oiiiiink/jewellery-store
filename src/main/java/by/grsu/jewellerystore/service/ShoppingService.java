package by.grsu.jewellerystore.service;

import by.grsu.jewellerystore.model.Product;
import by.grsu.jewellerystore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingService implements ShoppingServiceInterface {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.getAll();

        products.forEach(x -> x.setShortDescription(x.getShortDescription().substring(0, 57) + "..."));

        return products;
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Something went wrong"));
    }

}
