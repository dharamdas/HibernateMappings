package com.hb.mapping.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class Category {

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products;


    public Category(String computer) {
        this.name=computer;
    }
}
