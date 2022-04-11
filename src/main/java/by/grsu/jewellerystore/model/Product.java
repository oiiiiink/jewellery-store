package by.grsu.jewellerystore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "presentation_image")
    private String presentationImage;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.MERGE)
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @ManyToMany(fetch = FetchType.LAZY,
        mappedBy = "shoppingCard")
    private Set<User> customers;

}
