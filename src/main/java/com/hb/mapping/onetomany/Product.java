package com.hb.mapping.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private float price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Product() {
    }

    public Product(String name, String description, float price,
                   Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }


}
