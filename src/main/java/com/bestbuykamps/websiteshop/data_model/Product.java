package com.bestbuykamps.websiteshop.data_model;

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

    //zmiana na true bo błąd do ogarnięcia !!!! MICHAŁ
    @Column (name = "discount_id", nullable = true)
    private Long discountId;

    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Discount discount;

    public Product( String nameOfTheGame ) {
        name = nameOfTheGame;
    }

    public Object getProductId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", discountId=" + discountId +
                ", discount=" + discount +
                '}';
    }
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