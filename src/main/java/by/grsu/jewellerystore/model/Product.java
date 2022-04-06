package by.grsu.jewellerystore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "presentation_image")
    private String presentationImage;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @ManyToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.MERGE)
    @JoinColumn(name = "producer_id")
    private Producer producer;

}