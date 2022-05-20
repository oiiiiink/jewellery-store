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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShoppingController {

    private final ShoppingServiceInterface shoppingServiceInterface;

    @GetMapping("categories")
    public String getShoppingPage(Model model) {

        //model.addAttribute("products", shoppingServiceInterface.getAllProducts());
        model.addAttribute("feedBack", new FeedbackDto());

        return "categories.html";
    }

    @GetMapping("product/{id}")
    public String getProductById(Model model,
                                 @PathVariable("id") Long id) {
        model.addAttribute("product", shoppingServiceInterface.getProductById(id));
        model.addAttribute("feedBack", new FeedbackDto());

        return "product.html";
    }

    @GetMapping("products")
    public String orderAnProducts(Model model,
                                  @RequestParam("productId") Long productId,
                                  @RequestParam("customer") String customerName,
                                  @RequestParam("address") String address,
                                  @RequestParam("phoneNum") String phoneNumber) {

        model.addAttribute("user",
                shoppingServiceInterface.orderAnItem(productId, customerName, address, phoneNumber));

        model.addAttribute("feedBack", new FeedbackDto());
        return "user_orders.html";
    }

    @GetMapping("/shopping/{type}")
    public String getItemsByCategory(Model model,
                                     @PathVariable String type) {

        model.addAttribute("products", shoppingServiceInterface.getProductsByCategory(type));
        model.addAttribute("feedBack", new FeedbackDto());

        return "shop.html";
    }

}
