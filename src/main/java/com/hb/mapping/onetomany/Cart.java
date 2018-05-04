package com.hb.mapping.onetomany;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="CART")
@Getter
@Setter
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;


    @OneToMany(mappedBy = "cart")
    private Set<Items> items;


}
