package com.bestbuykamps.websiteshop.model;

import jakarta.persistence.*;

@Entity
@Table(name ="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "price")
    private Double price;

    @Column (name = "discount_id", nullable = false)
    private Long discountId;

    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Discount discount;

}



/*
CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    category VARCHAR(100),
    price DOUBLE,
    discount_id BIGINT NOT NULL,
    FOREIGN KEY (discount_id) REFERENCES discount(id)
);
 */