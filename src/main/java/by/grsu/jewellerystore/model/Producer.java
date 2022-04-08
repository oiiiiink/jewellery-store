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
@Table(name = "producers")
public class Producer {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "contactPhone")
    private String contactPhone;

    @Column(name = "short_description")
    private String shortDescription;

    @OneToMany(mappedBy = "producer",
        fetch = FetchType.LAZY)
    private Set<Product> products;

}
