package com.hb.mapping.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@javax.persistence.Entity
@Table(name="ITEMS")
@Getter
@Setter
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public Items(){
        //default constructor
    }

    // Hibernate requires no-args constructor
    public Items(Cart cart) {
        this.cart=cart;
    }

}
