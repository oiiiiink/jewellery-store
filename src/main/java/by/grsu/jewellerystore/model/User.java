package by.grsu.jewellerystore.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "shopping_cards", joinColumns = @JoinColumn(name = "users_id"),
    inverseJoinColumns = @JoinColumn(name = "products_id"))
    private Set<Product> shoppingCard;

}
