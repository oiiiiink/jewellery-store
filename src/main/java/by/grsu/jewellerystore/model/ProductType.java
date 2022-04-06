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
public class ProductType {

    @Id
    private Long id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "productType",
        fetch = FetchType.LAZY)
    private Set<Product> products;

}
