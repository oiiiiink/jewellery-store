package by.grsu.jewellerystore.service;

import by.grsu.jewellerystore.model.Product;
import by.grsu.jewellerystore.model.User;
import by.grsu.jewellerystore.repository.ProductRepository;
import by.grsu.jewellerystore.repository.UserRepository;
import com.ibm.icu.text.Transliterator;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ShoppingService implements ShoppingServiceInterface {

    private final UserRepository userRepository;

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

    @Override
    public User orderAnItem(Long productId, String customerName, String address, String phoneNumber){
        CustomerName customerInformation = extractCustomerName(customerName);

        User user = userRepository
                .findUserByFirstNameAndLastName(customerInformation.getFirstName(),
                        customerInformation.getLastName())
                .orElseGet(() -> userRepository.save(new User().setFirstName(customerInformation.getFirstName())
                        .setLastName(customerInformation.getLastName())
                        .setDeliveryAddress(address)
                        .setPhoneNumber(customerInformation.getNumber(phoneNumber))
                        .setUsername(customerInformation.generateLogin()))
                );

        if (Objects.isNull(user.getShoppingCard())) {
            user.setShoppingCard(new ArrayList<>() {{ add(productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Something went wrong")));}});
        } else {
            user.getShoppingCard().add(productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Something went wrong")));
        }

        user = userRepository.save(user);

        user.getShoppingCard().forEach(x -> x.setShortDescription(x.getShortDescription().substring(0, 57) + "..."));

        return user;
    }

    private CustomerName extractCustomerName(String customerName) {

        if (customerName.split("").length == 2)
            throw new RuntimeException("Something went wrong");

        return CustomerName.builder()
                .firstName(customerName.split(" ")[0])
                .lastName(customerName.split(" ")[1]).build();
    }


    @Getter
    @Builder
    private static class CustomerName {
        private String firstName;

        private String lastName;

        private String username;

        public String generateLogin() {
            Transliterator toLatinTrans = Transliterator.getInstance("Russian-Latin/BGN");
            return toLatinTrans.transliterate(firstName + "_" + lastName).toLowerCase(Locale.ROOT);
        }

        public String getNumber(String number) {
            StringBuffer stringBuffer = new StringBuffer(number);
            return stringBuffer.insert(0, "+").toString();
        }
    }

}
