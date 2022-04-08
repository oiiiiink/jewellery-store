package by.grsu.jewellerystore.controller;

import by.grsu.jewellerystore.dto.FeedbackDto;
import by.grsu.jewellerystore.model.Product;
import by.grsu.jewellerystore.repository.ProductRepository;
import by.grsu.jewellerystore.service.ShoppingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShoppingController {

    private final ShoppingServiceInterface shoppingServiceInterface;

    @GetMapping("shopping")
    public String getShoppingPage(Model model) {

        model.addAttribute("products", shoppingServiceInterface.getAllProducts());
        model.addAttribute("feedBack", new FeedbackDto());

        return "shop.html";
    }

    @GetMapping("product/{id}")
    public String getProductById(Model model,
                                 @PathVariable("id") Long id) {
        model.addAttribute("product", shoppingServiceInterface.getProductById(id));
        model.addAttribute("feedBack", new FeedbackDto());

        return "product.html";
    }

}
